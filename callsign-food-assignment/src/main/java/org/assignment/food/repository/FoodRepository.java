package org.assignment.food.repository;

import org.assignment.food.modal.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Delivery, Integer> {

    Optional<List<Delivery>> findByDeliveryStatusIsNot(String deliveryStatus);

}
