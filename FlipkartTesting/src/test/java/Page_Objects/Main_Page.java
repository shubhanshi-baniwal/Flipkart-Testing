
package Page_Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class Main_Page {
    WebDriver driver;
   Actions action;
    @FindBy(xpath="//*[contains(text(),\"Login\")]")
    private WebElement loginButton;
    @FindBy(xpath="//*[contains(text(),'My Profile')]")
    private WebElement myProfile;
    @FindBy(xpath="//img[@alt='Electronics']")
    private WebElement electronicsCategory;
    @FindBy(xpath="//*[contains(text(),'Audio')]")
    private WebElement Audio;
    @FindBy(xpath="//*[contains(text(),'Bluetooth Headphones')]")
    private WebElement bluetoothHeadset;


    public Main_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public void clickOnLogin()
    {
        loginButton.click();
    }
    public void hoverOverTheDropdown()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.moveToElement(loginButton).perform();
    }
    public void clickOnMyProfile()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.moveToElement(myProfile).click().perform();
    }
    public void hoverOverTheElectronics()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.moveToElement(electronicsCategory).perform();
    }
    public void hoverOverTheAudio()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.moveToElement(Audio).perform();
    }
    public void clickOnBluetoothHeadset()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.moveToElement(bluetoothHeadset).click().perform();
    }
}
