package task30;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LumaLogin {

    private WebDriver driver;

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
    }

    @Test
    void loginTest(){
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        WebElement signIn = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
        signIn.click();
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailInput.sendKeys("vitaliesirbu@coherentsolutions.com");
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
        passwordInput.sendKeys("Admin123!");
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"send2\"]/span"));
        signInButton.click();

        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span")).isDisplayed());
    }

    @AfterClass
    void cleanUp(){
        driver.quit();
    }
}
