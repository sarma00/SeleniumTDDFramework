package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePageClass;


public class HomePageTest extends TestBase {

    public HomePageClass homePageClass;

    @Test
    public void addToBasket() throws Exception{
        homePageClass = new HomePageClass(driver);
        homePageClass.addToBasket();
        takeScreenshot("homePage");
    }

}
