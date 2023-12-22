package task38_lecture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    private static final String URL="https://google.com";
    private static final By SEARCH_INPUT = By.name("q");

    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    private void navigateToUrl() {
        this.driver.get(URL);
    }

    public ResultPage search(String value) {
        navigateToUrl();
        WebElement searchInput = driver.findElement(SEARCH_INPUT);
        searchInput.sendKeys(value);
        searchInput.submit();

        return new ResultPage(driver);
    }
}
