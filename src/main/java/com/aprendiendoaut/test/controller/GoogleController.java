package com.aprendiendoaut.test.controller;

import com.aprendiendoaut.test.page.PageGoogleBusqueda;
import com.aprendiendoaut.test.page.PageGoogleImagenesBusqueda;
import com.aprendiendoaut.test.page.PageGoogleImagenesResultado;

public class GoogleController {

    private static PageGoogleBusqueda pageGoogleBusqueda;
    private static PageGoogleImagenesBusqueda pageGoogleImagenesBusqueda;
    private static PageGoogleImagenesResultado pageGoogleImagenesResultado;

    private GoogleController(){
    }

    public static void buscarImagenEnGoogle(String nombreImagen) {
        pageGoogleBusqueda = new PageGoogleBusqueda();
        pageGoogleBusqueda.clickLnkImagenes();
        pageGoogleImagenesBusqueda = new PageGoogleImagenesBusqueda();
        pageGoogleImagenesBusqueda.escribirBusqueda(nombreImagen);
        pageGoogleImagenesBusqueda.clickBtnBuscar();
    }

}
