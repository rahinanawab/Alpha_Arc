package TestCases;

import org.testng.annotations.Test;
import pageObjects.Team;

public class TeamTest extends BaseTest{
    @Test(priority = 3, dependsOnMethods = "TestCases.LoginTest.testLogin")
    public void testTeam() throws InterruptedException {
        team = new Team();
        team.teams();
    }
}
