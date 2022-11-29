package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void selectMyAccountOptions(String option, By by) {
        List<WebElement> options = driver.findElements(by);
        for (WebElement name : options) {
            if (name.getText().equalsIgnoreCase(option)) {
                name.click();
                break;
            }
        }
    }
        //1.2 This method should click on the options whatever name is passed as parameter.
        //(Hint: Handle List of Element and Select options)

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        //1.3 Verify the text “Register Account”.
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Register Account')]"), "Register Account");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter "Login"
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        //2.3 Verify the text “Returning Customer”.
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Returning Customer')]"),"Returning Customer");
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));

        //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"),"Pari");
        //3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"),"Patel");
        //3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"),"pp1987@gmail.com");
        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"),"+44 9865887436");
        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"123456");
        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"),"123456");

        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]/input[1]"));

        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));

        //3.11 Click on Continue button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"));

        //3.12 Verify the message “Your Account Has Been Created!”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"),"Your Account Has Been Created!");

        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"));

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]"));

        //3.16 Verify the text “Account Logout”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Account Logout')]"),"Account Logout");

        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"),"pp1987@gmail.com");

        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"123456");

        //4.6 Click on Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));

        //4.7 Verify text “My Account”
        verifyExpectedAndActual(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"),"My Account");

        //4.8 Clickr on My Account Link.
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"));

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]"));

        //4.10 Verify the text “Account Logout”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Account Logout')]"),"Account Logout");

        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
