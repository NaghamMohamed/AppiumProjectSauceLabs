package AppPages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckOutOverViewPage {
    WebDriver driver;

    By itemTotalPrice_text= AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[5]");
    By tax_text= AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[6]");
    By total_text= AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[7]");
    By finish_Btn = AppiumBy.accessibilityId("test-FINISH");

    public CheckOutOverViewPage(WebDriver driver) {

        this.driver = driver;
    }

        //Item total: $29.99 - Tax: $2.40 - Total: $32.39
    //  String s=new CheckOutOverViewPage(driver)
    //                    .getItemTotalPrice();
    //          System.out.println(s.substring(13,s.length()));

    public float getItemTotalPrice(){
        setExplicitWait(itemTotalPrice_text,30);
        String s=driver.findElement(itemTotalPrice_text).getText();
        return Float.parseFloat(s.substring(13, s.length()));
    }
    public float getTax(){
        setExplicitWait(tax_text,30);
        String s=driver.findElement(tax_text).getText();
        return Float.parseFloat(s.substring(6,s.length()));
    }
    public float getTotal(){
        setExplicitWait(total_text,30);
        String s=driver.findElement(total_text).getText();
        return Float.parseFloat(s.substring(7,s.length()));
    }
    public CheckOutCompletePage finishClick(){
        setExplicitWait(finish_Btn,30);
        driver.findElement(finish_Btn).click();
        return new CheckOutCompletePage(driver);
    }
    public  void setExplicitWait(By element, int timeoutInSeconds) {
        (new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}
