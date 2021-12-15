package org.assignment.food;

import lombok.extern.log4j.Log4j2;
import org.assignment.food.modal.entity.User;
import org.assignment.food.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@Log4j2
@SpringBootApplication
public class CallsignFoodAssignmentApplication implements CommandLineRunner {

    @Autowired UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(CallsignFoodAssignmentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        userRepository.save(User.builder()
            .userName("autouser")
            .password("password123")
            .roles("ROLE_ADMIN")
            .active(true)
            .build());
    }
}
