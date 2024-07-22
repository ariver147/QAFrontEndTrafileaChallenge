package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Tests.SeleniumTest.driver;

public class ProductPageObjects {

    //Product Page Web Elements
    public static String addToCartButton_xpath = "//button[@data-testid='add-to-cart']";
    public static WebElement addToCartButton = driver.findElement(By.xpath("//button[@data-testid='add-to-cart']"));

}
