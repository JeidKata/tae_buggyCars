package com.aviatur.buggy_car.test;

import com.aviatur.buggy_car.data.Data;
import com.aviatur.buggy_car.pages.MainPage;
import com.aviatur.buggy_car.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    @Parameters({"username", "firstname", "lastname", "password", "confirmPassword"})
    @Test(description = "Happy path")
    public void registerUserSuccess(String username, String firstname, String lastname, String password, String confirmPassword){

        MainPage main = new MainPage(driver);
        RegisterPage register = new RegisterPage(driver);

        main.clicOnRegister();
        Assert.assertEquals(register.btnRegisterDisabled(), true);
        register.enterUsername(username);
        register.enterFirstName(firstname);
        register.enterLastName(lastname);
        register.enterPassword(password);
        register.enterConfirmPassword(confirmPassword);
        Assert.assertEquals(register.btnRegisterDisabled(), false);
        register.clickRegister();
    }
}
