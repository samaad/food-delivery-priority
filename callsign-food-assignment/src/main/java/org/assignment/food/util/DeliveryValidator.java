package org.assignment.food.util;

import org.assignment.food.modal.CustomerType;
import org.assignment.food.modal.DeliveryStatus;
import org.assignment.food.modal.entity.Delivery;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.function.Function;


public interface DeliveryValidator extends Function<Delivery, DeliveryValidator.ValidationResult> {


    static DeliveryValidator isVIPCustomerWithPendingOrder(){
        return delivery -> delivery.getCustomerType().equals(CustomerType.VIP.toString()) ?
                ValidationResult.SUCCESS : ValidationResult.FAILURE;
    }

    static DeliveryValidator isDeliveryCrossedExpectedTimeAndNotDelivered(){
        return delivery ->
           Duration.between(LocalDateTime.now(), delivery.getExpectedDeliveryTime()).getSeconds() <= 0l
                   ? ValidationResult.SUCCESS : ValidationResult.FAILURE;
    }

    static DeliveryValidator isDeliveryLapsedEstimatedTime(){
        return delivery ->  Duration.between(delivery.getTimeToReachDestination(),
            delivery.getExpectedDeliveryTime().plusSeconds(delivery.getMeanTimeToPrepareFood().getSecond()).plusMinutes(delivery.getMeanTimeToPrepareFood().getMinute()).plusHours(
                delivery.getMeanTimeToPrepareFood().getHour()))
            .getSeconds() <= 0l ?
                    ValidationResult.SUCCESS : ValidationResult.FAILURE;

    }

    default DeliveryValidator or (DeliveryValidator other){
        return delivery -> {
            ValidationResult result = this.apply(delivery);
            return result.equals(ValidationResult.SUCCESS) ? result : other.apply(delivery);
        };
    }




    enum ValidationResult{
        SUCCESS,
        FAILURE
    }
}
