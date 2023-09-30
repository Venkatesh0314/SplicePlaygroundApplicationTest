package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class SplicePlaygroundApplication {
    public static void main(String[] args){
        try {
            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            // to maximize the window
            driver.manage().window().maximize();
            // to open the url
            driver.get("https://qaspliceplygr.ccbp.tech/");

            // enter the start-index
            WebElement enterText=driver.findElement(By.xpath("//input[starts-with(@id,'startIndex')]"));
            enterText.sendKeys("2");
            // enter the value as delete count
            WebElement enterCountValue=driver.findElement(By.xpath("//input[starts-with(@id,'deleteCount')]"));
            enterCountValue.sendKeys("0");

            // enter the value in itemInto add using start-with method
            WebElement ItemToAddItem=driver.findElement(By.xpath("//input[starts-with(@id,'itemToAddInput')]"));
            ItemToAddItem.sendKeys("pen");

            // click on the slice button
            WebElement clickOnSliceButton=driver.findElement(By.xpath("//button[contains(text(),'Splice')]"));
            clickOnSliceButton.click();
            // to find the Array is an output
            WebElement updatedArray = driver.findElement(By.xpath("//span[starts-with(@id,'updated')]"));
            String textRetriveArray=updatedArray.getText();

            // Verify whether the text matches the below text
            String expectedText = "[1,7,\"pen\",3,1,0,20,77]";

            if(textRetriveArray.equals(expectedText)){
                System.out.println("Updated Array :"+expectedText);
            }else{
                System.out.println("Array not updated as expected");
            }
            driver.close();
        }catch (Exception e){
            System.out.println("Hi venkatesh we review your code :"+e.getMessage());
        }
    }
}
