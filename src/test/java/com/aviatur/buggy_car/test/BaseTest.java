package com.aviatur.buggy_car.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {
    private static final String URL = "https://buggy.justtestit.org/";
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final Logger logger = LogManager.getLogger(String.valueOf(BaseTest.class));

    /*
     * Configuro WebDriver para Chrome
     */

    @BeforeSuite
    public void setupWebDriverManager(){
        WebDriverManager.chromedriver().setup();
        logger.info("WebDriverManager configurado para Chrome.");
    }

    @BeforeMethod
    public void setup(){
        logger.info("Inicia la configuración de la prueba...");
        logger.info("Configuración del entorno de prueba.");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--desactivar--extensiones");

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(URL);
        logger.info("Navegando en: https://buggy.justtestit.org/");
    }

    /*
     * Cierra el navegador después de cada metodo de prueba.
     */
    @AfterMethod
    public void teardown(){
        if (driver != null){
            driver.quit();
            logger.info("Navegador cerrado.");
        }
        logger.info("Configuración del test completado.");
    }

}
