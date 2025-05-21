package TestCases;

import BUCs.Utilities;
import Page_Objects.Login_Page;
import Page_Objects.Main_Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Login_to_app {

    Utilities utility = new Utilities();
    Login_Page loginPage;
    Main_Page mainPage;
    @BeforeClass
    public void setUp()
    {
        WebDriver driver = utility.launchURL();
        loginPage = new Login_Page(driver);
        mainPage = new Main_Page(driver);
    }

    @Test
    public void loginToApp() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        mainPage.clickOnLogin();
        loginPage.enterEmailOrMobileNo("8265991390");
        loginPage.clickOnRequestOTP();
        int value = scanner.nextInt();
        loginPage.enterOTP(value);
    }
   @AfterClass
   public void close()
    {
        utility.close();
    }

}


