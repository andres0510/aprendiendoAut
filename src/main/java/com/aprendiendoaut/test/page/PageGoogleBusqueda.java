package com.aprendiendoaut.test.page;

import com.aprendiendoaut.test.action.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageGoogleBusqueda {

    public PageGoogleBusqueda() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    //----------------------------------------------------------------------------------------------------------------->
    //---------- LOCATORS --------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    @FindBy(xpath = "//a[@data-pid='2']")
    private WebElement lnkImagenes;

    //----------------------------------------------------------------------------------------------------------------->
    //---------- ACTIONS ---------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public void clickLnkImagenes() {
        DriverManager.click(lnkImagenes);
    }

}
