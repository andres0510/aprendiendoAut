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

    public static void openGoogleApp() {
        PropertiesFile properties = new PropertiesFile(Dictionary.PropertiesPath.DEFAULT);
        String appUrl = properties.getProperty("google.url");
        DriverManager.open(appUrl);
        Report.reportInfo(String.format(Dictionary.Messages.SUCCESS, "Open Google app"));
    }

}
