package org.assignment.food.modal.entity;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table
@Entity
public class Delivery implements Serializable {

    private static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deliveryId;
    @NotNull
    private String customerType;
    @NotNull
    private String deliveryStatus;
    @NotNull
    private LocalDateTime expectedDeliveryTime;
    @NotNull
    private Integer currentDistanceFromDestinationInMeters;
    @NotNull
    private LocalDateTime timeToReachDestination;
    @NotNull
    private LocalTime meanTimeToPrepareFood;

}
