package TestCases;

import BUCs.Utilities;
import Page_Objects.Login_Page;
import Page_Objects.Main_Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Dropdown_Testcase_Scenario {
    Utilities utility = new Utilities();
    Main_Page mainpage;
   // Login_Page loginPage;
    @BeforeClass
    public void setUp()
    {
        WebDriver driver = utility.isHeadless();
        mainpage = new Main_Page(driver);
       // loginPage = new Login_Page(driver);
    }

     @Test
     public void verifyElectronicsCategory()
     {
      mainpage.hoverOverTheDropdown();
      mainpage.clickOnMyProfile();
     }
    @AfterClass
    public void close() throws InterruptedException {
        Thread.sleep(5000);
        utility.close();
    }

}
