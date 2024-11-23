package insaturbo

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import kotlin.test.assertTrue

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
            wait = WebDriverWait(driver, Duration.ofSeconds(15))
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
        // Navigate to the website
        driver.get("https://akor-tires.vercel.app")

        // Step 1: Select English version
        val englishLanguageOption = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'language-selector')]//span[text()='EN']")
            )
        )
        englishLanguageOption.click()

        // Step 2: Click on 'Tires' tab if not already on the page
        val tiresTab = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='Tires 4x4']")
            )
        )
        tiresTab.click()

        // Step 3: Select width and choose '235'
        val widthSelectElement = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("width"))
        )
        val widthSelect = Select(widthSelectElement)
        widthSelect.selectByValue("235")

        // Step 4: Click on select 'Profile' and select '75'
        val profileSelectElement = wait.until(
            ExpectedConditions.elementToBeClickable(By.cssSelector("//*[@id=\"root\"]/div/div/div/div[2]/div/div/div[1]/div[3]/div"))
        )
        val profileSelect = Select(profileSelectElement)
        profileSelect.selectByValue("75")

        // Step 5: Click on select 'Diameter' and select '15'
        val diameterSelectElement = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("diameter"))
        )
        val diameterSelect = Select(diameterSelectElement)
        diameterSelect.selectByValue("15")

        // Step 6: Click button 'Search tires'
        val searchButton = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector("#root > div > div > div > div.list > div > div > div.tires > div.btn-wrapper > button")
            )
        )
        searchButton.click()

        // Step 7: Find first tire in list and click on it
        val tireList = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector(".tires-list")
            )
        )
        assertTrue(tireList.isNotEmpty(), "No tires found after applying the filter.")
        println("dm:: asdfasdvasd !")



        // Click on the first tire item
        tireList[0].click()

        // Step 8: Check if 'Diameter' is on the page
        val diameterText = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), 'Diameter')]")
            )
        )
        assertTrue(diameterText.isDisplayed, "'Diameter' is not displayed on the page.")

        println("dm:: qwww222 !")
    }

    // Test methods will go here
//
//    @Test
//    fun `test tire filter and selection`() {
//        println("dm:: 1")
//        driver.get("https://akor-tires.vercel.app")
//
//        val filterButtonww = wait.until {
//            driver.findElement(By.cssSelector("#root > div > div > header > div > div > div > div.language-selector > span:nth-child(3)"))
//        }
//        println("dm:: 2")
//        filterButtonww.click()
//
//        println("dm:: 3")
//        // Navigate to the tires section if necessary
//        val tiresTab = wait.until {
//            driver.findElement(By.xpath("//a[contains(text(), 'Шины')]"))
//        }
//
//        println("dm:: 4")
//        tiresTab.click()
//
//        println("dm:: 5")
//
//
//
//        println("dm:: 6")
//        // Select specific filter options
////        val widthOption = wait.until {
////            driver.findElement(By.xpath("//*[@id=\"2\"]"))
////        }
////        println("dm:: 6/11")
////        widthOption.click()
////        println("dm:: 6/111+")
////        val heightOption = driver.findElement(By.xpath("//*[@id=\"0\"]"))
////        heightOption.click()
////        println("dm:: 6.2")
////        val diameterOption = driver.findElement(By.xpath("//label[contains(text(), 'Диаметр')]/following-sibling::select"))
////        diameterOption.sendKeys("16")
//
//        // Submit the filter
////        val applyFilterButton = driver.findElement(By.cssSelector("#root > div > div > div > div.list > div > div > div.tires > div.btn-wrapper > button"))
////        applyFilterButton.click()
//
//        // Apply a filter (modify selectors based on actual elements)
//        val filterButton = wait.until {
//            driver.findElement(By.cssSelector("#root > div > div > div > div.list.active > div.wrapper.active > div > div > div.btn-wrapper"))
//        }
//        filterButton.click()
//        println("dm:: 7")
//        // Wait for results to load
//        wait.until {
//            driver.findElements(By.cssSelector(".tire-item")).isNotEmpty()
//        }
//        println("dm:: 8")
//        // Verify that tires are displayed
//        val tireElements = driver.findElements(By.cssSelector(".tire-item"))
//        assert(tireElements.isNotEmpty()) { "No tires found after applying the filter." }
//        println("dm:: 9")
//        // Click on the first tire
//        tireElements[0].click()
//        println("dm:: 10")
//        // Verify that the tire details page is displayed
//        val tireDetail = wait.until {
//            driver.findElement(By.cssSelector(".tire-details"))
//        }
//        assert(tireDetail.isDisplayed) { "Tire details are not displayed." }
//    }

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
