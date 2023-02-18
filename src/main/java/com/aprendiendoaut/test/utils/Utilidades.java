package com.aprendiendoaut.test.utils;

public class Utilidades {

    public static void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
