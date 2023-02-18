package com.aprendiendoaut.test.steps;

import com.aprendiendoaut.test.controller.GeneralController;
import com.aprendiendoaut.test.controller.GoogleController;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class GoogleSteps {

    //----------------------------------------------------------------------------------------------------------------->
    //---------- STEPS ------------------------------------------------------------------------------------------------>
    //----------------------------------------------------------------------------------------------------------------->

    @Dado("^que me encuentro en la pagina de Google$")
    public void queMeEncuentroEnLaPaginaDeGoogle(){
        GeneralController.openApp("Google");
    }

    @Cuando("^ingreso a la seccion de imagenes e ingreso el elemento a buscar$")
    public void ingresoALaSeccionDeImagenes(){
        GoogleController.buscarImagenEnGoogle("perro");
    }

    @Entonces("^se muestran los resultados$")
    public void seMuestranLosResultados(){
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
