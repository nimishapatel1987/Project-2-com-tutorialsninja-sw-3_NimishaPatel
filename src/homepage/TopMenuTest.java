package homepage;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        clickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));

        //1.3 Verify the text ‘Desktops’
        verifyExpectedAndActual(By.cssSelector("body:nth-child(2) div.container:nth-child(4) div.row div.col-sm-9 > h2:nth-child(1)"), "Desktops");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        clickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

        //2.3 Verify the text ‘Laptops & Notebooks’
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"), "Laptops & Notebooks");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        clickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Components')]"));

        //3.3 Verify the text ‘Components’
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Components')]"), "Components");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
