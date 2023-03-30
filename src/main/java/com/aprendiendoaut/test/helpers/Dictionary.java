package com.aprendiendoaut.test.helpers;

import java.util.Arrays;
import java.util.List;

public class Dictionary {

    private Dictionary(){}

    public static class PropertiesPath {
        private PropertiesPath(){}
        private static final String SYSTEM_SEPARATOR = System.getProperty("file.separator");
        private static final String DEFAULT_PATH = "src/main/resources/properties/configuration.properties";
        public static final String DEFAULT = DEFAULT_PATH.replace("/", SYSTEM_SEPARATOR);
    }

    public static class Messages {
        private Messages(){}
        public static final String SUCCESS = "[SUCCESS] - %s";
        public static final String COMPARE = "[COMPARE] %s - Expected: %s - Found: %s";
    }

    public static class DateFormat {
        private DateFormat(){}
        public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH-mm-ss";
        public static final String YYYY_MM = "yyyy-MM";
        public static final String D = "d";
        public static final String DD_MMM_YYYY = "dd MMM yyyy";
    }
    public static class Pais{
        private Pais(){}
        public static final List<String> PAISES= Arrays.asList("Colombia","Argentina", "Estados Unidos");
    }
    public static class Sexo{
        private Sexo(){}
        public static final List<String> SEXOS= Arrays.asList("Masculino","Femenino");
    }
}
