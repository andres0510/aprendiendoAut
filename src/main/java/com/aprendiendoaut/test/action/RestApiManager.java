package com.aprendiendoaut.test.action;

import com.aprendiendoaut.test.dto.ServiceResponse;
import com.aprendiendoaut.test.helpers.Report;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestApiManager {

    //----------------------------------------------------------------------------------------------------------------->
    //---------- MAIN METHODS ----------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public static ServiceResponse consumirServicioGet(String endpoint) {
        try {
            URL url = new URL(endpoint);//your url i.e fetch data from .
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            int status = connection.getResponseCode();
            validateSuccessResponseCode(status);
            StringBuilder sb = getResponseMessage(connection);
            connection.disconnect();
            return new ServiceResponse(status, sb.toString());
        } catch (Exception e) {
            Report.reportFail(String.format("Error al consumir servicio GET: %s", e.getMessage()));
            return new ServiceResponse();
        }
    }

    public static ServiceResponse consumirServicioPost(String endpoint, String request) {
        try {
            URL url = new URL (endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = request.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            int status = connection.getResponseCode();
            validateSuccessResponseCode(status);
            StringBuilder sb = getResponseMessage(connection);
            connection.disconnect();
            return new ServiceResponse(status, sb.toString());
        } catch (IOException e) {
            Report.reportFail(String.format("Error al consumir servicio POST: %s", e.getMessage()));
            return new ServiceResponse();
        }
    }

    //----------------------------------------------------------------------------------------------------------------->
    //---------- SUPPORT METHODS -------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    private static void validateSuccessResponseCode(int responseCode) throws RuntimeException{
        if (responseCode!=200 && responseCode!=201) {
            throw new RuntimeException(
                String.format("Failed : HTTP Error code : %s", responseCode)
            );
        }
    }

    private static StringBuilder getResponseMessage(HttpURLConnection connection) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStreamReader in = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
        } catch (IOException e) {
            Report.reportFail(String.format("Error al obtener el mensaje de respuesta: %s", e.getMessage()));
        }
        return sb;
    }

}
