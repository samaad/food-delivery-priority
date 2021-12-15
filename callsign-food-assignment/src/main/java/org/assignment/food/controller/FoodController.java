package org.assignment.food.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assignment.food.modal.entity.Delivery;
import org.assignment.food.servic.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class FoodController {

    private final FoodService foodService;

    @GetMapping("/login")
    public String user(){
        return "Application is up and running";
    }

    @GetMapping("/prioritylists")
    public ResponseEntity<List<Delivery>> getDeliveryPriorities(){
        return ResponseEntity.ok().body(foodService.getPrioritization());
    }

    @PostMapping("/order")
    public ResponseEntity<Integer> saveOrder(@Valid @RequestBody Delivery delivery){
        Integer integer = foodService.saveOrder(delivery);
        if(integer > 0 ){
            return new ResponseEntity<>(integer, HttpStatus.CREATED);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/allfoodlists")
    public ResponseEntity<List<Delivery>> getAllDeliveryPriorities(){
        return ResponseEntity.ok().body(foodService.getAll()); 
        // dasda
    }


    @PutMapping("/order/{orderId}")
    public ResponseEntity<Delivery> updateDelivery(@Valid @RequestBody Delivery delivery, @PathVariable("orderId") Integer orderId){
        Delivery deliverySave = null;
        try {
            deliverySave = foodService.updateOrder(delivery, orderId);
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
        if(deliverySave != null ){
            return new ResponseEntity<>(deliverySave, HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
