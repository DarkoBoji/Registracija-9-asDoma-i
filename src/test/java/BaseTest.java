import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    public void setap() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterMethod
    public void tearDown() {


    }

    protected WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    protected void typeIn(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    protected void clickOnElement(By locator) {
        getElement(locator).click();
    }

    protected String getTextFromElement(By locator) {
        return getElement(locator).getText();
    }

    protected String getColorFromElement(By locator, String cssValue) {
        return getElement(locator).getCssValue(cssValue);
    }

}
