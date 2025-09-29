package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Team extends BasePage{
    private final By teammanagement = By.xpath("//a[@href='/dashboard/team-management']");
    private final By createteam = By.xpath("//button[normalize-space()='Create Team']");
    private final By teamname = By.xpath("//input[@placeholder='Enter team name']");
    private final By createteambtn = By.xpath("//button[normalize-space()='Create']");
    private final By actionbutton = By.xpath("(//div[@class='relative inline-block '])[1]");
    private final By editbtn = By.xpath("//button[normalize-space()='Save changes']");
    private final By deletebtn = By.xpath("//button[normalize-space()='Delete']");
    private final By searchteamField = By.xpath("//input[@placeholder='Search teams']");

    private final Random random = new Random();

    private String getRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }

    public void teams() throws InterruptedException {
        driver.findElement(teammanagement).click();
        driver.findElement(createteam).click();
        driver.findElement(teamname).sendKeys(getRandomString(6));
        driver.findElement(createteambtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement action = wait.until(ExpectedConditions.presenceOfElementLocated(actionbutton));
        Thread.sleep(1000);
        action.click();
        WebElement edit = driver.findElement(By.xpath("//button[normalize-space()='Edit']"));
        edit.click();
        driver.findElement(teamname).clear();
        driver.findElement(teamname).sendKeys(getRandomString(6));
        driver.findElement(editbtn).click();
        WebElement action1 = wait.until(ExpectedConditions.presenceOfElementLocated(actionbutton));
        Thread.sleep(1000);
        action1.click();
        WebElement delete = driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
        delete.click();
        driver.findElement(deletebtn).click();
        Thread.sleep(1000);
        driver.findElement(searchteamField).sendKeys("Developments");
    }
}