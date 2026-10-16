package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.utils.AdbUtils;
import org.testng.annotations.Test;

public class BatteryScenarioTest extends BaseTest {

    @Test
    public void testBatteryDropAlert() throws Exception {
        System.out.println("Starting Battery Scenario Test...");
        Thread.sleep(2000);


        System.out.println("Simulating Low Battery (10%)...");
        AdbUtils.dropBatteryTo(10);

        System.out.println("Verify phone is in low power / power saving warning state!");
        Thread.sleep(5000);


        System.out.println("Resetting battery back to original state...");
        AdbUtils.resetBattery();
        System.out.println("Battery Scenario Test Completed Successfully!");
    }
}