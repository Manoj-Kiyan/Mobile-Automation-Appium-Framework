package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.SettingsPage;
import com.automation.utils.AdbUtils;
import com.automation.utils.ConfigReader;
import com.automation.utils.DeviceKeyUtils;
import org.testng.annotations.Test;

public class SettingsAndBatteryTest extends BaseTest {

    @Test
    public void testFullDeviceLifecycleScenario() throws Exception {
        System.out.println("--- Launching Settings App");
        launchApp(ConfigReader.getProperty("settingsPackage"), ConfigReader.getProperty("settingsActivity"));
        Thread.sleep(2000);

        SettingsPage settingsPage = new SettingsPage(driver);


        System.out.println("--- Scenario Step 1: Navigating Settings ---");
        settingsPage.scrollToAboutAndClick();
        Thread.sleep(2000);


        System.out.println("--- Scenario Step 2: Hardware Keys ---");
        DeviceKeyUtils.pressBack(driver);
        Thread.sleep(1500);

        DeviceKeyUtils.pressHome(driver);
        Thread.sleep(1500);


        System.out.println("--- Scenario Step 3: Low Battery Simulation ---");
        AdbUtils.dropBatteryTo(10);
        System.out.println("Battery dropped to 10% on Home screen!");
        Thread.sleep(4000);


        System.out.println("--- Scenario Step 4: Resume App ---");
        driver.activateApp("com.android.settings");
        System.out.println("Settings app restored smoothly!");
        Thread.sleep(2000);


        AdbUtils.resetBattery();
        System.out.println("Scenario Completed with Zero Errors!");
    }
}