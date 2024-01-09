package task40_7_wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitForUser {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUP(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,  Duration.ofSeconds(20));
        driver.get("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html");
    }

    @Test
    public void testDynamicLoading(){
        WebElement getNewUserButton = driver.findElement(By.id("save"));
        getNewUserButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

        WebElement firstName = driver.findElement(By.xpath("//div[@id='loading']//following-sibling::br[contains(text(), 'First Name')]"));
        Assert.assertNotNull(firstName.getText());
        System.out.println(firstName);
    }

    @AfterTest
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
