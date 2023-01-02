    import AppPages.LoginPage;
    import AppPages.ProductPage;

    import io.appium.java_client.android.AndroidDriver;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.remote.DesiredCapabilities;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import org.testng.Assert;
    import org.testng.annotations.AfterMethod;
    import org.testng.annotations.BeforeMethod;
    import org.testng.annotations.Test;

    import java.net.MalformedURLException;
    import java.net.URL;

    public class LoginTest {
        WebDriver driver;

        @BeforeMethod

      public void setUp() throws MalformedURLException {
           driver= new setUp(driver).setupDevice();

        }
        @Test
        public void TC01_loginWithValidData(){
            //login with valid Data
            new LoginPage(driver)
                    .loginEnterUserName("standard_user")
                    .loginEnterPassword("secret_sauce")
                    .clickLoginBtn();
            // validate Navigation to Products Page
           Assert.assertEquals(new ProductPage(driver).getProductsLabelText(),"PRODUCTS");

        }
        @Test
        public void TC02_loginWithInvalidUserName(){
            //login with Invalid Data
            new LoginPage(driver)
                    .loginEnterUserName("user")
                    .loginEnterPassword("secret_sauce")
                    .clickLoginBtn();
            // Validate Wrong User Name Error Msg
            Assert.assertEquals(new LoginPage(driver).getLoginErrorMsg(),"Username and password do not match any user in this service.");

        }



        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }
