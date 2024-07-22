package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Tests.SeleniumTest.driver;

public class HomePageObjects {

    //Home Page Web Elements
    public static String firstElementWithinOurBestSellersSection_xpath = "((//div[@class='styles_products__1vjbu styles_gridProducts__bS8Iq']/div)[1]/a)[1]";
    public static WebElement firstElementWithinOurBestSellersSection = driver.findElement(By.xpath("((//div[@class='styles_products__1vjbu styles_gridProducts__bS8Iq']/div)[1]/a)[1]"));

}
