package pageObjects;

import org.openqa.selenium.By;

public class Team extends BasePage{
    private final By teammanagement = By.xpath("//a[@href='/dashboard/team-management']");

    public void teams(){
        driver.findElement(teammanagement).click();
    }
}
