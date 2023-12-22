package task40_multiselect;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static task40_multiselect.ByVariables.*;

public class MultiSelectTest {
    private static final String LOGIN_PAGE_URL = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";

    private WebDriver driver;
    @BeforeMethod
    void setup(){
        driver = new ChromeDriver();
        driver.get(LOGIN_PAGE_URL);
    }

    @Test
    void testMultiSelect() {

        WebElement multiSelectElement = driver.findElement(multiSelectField);
        Select multiSelect = new Select(multiSelectElement);
        List<WebElement> options = multiSelect.getOptions();
        Random random = new Random();

        // Select 3 random options
        Set<String> selectedValues = new HashSet<>();
        while (selectedValues.size() < 3) {
            int randomIndex = random.nextInt(options.size());
            WebElement option = options.get(randomIndex);
            selectedValues.add(option.getAttribute("value"));
            multiSelect.selectByIndex(randomIndex);
        }

        // Click on 'Get All Selected' button
        WebElement getAllSelectedButton = driver.findElement(selectAllButton);
        getAllSelectedButton.click();

        // Verify selected options are displayed in the paragraph
        WebElement selectedOptionsDisplay = driver.findElement(selectedList);
        String selectedOptionsText = selectedOptionsDisplay.getText();
        String[] displayedValues = selectedOptionsText.split(":")[1].trim().split(",");

        Assert.assertTrue(selectedOptionsText.contains("Options selected are"), "Selected options are not displayed correctly");
        for (String value : displayedValues) {
            Assert.assertTrue(selectedValues.contains(value.trim()), "Option " + value + " should be in the displayed list");
        }
    }
    @AfterMethod
    void cleanUp(){
        driver.quit();
    }
}
