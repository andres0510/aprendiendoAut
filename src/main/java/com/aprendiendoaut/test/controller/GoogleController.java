package com.aprendiendoaut.test.controller;

import com.aprendiendoaut.test.page.google.PageGoogleBusqueda;
import com.aprendiendoaut.test.page.google.PageGoogleImagenesBusqueda;
import com.aprendiendoaut.test.page.google.PageGoogleImagenesResultado;

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
