package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends BasePage {

    private final By emailField = By.xpath("//input[@placeholder='Enter email address']");
    private final By passwordField = By.xpath("//input[@placeholder='Enter password']");
    private final By loginButton = By.xpath("//button[normalize-space()='Log in']");

    public void navigateToLoginPage() {
        driver.get("https://alpha3-omega.vercel.app/");
    }
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginSuccessful() {
        return driver.getCurrentUrl().contains("https://alpha3-omega.vercel.app/");
    }

}
