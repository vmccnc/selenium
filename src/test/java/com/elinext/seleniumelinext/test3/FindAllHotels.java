package com.elinext.seleniumelinext.test3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;

public class FindAllHotels {

    WebDriver driver;
    private final long SLEEP_SEC = 0L;

    private String WEBSITE_WE_ARE_TESTING;


    public FindAllHotels(WebDriver driver) {
        this.driver = driver;
    }







//
//    public void checRightPage(String websiteName) throws Exception {
//
//    }


    public void fillCityYouWish(String city) throws InterruptedException {
        WebElement button_ADVANCED_SEARCH_Element   = driver.findElement(By.xpath("//*[@id=\"expanded_form_view\"]/button/span[1]"));
        button_ADVANCED_SEARCH_Element.click();
        sleep(500);

        // Step 1
        WebElement find_Element_City   = driver.findElement(By.id("hotelSearchOneBox"));

        // Step 2 - Clicking buttons
        System.out.println("Fill the field 'Find a Hotel' by value " + city);
        sleep(SLEEP_SEC);
        find_Element_City.sendKeys(city);


    }


    public void fillNumberOfAdults(int numberOfAdults) throws InterruptedException {
        WebElement adultsInline_Element   = driver.findElement(By.id("room1Adults"));
        System.out.println("Select number of adults");
        sleep(SLEEP_SEC);
        new Select(adultsInline_Element).selectByVisibleText(""+ numberOfAdults);
    }


    public void fillOtherFields( ) throws InterruptedException{
        WebElement checkin_Element   = driver.findElement(By.id("checkin"));
        WebElement checkout_Element   = driver.findElement(By.id("checkout"));

        System.out.println("Select date 01 May 2019");
        sleep(SLEEP_SEC);
        checkin_Element.clear();
        checkin_Element.sendKeys("01 May 2019");

        System.out.println("Select date 07 May 2019");
        sleep(SLEEP_SEC);
        checkout_Element.clear();
        checkout_Element.sendKeys("07 May 2019");
    }


    public void clickButton() throws InterruptedException {
        WebElement button_GO_Element   = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div/div/div[1]/div/div/div/div/div/div[3]/div/div/div[1]/div/div/div/div/form/div[2]/div[5]/a[1]/span[1]"));

        System.out.println("click button 'GO'");
        sleep(SLEEP_SEC);
        button_GO_Element.click();

    }



}
