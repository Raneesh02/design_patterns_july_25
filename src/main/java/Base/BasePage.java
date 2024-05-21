package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PropertyHandler;

import java.time.Duration;

public class BasePage {
    protected String url;
    protected WebDriver driver;
    WebDriverWait webDriverWait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        url = PropertyHandler.getProperty("url");
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected void waitAndClick(By locator){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element=driver.findElement(locator);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected boolean isDisplayed(By locator){
        try {
            return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        }catch (TimeoutException e){
            System.out.println("Cannot find element with location: "+locator);
        }
        System.out.println("element with locator : "+locator+" is not displayed");
        return false;
    }

    protected void waitAndSendKeys(By locator,String keysToSend){
        WebElement element=waitForVisible(locator);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(keysToSend);
    }

    protected WebElement waitForVisible(By locator){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    protected String getText(By locator){
        waitForVisible(locator);
        return driver.findElement(locator).getText();
    }


}
