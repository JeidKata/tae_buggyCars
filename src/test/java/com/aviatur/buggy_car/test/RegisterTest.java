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
        register.fillRegistrationForm(username, firstname,lastname,password,confirmPassword);
        Assert.assertEquals(register.btnRegisterDisabled(), false);
        register.clickRegister();
        Assert.assertEquals((register.isMsgAlertDisplayed()), "Registration is successful");

    }

    @Test(description = "Unhappy Paths", dataProvider = "registerData", dataProviderClass = Data.class)
    public void resgiterUserWithErrors(String username, String firstname, String lastname, String password, String confirmPassword, String error){
        MainPage main = new MainPage(driver);
        RegisterPage register = new RegisterPage(driver);

        main.clicOnRegister();
        Assert.assertTrue(register.btnRegisterDisabled(), "El botón de resgistro debe estar deshabilitado si hay campos vacíos.");
        register.fillRegistrationForm(username, firstname,lastname,password,confirmPassword);

        switch (error){
            case "Campos requeridos.":
                register.triggerAllRequiredErrors();
                Assert.assertTrue(register.getMsgAlert(), "Debe mostrar mensajes de validación en todos los campos vacíos.");
                break;

            case "Password corta":
            register.clickRegister();
            Assert.assertEquals(register.isMsgAlertDisplayed(), "InvalidParameter: 1 validation error(s) found. - minimum field size of 6, SignUpInput.Password.");
            break;

            case "Password minimo 6":
            register.clickRegister();
            Assert.assertEquals(register.isMsgAlertDisplayed(), "InvalidParameter: 1 validation error(s) found. - minimum field size of 6, SignUpInput.Password.");
            break;

            case "No cumple condiciones":
            register.clickRegister();
            Assert.assertEquals(register.isMsgAlertDisplayed(), "InvalidPasswordException: Password did not conform with policy: Password must have uppercase characters");
            break;

            case "No coinciden":
            Assert.assertTrue(register.getMsgAlert(), "Debe mostrar mensaje: 'Constraseñas no coinciden'.");
            Assert.assertEquals(register.btnRegisterDisabled(), true);
            break;

            case "Ya existe usuario":
            register.clickRegister();
            Assert.assertEquals(register.isMsgAlertDisplayed(), "UsernameExistsException: User already exists");
            Assert.assertFalse(register.btnRegisterDisabled(), "El botón de resgistro debe estar habilitado.");
            break;
        }
    }
}
