package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(priority = 1)
public void testLogin() {
    loginPage.navigateToLoginPage();
    loginPage.enterEmail("peace@yopmail.com");
    loginPage.enterPassword("Test@123");
    loginPage.clickLogin();
    Assert.assertTrue(loginPage.isLoginSuccessful(), "Login Failed!");
    System.out.println("Login Successful!");
}
}
