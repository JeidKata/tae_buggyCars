package com.aviatur.buggy_car.data;

import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "registerData")
    public Object [] [] registerData(){
        return new Object[][]{
                {"", "", "", "", "", "Campos requeridos."},
                {"TestPrueba", "Test", "Prueba", "123t", "123t","Password corta"},
                {"TestPrueba", "Test", "Prueba", "123t#", "123t#","Password minimo 6"},
                {"TestPrueba", "Test", "Prueba", "123test654#", "123test654#","No cumple condiciones"},
                {"TestPrueba", "Test", "Prueba", "123tesT654#", "123testT654#","No coinciden"},
                {"TestPrueba", "Test", "Prueba", "123tesT654#", "123tesT654#","Ya existe usuario"},
        };
    }
}
