package com.aprendiendoaut.test.action;

import com.aprendiendoaut.test.helpers.Report;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    private static WebDriverWait webDriverWait;
    private static final int DEFAULT_TIMEOUT = 10;
    private static final String ERROR_MSG = "Error waiting for element: %s";

    private Wait(){}

    //----------------------------------------------------------------------------------------------------------------->
    //---------- OBJECT INITIATION ------------------------------------------------------------------------------------>
    //----------------------------------------------------------------------------------------------------------------->

    public static void init(WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    public static void forElementClickable(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            Report.reportFail(String.format(ERROR_MSG, e.getMessage()));
        }
    }

    public static void forElementClickable(String xpath) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        } catch (Exception e) {
            Report.reportFail(String.format(ERROR_MSG, e.getMessage()));
        }
    }

    public static void forElementVisible(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            Report.reportFail(String.format(ERROR_MSG, e.getMessage()));
        }
    }

    public static void forElementDisplayed(WebElement element) throws NoSuchElementException {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            throw new NoSuchElementException(String.format(ERROR_MSG, e.getMessage()));
        }
    }

    public static void forElementDisplayed(String xpath) throws NoSuchElementException {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            throw new NoSuchElementException(String.format(ERROR_MSG, e.getMessage()));
        }
    }

}
