package com.selenium.practice.seleniumpractice.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.function.Consumer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CreepyPastaElement {

    private String title;
    private String description;
    private String rating;
    private String postedDate;

    public CreepyPastaElement(WebElement element){
//        System.out.println(element.toString());
        try{
            this.title = element.findElement(By.cssSelector(".pt-cv-title")).getText();
        }catch (NoSuchElementException e){
//            System.out.println("No title found, text is : " + element.getText());
        }
        try {
            this.description = element.findElement(By.cssSelector(".pt-cv-content")).getText().replace("Read Now","");
        }catch (NoSuchElementException e){
//            System.out.println("No description found, text is : " + element.getText() );
        }
        try {
            //By.xpath("//div[@class='pt-cv-ifield']/div[@class='pt-cv-ctf-list']//div[@class='pt-cv-ctf-value']")
            this.rating = element.findElement(By.cssSelector(".pt-cv-ctf-list .pt-cv-ctf-value")).getText();
        }catch (NoSuchElementException e){
//            System.out.println("No rating found, text is : " + element.getText());
            if(this.rating == null) this.rating = "Not yet rated or rating not found";
        }

        try{
            this.postedDate = element.findElement(By.cssSelector(".pt-cv-meta-fields .entry-date time")).getText();
        }catch (NoSuchElementException e){

        }
    }

//    public String getDescription(){
//
//    }

}
