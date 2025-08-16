package com.selenium.practice.seleniumpractice;

import com.selenium.practice.seleniumpractice.service.SearchSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeleniumPracticeApplication{

//    @Autowired
//    private SearchSteps searchSteps;

    public static void main(String[] args) {
        SpringApplication.run(SeleniumPracticeApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//            searchSteps.search();
//    }
}
