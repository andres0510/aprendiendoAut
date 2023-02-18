package com.aprendiendoaut.test.page.wappi;

import com.aprendiendoaut.test.action.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageWappiIniciarSesion {

    @FindBy(id="username")
    WebElement inputUsuario;

    @FindBy(id="password")
    WebElement inputContrasena;

    @FindBy(id="button-login")
    WebElement btnIngresar;

    public PageWappiIniciarSesion(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void ingresarUsuario(String usuario){
        inputUsuario.sendKeys(usuario);
    }

    public void ingresarContrasena(String contrasena){
        inputContrasena.sendKeys(contrasena);
    }

    public void clickBtnIngresar(){
        btnIngresar.click();
    }

}
