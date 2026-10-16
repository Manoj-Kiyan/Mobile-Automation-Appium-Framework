package com.automation.utils;

import com.automation.base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();

        System.out.println(" TEST FAILED: " + testName + " - Capturing Evidence Screenshot...");


        Object currentClass = result.getInstance();
        AndroidDriver driver = ((BaseTest) currentClass).getDriver();

        if (driver != null) {
            ScreenshotUtils.captureScreenshot(driver, testName);
        }
    }
}