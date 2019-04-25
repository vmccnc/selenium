package com.elinext.seleniumelinext.test3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class SelectOneHotels {

    WebDriver driver;
    private final long SLEEP_SEC = 0L;


    List<Integer> avalubleHotels;


    public SelectOneHotels(WebDriver driver) {
        this.driver = driver;
    }


    public void selectionOfHotel( ) throws InterruptedException {

        System.out.println("Waiting when page is upload (2)");
        Wait<WebDriver> wait = new WebDriverWait(driver, 80);

        System.out.println("Sleep 2 sec");
        sleep(2000);

        WebElement hotelOnePrice_Element;
        WebElement hotelName_Element;
//        try {
//         hotelOnePrice_Element   = driver.findElement(By.xpath("//*[@id=\"hotelsEndlessScrolling\"]/fieldset[1]/div/div[5]/h2/a/span"));
//         driver.findElement(By.xpath("//*[@id=\"hotelsEndlessScrolling\"]/fieldset[1]/div/div[5]/h2")).click();
        WebElement teswwt_sResults  =  driver.findElement(By.xpath("//*[@id=\"hotelCompareForm\"]/div/fieldset[1]/div/div[4]/div[2]/div/span[1]/a")); // button SELECT

        String ff = teswwt_sResults.getText();
        System.out.println("fffffffffffffffff = " + ff);

        WebElement teswwt_sResults2  =  driver.findElement(By.xpath("//*[@id=\"hotelCompareForm\"]/div/fieldset[1]/div/div[5]/h2/a/span"));
        String ff2 = teswwt_sResults2.getText();
        System.out.println("fffffffffffffffff 22 = " + ff2);

         avalubleHotels = new ArrayList<>();

        for(int i = 1; i<20; i++) {
            try {

                WebElement t_hotelName  =   driver.findElement(By.xpath("//*[@id=\"hotelCompareForm\"]/div/fieldset[1]/div/div[5]/h2/a/span"));
                WebElement t_price = driver.findElement(By.xpath("//*[@id=\"hotelCompareForm\"]/div/fieldset["+i+"]/div/div[4]/div[1]/h3/ins"));
                String t_price_string = t_price.getText();
                System.out.println("hotel name = " + t_hotelName.getText());
                System.out.println("hotel price = " + t_price_string);
                avalubleHotels.add(i);
            }catch (Exception e){
                System.out.println("Catch Exception " + i);
            }
        }

    }


    public void clickButtonSelectHotel( ) throws InterruptedException {
        System.out.println("avalubleHotels.get(0) = " + avalubleHotels.get(0));
        WebElement t_button_SELECT  =  driver.findElement(By.xpath("//*[@id=\"hotelCompareForm\"]/div/fieldset["+avalubleHotels.get(0)+"]/div/div[4]/div[2]/div/span[1]/a"));
        t_button_SELECT.click();
    }




}
