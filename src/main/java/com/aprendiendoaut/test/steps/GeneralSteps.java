package com.aprendiendoaut.test.steps;

import com.aprendiendoaut.test.action.DriverManager;
import com.aprendiendoaut.test.helpers.Report;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class GeneralSteps {

    private GeneralSteps(){}

    @Before
    public static void setUp(){
        Report.init();
        DriverManager.init();
    }

    @After
    public static void tearDown(){
        DriverManager.finish();
    }

}
