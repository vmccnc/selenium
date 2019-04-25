package com.elinext.seleniumelinext.test3;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.sleep;

public class TestThree_www3_hilton_com {

    WebDriver driver;
    private final String WEBSITE_WE_ARE_TESTING = "http://www3.hilton.com";
    private final String HOTEL_IN_CITY = "Washington, DC";
    private final int nomberOfAdults = 2;

    private final long SLEEP_SEC = 0L;



    @Test
    public void test_() throws Exception {



        do{
            System.out.println("Check the right page");
        } while (!checkThePage());

        // Page one
        FindAllHotels fillFirstPage = new FindAllHotels(driver);
//        fillFirstPage.checRightPage(WEBSITE_WE_ARE_TESTING);
        fillFirstPage.fillCityYouWish("Washington, DC");
        fillFirstPage.fillNumberOfAdults(nomberOfAdults);
        fillFirstPage.fillOtherFields();
        fillFirstPage.clickButton();



        ///   NEXT page - Page two
        SelectOneHotels selectOneHotels = new SelectOneHotels(driver);
        selectOneHotels.selectionOfHotel();
        selectOneHotels.clickButtonSelectHotel();









        System.out.println("Waiting when page is upload (3)");
        Wait  wait = new WebDriverWait(driver, 80);
        System.out.println("Sleepp 2 sec");
        sleep(2000);



// Check type of url (secure3. or without )
        String url = driver.getCurrentUrl();
        System.out.println("--------------- Current Url = " + url);


        // Version 1
        if(url.contains("secure3.hilton.com")){
            System.out.println("Version 1  - secure3.hilton.com");
//            WebElement webElement1 = driver.findElement(By.xpath("//*[@id=\"roomViewRegularView\"]/div[2]/fieldset/div/ul/li[1]/div[3]/ul[1]"));
            WebElement webElement2 = driver.findElement(By.xpath("//*[@id=\"roomViewRegularView\"]/div[2]/fieldset/div/ul"));
            List<WebElement> webElements =  webElement2.findElements(By.xpath("//div[3]/ul[1]/li[1]/div[2]/span/ins"));
//                        /html/body/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div[2]/fieldset/div/ul/li[1]/div[3]/ul[1]/li[3]/div[2]/span

            //        System.out.println("How many elements (avaluble room price) webElements = " + webElements.size());
//        for(int i=0; i<webElements.size(); i++){
//            System.out.println("i = " + i);
//            System.out.println( "WebElements.get("+i+").getText()  (" +  webElements.get(i).toString() + " ) = " +  webElements.get(i).getText() );
//        }

            System.out.println("Version 1 : Click  button!");
            WebElement t_el  =  driver.findElement(By.xpath("//*[@id=\"roomViewRegularView\"]/div[2]/fieldset/div/ul/li[1]/div[3]/ul[1]/li[1]/div[3]/form/a/span[1] "));
            t_el.click();

        } else { //  Version 2

            System.out.println("Version 2  - hilton.com");

            WebElement gg = driver.findElement(By.xpath("//ul[@class='RoomTilesstyles__Tiles-sc-9cb585-5 OSDRW']"));

            List<WebElement> list = driver.findElements(By.xpath("//li"));

            System.out.println("Amount of element in list = " + list.size());


//            List<WebElement> webElements =  webElement_v2.findElements(By.xpath("//div/div[1]/button/span/span"));
//            System.out.println("webElement2.size = " + webElements.size());


                   ///html/body/div[2]/div/div/div/div/div[3]/div/div/div[1]/div[3]/ul/li/div/div[1]/button/span/span
//            /html/body/div[2]/div/div/div/div/div[3]/div/div/div[1]/div[4]
        }











//                /html/body/div[2]/div/div/div/div/div[3]/div/div/div[1]/div[3]
//                /html/body/div[2]/div/div/div/div/div[1]
//                /html/body/div[2]/div/div/div/div/div[3]
//                /html/body/div[2]/div/div/div/div/div[3]/div/div/div[1]/div[3]/ul/li[2]/div/div[1]/button/span/span
//                /html/body/div[2]/div/div/div/div/div[3]/div/div/div[1]/div[3]/ul/li[3]/div/div[1]/button/span/span
//                /html/body/div[2]/div/div/div/div/div[3]/div/div/div[1]/div[3]/ul/li[4]/div/div[1]/button/span/span
//                /html/body/div[2]/div/div/div/div/div[3]/div/div/div[1]/div[3]/ul/li[1]/div/div[1]/button/span/span

//                /html/body/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div[2]/fieldset/div/ul/li[1]/div[3]/ul[1]/li[1]/div[3]/form/a/span[1]  - button select

//                /html/body/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div[2]/fieldset/div/ul
        //1
//                /html/body/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div[2]/fieldset/div/ul/li[1]/div[3]/ul[1]/li[1]/div[2]/span/ins
//                /html/body/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div[2]/fieldset/div/ul/li[1]/div[3]/ul[2]/li[1]
//                /html/body/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div[2]/fieldset/div/ul/li[1]/div[3]/ul[1]/li[3]/div[2]/span
        //        /html/body/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div[2]/fieldset/div/ul/li[1]/div[3]/ul[1]/li[2]
        //        /html/body/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div[2]/fieldset/div/ul/li[1]/div[3]/ul[1]/li[2]/div[3]/form/a -- button
//                /html/body/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div[2]/fieldset/div/ul/li[1]/div[3]/ul[1]/li[2]/div[2]/span/ins
//                /html/body/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div[2]/fieldset/div/ul/li[1]/div[3]/ul[1]/li[3]/div[2]/span
        //        /html/body/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div[2]/fieldset/div/ul/li[1]/div[3]/ul[2]/li[3]/div[2]/span/ins
//                /html/body/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div[2]/fieldset/div/ul/li[1]/div[3]/ul[2]/li[5]/div[2]/span
        // 2
//                /html/body/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div[2]/fieldset/div/ul/li[2]/div[3]
//                /html/body/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div[2]/fieldset/div/ul/li[2]/div[3]/ul[1]/li[1]/div[2]/span
//                /html/body/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div[2]/fieldset/div/ul/li[2]/div[3]/ul[1]/li[2]/div[2]/span/ins
//                /html/body/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div[2]/fieldset/div/ul/li[2]/div[3]/ul[1]/li[2]/div[2]/span/ins

//                /html/body/div[2]/div[3]/div[3]/div[2]/div/div/div[2]/div[2]/fieldset/div/ul/li[4]/div[3]/ul[1]/li[1]/div[2]/span



        //        WebElement t_el  =  driver.findElement(By.xpath("//*[@id=\"roomViewRegularView\"]/div[2]/"));

//        System.out.println(hotelName_Element.getText());


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
        System.setProperty("webdriver.gecko.driver", "D:\\Dmitry Prokopenko\\z_library\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(WEBSITE_WE_ARE_TESTING);
    }



}