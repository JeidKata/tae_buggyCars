package com.aviatur.buggy_car.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logs;
    private static final int TIMEOUT = 10;


    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.logs = LogManager.getLogger(this.getClass().getName());
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(TIMEOUT));
    }

    /**
     * Manejar las alertas de la pagina.
     */
    public void handleAlert(){
        try {
            this.wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = this.driver.switchTo().alert();
            alert.accept();
            logs.info("Alerta aceptada.");
        } catch (Exception e){
            logs.error("No hay alertas: " + e.getMessage());
        }
    }

    /**
     * Metodo para dar click.
     */
    public void clicOn(WebElement locator){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (Exception e) {
            System.out.println("No se pudo hacer click en el elemento: " + locator);
            e.printStackTrace();
        }
    }

    /**
     * Metodo para escribir texto.
     */
    public void writeText(WebElement locator, String text){
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            System.out.println("No se pudo escribir en el elemento: " + locator);
        }
    }
}
