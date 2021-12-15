package org.assignment.food.servic;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.assignment.food.modal.entity.Delivery;
import org.assignment.food.repository.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class FoodServiceImplTest {

    @InjectMocks
    FoodServiceImpl foodServiceImpl;

    @Mock FoodRepository foodRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }



    @Test
    public void getPrioritization(){
        Optional<List<Delivery>> deliveries = Optional.ofNullable(List.of( Delivery.builder()
            .deliveryId(1)
            .customerType("LOYAL")
            .deliveryStatus("ORDER_RECEIVED")
            .expectedDeliveryTime(LocalDateTime.parse("2021-12-07T17:09:42"))
            .currentDistanceFromDestinationInMeters(100)
            .timeToReachDestination(LocalDateTime.parse("2021-12-07T17:09:30"))
            .meanTimeToPrepareFood(LocalTime.parse("00:40:12"))
            .build(),Delivery.builder()
            .deliveryId(2)
            .customerType("NEW")
            .deliveryStatus("ORDER_RECEIVED")
            .expectedDeliveryTime(LocalDateTime.parse("2021-12-07T17:15:42"))
            .currentDistanceFromDestinationInMeters(200)
            .timeToReachDestination(LocalDateTime.parse("2021-12-07T17:16:30"))
            .meanTimeToPrepareFood(LocalTime.parse("00:55:00"))
            .build(), Delivery.builder()
            .deliveryId(3)
            .customerType("LOYAL")
            .deliveryStatus("ORDER_DELIVERED")
            .expectedDeliveryTime(LocalDateTime.parse("2021-12-07T17:12:42"))
            .currentDistanceFromDestinationInMeters(200)
            .timeToReachDestination(LocalDateTime.parse("2021-12-07T17:12:30"))
            .meanTimeToPrepareFood(LocalTime.parse("00:30:00"))
            .build(),Delivery.builder()
            .deliveryId(4)
            .customerType("VIP")
            .deliveryStatus("ORDER_RECEIVED")
            .expectedDeliveryTime(LocalDateTime.parse("2021-12-07T17:12:42"))
            .currentDistanceFromDestinationInMeters(200)
            .timeToReachDestination(LocalDateTime.parse("2021-12-07T17:12:30"))
            .meanTimeToPrepareFood(LocalTime.parse("00:30:00"))
            .build()));
        when(foodRepository.findByDeliveryStatusIsNot(any(String.class))).thenReturn(deliveries);

        List<Delivery> prioritization = foodServiceImpl.getPrioritization();

        assertNotNull(prioritization);

    }

    @Test
    public void updateOrderShouldReturnMessageNotFound() {
        when(foodRepository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(null));

        given(foodServiceImpl.updateOrder(Delivery
            .builder()
            .deliveryId(4)
            .customerType("VIP")
            .deliveryStatus("ORDER_RECEIVED")
            .expectedDeliveryTime(LocalDateTime.parse("2021-12-07T17:12:42"))
            .currentDistanceFromDestinationInMeters(200)
            .timeToReachDestination(LocalDateTime.parse("2021-12-07T17:12:30"))
            .meanTimeToPrepareFood(LocalTime.parse("00:30:00"))
            .build(), 2)).willThrow(new NoSuchElementException("record not found"));
    }
}
