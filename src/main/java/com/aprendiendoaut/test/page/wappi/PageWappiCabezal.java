package com.aprendiendoaut.test.page.wappi;

import com.aprendiendoaut.test.action.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageWappiCabezal {

    @FindBy(xpath = "//a[@href='/home']")
    WebElement btnInicio;

    @FindBy(xpath = "//a[@href='/coupons']")
    WebElement btnCupones;

    @FindBy(xpath = "//a[@href='/orders']")
    WebElement btnMisPedidos;

    @FindBy(xpath = "//a[@href='/profile']")
    WebElement btnInformacionPersonal;

    public PageWappiCabezal(){

        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public void clickBtnInicio(){
        btnInicio.click();
    }

    public void clickBtnCupones(){
        btnCupones.click();
    }

    public void clickBtnMisPedidos(){
        btnMisPedidos.click();
    }

    public void clickBtnInformacionPersonal(){
        btnInformacionPersonal.click();
    }
}


