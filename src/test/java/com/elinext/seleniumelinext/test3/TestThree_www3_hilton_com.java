package com.elinext.seleniumelinext.test3;

import lombok.extern.java.Log;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

@Log
public class TestThree_www3_hilton_com {

    WebDriver driver;
    private final String WEBSITE_WE_ARE_TESTING = "http://www3.hilton.com";
    private final String CITY = "Washington, DC";
    private final String CHECK_IN = "01 May 2019";
    private final String CHECK_OUT = "07 May 2019";
    private final int nomberOfAdults = 2;

    private final long SLEEP_SEC = 0L;



    @Test
    public void test_() throws Exception {

        do{
            System.out.println("Check the right page");
        } while (!checkThePage());

        // Page one
        FindAllHotels fillFirstPage = new FindAllHotels(driver);
        fillFirstPage.action(CITY, CHECK_IN, CHECK_OUT, nomberOfAdults);


        // Page two
        SelectOneHotels selectOneHotels = new SelectOneHotels(driver);
        selectOneHotels.selectFirstEvaluableHotel();



        System.out.println("Waiting when page is upload (3)");
        Wait  wait = new WebDriverWait(driver, 80);
        System.out.println("Sleepp 2 sec");
        sleep(2000);



// Check type of url (secure3. or without )
        String url = driver.getCurrentUrl();
        System.out.println("--------------- Current Url = " + url);


        // Version 1
        if(url.contains("secure3.hilton.com")){

            HiltonV1SelectARoom hiltonV1SelectARoom = new HiltonV1SelectARoom(driver);
            hiltonV1SelectARoom.go();


        } else { // ------------------- Version 2   --------------------

         HiltonV2SelectARoom hiltonV2SelectARoom = new HiltonV2SelectARoom(driver);
            hiltonV2SelectARoom.go();

        }









    }




    @After
    public void tearDown() throws Exception {
//        driver.close();
//        driver.quit();
    }


    private boolean checkThePage() throws Exception {
        setUp();
        System.out.println("Waiting when 'search_from_str' element will be appeared");
        Wait<WebDriver> wait = new WebDriverWait(driver, 80);

        String pageTitle = driver.getTitle();
        if (!pageTitle.equals("Hilton Hotels and Resorts - Find Hotel Rooms")){
            driver.close();
            return false;
        }
        return true;
    }



    public void setUp() throws Exception {
        // Set driver for Mozila
//        System.setProperty("webdriver.gecko.driver", "D:\\Dmitry Prokopenko\\z_library\\geckodriver.exe");
//        driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "d:\\Dmitry Prokopenko\\z_library\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get(WEBSITE_WE_ARE_TESTING);
    }



}