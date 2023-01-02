import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class setUp {
    WebDriver driver;

    public setUp(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver setupDevice() throws MalformedURLException {
        String AppName = System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataFiles\\Android.SauceLabs.Mobile.Sample.app.2.2.0.apk";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Galaxy A52");
        caps.setCapability("appium:app", AppName);
        caps.setCapability("appium:appWaitActivity","com.swaglabsmobileapp.MainActivity");
        caps.setCapability("appium:platformVersion", "12");
        caps.setCapability("appium:automationName", "UiAutomator2");
        driver = new AndroidDriver(new URL("http://localhost:4723/"), caps);
        return driver;
    }
}
