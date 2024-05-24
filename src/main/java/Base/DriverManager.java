package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
//
//    ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public WebDriver initDriver(){
//        threadLocalDriver.set();
//        System.out.println("Driver init : " + Thread.currentThread().getId()
//                + " on driver reference : " + getDriver());
//        return threadLocalDriver.get();
        return new ChromeDriver();
    }

//    public WebDriver getDriver(){
//        return threadLocalDriver.get();
//    }

//    public void quitDriver(){
//        System.out.println("Driver tearup : by Thread : " + Thread.currentThread().getId()
//                + " on driver reference : " + threadLocalDriver.get());
//        threadLocalDriver.get().close();
//        System.out.println("Driver has quit");
//        threadLocalDriver.remove();
//    }

}
