package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Users extends BasePage{
    private final By searchuserField = By.xpath("//input[@placeholder='Search users']");
    private final By actionbutton = By.xpath("//div[@class='flex justify-center']");
    private final By restrictbtn = By.xpath("//button[normalize-space()='Restrict']");
    private final By deletebtn = By.xpath("//button[normalize-space()='Delete']");
    private final By restricteduser = By.xpath("//button[normalize-space()='Restricted Users']");
    private final By salesuser = By.xpath("//button[normalize-space()='Sales Tab Request']");


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
        driver.findElement(searchuserField).clear();

    }

    //restricted users
    public void restrictuserstab() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(restricteduser).click();
        driver.findElement(searchuserField).clear();

        driver.findElement(searchuserField).sendKeys("Christopher");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement action = wait.until(ExpectedConditions.presenceOfElementLocated(actionbutton));
        Thread.sleep(1000);
        action.click();
        WebElement unrestrict = driver.findElement(By.xpath("//button[normalize-space()='Unrestrict']"));
        unrestrict.click();

        driver.findElement(searchuserField).clear();
        Thread.sleep(2000);
        driver.findElement(searchuserField).clear();

        driver.findElement(searchuserField).sendKeys("Harper");

        WebElement action1 = wait.until(ExpectedConditions.presenceOfElementLocated(actionbutton));
        Thread.sleep(1000);
        action1.click();
        WebElement delete = driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
        delete.click();
        driver.findElement(deletebtn).click();
        driver.findElement(searchuserField).clear();
    }
    //sales tab request users
    public void salestab() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(salesuser).click();
        driver.findElement(searchuserField).clear();

        driver.findElement(searchuserField).sendKeys("Sophia");
    }
}

