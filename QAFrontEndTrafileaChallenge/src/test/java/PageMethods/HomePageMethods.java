package PageMethods;

import PageObjects.HomePageObjects;
import org.openqa.selenium.By;

import static Tests.SeleniumTest.driver;

public class HomePageMethods {

    //Home Page Web Methods

    public static void clickFirstElementWithinOurBestSellersSection(){
        driver.findElement(By.xpath(HomePageObjects.firstElementWithinOurBestSellersSection_xpath)).click();
    }

}
