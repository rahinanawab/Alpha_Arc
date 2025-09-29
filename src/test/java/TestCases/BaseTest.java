package TestCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pageObjects.*;

public class BaseTest {
    protected Login loginPage;
    protected Users users;
    protected Team team;

    @BeforeSuite
    public void setUp() {
        BasePage.initializeDriver();
        loginPage = new Login();
        users = new Users();
        team = new Team();


    }
//    @AfterSuite
//    public void tearDownSuite() {
//        BasePage.quitDriver();
//    }
}
