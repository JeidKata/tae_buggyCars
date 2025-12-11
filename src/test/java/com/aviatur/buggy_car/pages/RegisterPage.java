package com.aviatur.buggy_car.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(id = "firstName")
    private WebElement txtFirstName;

    @FindBy(id = "lastName")
    private WebElement txtLastName;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(id = "confirmPassword")
    private WebElement txtConfirmPassword;

    @FindBy(className = "btn-default")
    private WebElement btnRegister;

    @FindBy(className = "result alert alert-danger")
    private WebElement msgAlert;

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    /**
     * Aquí empiezan los metodos del registro
     */
    public void enterUsername(String username){
        writeText(txtUsername, username);
    }

    public void enterFirstName(String firstname){
        writeText(txtFirstName, firstname);
    }

    public void enterLastName(String lastname){
        writeText(txtLastName, lastname);
    }

    public void enterPassword(String password) {
        if (password.length() >= 6){
            writeText(txtPassword, password);
        }else {
            getMsgAlert();
        }
    }

    public void enterConfirmPassword(String confirmPassword){
        writeText(txtConfirmPassword, confirmPassword);
    }

    public void clickRegister(){
        clicOn(btnRegister);
    }

    public boolean btnRegisterDisabled(){
        return !btnRegister.isEnabled();
    }

    public void getMsgAlert(){
        if (msgAlert.isEnabled()){
            logs.info("Aparece mensaje error de contraseña.");
        }else{
            logs.info("No hay mensaje de error por contraseña.");
        }
    }
}
