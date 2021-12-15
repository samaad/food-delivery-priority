package org.assignment.food.servic;

import org.assignment.food.modal.entity.Delivery;

import java.util.List;

public interface FoodService {

    List<Delivery> getPrioritization();

    Integer saveOrder(Delivery delivery);
    Delivery updateOrder(Delivery delivery, Integer orderId);
    List<Delivery> getAll();

}
