package org.assignment.food;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SampleTest {

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.parse("2021-12-07T17:09:55");
        System.out.println(dateTime);
        System.out.println(LocalDateTime.now());
        LocalDateTime timeToReach = LocalDateTime.parse("2021-12-07T17:10:11");
        long seconds = Duration
            .between(LocalDateTime.now(), dateTime)
            .getSeconds();
        System.out.println(seconds);

        LocalTime localTime = LocalTime.parse("00:40:12");
        LocalDateTime dateTime1 = dateTime
            .plusSeconds(localTime.getSecond())
            .plusMinutes(localTime.getMinute())
            .plusHours(
                localTime.getHour());
        System.out.println("addition "+ dateTime1);
        long seconds1 = Duration
            .between(dateTime1, timeToReach)
            .getSeconds();
        System.out.println(seconds1);

    }
}
