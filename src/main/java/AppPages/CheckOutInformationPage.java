package AppPages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutInformationPage {
    WebDriver driver;
    By firstName_placeHolder= AppiumBy.accessibilityId("test-First Name");
    By lastName_placeHolder= AppiumBy.accessibilityId("test-Last Name");
    By zipCode_placeHolder= AppiumBy.accessibilityId("test-Zip/Postal Code");
    By continue_Btn= AppiumBy.accessibilityId("test-CONTINUE");

    public CheckOutInformationPage(WebDriver driver) {
        this.driver = driver;
    }
    public CheckOutInformationPage enterFirstName(String firstName) {
        setExplicitWait(firstName_placeHolder,30);
        driver.findElement(firstName_placeHolder).sendKeys(firstName);
        return this;
    }
    public CheckOutInformationPage enterLastName(String lastName){
        setExplicitWait(lastName_placeHolder,30);
        driver.findElement(lastName_placeHolder).sendKeys(lastName);
        return this;
    }
    public CheckOutInformationPage enterZipCode(String zipCode) {
        setExplicitWait(zipCode_placeHolder, 30);
        driver.findElement(zipCode_placeHolder).sendKeys(zipCode);
        return this;
    }


        public CheckOutOverViewPage clickContinue(){
        setExplicitWait(continue_Btn,30);
        driver.findElement(continue_Btn).click();
        return new CheckOutOverViewPage(driver);
    }

    public  void setExplicitWait(By element, int timeoutInSeconds) {
        (new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))).until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
