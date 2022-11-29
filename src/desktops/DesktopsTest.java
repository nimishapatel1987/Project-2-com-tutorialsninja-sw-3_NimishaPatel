package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Mouse hover on “Desktops” Tab and click
        clickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));

        //1.3 Select Sort By position "Name: Z to A"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        Select sortBy = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
        sortBy.selectByValue("http://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC");

        //1.4 Verify the Product will arrange in Descending order.
        // verifyExpectedAndActual(By.xpath("//option[contains(text(),'Name (Z - A)')]"),"Name: Z to A");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Desktops Tab. and click
        clickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));

        //2.2 call selectMenu method and pass the menu = “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));

        //2.3 Select Sort By position "Name: A to Z"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        Select sortBy = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
        sortBy.selectByValue("http://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=ASC");

        //2.4 Select product “HP LP3065”
        clickOnElement(By.linkText("HP LP3065"));

        //2.5 Verify the Text "HP LP3065"
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'HP LP3065')]"), "HP LP3065");

        //2.6 Select Delivery Date "2022-11-30"
        // verifyExpectedAndActual(By.xpath("//small[contains(text(),'Delivery Date: 2022-11-30')]"),"Delivery Date: 2022-11-30");

        //2.7.Enter Qty "1” using Select class.
        clearText(By.cssSelector("#input-quantity"));
        sendTextToElement(By.cssSelector("#input-quantity"), "1"); // 2.7.Enter Qty "1” using Select class.
        clickOnElement(By.xpath("//button[@id='button-cart']"));// 2.8 Click on “Add to Cart” button

        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        //verifyExpectedAndActual(By.xpath("//body/div[@id='product-product']/div[1]"),"Success: You have added HP LP3065 to your shopping cart!");

        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //2.11 Verify the text "Shopping Cart"
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),' (1.00kg)')]"), "Shopping Cart  (1.00kg)");

        //2.12 Verify the Product name "HP LP3065"
        verifyExpectedAndActual(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "HP LP3065");

        //2.13 Verify the Delivery Date "2022-11-30"
        //sendTextToElement(By.xpath("//input[@value = '2011-04-22']"),"2022-11-30");
        String year = "2022";
        String month = "November";
        String date = "30";
        Thread.sleep(2000);
        // opens the date picker
        clickOnElement(By.xpath("//button[@class = 'btn btn-default']/i[@class='fa fa-calendar']"));

        while (true) {
            String monthYear = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
            // Nov 2022
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];

            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]"));
            }
        }
        //Select Date
        List<WebElement> allDates = driver.findElements(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[3]"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }

        //2.14 Verify the Model "Product21"
        clickOnElement(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md' and text() ='Currency']"));
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[contains(text(),'£ Pound Sterling')]"));
        //selectByVisibleTextFromDropDown(By.xpath("//button[contains(text(),'£ Pound Sterling')]"),"£ Pound Sterling");
        //2.15 Verify the Todat "£74.73"
        verifyExpectedAndActual(By.xpath("//tbody/tr[1]/td[6]"), "£74.73");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
