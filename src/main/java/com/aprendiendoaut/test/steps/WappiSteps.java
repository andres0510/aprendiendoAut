package com.aprendiendoaut.test.steps;

import com.aprendiendoaut.test.controller.GeneralController;
import com.aprendiendoaut.test.controller.WappiController;
import com.aprendiendoaut.test.dto.Persona;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.Date;

public class WappiSteps {
    @Dado("^que me autentico en la página de wappi$")
    public void queMeAutenticoEnLaPaginaDeWappi(){
        GeneralController.openApp("Wappi");
        WappiController.iniciarSesion("Angelica","keka4594");
    }

    @Cuando("^diligencio el formulario de actualización de datos$")
    public void diligencioElFormularioDeActualizacionDeDatos(){
        WappiController.seleccionarOpcionMenu("Informacion Personal");
        Persona persona = new Persona();
        persona.setNombre("Angelica");
        persona.setApellido("Franco");
        persona.setFechaNacimiento(new Date());
        persona.setPais("Colombia");
        persona.setSexo("Femenino");
        WappiController.ingresarDatos(persona);
        WappiController.guardarDatos();

    }

    @Entonces("^el sistema actualizará los datos$")
    public void elSistemaActualizaraLosDatos() throws InterruptedException {
        WappiController.validarMensaje();
        Thread.sleep(10000);

    }

}
