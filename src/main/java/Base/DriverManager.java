package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    WebDriver driver;
    ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public WebDriver initDriver(){
        driver = new ChromeDriver();
        threadLocalDriver.set(driver);
        return threadLocalDriver.get();
    }

    public void quitDriver(){
        threadLocalDriver.get().quit();
        System.out.println("Driver has quit");
        threadLocalDriver.remove();
    }

}
