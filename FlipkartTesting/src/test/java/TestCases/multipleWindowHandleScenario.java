package TestCases;

import BUCs.Utilities;
import Page_Objects.BluetoothHeadphones_Page;
import Page_Objects.Login_Page;
import Page_Objects.Main_Page;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class multipleWindowHandleScenario {

    Utilities utility = new Utilities();
    Login_Page loginPage;
    Main_Page mainPage;
    BluetoothHeadphones_Page headsetpage;
    String testFolder;
    @BeforeClass
    public void setUp() throws IOException {
        WebDriver driver = utility.launchURL();
        loginPage = new Login_Page(driver);
        mainPage = new Main_Page(driver);
        headsetpage = new BluetoothHeadphones_Page(driver);
        testFolder = utility.createTestReportFolder();
    }
 @Test
 public void searchForElectronicsCategory() throws InterruptedException, IOException {
     mainPage.hoverOverTheElectronics();
     utility.captureScreenshot(testFolder);
     mainPage.hoverOverTheAudio();
     utility.captureScreenshot(testFolder);
     String mainWindow = utility.getCurrentWindowHandle();
     utility.captureScreenshot(testFolder);
     mainPage.clickOnBluetoothHeadset();
     utility.captureScreenshot(testFolder);
     headsetpage.clickOnHeadset();
     utility.captureScreenshot(testFolder);
     utility.switchToWindow(mainWindow);
     utility.captureScreenshot(testFolder);
 }

    @AfterClass
    public void close()
    {
        ExtentReports extent = utility.createExtentReport(testFolder);
        extent.createTest("Sample Test").pass("Test Passed Successfully");

        // Save and close report
        extent.flush();
        utility.quit();
    }
}
