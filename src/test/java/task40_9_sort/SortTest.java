package task40_9_sort;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class SortTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
    }
    @Test
    public void filterTable() {
        setSelectedDropdownOption("10");
        List<Employee> filteredData = getFilteredData(45, 200000);
        for (Employee employee : filteredData) {
            System.out.println("Name: " + employee.name + ", Position: " + employee.position + ", Office: " + employee.office);
        }
    }
    public void setSelectedDropdownOption(String value) {
        Select dropdown = new Select(driver.findElement(By.name("example_length")));
        dropdown.selectByValue(value);
    }
    public List<Employee> getFilteredData(int minAge, int maxSalary) {
        List<Employee> employees = new ArrayList<>();
        List<WebElement> pages = driver.findElements(By.cssSelector("#example_paginate span a"));

        for (int i = 1; i <= pages.size(); i++) {
            WebElement page = driver.findElement(By.cssSelector("#example_paginate span a[data-dt-idx='" + i + "']"));
            page.click();

            List<WebElement> rows = driver.findElements(By.cssSelector("#example tbody tr"));
            for (WebElement row : rows) {
                int age = Integer.parseInt(row.findElement(By.xpath(".//td[4]")).getText());
                String salaryString = row.findElement(By.xpath(".//td[6]")).getText().replace("$", "").replace(",","").replace("/y", "");
                int salary = Integer.parseInt(salaryString);

                if (age > minAge && salary <= maxSalary) {
                    String name = row.findElement(By.xpath(".//td[1]")).getText();
                    String position = row.findElement(By.xpath(".//td[2]")).getText();
                    String office = row.findElement(By.xpath(".//td[3]")).getText();
                    employees.add(new Employee(name, position, office));
                }
            }
        }
        return employees;
    }

    @AfterTest
    public void tearDown(){ driver.quit(); }
}
