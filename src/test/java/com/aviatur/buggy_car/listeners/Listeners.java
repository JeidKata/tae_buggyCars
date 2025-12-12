package com.aviatur.buggy_car.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    public Logger logs = LogManager.getLogger(Listeners.class);

    @Override
    public void onTestStart(ITestResult result) {
        logs.info("Test started " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logs.info("Test Exitoso ✅ " + result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        logs.error("Test Fallido ❌ " + result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logs.warn("Test Ignorado ⏭\uFE0F " + result.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logs.info("Test con algunos fallos" + result.getName());
        // This method is not commonly used, so we can leave it empty or log a message if needed

    }

    @Override
    public void onStart(ITestContext context) {
        logs.info("--- \uD83C\uDFC1 INICIA TEST " + context.getName());

    }

    @Override
    public void onFinish(ITestContext context) {
        logs.info("--- \uD83C\uDFC1 FINALIZA TEST " + context.getName());

    }
}
