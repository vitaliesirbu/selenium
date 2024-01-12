package task60_page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="email")
    private WebElement emailField;

    @FindBy(id="pass")
    private WebElement passwordFied;

    @FindBy(id="send2")
    private WebElement loginButton;

    @FindBy(className = "authorization-link")
    private WebElement signInLink;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        signInLink.click();
        emailField.clear();
        emailField.sendKeys(email);
        passwordFied.clear();
        passwordFied.sendKeys(password);
        loginButton.click();
    }

}
