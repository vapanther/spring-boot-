package com.crosscode.profile_based;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private WetherForcast weatherService;

    public void run(String... args) throws Exception {
        //weather forecast, default is sunny day!
        System.out.println(weatherService.forcast());
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
