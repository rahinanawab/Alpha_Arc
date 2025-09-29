package TestCases;

import org.testng.annotations.Test;
import pageObjects.DailyContent;

public class DailyContentTest extends BaseTest{
    @Test(priority = 4, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void dailycontents() {
        dailyContent = new DailyContent();
        dailyContent.content();
    }
}
