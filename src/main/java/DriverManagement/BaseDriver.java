package DriverManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseDriver {

    WebDriver driver;
    protected static Properties prop = new Properties();


    public void initDriver(){
        driver = new ChromeDriver();
    }

    public void loadPropertyFile() throws IOException {
        InputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/application.properties");
        //Load properties file
        prop.load(input);
    }

    public Properties getApplicationProperties(){
        return prop;
    }

//    private DesiredCapabilities getDesiredCapabilities(String platform) {
//
//    }

    public void quitDriver(){
        driver.quit();
        System.out.println("Driver has quit");

    }

}
