package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Login_Page {
    WebDriver driver;
  Actions action;

    @FindBy(xpath="//input[@type='text' and contains(@class, 'r4vIwl BV+Dqf')]")
    private WebElement enterEmail;
    @FindBy(xpath="//*[contains(text(),\"OTP\")]")
    private WebElement requestOTP;
    @FindBy(xpath = "//input[@type='text' and contains(@class, 'r4vIwl IX3CMV')]")
    private List<WebElement> OTP;

    public Login_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }


    public void enterEmailOrMobileNo(String Email) throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        enterEmail.sendKeys(Email);
    }
    public void clickOnRequestOTP()
    {
        requestOTP.click();
    }
    public void enterOTP(int n)
    {
        int i=0,v=0;
        while(i<=5)
        {
            v = n%10;
            OTP.get(i).sendKeys("v");
            n = n/10;
            i++;
        }
    }

}
