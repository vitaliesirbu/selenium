package task40_alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
    }

    @Test
    public void testConfirmAlert(){
        WebElement confirmButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg'][normalize-space()='Click me!']"));
        confirmButton.click();

        Alert confirmAlert = driver.switchTo().alert();

        String alertText = confirmAlert.getText();
        Assert.assertEquals(alertText,"Press a button!");

        confirmAlert.accept();

        WebElement resultText = driver.findElement(By.id("confirm-demo"));
        Assert.assertEquals(resultText.getText(),"You pressed OK!");
    }

    @Test
    public void testDismissAlert(){
        WebElement confirmButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg'][normalize-space()='Click me!']"));
        confirmButton.click();

        Alert confirmAlert = driver.switchTo().alert();

        String alertText = confirmAlert.getText();
        Assert.assertEquals(alertText,"Press a button!");

        confirmAlert.dismiss();

        WebElement resultText = driver.findElement(By.id("confirm-demo"));
        Assert.assertEquals(resultText.getText(),"You pressed Cancel!");
    }


    @Test
    public void testAlertBox(){
        WebElement promptBoxButton = driver.findElement(By.xpath("//button[normalize-space()='Click for Prompt Box']"));
        promptBoxButton.click();

        Alert confimAlert = driver.switchTo().alert();
        confimAlert.sendKeys("Elon");

        confimAlert.accept();

        WebElement resultText = driver.findElement(By.xpath("//p[@id='prompt-demo']"));
        Assert.assertEquals(resultText.getText(),"You have entered 'Elon' !");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
