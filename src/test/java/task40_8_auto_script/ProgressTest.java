package task40_8_auto_script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProgressTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html");
    }

    @Test
    public void testDownloadProgressBar() throws InterruptedException {

        WebElement downloadButton = driver.findElement(By.id("cricle-btn"));
        downloadButton.click();

        while (true) {
            WebElement progressBar = driver.findElement(By.className("percenttext"));
            String progressText = progressBar.getText();
            int progressValue = Integer.parseInt(progressText.replace("%", "").trim());

            if (progressValue > 50) {
                driver.navigate().refresh();
                break;
            }

            Thread.sleep(500);
        }

    }

    @AfterClass
    public void tearDown(){ driver.quit(); }
}
