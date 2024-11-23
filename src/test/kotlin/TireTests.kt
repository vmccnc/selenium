package com.insaturbo.ee

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class TireTests {

    companion object {
        lateinit var driver: WebDriver

        @BeforeAll
        @JvmStatic
        fun setup() {
            // Set the path to your chromedriver executable
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\marke\\OneDrive\\Documents\\chromedriver-win64\\chromedriver.exe")

            // Optional: Set Chrome options
            val options = ChromeOptions()
            options.addArguments("--start-maximized")

            driver = ChromeDriver(options)
        }

        @AfterAll
        @JvmStatic
        fun teardown() {
            if (this::driver.isInitialized) {
                driver.quit()
            }
        }

    }

    @Test
    fun `test tire filter and selection`() {
        driver.get("https://akor-tires.vercel.app")

        val wait = WebDriverWait(driver, Duration.ofSeconds(10))

        // Apply tire filter (modify the selector to match your filter element)
        val filterElement = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("btn-wrapper"))
        )
        filterElement.click()

        // Wait for the results to load
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.className("tire-item"))
        )

        // Verify that tires are displayed
        val tireElements = driver.findElements(By.className("tire-item"))
        assert(tireElements.isNotEmpty()) { "No tires found after applying the filter." }

        // Click on the first tire
        tireElements[0].click()

        // Verify that the tire details page is displayed
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("tire-details"))
        )
        val tireDetail = driver.findElement(By.id("tire-details"))
        assert(tireDetail.isDisplayed) { "Tire details are not displayed." }
    }

    @Test
    fun `test wheel filter and selection`() {
        driver.get("https://akor-tires.vercel.app")

        val wait = WebDriverWait(driver, Duration.ofSeconds(10))

        // Navigate to wheels section
        val wheelsTab = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("wheels-tab"))
        )
        wheelsTab.click()

        // Apply wheel filter (modify the selector to match your filter element)
        val wheelFilter = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("wheel-filter"))
        )
        wheelFilter.click()

        // Wait for the results to load
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.className("wheel-item"))
        )

        // Verify that wheels are displayed
        val wheelElements = driver.findElements(By.className("wheel-item"))
        assert(wheelElements.isNotEmpty()) { "No wheels found after applying the filter." }

        // Click on the first wheel
        wheelElements[0].click()

        // Verify that the wheel details page is displayed
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("wheel-details"))
        )
        val wheelDetail = driver.findElement(By.id("wheel-details"))
        assert(wheelDetail.isDisplayed) { "Wheel details are not displayed." }
    }
}
