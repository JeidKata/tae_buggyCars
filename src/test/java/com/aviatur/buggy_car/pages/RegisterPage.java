package com.aviatur.buggy_car.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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

    @FindBy(className = "alert-danger")
    private List<WebElement> msgAlert;

    @FindBy(className = "result")
    private WebElement invalidParameter;

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    /**
     * Aquí empiezan los metodos del registro
     */
    public void fillRegistrationForm(String username, String firstname, String lastname, String password, String confirmPassword){
        writeText(txtUsername, username);
        writeText(txtFirstName, firstname);
        writeText(txtLastName, lastname);
        writeText(txtPassword, password);
        writeText(txtConfirmPassword, confirmPassword);
    }

    public void clickRegister(){
        clicOn(btnRegister);
    }

    public boolean btnRegisterDisabled(){
        return !btnRegister.isEnabled();
    }

    public boolean getMsgAlert(){
        try{
            for (WebElement alerta : msgAlert) {
                if (alerta.isDisplayed()) {
                    return true;
                }
            }
            return false;
        }
        catch (Exception e){
            return false;
        }
    }

    public void triggerAllRequiredErrors(){
        touchFieldAndLeaveEmpty(txtUsername);
        touchFieldAndLeaveEmpty(txtFirstName);
        touchFieldAndLeaveEmpty(txtLastName);
        touchFieldAndLeaveEmpty(txtPassword);
        touchFieldAndLeaveEmpty(txtConfirmPassword);
    }

    public boolean isMsgAlertDisplayed(){
        try{
            wait.until(ExpectedConditions.visibilityOf(invalidParameter));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
