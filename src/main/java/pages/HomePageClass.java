package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageClass {

    WebDriver driver;
    public HomePageClass(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(@href,'selenium-ruby')]/following-sibling::a")
    public WebElement addToBasketBtn;

    public void addToBasket(){
        addToBasketBtn.click();
    }
}
