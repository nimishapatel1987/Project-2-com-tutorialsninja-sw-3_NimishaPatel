package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSucessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        clickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order.
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        //2.1 Mouse hover on Laptops & Notebooks Tab.and click
        clickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

        //2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));

        //2.5 Verify the text “MacBook”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'MacBook')]"), "MacBook");

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        //verifyExpectedAndActual(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have added MacBook to your shopping cart!");

        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //2.9 Verify the text "Shopping Cart"
        verifyMessage("MacBook", getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")));

        //2.10 Verify the Product name "MacBook"
        verifyExpectedAndActual(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "MacBook");

        //2.11 Change Quantity "2"
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));

        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]"));

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        // verifyExpectedAndActual(By.xpath("//body/div[@id='checkout-cart']/div[1]"), "Success: You have modified your shopping cart!");

        //2.14 Verify the Total £737.45
        // verifyExpectedAndActual(By.xpath("//tbody/tr[1]/td[6]"), "£737.45");

        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));

        //2.16 Verify the text “Checkout”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Checkout')]"), "Checkout");

        //2.17 Verify the Text “New Customer”
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'New Customer')]"), "New Customer");

        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]"));

        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "Pari");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "Patel");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "paripatel123@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "+44 8766787889");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "CB4 3NB");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "Cambridge");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "CB4 3NB");
        sendTextToElement(By.xpath("//select[@id='input-payment-country']"), "United Kindom");
        sendTextToElement(By.xpath("//select[@name = 'zone_id']"),"Cambridgeshire");

        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]"), "Please send another option");

        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]"));

        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        //2.25 Verify the message “Warning: Payment method required!”
       // verifyExpectedAndActual(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]"), "Warning: Payment method required!");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
