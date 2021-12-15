package org.assignment.food.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assignment.food.servic.FoodService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PriorityDeliverySchedular {

    private FoodService foodService;

    @Scheduled(fixedRate = 15000)
    public void getHeadValue() {
        log.info("Value: {}", "15s");
    }
}
