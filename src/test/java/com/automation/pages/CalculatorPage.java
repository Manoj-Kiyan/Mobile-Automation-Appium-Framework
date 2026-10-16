package com.automation.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CalculatorPage {

    private AndroidDriver driver;


    private By btn2 = AppiumBy.id("com.coloros.calculator:id/digit_2");
    private By btn5 = AppiumBy.id("com.coloros.calculator:id/digit_5");
    private By btnMultiply = AppiumBy.id("com.coloros.calculator:id/op_mul");
    private By btnEquals = AppiumBy.id("com.coloros.calculator:id/img_eq");
    private By resultText = AppiumBy.id("com.coloros.calculator:id/result");


    public CalculatorPage(AndroidDriver driver) {
        this.driver = driver;
    }


    public void multiplyTwoAndFive() {
        driver.findElement(btn2).click();
        driver.findElement(btnMultiply).click();
        driver.findElement(btn5).click();
        driver.findElement(btnEquals).click();
    }

    public String getCalculationResult() {
        return driver.findElement(resultText).getText();
    }
}