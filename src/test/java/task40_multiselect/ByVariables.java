package task40_multiselect;

import org.openqa.selenium.By;

public class ByVariables {
    static By multiSelectField = By.id("multi-select");
    static By selectAllButton = By.id("printAll");
    static By selectedList = new By.ByXPath("//p[@class='getall-selected']");

}
