package BUCs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Utilities {
   WebDriver driver;

    //To open browser and launch URl
    public WebDriver launchURL(){
        System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    public void close()
    {
       driver.close();
    }
    public void quit()
    {
        driver.quit();
    }
     public String getCurrentWindowHandle(){
        return driver.getWindowHandle();
     }
     public void switchToWindow(String window){
        driver.switchTo().window(window);
     }


     public String createTestReportFolder()
     {
         // Generate timestamped folder name
         String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
         String parentDir = System.getProperty("user.dir") + "/TestRun_" + timestamp;

         // Create parent folder
         new File(parentDir).mkdirs();

         // Create subfolders for reports & screenshots
         new File(parentDir + "/ExtentReports").mkdirs();
         new File(parentDir + "/Screenshots").mkdirs();

         return parentDir;
     }

     public void captureScreenshot(String ParentFolder){
         String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
         String screenshotName = "SS_"+timestamp+".png";
         File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         File destFile = new File(ParentFolder + "/Screenshots/" + screenshotName + ".png");

         try {
             FileUtils.copyFile(srcFile, destFile);
         } catch (IOException e) {
             System.out.println("Error saving screenshot: " + e.getMessage());
         }
     }

    public static ExtentReports createExtentReport(String parentFolder) {
        String reportPath = parentFolder + "/ExtentReports/ExtentReport.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        return extent;
    }

}
