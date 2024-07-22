package Tests;

import PageMethods.CheckoutPageMethods;
import PageMethods.HomePageMethods;
import PageMethods.ProductPageMethods;
import PageObjects.CheckoutPageObjects;
import PageObjects.HomePageObjects;
import PageObjects.ProductPageObjects;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    public static WebDriver driver;
    WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

    @BeforeTest
    public static void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://shapermint.com/");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
        extent.attachReporter(spark);
    }

    @Test
    void testSteps() throws InterruptedException {
        test = extent.createTest("Validate Checkout End to End", "Simulates user's process to select a product, proceed to checkout and input buyer information");

        Thread.sleep(2000);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        String xButtonAddPopUp_xpath = "(//span[.='×'])[2]";
        WebElement xButtonAddPopUp = driver.findElement(By.xpath("(//span[.='×'])[2]"));

        //Close AddPopUp if appears

        try {
            Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(NoSuchElementException.class);
            WebElement element = fwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xButtonAddPopUp_xpath)));
            xButtonAddPopUp.click();
        } catch (Exception e) {

        }
        //Click firstElementWithinOurBestSellersSection
        try {
            explicitWait.until(ExpectedConditions.visibilityOf(HomePageObjects.firstElementWithinOurBestSellersSection));
            Actions a = new Actions(driver);
            a.moveToElement(HomePageObjects.firstElementWithinOurBestSellersSection);
            a.perform();
            HomePageMethods.clickFirstElementWithinOurBestSellersSection();
            test.log(Status.PASS, "Test Passed: clicking on first element in Our Best Seller's Section");
        } catch (Exception e) {
            test.log(Status.FAIL, "Test Failed: clicking on first element in Our Best Seller's Section");
        }

        //Click xButtonAddPopUp if appears
        try {
            explicitWait.until(ExpectedConditions.elementToBeClickable(xButtonAddPopUp));
            xButtonAddPopUp.click();
        } catch (Exception e) {

        }
        try {
            explicitWait.until(ExpectedConditions.elementToBeClickable(ProductPageObjects.addToCartButton));
            Actions a = new Actions(driver);
            a.moveToElement(ProductPageObjects.addToCartButton);
            a.perform();
            ProductPageMethods.clickAddToCartButton();
            test.log(Status.PASS, "Test Passed: clicking on add to cart button");
        } catch (Exception e) {
            test.log(Status.FAIL, "Test Failed: clicking on add to cart button");
        }

        String proceedToCheckoutButton_xpath = "(//button[@data-testid='proceed-to-checkout'])[1]";
        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("(//button[@data-testid='proceed-to-checkout'])[1]"));

        //Click xButtonAddPopUp if appears
        try {
            xButtonAddPopUp.click();
        } catch (Exception e) {

        }

        try {
            explicitWait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
            driver.findElement(By.xpath(proceedToCheckoutButton_xpath)).click();
            test.log(Status.PASS, "Test Passed: clicking on proceed to checkout button");
        } catch (Exception e) {
            test.log(Status.PASS, "Test Failed: clicking on proceed to checkout button");
        }

        try {
            //Fill Contact and Shipping Form
        Thread.sleep(2000);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        String emailInputField_xpath = "//input[@data-testid='email-field']";
        WebElement emailInputField = driver.findElement(By.xpath("//input[@data-testid='email-field']"));
        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement element = fwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(emailInputField_xpath)));
            emailInputField.sendKeys("qa.mail@gmail.com");
            CheckoutPageObjects.firstNameInputField.sendKeys("My Name");
            CheckoutPageObjects.lastNameInputField.sendKeys("My LastName");
            CheckoutPageObjects.addressInputField.sendKeys("123 William Street");
            CheckoutPageObjects.aptSuiteInputField.sendKeys("apt 1");
            CheckoutPageObjects.cityInputField.sendKeys("New York");
            CheckoutPageObjects.stateDropdown.click();
            String newYorkStateOption_xpath = "//div[@data-testid='state-shipping-field']//ul/li[.='New York']";
            WebElement newYorkStateOption = driver.findElement(By.xpath("//div[@data-testid='state-shipping-field']//ul/li[.='New York']"));
            newYorkStateOption.click();
            CheckoutPageObjects.postalcodeInputField.sendKeys("10038");
            CheckoutPageObjects.phoneInputField.sendKeys("1234567890");
            test.log(Status.PASS, "Test Passed: Completed Shipping Info");
        } catch (Exception e) {
            test.log(Status.PASS, "Test Failed: Completed Shipping Info");
        }

        //Scroll to bottom
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        //Switch to iframeCreditCard
        String iframeCreditCard_xpath = "//iframe[@title='Secure card number input frame']";
        WebElement iframeCreditCard = driver.findElement(By.xpath("//iframe[@title='Secure card number input frame']"));
        driver.switchTo().frame(iframeCreditCard);

        //Enter Card Info
        String creditCardNumberInputField_xpath = "//input[@placeholder='Card number']";
        WebElement creditCardNumberInputField = driver.findElement(By.xpath("//input[@placeholder='Card number']"));
        creditCardNumberInputField.sendKeys("1234123412341234");
        driver.switchTo().defaultContent();
        
        //Switch to iframeExpDate
        String iframeExpDate_xpath = "//iframe[@title='Secure card number input frame']";
        WebElement iframeExpDate = driver.findElement(By.xpath("//iframe[@title='Secure card number input frame']"));
        driver.switchTo().frame(iframeExpDate);

        //Enter Exp Date Info
        String expirationDateInputField_xpath = "//input[@placeholder='MM / YY']";
        WebElement expirationDateInputField = driver.findElement(By.xpath("//input[@placeholder='MM / YY']"));
        String expDate = "0125";
        js.executeScript("arguments[0].value = arguments[1]", expirationDateInputField_xpath, expDate);
        driver.switchTo().defaultContent();

//        //Switch to iframeCVV
//        String iframeCVV_xpath = "//iframe[@title='Secure CVC input frame']";
//        WebElement iframeCVV = driver.findElement(By.xpath("//iframe[@title='Secure card number input frame']"));
//        driver.switchTo().frame(iframeCVV);
//
//        //Enter CVV Info
//        String cvvInputField_xpath = "//input[@name='exp-date']";
//        WebElement cvvInputField = driver.findElement(By.xpath("//input[@placeholder='CVV']"));
//        driver.switchTo(). defaultContent();

        driver.quit();
    }

    @AfterTest
    public static void cleanUp() {
        extent.flush();
    }

}