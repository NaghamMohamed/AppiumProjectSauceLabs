    import Actions.MobileActions;
    import AppPages.*;
    import org.openqa.selenium.WebDriver;
    import org.testng.Assert;
    import org.testng.annotations.AfterMethod;
    import org.testng.annotations.BeforeMethod;
    import org.testng.annotations.Test;

    import java.net.MalformedURLException;
    import java.time.Duration;


    public class OrderingTest {
        WebDriver driver;
        @BeforeMethod
        public void setUp() throws MalformedURLException {
           driver= new setUp(driver).setupDevice();
            new LoginPage(driver)
                    .loginEnterUserName("standard_user")
                    .loginEnterPassword("secret_sauce")
                    .clickLoginBtn();
        }
        @Test
        public void TC03_AddToCartTest(){
       //Save the title and price of backPack in Products Page
        String backPackTitleInProductPage=new ProductPage(driver).getBackPackProductTitle();
       String backPackPriceInProductPage=new ProductPage(driver).getBackPackProductPrice();

        // Add Item to cart And Navigate to the Cart
        new ProductPage(driver).addToCartBackPack().clickCartIcon();

        //Save the title and price of backPack in Cart Page
        String backPackTitleInCartPage=new CartPage(driver).getBackPackProductText();
        String backPackPriceInCartPage=new CartPage(driver).getBackPackProductPrice();

        //Validate that the item ordered at products page is the same in Cart page
            Assert.assertEquals(backPackTitleInProductPage,backPackTitleInCartPage);
            Assert.assertEquals(backPackPriceInProductPage,backPackPriceInCartPage);
        }
        @Test
        public void TC04_removeItemsTest(){
            new ProductPage(driver).addToCartBackPack().clickCartIcon();

            //Validate that Item is Added
            Assert.assertEquals(new ProductPage(driver).itemsInCartNumber(),"1");

            new CartPage(driver).remove1stItemCartPage();

            //Validate that Item is Removed
            Assert.assertEquals(new CartPage(driver).validateItemsAreRemoved(),true);
        }
        @Test
        public void TC05_completeOrderTest(){
            // Add Item to cart And Navigate to the Cart
            new ProductPage(driver)
                    .addToCartBackPack()
                    .clickCartIcon()
                    .clickCheckOut()
                    .enterFirstName("nagham")
                    .enterLastName("Mady")
                    .enterZipCode("1234")
                    .clickContinue();

//            System.out.println(new CheckOutOverViewPage(driver).getItemTotalPrice());
//            new MobileActions(driver);
//            MobileActions.scrollDownToSpecificText("Tax: $2.40");
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//            System.out.println(new CheckOutOverViewPage(driver).getTax());
//
//            new MobileActions(driver);
//            MobileActions.scrollDownToSpecificText("Total: $32.39");
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//            System.out.println(new CheckOutOverViewPage(driver).getTotal());

            new MobileActions(driver);
            MobileActions.scrollDownToSpecificText("FINISH");
            new CheckOutOverViewPage(driver)
                    .finishClick();
            Assert.assertEquals(new CheckOutCompletePage(driver).getSuccessMsgText(),
                    "Your order has been dispatched, and will arrive just as fast as the pony can get there!");

        }


        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }

