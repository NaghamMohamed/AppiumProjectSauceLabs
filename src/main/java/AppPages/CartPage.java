package AppPages;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    private By backPackProduct_title= AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
    private By backPackProduct_Price=AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");
    private By remove1stItem_Btn =AppiumBy.xpath("//android.widget.TextView[@text=\"REMOVE\"]");
    private By cart_Icon=AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView");
    private By checkOut_Icon=AppiumBy.xpath("//android.widget.TextView[@text=\"CHECKOUT\"]");
    private By cartItemsNumber=AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getBackPackProductText(){
        setExplicitWait(backPackProduct_title,30);
        return driver.findElement(backPackProduct_title).getText();
    }
    public String getBackPackProductPrice(){
        setExplicitWait(backPackProduct_Price,30);
        return driver.findElement(backPackProduct_Price).getText();
        //return Integer.getInteger(s);
    }
    public CartPage remove1stItemCartPage(){
        setExplicitWait(remove1stItem_Btn,30);
        driver.findElement(remove1stItem_Btn).click();
        return this;
    }
   public boolean validateItemsAreRemoved() {
        try {
            driver.findElement(cartItemsNumber);
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }
    public CheckOutInformationPage clickCheckOut(){
        setExplicitWait(checkOut_Icon,30);
        driver.findElement(checkOut_Icon).click();
        return new CheckOutInformationPage(driver);
    }
    public  void setExplicitWait(By element, int timeoutInSeconds) {
        (new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}
