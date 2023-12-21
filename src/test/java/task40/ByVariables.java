package task40;

import org.openqa.selenium.By;

public class ByVariables {
    public static By signInVar = By.className("authorization-link");
    public static By emailInputVar = new By.ById("email");
    public static By passwordInputVar = new By.ById("pass");
    public static By signInButtonVar = new By.ById("send2");
    public static By loggedIn = By.cssSelector("div[class='panel header'] span[class='logged-in']");

}
