package task38_lecture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SampleTest {

    private static final String SEARCH_VALUE = "Microsoft";
    private SearchPage searchPage;
    private WebDriver driver;

    @BeforeTest
    void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--user-data-dir=/path/to/custom/profile");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    void sampleTest(){
        searchPage = new SearchPage(driver);
        ResultPage resultPage = searchPage.search("Microsoft");
        resultPage.waitForResults();

        Assert.assertTrue(resultPage.getResultHeaders().stream().allMatch(text -> text.contains(SEARCH_VALUE)));
    }

    @AfterTest
    void cleanUp(){
        driver.quit();
    }
}
