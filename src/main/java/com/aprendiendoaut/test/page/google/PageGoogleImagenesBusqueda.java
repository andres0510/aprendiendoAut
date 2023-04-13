package com.aprendiendoaut.test.page.google;

import com.aprendiendoaut.test.action.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageGoogleImagenesBusqueda {

    public PageGoogleImagenesBusqueda() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    //----------------------------------------------------------------------------------------------------------------->
    //---------- LOCATORS --------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    @FindBy(name = "q")
    private WebElement inputBusqueda;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnBuscar;

    //----------------------------------------------------------------------------------------------------------------->
    //---------- ACTIONS ---------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public void escribirBusqueda(String imagenABuscar){
        DriverManager.sendText(inputBusqueda, imagenABuscar);
    }

    public void clickBtnBuscar() {
        DriverManager.click(btnBuscar);
    }

}
