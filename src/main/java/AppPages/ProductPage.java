    package AppPages;

    import io.appium.java_client.AppiumBy;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.time.Duration;

    public class ProductPage {
        WebDriver driver;

       private By products_Label= AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
       private By addToCartBackPack_Icon=AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView");
       private By backPackProduct_title=AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]");
       private By backPackProduct_Price=AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"test-Price\"])[1]");
        // (//*[@class="inventory_item_price"])[1]
        private By cart_Icon=AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");
        private By cartItemsNumber=AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView");
        public ProductPage(WebDriver driver) {
            this.driver = driver;
        }
        public String getProductsLabelText(){
            setExplicitWait(products_Label,30);
            return driver.findElement(products_Label).getText();
        }
        public String getBackPackProductTitle(){
            setExplicitWait(backPackProduct_title,30);
            return driver.findElement(backPackProduct_title).getText();
        }
        public String getBackPackProductPrice(){
            setExplicitWait(backPackProduct_Price,30);
            return driver.findElement(backPackProduct_Price).getText();
            //return Integer.getInteger(s);
        }
        public ProductPage addToCartBackPack(){
            setExplicitWait(addToCartBackPack_Icon,30);
            driver.findElement(addToCartBackPack_Icon).click();
            return this;
        }
        public CartPage clickCartIcon(){
            setExplicitWait(cart_Icon,30);
            driver.findElement(cart_Icon).click();
            return new CartPage(driver);
        }
        public String itemsInCartNumber(){
            setExplicitWait(cartItemsNumber,30);
            return driver.findElement(cartItemsNumber).getText();
        }
        public  void setExplicitWait(By element, int timeoutInSeconds) {
            (new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))).until(ExpectedConditions.visibilityOfElementLocated(element));
        }

    }
