package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.CalculatorPage;
import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorPomTest extends BaseTest {

    @Test
    public void testMultiplicationWithPOM() {

        launchApp(ConfigReader.getProperty("calculatorPackage"), ConfigReader.getProperty("calculatorActivity"));

        CalculatorPage calcPage = new CalculatorPage(driver);
        calcPage.multiplyTwoAndFive();
        Assert.assertEquals(calcPage.getCalculationResult(), "10", "Multiplication Assertion Failed!");
        System.out.println("Calculator Test Passed Successfully!");
    }
}