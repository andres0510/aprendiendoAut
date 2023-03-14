package com.aprendiendoaut.test.page.wappi;

import com.aprendiendoaut.test.action.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageWappiFormulario {

    @FindBy(xpath="//input[@id='image']")
    WebElement inputImagen;

    @FindBy(id="name")
    WebElement inputNombre;

    @FindBy(id="lastName")
    WebElement inputApellido;

    @FindBy(id="bornDate")
    WebElement inputFechaNacimiento;

    @FindBy(id="country")
    WebElement inputPais;

    @FindBy(xpath="//option[text()='Argentina']")
    WebElement optionPaisArgentina;

    @FindBy(xpath="//option[text()='Colombia']")
    WebElement optionPaisColombia;

    @FindBy(xpath="//option[text()='Estados Unidos']")
    WebElement optionPaisEstadosUnidos;

    @FindBy(id="M")
    WebElement radioSexoMasculino;

    @FindBy(id="F")
    WebElement radioSexoFemenino;

    @FindBy(id="save-profile")
    WebElement btnGuardar;

    @FindBy(xpath = "//div[@id='confirmation-modal']//p")
    WebElement lblMensajeModal;

    @FindBy(xpath = "//div[@id='confirmation-modal']//span")
    WebElement btnCerrarModal;

    public PageWappiFormulario() {
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public void ingresarImagen(String imagen){
        inputImagen.sendKeys(imagen);
    }

    public void ingresarUsuario(String nombre){
        inputNombre.clear();
        inputNombre.sendKeys(nombre);
    }

    public void ingresarApellido(String apellido){
        inputApellido.clear();
        inputApellido.sendKeys(apellido);
    }

    public void ingresarFechaNacimiento(String fechaNacimiento){
        inputFechaNacimiento.clear();
        inputFechaNacimiento.sendKeys(fechaNacimiento);
    }

    public void clickPaisArgentina(){
        optionPaisArgentina.click();
    }

    public void clickPaisColombia(){
        optionPaisColombia.click();
    }

    public void clickPaisEstadosUnidos(){
        optionPaisEstadosUnidos.click();
    }

    public void clickSexoMasculino(){
        radioSexoMasculino.click();
    }

    public void clickSexoFemenino(){
        radioSexoFemenino.click();
    }

    public void clickBtnGuardar(){
        btnGuardar.click();
    }

    public String obtenerTextoModal(){
       return lblMensajeModal.getText();
    }

    public void clickBtnCerrarModal(){
        btnCerrarModal.click();
    }

    public String obtenerNombre() {
        System.out.println("");
        return inputNombre.getText();
    }

    public String obtenerApellido() {return inputApellido.getText();}

    public String obtenerPais() {return inputPais.getText();}

    public String obtenerFechaNacimiento() {return inputFechaNacimiento.getText();}

    public boolean validarCheckSexoFemenino() {return radioSexoFemenino.isSelected();}

    public boolean validarCheckSexoMasculino() {return radioSexoMasculino.isSelected();}
}
