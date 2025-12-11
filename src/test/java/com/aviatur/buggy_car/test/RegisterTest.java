package com.aviatur.buggy_car.test;

import com.aviatur.buggy_car.data.Data;
import com.aviatur.buggy_car.pages.MainPage;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

     @Test
    public void registerUser(){

         MainPage main = new MainPage(driver);

         main.clicOnRegister();
     }
}
