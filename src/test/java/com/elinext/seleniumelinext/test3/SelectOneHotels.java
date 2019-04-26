package com.elinext.seleniumelinext.test3;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

@Log
public class SelectOneHotels {

    WebDriver driver;
    private final long SLEEP_SEC = 0L;
    private List<Integer> avalubleHotels ;

    private Random rn;


    // Steps we want to do

    // Step 1
    public void selectionOfHotel( ) throws InterruptedException {

        System.out.println("Waiting when page is upload (2)");
        Wait<WebDriver> wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hotelCompareForm")));



//        System.out.println("Click radio button 'Show Available Only'");
//        WebElement button_ShowAvailableOnly = driver.findElement(By.cssSelector("input[id='filterAvailableOnly'][type='radio']"));
//        button_ShowAvailableOnly.click();
//
//        System.out.println("Waiting when page is upload (After click radio button 'Show Available Only') - sleep 8 sec");
//        sleep(8000);
//        wait = new WebDriverWait(driver, 80);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hotelCompareForm")));



        avalubleHotels = new ArrayList<>();
        System.out.println("Start search hotels.");
        for(int i = 1; i<10; i++) { // I must chagen '10'
            try {
                WebElement t_hotelName = driver.findElement(By.xpath("//*[@id=\"hotelCompareForm\"]/div/fieldset["+i+"]/div/div[5]/h2/a/span"));
                WebElement t_price = driver.findElement(By.xpath("//*[@id=\"hotelCompareForm\"]/div/fieldset["+i+"]/div/div[4]/div[1]/h3/ins"));
                System.out.println("price = " + t_price.getText() + ", hotel name: " + t_hotelName.getText() );
//                System.out.println("hotel price = " + t_price.getText());
                avalubleHotels.add(i);
            }catch (Exception e){
                System.out.println("Catch Exception : Hotel " + i + " not evaluable to book");
            }
        }

        for (int i = 0; i<avalubleHotels.size()-1; i++ ){
            System.out.println(avalubleHotels.get(i));
        }

    }

    // Step 2
    public void clickButtonSelectHotel( ) throws InterruptedException {

        for (int i = 0; i<avalubleHotels.size()-1; i++ ){
            System.out.println("i = " + avalubleHotels.get(i));
        }


//        int number = 2;
        System.out.println("avalubleHotels.get(0) = " + avalubleHotels.get(0));

        WebElement t_hotelName = driver.findElement(By.xpath("//*[@id='hotelCompareForm']/div/fieldset["+avalubleHotels.get(0)+"]/div/div[5]/h2/a/span"));
//        System.out.println("hotel name = " + t_hotelName.getText());
        log.info("We select hotel :" + t_hotelName.getText());

        WebElement t_button_SELECT  =  driver.findElement(By.xpath("//*[@id='hotelCompareForm']/div/fieldset["+avalubleHotels.get(0)+"]/div/div[4]/div[2]/div/span[1]"));
        t_button_SELECT.click();


//        WebElement ttt = driver.findElement(By.xpath("//ul[@class='RoomTilesstyles__Tiles-sc-9cb585-5 OSDRW']"));
//        WebElement list = t_hotelName.findElements
    }




    // Action
    public void selectFirstEvaluableHotel() throws InterruptedException {
        selectionOfHotel();
        clickButtonSelectHotel();
    }



    // Constructor
    public SelectOneHotels(WebDriver driver) {
        // Initialize the state of the driver
        this.driver = driver;
        // Initialize web elements
        PageFactory.initElements(driver, this);
    }

}
