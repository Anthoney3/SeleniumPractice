package com.selenium.practice.seleniumpractice.service;

import com.selenium.practice.seleniumpractice.models.CreepyPastaElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchSteps {

    final WebDriver driver;

    public List<CreepyPastaElement> search() throws IOException {
        driver.get("https://www.creepypasta.com");
        List<WebElement> creepyPastas = driver.findElements(By.cssSelector(".pt-cv-ifield"));
        List<CreepyPastaElement> latestCreepyPastas = populateCreepyPastaElements(creepyPastas);
        return latestCreepyPastas;
//        printCreepyPastas(creepyPastaElements);
    }

    public void printCreepyPastas(List<CreepyPastaElement> creepyPastas) throws IOException {
        try(final FileWriter writer = new FileWriter("latest_creepy_pastas.txt");
            final BufferedWriter bf = new BufferedWriter(writer)){
            for(CreepyPastaElement creepyPasta : creepyPastas){
                bf.write("Title : " + creepyPasta.getTitle() + "\n" +
                        "Description : " + creepyPasta.getDescription() + "\n" +
                        "Rating : " + creepyPasta.getRating() + "\n" +
                        "Date Posted : " + creepyPasta.getPostedDate());
                bf.newLine();
                bf.newLine();
            }
        }
//        for(CreepyPastaElement creepyPasta : creepyPastas){
//            log.info("Title : {} |\n Description : {} \n| Rating : {}", creepyPasta.getTitle(), creepyPasta.getDescription(), creepyPasta.getRating());
//        }
    }

    public List<CreepyPastaElement> populateCreepyPastaElements(List<WebElement> elements){
        List<CreepyPastaElement> creepyPastaElements = new ArrayList<>();
        for(WebElement element : elements){
            creepyPastaElements.add(new CreepyPastaElement(element));
        }
        return creepyPastaElements;
    }

}
