package pageObjects;

import org.openqa.selenium.By;

public class DailyContent extends BasePage  {
    private final By dailycontent = By.xpath("(//button[@class='w-full flex items-center px-4 py-3 txt-16 rounded-md transition-colors text-text-col font-normal hover:bg-neutral-100'])[1]");
    private final By quotes = By.xpath("//a[normalize-space()='Quotes']");

    public void content(){
        driver.findElement(dailycontent).click();
        driver.findElement(quotes).click();
    }
}
