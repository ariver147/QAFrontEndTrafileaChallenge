package PageMethods;

import PageObjects.HomePageObjects;
import PageObjects.ProductPageObjects;
import org.openqa.selenium.By;

import static Tests.SeleniumTest.driver;

public class ProductPageMethods {

    //Product Page Web Methods
    public static void clickAddToCartButton(){
        driver.findElement(By.xpath(ProductPageObjects.addToCartButton_xpath)).click();
    }
    public static void clickProceedToCheckout(){

    }

}
