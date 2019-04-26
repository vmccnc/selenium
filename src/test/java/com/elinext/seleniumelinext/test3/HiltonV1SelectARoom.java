package com.elinext.seleniumelinext.test3;

import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.regex.Pattern;

@Log
public class HiltonV1SelectARoom {

    WebDriver driver;
    private final long SLEEP_SEC = 00L;


    public void go(){


        System.out.println("Version 1  - secure3.hilton.com");

//        List<WebElement> list1= driver.findElements(By.xpath("//*[contains(@class, 'rowRateShowing')]/div[2]/span/ins"));

        List<WebElement> list2= driver.findElements(By.xpath("//*[contains(@class, 'priceamount')]"));
//        rate ratePackageFeaturedRates rowRateShowing
//            /html/body/div[3]/div[3]/div[3]/div/div/div/div[2]/div[2]/fieldset/div/ul/li[1]/div[3]/ul[1]/li[1]/div[3]/form/a
        System.out.println("->->->---------list2.size() : " + list2.size() );

        for(WebElement el: list2){
//                System.out.println(  el.findElement(By.xpath("//*[@class='new-price' or @class='currencyCode-USD']")).getText()  );
            System.out.println(  el.findElement(By.xpath("//*[@class='priceamount currencyCode-USD']")).getText()  );
        }


        System.out.println("Version 1 : Click  button!");
        WebElement t_el  =  driver.findElement(By.xpath("//*[@id=\"roomViewRegularView\"]/div[2]/fieldset/div/ul/li[1]/div[3]/ul[1]/li[1]/div[3]/form/a/span[1] "));
        t_el.click();



        try {
            WebElement buttonInPopUp  =  driver.findElement(By.xpath("//a[class='linkBtn proceedButton']"));
            buttonInPopUp.click();
        }catch (Exception e ){
            System.out.println("PopUp window not appiard");
        }


    }




    public HiltonV1SelectARoom(WebDriver driver) {
        this.driver = driver;
        // Initialize web elements
        PageFactory.initElements(driver, this);
    }



}
