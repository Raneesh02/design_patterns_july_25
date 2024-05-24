package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.PropertyHandler;

public class BaseTest {
    protected  DriverManager driverManager;
    protected String url;
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    @BeforeMethod
    public void init(){
        driverManager = new DriverManager();
        tlDriver.set(driverManager.initDriver());
                System.out.println("Driver init : " + Thread.currentThread().getId()
                + " on driver reference : " + tlDriver.get());
        url = PropertyHandler.getProperty("url");
        tlDriver.get().get(url);
    }

    public WebDriver getDriver(){
        return tlDriver.get();
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Browser closed by Thread : " + Thread.currentThread().getId()
                + " and Closing driver reference is :" + getDriver());
        tlDriver.get().close();
        tlDriver.remove();
    }

}
