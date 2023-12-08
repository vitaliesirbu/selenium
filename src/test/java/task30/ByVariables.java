package task30;

import org.openqa.selenium.By;

public class ByVariables {
    public static By SignIn = By.className("authorization-link");
    public static By EmailInput = new By.ById("email");
    public static By PasswordInput = new By.ById("pass");
    public static By SignInButton = new By.ById("send2");

    public static By AssertElement = By.className("logged-in");
   // public static By AssertElement = new By.ByCssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.greet.welcome > span");


}
