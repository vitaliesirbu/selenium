package task38_lecture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPage {

    private static final By MORE_RESULTS = By.xpath("//span[@class='RVQdVd']");
    private static final By RESULT_HEADERS = By.xpath("h3.LC20lb");
    private final WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;

        new WebDriverWait(this.driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(MORE_RESULTS));
    }

    public List<String> getResultHeaders(){
        return  driver.findElements(RESULT_HEADERS).stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
