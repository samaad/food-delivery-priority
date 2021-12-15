package org.assignment.food.servic;

import static org.assignment.food.util.DeliveryValidator.ValidationResult;
import static org.assignment.food.util.DeliveryValidator.isDeliveryCrossedExpectedTimeAndNotDelivered;
import static org.assignment.food.util.DeliveryValidator.isDeliveryLapsedEstimatedTime;
import static org.assignment.food.util.DeliveryValidator.isVIPCustomerWithPendingOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.assignment.food.modal.DeliveryStatus;
import org.assignment.food.modal.entity.Delivery;
import org.assignment.food.repository.FoodRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{

    private final FoodRepository foodRepository;

    @Override
    public List<Delivery>  getPrioritization() {

        Optional<List<Delivery>> byDeliveryStatusIsNotLike = foodRepository.findByDeliveryStatusIsNot(DeliveryStatus.ORDER_DELIVERED.toString());
        return byDeliveryStatusIsNotLike.map(deliveries -> deliveries.stream().filter(this::getDeliveryPriority).collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
    }

    @Override
    public Integer saveOrder(Delivery delivery) {
        Delivery saveOrder = foodRepository.save(delivery);
        if(saveOrder.getDeliveryId() > 0){
            return saveOrder.getDeliveryId();
        }
        return null;
    }

    @Override public Delivery updateOrder(Delivery delivery, Integer orderId) {
        return foodRepository.findById(orderId)
            .filter(delivery1 -> delivery1.getDeliveryId() == orderId)
            .map(delivery1 -> foodRepository.save(delivery))
            .orElseThrow(() -> new NoSuchElementException("record not found"));
    }

    @Override public List<Delivery> getAll() {
        return foodRepository.findAll();
    }

    private boolean getDeliveryPriority(Delivery delivery) {

        ValidationResult result = isVIPCustomerWithPendingOrder()
                .or(isDeliveryCrossedExpectedTimeAndNotDelivered())
                .or(isDeliveryLapsedEstimatedTime()).apply(delivery);
        return result.equals(ValidationResult.SUCCESS);
    }

}
