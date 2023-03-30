package com.aprendiendoaut.test.helpers;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Utilities {

    private Utilities(){
    }

    public static String getCurrentDate(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    public static String getDateAsFormat(Date date, String format) {
        Locale locale = new Locale("es", "ES");
        SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
        return sdf.format(date);
    }

    public static void waitFor(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            Report.reportFail(String.format("[ERROR] Waiting failure: %s", e.getMessage()));
        }
    }

    public static String seleccionarValorAleatorioDeLista (List<String> lista){
        Faker faker = new Faker();
        int indice = faker.random().nextInt(0, lista.size()-1);
        return lista.get(indice);

    }

}
