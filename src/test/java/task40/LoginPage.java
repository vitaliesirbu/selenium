package task40;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static task40.ByVariables.*;

public class LoginPage {

    private WebDriver driver;

    public LoginPage (WebDriver driver, String Url){
        this.driver = driver;
        this.driver.get(Url);
    }

    public String logIn(String email, String password) throws InterruptedException {
        WebElement signIn = driver.findElement(ByVariables.signInVar);
        signIn.click();

        Thread.sleep(2000); // This is a static wait and is a poor practice in test automation because
        // can lead to long test execution times and does not account for variable page load times.

        WebElement loginInput = driver.findElement(emailInputVar);
        loginInput.sendKeys(email);
        WebElement passwordInput = driver.findElement(passwordInputVar);
        passwordInput.sendKeys(password);
        WebElement signInButton = driver.findElement(ByVariables.signInButtonVar);
        signInButton.click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) // Maximum time to wait for
                .pollingEvery(Duration.ofSeconds(1)) // Polling frequency
                .ignoring(NoSuchElementException.class); // Ignore this exception while polling

        WebElement loggedInElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loggedIn));

        return loggedInElement.getText();
    }

}
