import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import utils.Utils;

public class RegistrationTest extends BaseTest{

    By registrationButton = By.cssSelector("a[class='ico-register']");
    By selectGenderMale = By.cssSelector("input[id='gender-male']");
    By usernameField = By.cssSelector("input[id='FirstName']");
    By lastnameField = By.cssSelector("input[id='LastName']");
    By emailField = By.cssSelector("input[id='Email']");
    By passwordField = By.id("Password");
    By confirmPassword = By.id("ConfirmPassword");
    By register = By.id("register-button");
    By continueButton = By.cssSelector("input[class='button-1 register-continue-button']");
    By registrationCompletedText = By.cssSelector("div[class='result']");


    @Test
    public void registerUserTest(){

        String email = Utils.generateRandomEmail();
        System.out.println("Email: " + email);
        clickOnElement(registrationButton);
        clickOnElement(selectGenderMale);
        //Unos podataka
        typeIn(usernameField, "Tom");
        typeIn(lastnameField, "Smith");
        typeIn(emailField,email);
        typeIn(passwordField, "SuperSecretPassword!");
        typeIn(confirmPassword, "SuperSecretPassword!");

        clickOnElement(register);

        //Verifikacija
        boolean isElementPresent = getElement(continueButton).isDisplayed();
        softAssert.assertTrue(isElementPresent);
        System.out.println("Continue dugme je prisutno.");

        String actualText = getTextFromElement(registrationCompletedText);
        String expectedText = "Your registration completed";
        softAssert.assertEquals(actualText, actualText);
        System.out.println("Očekivani tekst je prisutan.");
        softAssert.assertAll();

    }

}
