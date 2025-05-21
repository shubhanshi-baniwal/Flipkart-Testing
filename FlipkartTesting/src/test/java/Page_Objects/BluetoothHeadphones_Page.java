package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BluetoothHeadphones_Page {
    WebDriver driver;
    @FindBy(xpath="//div[@class='DOjaWF gdgoEp']/div[2]/div[1]/div")
    private WebElement headset1;
    public BluetoothHeadphones_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnHeadset()
    {
        headset1.click();
    }
}
