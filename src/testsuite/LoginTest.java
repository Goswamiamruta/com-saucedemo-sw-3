package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";
   @Before
   public void setUp(){
       openBrowser(baseUrl);
   }
   @Test
     public void userShouldLoginSuccessfullyWithValidCredentials(){
       // Find the Email Field Type the Email address to username field
       sendTextToElement(By.id("user-name"),"standard_user");
       //Find the password field and Type the password to password field
       sendTextToElement(By.name("password"),"secret_sauce");
       // Find the login btn element and click
       clickOnElement(By.name("login-button"));
       // Verify the text “PRODUCTS”
       String expectedText = "Products";
       String actualText = getTextFromElement(By.xpath("//span[@class='title']"));
       Assert.assertEquals(expectedText,actualText);

}
@Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
    // Find the Email Field Type the Email address to username field
    sendTextToElement(By.id("user-name"),"standard_user");
    //Find the password field and Type the password to password field
    sendTextToElement(By.name("password"),"secret_sauce");
    // Find the login btn element and click
    clickOnElement(By.name("login-button"));
    // Verify that six products are displayed on
    //find the web elements list
    List<WebElement> products = driver.findElements(By.className("inventory_item"));
    System.out.println("Total products are: " + products.size());
    Assert.assertEquals("",6, products.size());
}

    @After
    public void tearDown() {
        closeBrowser();
    }
}






