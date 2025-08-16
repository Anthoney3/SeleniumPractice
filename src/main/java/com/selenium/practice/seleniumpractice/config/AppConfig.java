package com.selenium.practice.seleniumpractice.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public WebDriver driver(){
        final ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
//        options.addArguments("--disable-javascript");
        options.addArguments("--user-data-dir=C:\\Users\\Antho\\AppData\\Local\\BraveSoftware\\Brave-Browser");
        options.addArguments("--profile-directory=Default");
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }
}
