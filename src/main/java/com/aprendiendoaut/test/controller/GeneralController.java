package com.aprendiendoaut.test.controller;

import com.aprendiendoaut.test.action.DriverManager;
import com.aprendiendoaut.test.helpers.Dictionary;
import com.aprendiendoaut.test.helpers.PropertiesFile;
import com.aprendiendoaut.test.helpers.Report;

public class GeneralController {

    private GeneralController(){}

    //----------------------------------------------------------------------------------------------------------------->
    //---------- INIT & LOGIN ----------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public static void openApp(String app) {

        String appUrl = obtenerUrl(app);
        DriverManager.open(appUrl);
        Report.reportInfo(String.format(Dictionary.Messages.SUCCESS, "Open Google app"));
    }

    private static String obtenerUrl(String app){
        PropertiesFile properties = new PropertiesFile(Dictionary.PropertiesPath.DEFAULT);
        switch (app){
            case "Google":
                return properties.getProperty("google.url");
            case "Wappi":
                return properties.getProperty("wappi.url");
            default:
                Report.reportFail(
                        String.format("La aplicacion %s no es válida", app)
                );
                return "";
        }
    }

}
