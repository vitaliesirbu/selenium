package task30;

import org.openqa.selenium.By;

public class ByVariables {
    public static By SignIn = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");
    public static By EmailInput = By.xpath("//*[@id=\"email\"]");
    public static By PasswordInput = By.xpath("//*[@id=\"pass\"]");
    public static By SignInButton = By.xpath("//*[@id=\"send2\"]/span");

    public static By AssertElement = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span");

}
