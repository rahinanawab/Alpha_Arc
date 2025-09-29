package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class DailyContent extends BasePage  {
    private final By dailycontent = By.xpath("(//button[@class='w-full flex items-center px-4 py-3 txt-16 rounded-md transition-colors text-text-col font-normal hover:bg-neutral-100'])[1]");
    private final By quotes = By.xpath("//a[normalize-space()='Quotes']");
    private final By addquote = By.xpath("//button[normalize-space()='Add Quote']");
    private final By date = By.xpath("(//button[contains(@class,'w-full max-h-[56px] text-left p-5 rounded bg-[#F2F5F6] flex items-center justify-between foust:outline-none focus:green')])[1]");
    private final By date1 = By.xpath("(//button[contains(@class,'w-full max-h-[56px] text-left p-5 rounded bg-[#F2F5F6] flex items-center justify-between foust:outline-none focus:green')])[1]");
    private final By date2 = By.xpath("(//button[contains(@class,'w-full max-h-[56px] text-left p-5 rounded bg-[#F2F5F6] flex items-center justify-between foust:outline-none focus:green')])[1]");

    private final By quote = By.xpath("//textarea[@placeholder='Add Quote (Max 150 characters)']");
    private final By addanotherquote = By.xpath("(//button[contains(@class,'text-[#111827] font-medium flex items-center gap-2 mt-3')])[1]");
    private final By addbtn = By.xpath("//button[normalize-space()='Add']");
    private final By actionbutton = By.xpath("(//div[@class='relative inline-block '])[1]");
    private final By editbtn = By.xpath("//button[normalize-space()='Save Changes']");
    private final By deletebtn = By.xpath("//button[normalize-space()='Delete']");
    private final By searchquotesField = By.xpath("//input[@placeholder='Search quotes']");

    private final Random random = new Random();

    private String getRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }

    public void content() throws InterruptedException {
        driver.findElement(dailycontent).click();
        driver.findElement(quotes).click();
        driver.findElement(addquote).click();
        driver.findElement(date).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//button[contains(@title,'2025-09-30')])")));
        date.click();
        driver.findElement(quote).sendKeys(getRandomString(100));
        driver.findElement(addanotherquote).click();
        driver.findElement(date1).click();
        WebElement date1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//button[contains(@title,'2025-09-30')])")));
        date1.click();
        driver.findElement(quote).sendKeys(getRandomString(100));
        driver.findElement(addbtn).click();
        WebElement action = wait.until(ExpectedConditions.presenceOfElementLocated(actionbutton));
        Thread.sleep(1000);
        action.click();
        WebElement edit = driver.findElement(By.xpath("//button[normalize-space()='Edit']"));
        edit.click();
        driver.findElement(date2).click();
//        driver.findElement(date2).clear();
        WebElement date2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//button[contains(@title,'2025-09-29')])")));
        date2.click();
        driver.findElement(quote).clear();
        driver.findElement(quote).sendKeys(getRandomString(100));
        driver.findElement(editbtn).click();
        WebElement action1 = wait.until(ExpectedConditions.presenceOfElementLocated(actionbutton));
        Thread.sleep(1000);
        action1.click();
        WebElement delete = driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
        delete.click();
        driver.findElement(deletebtn).click();
        Thread.sleep(1000);
        driver.findElement(searchquotesField).sendKeys("Success");
    }
}
