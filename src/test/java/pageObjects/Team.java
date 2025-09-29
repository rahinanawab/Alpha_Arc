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
    private final By noofmembers = By.xpath("//tbody/tr[1]/td[2]/div[1]");
    private final By addteamember = By.xpath("//button[normalize-space()='Add Team Member']");
    private final By fullname = By.xpath("//input[@placeholder='Enter full name']");
    private final By username = By.xpath("//input[@placeholder='Enter username']");
    private final By email = By.xpath("//input[@placeholder='Enter email address']");
    private final By sendinvitebtn = By.xpath("//button[normalize-space()='Send Invite']");
    private final By actionbtn = By.xpath("//div[@class='flex justify-center']//div[@class='relative inline-block']");
    private final By editbutton = By.xpath("//button[normalize-space()='Save Changes']");
    private final By backbtn = By.xpath("//button[@aria-label='Back']");
    private final By actionbutton = By.xpath("(//div[@class='relative inline-block '])[1]");
    private final By editbtn = By.xpath("//button[normalize-space()='Save changes']");
    private final By restrictbtn = By.xpath("//button[normalize-space()='Restrict']");
    private final By deletebtn = By.xpath("//button[normalize-space()='Delete']");
    private final By searchuserField = By.xpath("//input[@placeholder='Search by name, username, or email']");

    private final Random random = new Random();

    private String getRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }
    private String getRandomEmail() {
        return getRandomString(8) + "@gmail.com";
    }

    public void teams() throws InterruptedException {
        driver.findElement(teammanagement).click();
        driver.findElement(createteam).click();
        driver.findElement(teamname).sendKeys(getRandomString(6));
        driver.findElement(createteambtn).click();
        driver.findElement(noofmembers).click();
        driver.findElement(addteamember).click();
        driver.findElement(fullname).sendKeys(getRandomString(6));
        driver.findElement(username).sendKeys(getRandomString(6));
        driver.findElement(email).sendKeys(getRandomEmail());
        driver.findElement(sendinvitebtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement action1 = wait.until(ExpectedConditions.presenceOfElementLocated(actionbtn));
        Thread.sleep(1000);
        action1.click();
        WebElement edit1 = driver.findElement(By.xpath("//button[normalize-space()='Edit']"));
        edit1.click();
        driver.findElement(fullname).clear();
        driver.findElement(fullname).sendKeys(getRandomString(6));
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(getRandomString(6));
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(getRandomEmail());
        driver.findElement(editbutton).click();
        WebElement action2 = wait.until(ExpectedConditions.presenceOfElementLocated(actionbtn));
        Thread.sleep(1000);
        action2.click();
        WebElement restrict = driver.findElement(By.xpath("//button[normalize-space()='Restrict']"));
        restrict.click();
        driver.findElement(restrictbtn).click();
        WebElement action3 = wait.until(ExpectedConditions.presenceOfElementLocated(actionbtn));
        Thread.sleep(1000);
        action3.click();
        WebElement delete = driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
        delete.click();
        driver.findElement(deletebtn).click();
        Thread.sleep(1000);
        driver.findElement(searchuserField).sendKeys("Sarah");
        driver.findElement(backbtn).click();
        WebElement action = wait.until(ExpectedConditions.presenceOfElementLocated(actionbutton));
        Thread.sleep(1000);
        action.click();
        WebElement edit = driver.findElement(By.xpath("//button[normalize-space()='Edit']"));
        edit.click();
        driver.findElement(teamname).clear();
        driver.findElement(teamname).sendKeys(getRandomString(6));
        driver.findElement(editbtn).click();
        WebElement action4 = wait.until(ExpectedConditions.presenceOfElementLocated(actionbutton));
        Thread.sleep(1000);
        action4.click();
        WebElement delete1 = driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
        delete1.click();
        driver.findElement(deletebtn).click();
        Thread.sleep(1000);
        driver.findElement(searchuserField).sendKeys("Developments");
    }
}