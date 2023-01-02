package AppPages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutCompletePage {
    WebDriver driver;
    By successMsg= AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[2]");


    public CheckOutCompletePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getSuccessMsgText(){
        setExplicitWait(successMsg,30);
        return driver.findElement(successMsg).getText();
    }
    public  void setExplicitWait(By element, int timeoutInSeconds) {
        (new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))).until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
