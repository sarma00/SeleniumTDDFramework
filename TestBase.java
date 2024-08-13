package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.PropertyFileReader;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestBase {
    public WebDriver driver;
    String browser = PropertyFileReader.getBrowser();
    String url = PropertyFileReader.getUrl();


    @BeforeSuite
    public void openBrowser(){
        switch(browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
            default:
                System.out.println("Please specify driver : chrome or firefox!!!");

        }
    }

    @BeforeSuite(dependsOnMethods = "openBrowser")
    public void navigateToUrl(){
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void captureFailedScreenshots(ITestResult testResult) throws IOException {
        if(testResult.getStatus()==ITestResult.FAILURE){
            File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcfile, new File("Error"+testResult.getName()+".png"));
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    public void takeScreenshot(String fileName)throws IOException{
        File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcfile, new File(fileName+".png"));
    }

}
