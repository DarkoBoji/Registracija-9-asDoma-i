import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.cssSelector(".fa");
    By actualTextAndColorElement = By.id("flash");


    @Test
    public void loginTestByText() throws InterruptedException {

        typeIn(usernameField, "tomsmith");
        typeIn(passwordField, "SuperSecretPassword!");
        clickOnElement(loginButton);

        String actualText = getTextFromElement(actualTextAndColorElement);
        System.out.println(actualText);

        int indexDrugi = actualText.length() - 2;
        String actualTextSubString = actualText.substring(0, indexDrugi);
        String actualTextSplit[] = actualText.split("(?<=!)");
        String expectedText = "You logged into a secure area!";

        Assert.assertEquals(actualTextSplit[0], expectedText, "Expected text iz not eyual to actaual text");

    }

    @Test
    public void loginTestByColor() throws InterruptedException {

        typeIn(usernameField, "tomsmith");
        typeIn(passwordField, "SuperSecretPassword!");
        clickOnElement(loginButton);

        String actualColor = getColorFromElement(actualTextAndColorElement, "background-color");
        System.out.println(actualColor);
        String expectedColor = "rgba(93, 164, 35, 1)";

        Assert.assertTrue(actualColor.equals(expectedColor), "Epected color is not eyual to: " + actualColor);

    }


}




