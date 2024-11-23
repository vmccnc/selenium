package com.selenium.dm.insaturbo

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class TireTests {

    companion object {
        lateinit var driver: WebDriver
        lateinit var wait: WebDriverWait

        @BeforeAll
        @JvmStatic
        fun setup() {
            // Initialize ChromeDriver with options
            val options = ChromeOptions()
            options.addArguments("--start-maximized")
            driver = ChromeDriver(options)

            // Initialize WebDriverWait
            wait = WebDriverWait(driver, Duration.ofSeconds(2))
        }

        @AfterAll
        @JvmStatic
        fun teardown() {
            if (this::driver.isInitialized) {
                driver.quit()
            }
        }
    }

    // Test methods will go here

    @Test
    fun `test tire filter and selection`() {
println("dm:: 1")
        driver.get("https://akor-tires.vercel.app")

        val filterButtonww = wait.until {
            driver.findElement(By.cssSelector("#root > div > div > header > div > div > div > div.language-selector > span:nth-child(3)"))
        }
        println("dm:: 2")
        filterButtonww.click()

        println("dm:: 3")
        // Navigate to the tires section if necessary
        val tiresTab = wait.until {
            driver.findElement(By.xpath("//a[contains(text(), 'Шины')]"))
        }
        println("dm:: 4")
        tiresTab.click()

        println("dm:: 5")

        // Apply a filter (modify selectors based on actual elements)
        val filterButton = wait.until {
            driver.findElement(By.cssSelector("#root > div > div > div > div.list > div > div > div.tires > div.btn-wrapper > button"))
        }
        filterButton.click()
        println("dm:: 6")
//        // Select specific filter options
//        val widthOption = wait.until {
//            driver.findElement(By.xpath("//label[contains(text(), 'Ширина')]/following-sibling::select"))
//        }
//        widthOption.sendKeys("205")
//
//        val heightOption = driver.findElement(By.xpath("//label[contains(text(), 'Высота')]/following-sibling::select"))
//        heightOption.sendKeys("55")
//
//        val diameterOption = driver.findElement(By.xpath("//label[contains(text(), 'Диаметр')]/following-sibling::select"))
//        diameterOption.sendKeys("16")

        // Submit the filter
//        val applyFilterButton = driver.findElement(By.cssSelector("#root > div > div > div > div.list > div > div > div.tires > div.btn-wrapper > button"))
//        applyFilterButton.click()
        println("dm:: 7")
        // Wait for results to load
        wait.until {
            driver.findElements(By.cssSelector(".tire-item")).isNotEmpty()
        }
        println("dm:: 8")
        // Verify that tires are displayed
        val tireElements = driver.findElements(By.cssSelector(".tire-item"))
        assert(tireElements.isNotEmpty()) { "No tires found after applying the filter." }
        println("dm:: 9")
        // Click on the first tire
        tireElements[0].click()
        println("dm:: 10")
        // Verify that the tire details page is displayed
        val tireDetail = wait.until {
            driver.findElement(By.cssSelector(".tire-details"))
        }
        assert(tireDetail.isDisplayed) { "Tire details are not displayed." }
    }

//
//    //2
//    @Test
//    fun `test wheel filter and selection`() {
//        driver.get("https://akor-tires.vercel.app")
//
//        // Navigate to the wheels section
//        // Apply a filter (modify selectors based on actual elements)
//        val filterButtonww = wait.until {
//            driver.findElement(By.cssSelector("//*[@id=\"root\"]/div/div/header/div/div/div/div[3]/span[1]"))
//        }
//        filterButtonww.click()
//
//        val wheelsTab = wait.until {
//            driver.findElement(By.xpath("//a[contains(text(), 'Диски')]"))
//        }
//        wheelsTab.click()
//
//        // Apply a filter (modify selectors based on actual elements)
//        val filterButton = wait.until {
//            driver.findElement(By.cssSelector("button.filter-button"))
//        }
//        filterButton.click()
//
//        // Select specific filter options
//        val diameterOption = wait.until {
//            driver.findElement(By.xpath("//label[contains(text(), 'Диаметр')]/following-sibling::select"))
//        }
//        diameterOption.sendKeys("16")
//
//        val pcdOption = driver.findElement(By.xpath("//label[contains(text(), 'PCD')]/following-sibling::select"))
//        pcdOption.sendKeys("5x114.3")
//
//        // Submit the filter
//        val applyFilterButton = driver.findElement(By.cssSelector("button.apply-filter"))
//        applyFilterButton.click()
//
//        // Wait for results to load
//        wait.until {
//            driver.findElements(By.cssSelector(".wheel-item")).isNotEmpty()
//        }
//
//        // Verify that wheels are displayed
//        val wheelElements = driver.findElements(By.cssSelector(".wheel-item"))
//        assert(wheelElements.isNotEmpty()) { "No wheels found after applying the filter." }
//
//        // Click on the first wheel
//        wheelElements[0].click()
//
//        // Verify that the wheel details page is displayed
//        val wheelDetail = wait.until {
//            driver.findElement(By.cssSelector(".wheel-details"))
//        }
//        assert(wheelDetail.isDisplayed) { "Wheel details are not displayed." }
//    }

}
