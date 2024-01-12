package task60_page_factory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    @FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
    private WebElement myAccountButton;
    @FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
    private WebElement logoutLink;

    @FindBy(className = "logged-in")
    private WebElement welcomeMessage;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void logout(){
        myAccountButton.click();
        logoutLink.click();
    }
    public String welcomeText(){
        return welcomeMessage.getText();
    }
}
