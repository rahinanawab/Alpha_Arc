package pageObjects;

import TestCases.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Users extends BasePage{
    private final By searchuserField = By.xpath("//input[@placeholder='Search users']");
    private final By actionbutton = By.xpath("//div[@class='flex justify-center']");
    private final By restrictbtn = By.xpath("//button[normalize-space()='Restrict']");
    private final By deletebtn = By.xpath("//button[normalize-space()='Delete']");
    private final By restricteduser = By.xpath("//button[normalize-space()='Restricted Users']");
    private final By salesuser = By.xpath("//button[normalize-space()='Sales Tab Request']");
    private final By viewbtn = By.xpath("//button[normalize-space()='View']");
    private final By team = By.xpath("//div[@class='relative']");
    private final By addtosalesteam = By.xpath("//button[normalize-space()='Add to Sales Team']");
    private final By reject = By.xpath("//button[normalize-space()='Reject']");

    //active users
    public void activeuserstab() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(searchuserField).sendKeys("Robert");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement action = wait.until(ExpectedConditions.presenceOfElementLocated(actionbutton));
        Thread.sleep(1000);
        action.click();
        WebElement restrict = driver.findElement(By.xpath("//button[normalize-space()='Restrict']"));
        restrict.click();
        driver.findElement(restrictbtn).click();
        driver.findElement(searchuserField).clear();
        Thread.sleep(2000);
        driver.findElement(searchuserField).sendKeys("John");

        WebElement action1 = wait.until(ExpectedConditions.presenceOfElementLocated(actionbutton));
        Thread.sleep(1000);
        action1.click();
        WebElement delete = driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
        delete.click();
        driver.findElement(deletebtn).click();
    }

    //restricted users
    public void restrictuserstab() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(restricteduser).click();
        driver.findElement(searchuserField).sendKeys("Christopher");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement action = wait.until(ExpectedConditions.presenceOfElementLocated(actionbutton));
        Thread.sleep(1000);
        action.click();
        WebElement unrestrict = driver.findElement(By.xpath("//button[normalize-space()='Unrestrict']"));
        unrestrict.click();
        Thread.sleep(2000);
        driver.findElement(searchuserField).clear();
        driver.findElement(searchuserField).sendKeys("Harper");
        WebElement action1 = wait.until(ExpectedConditions.presenceOfElementLocated(actionbutton));
        Thread.sleep(1000);
        action1.click();
        WebElement delete = driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
        delete.click();
        driver.findElement(deletebtn).click();
    }

    //sales tab request users
    public void salestab() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(salesuser).click();
        driver.findElement(searchuserField).sendKeys("Sophia");
        driver.findElement(viewbtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement teamfield = wait.until(ExpectedConditions.presenceOfElementLocated(team));
        Thread.sleep(1000);
        teamfield.click();
        List<WebElement> options = driver.findElements(By.xpath("//div[contains(@role,'listbox')]//button"));
        if (!options.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(options.size());
            options.get(randomIndex).click();
            System.out.println("Selected option index of threat level: " + randomIndex);
        } else {
            System.out.println("No options found.");
        }
        driver.findElement(addtosalesteam).click();
        Thread.sleep(2000);
        driver.findElement(searchuserField).clear();
        driver.findElement(searchuserField).sendKeys("James");
        driver.findElement(viewbtn).click();
        driver.findElement(reject).click();
        driver.findElement(searchuserField).clear();
    }
}

