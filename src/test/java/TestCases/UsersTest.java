package TestCases;

import org.testng.annotations.Test;
import pageObjects.Users;

public class UsersTest extends BaseTest{

    @Test(priority = 5, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void testUser() throws InterruptedException {
        users = new Users();
        users.activeuserstab();
        users.restrictuserstab();
    }
}
