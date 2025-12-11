package com.aviatur.buggy_car.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(className = "btn-success-outline")
    private WebElement btnRegister;

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void clicOnRegister(){
        clicOn(btnRegister);
    }
}
