package com.example.projectwithsql;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.util.*;

@Component
public class ScheduledTasks {

    RestTemplate restTemplate = new RestTemplate();
    Random random = new Random();


    private static int id = 1;
    String [] names = {"Ford F150", "Toyota Tacoma", "Nissan Altima", "Honda Civic", "Hyundai Elantra", "Kia Optima", "Lincoln Navigator", "Volkswagon Jetta"};

    @Scheduled(cron = "*/5 * * * * *")
    public void addVehicle(){
        String url = "http://localhost:8080/addVehicle";
        Vehicle vehicle = new Vehicle(0,RandomStringUtils.random(17,true,true),
                random.nextInt((2016-1986) + 1)+1986,random.nextInt((45000-15000) + 1));
        restTemplate.postForObject(url,vehicle, Vehicle.class);
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void deleteVehicle(){
        String url1 = "http://localhost:8080/getVehicle/{id}";
        String url2 = "http://localhost:8080/deleteVehicle/{id}";
        Map<String, String> params = new HashMap<>();
        params.put("id", Integer.toString(random.nextInt(50)));
        if(!restTemplate.getForEntity(url1,Vehicle.class,params).getClass().equals(Vehicle.class)){
            System.out.println("*********ERROR: greeting not found**********");
        }else{
            System.out.println(restTemplate.getForEntity(url1,Greeting.class,params));
            restTemplate.delete(url2,params);
        }

    }

    @Scheduled(cron = "0 * * * * *")
    public void updateVehicle(){
        String url = "http://localhost:8080/updateVehicle";
        Vehicle vehicle = new Vehicle(random.nextInt(100)+1,names[random.nextInt((names.length-1) + 1)],
                random.nextInt((2016-1986) + 1) + 1986,random.nextInt((45000-15000) + 1)+15000);
        restTemplate.put(url,vehicle);
    }

    @Scheduled(cron = "0 0 * * * *")
    public void latestVehiclesReport(){
        String url = "http://localhost:8080/getLatestVehicles";
        List<Vehicle> inventory =  restTemplate.getForObject(url, List.class);
        for(Vehicle vehicle: inventory){
            System.out.println(vehicle);
        }
    }

//
////    @Scheduled(cron = "*/2 * * * * *")
////    public void updateGreeting(){
////        String url = "http://localhost:8080/updateGreeting";
////        String message = (isHello)?"Hello World":"Bye World";
////        restTemplate.put(url, message);
////    }
////
////    @Scheduled(cron = "*/5 * * * * *")
////    public void getGreeting() {
////        String url = "http://localhost:8080/greeting";
////        Greeting g = restTemplate.getForObject(url, Greeting.class);
////        System.out.println(g.getContent());
////        isHello = !isHello;
//    }
}
