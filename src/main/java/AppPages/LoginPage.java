package AppPages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
   private By userName_placeHolder= AppiumBy.accessibilityId("test-Username");
   private By password_placeHolder=AppiumBy.accessibilityId("test-Password");
   private By login_Btn=AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView");
   private By loginErrorMsg_text=AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginEnterUserName(String userNameIn) {
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(password_placeHolder));
        driver.findElement(userName_placeHolder).sendKeys(userNameIn);
        return this;
    }
    public LoginPage loginEnterPassword(String passwordIn){
        setExplicitWait(login_Btn,30);
        driver.findElement(password_placeHolder).sendKeys(passwordIn);
        return this;
    }
    public ProductPage clickLoginBtn(){
       // webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(login_Btn));
        driver.findElement(login_Btn).click();
       return new ProductPage(driver);
    }

    // set Explicit wait
    public  void setExplicitWait(By element, int timeoutInSeconds) {
        (new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public String getLoginErrorMsg(){
        setExplicitWait(loginErrorMsg_text,30);
        return driver.findElement(loginErrorMsg_text).getText();
    }
}
