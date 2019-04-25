package com.elinext.seleniumelinext.test1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TrigolosAlexTest1 {

    WebDriver  driver;

    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "d:\\Dmitry Prokopenko\\z_library\\chromedriver.exe");
        driver = new ChromeDriver();
    }



    @After
    public void after() {
        driver.close();
        driver.quit();
    }


    @Test
    public void doTheTest() {

        driver.get("https://www.tut.by");

        System.out.println("Waiting when 'search_from_str' element will be appeared");
        Wait<WebDriver> wait1 = new WebDriverWait(driver, 80);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_from_str")));

        // Define elements
        WebElement searchElement   = driver.findElement(By.id("search_from_str"));
        WebElement searchElement_Button   = driver.findElement(By.name("search"));

        searchElement.clear();
        searchElement.sendKeys("Лукашенко");

        searchElement_Button.click(); // click the button search
        wait1 = new WebDriverWait(driver, 80);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_from_str")));

        List<WebElement> listStringLukoshenkoSelenium = driver.findElements(By.xpath("//ol[@class='b-results-list']/li//h3//a[2]"));


        System.out.println("Nomber result on the first page: " + listStringLukoshenkoSelenium.size());


        for(int i = 0; i < listStringLukoshenkoSelenium.size() ; i++){
            System.out.println("Element " + (i+1) + ": " + listStringLukoshenkoSelenium.get(i).getText());
        }


        // Without Selenium
        List<String> stringListQueryLukoshenko2019_04_25 = getStringListQueryLukoshenko2019_04_25();



        for(int i = 0; i < listStringLukoshenkoSelenium.size() ; i++){
            System.out.println("compare " + (i+1)  );
            assertEquals(stringListQueryLukoshenko2019_04_25.get(i), listStringLukoshenkoSelenium.get(i).getText());

        }
//        Assert.assertEquals(13, listStringLukoshenkoSelenium.size());
    }

    List<String> getStringListQueryLukoshenko2019_04_25(){

        // Get manually
        List<String> stringListQueryLukoshenko2019_04_25 = new ArrayList<>();
        stringListQueryLukoshenko2019_04_25.add("Лукашенко, Александр Григорьевич — Википедия");
        stringListQueryLukoshenko2019_04_25.add("Интернет-портал Президента Республики Беларусь");
        stringListQueryLukoshenko2019_04_25.add("Александр Лукашенко | ВКонтакте");
        stringListQueryLukoshenko2019_04_25.add("Надоел нам этот лукашенко | ok.ru");
        stringListQueryLukoshenko2019_04_25.add("Трудовые мозоли, амурные дела и личные финансы. 20 любопытных фактов из...");
        stringListQueryLukoshenko2019_04_25.add("Александр Лукашенко - Лукашенко направил... — Рамблер/новости");
        stringListQueryLukoshenko2019_04_25.add("Хэштег #лукашенко в Instagram • Фото и видео");
        stringListQueryLukoshenko2019_04_25.add("Александр Лукашенко - биография, фото, личная жизнь, политика...");
        stringListQueryLukoshenko2019_04_25.add("Лукашенко - последние новости сегодня");
        stringListQueryLukoshenko2019_04_25.add("Лукашенко Александр Григорьевич - YouTube");
        stringListQueryLukoshenko2019_04_25.add("Александр Лукашенко (@Lukashenko_AG) | Twitter");
        stringListQueryLukoshenko2019_04_25.add("10 любопытных фактов из биографии Александра Лукашенко");
        stringListQueryLukoshenko2019_04_25.add("Лукашенко, Саша Гри-Горьевич — Абсурдопедия");

        return stringListQueryLukoshenko2019_04_25;
    }


}