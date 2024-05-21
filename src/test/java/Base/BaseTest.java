package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.PropertyHandler;

public class BaseTest {
    protected  DriverManager driverManager;
    protected WebDriver driver;
    protected String url;

    @BeforeMethod
    public void init(){
        driverManager = new DriverManager();
        driver = driverManager.initDriver();
        url = PropertyHandler.getProperty("url");
        driver.get(url);
    }

    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }

}
