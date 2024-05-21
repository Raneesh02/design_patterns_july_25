package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    WebDriver driver;

    public WebDriver initDriver(){
        driver = new ChromeDriver();
        return driver;
    }

    public void quitDriver(){
        driver.quit();
        System.out.println("Driver has quit");

    }

}
