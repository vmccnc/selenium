package com.elinext.seleniumelinext.test3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;

public class FindAllHotels {

    WebDriver driver;
    private final long SLEEP_SEC = 00L;

    @FindBy(xpath = "//*[@id=\"expanded_form_view\"]/button/span[1]")
    WebElement button_ADVANCED_SEARCH;

    @FindBy(id = "hotelSearchOneBox")
    WebElement cityElement;

    @FindBy(id = "checkin")
    WebElement checkin_Element;

    @FindBy(id = "checkout")
    WebElement checkout_Element;

//    @FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/div/div/div[1]/div/div/div/div/div/div[3]/div/div/div[1]/div/div/div/div/form/div[2]/div[5]/a[1]/span[1]")
//    WebElement button_GO;
    @FindBy(css = "a[class='find_button cta_button findItButton'][role='button']")
    WebElement button_GO;





   // Steps we want to do

    // Step 1
    public void fillCityYouWish(String city) throws InterruptedException {

        System.out.println("1) click button 'ADVANCED SEARCH'" );
        sleep(SLEEP_SEC);
        button_ADVANCED_SEARCH.click();

        System.out.println("2) Fill the field 'Find a Hotel' by value " + city);
        sleep(SLEEP_SEC);
        cityElement.sendKeys(city);
    }


    // Step 2
    public void fillCheckInAndCheckOut(String checkIn, String checkOut ) throws InterruptedException{

        System.out.println("3) Select date - " + checkIn);
        sleep(SLEEP_SEC);
        checkin_Element.clear();
        checkin_Element.sendKeys(checkIn);

        System.out.println("4) Select date - " + checkOut);
        sleep(SLEEP_SEC);
        checkout_Element.clear();
        checkout_Element.sendKeys(checkOut);
    }

    // Step 3
    public void fillNumberOfAdults(int numberOfAdults) throws InterruptedException {
        WebElement adultsInline_Element   = driver.findElement(By.id("room1Adults"));
        System.out.println("5) Select number of adults - " + numberOfAdults);
        sleep(SLEEP_SEC);
        new Select(adultsInline_Element).selectByVisibleText(""+ numberOfAdults);
    }

    // Step 4
    public void clickButton() throws InterruptedException {

        System.out.println("6) click button 'GO'");
        sleep(SLEEP_SEC);
        button_GO.click();
    }


    // Action
    public void action(String city, String checkIn, String checkOut, int numberOfAdults) throws InterruptedException {
        fillCityYouWish(city);
        fillCheckInAndCheckOut(checkIn, checkOut);
        fillNumberOfAdults(numberOfAdults);
        clickButton();
    }


    public FindAllHotels(WebDriver driver) {
        // Initialize the state of the driver
        this.driver = driver;
        // Initialize web elements
        PageFactory.initElements(driver, this);
    }


}
