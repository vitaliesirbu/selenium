package task30;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SampleTest {

    private WebDriver driver;

    @BeforeClass
    void setup(){
        // Set Chrome options to disable language page
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--user-data-dir=/path/to/custom/profile");

        driver = new ChromeDriver(options);
    }

    @Test
    void sampleTest(){

        driver.navigate().to("https://google.com");

        WebElement searchInput = driver.findElement(By.xpath("//textarea[@name='q']"));
        searchInput.sendKeys("microsoft");
        searchInput.submit();

        Assert.assertTrue(driver.findElement(By.id("result-stats")).isDisplayed());
    }

    @AfterClass
    void cleanup(){
        driver.quit();
    }
}
