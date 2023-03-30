package com.aprendiendoaut.test.dto;

import com.aprendiendoaut.test.helpers.Dictionary;
import com.aprendiendoaut.test.helpers.Utilities;
import com.github.javafaker.Faker;

import java.util.Date;

public class Persona {
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String pais;
    private String sexo;

    public Persona() {
        Faker faker = new Faker();
        this.nombre= faker.name().firstName();
        this.apellido= faker.name().lastName();
        this.pais= Utilities.seleccionarValorAleatorioDeLista(Dictionary.Pais.PAISES);
        this.fechaNacimiento= faker.date().birthday();
        this.sexo= Utilities.seleccionarValorAleatorioDeLista(Dictionary.Sexo.SEXOS);;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}


