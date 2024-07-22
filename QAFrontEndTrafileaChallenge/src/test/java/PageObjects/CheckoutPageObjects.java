package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static Tests.SeleniumTest.driver;

public class CheckoutPageObjects {

    //Shipping Address Section Web Elements
    public static String firstNameInputField_xpath = "//input[@data-testid='first-name-shipping-field']";
    public static WebElement firstNameInputField = driver.findElement(By.xpath("//input[@data-testid='first-name-shipping-field']"));
    public static String lastNameInputField_xpath = "//input[@data-testid='last-name-shipping-field']";
    public static WebElement lastNameInputField = driver.findElement(By.xpath("//input[@data-testid='last-name-shipping-field']"));
    public static String addressInputField_xpath = "//input[@data-testid='address-shipping-field']";
    public static WebElement addressInputField = driver.findElement(By.xpath("//input[@data-testid='address-shipping-field']"));
    public static String aptSuiteInputField_xpath = "//input[@data-testid='apt-shipping-field']";
    public static WebElement aptSuiteInputField = driver.findElement(By.xpath("//input[@data-testid='apt-shipping-field']"));
    public static String cityInputField_xpath = "//input[@data-testid='city-shipping-field']";
    public static WebElement cityInputField = driver.findElement(By.xpath("//input[@data-testid='city-shipping-field']"));
    public static String stateDropdown_xpath = "//button[@data-testid='state-field']";
    public static WebElement stateDropdown = driver.findElement(By.xpath("//button[@data-testid='state-field']"));
    public static String postalcodeInputField_xpath = "//input[@data-testid='zipcode-shipping-field']";
    public static WebElement postalcodeInputField = driver.findElement(By.xpath("//input[@data-testid='zipcode-shipping-field']"));
    public static String phoneInputField_xpath = "//input[@data-testid='phone-shipping-field']";
    public static WebElement phoneInputField = driver.findElement(By.xpath("//input[@data-testid='phone-shipping-field']"));


    //Credit Card Section Web Elements
    public static String nameOnCardInputField_xpath = "//input[@placeholder='Name on card']";
    public static WebElement nameOnCardInputField = driver.findElement(By.xpath("//input[@placeholder='Name on card']"));






}
