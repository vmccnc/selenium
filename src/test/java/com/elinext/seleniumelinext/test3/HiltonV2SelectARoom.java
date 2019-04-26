package com.elinext.seleniumelinext.test3;

import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.regex.Pattern;

@Log
public class HiltonV2SelectARoom {

    WebDriver driver;
    private final long SLEEP_SEC = 00L;


    public void go(){

        System.out.println("Version 2  - hilton.com (Select a Room)");

//            WebElement gg = driver.findElement(By.xpath("//ul[@class='RoomTilesstyles__Tiles-sc-9cb585-5 OSDRW']"));

//            List<WebElement> list = driver.findElements(By.xpath("//ul[@class='RoomTilesstyles__Tiles-sc-9cb585-5 OSDRW']//li/descendant::button[@id='roomMoreRatesButtonNQRQE'][@type='button']"));
//            List<WebElement> list = driver.findElements(By.xpath("//*[@class='MoreRatesButtonstyles__MoreRates-sc-1eyzhlz-1']"));


//        List<WebElement> list2= driver.findElements(By.xpath("//*[@id=\"roomMoreRatesButtonNQRQE\"]"));

        List<WebElement> list2= driver.findElements(By.xpath("//div[@class='RoomTilesstyles__Container-sc-9cb585-0 esRuYc']//span[@class='MoreRatesButtonstyles__MoreRates-sc-1eyzhlz-1 kpcnFM']"));

//            System.out.println("Amount of element in list = " + list.size());
        System.out.println("Amount of element in list = " + list2.size());


//        String y =  "tttt".replace('$', 'd');

        for(WebElement el: list2) {
            System.out.println("el2 = " + el.getText());

            int price =   Pattern.compile(" ").splitAsStream( el.getText() ).
                    map(t-> t.replace("$", "") )
                    .filter((s) -> s.matches("\\d+"))  // Only select the numbers
                    .mapToInt(Integer::parseInt)
                    .sum();
            System.out.println("Price of hotel = " + price);
        }

        System.out.println("If only One element we click it ");
        if(list2.size()==1) list2.get(0).click();



        try {
            WebElement but = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
            but.click();
        }catch (Exception e){
            log.info("Something wrong with //button[contains(text(),'Continue')] !!!");
        }

    }




    public HiltonV2SelectARoom(WebDriver driver) {
        this.driver = driver;
        // Initialize web elements
        PageFactory.initElements(driver, this);
    }



}
