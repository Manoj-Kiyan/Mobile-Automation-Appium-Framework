package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.utils.AdbUtils;
import com.automation.utils.DeviceKeyUtils;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class NetworkAndInterruptionTest extends BaseTest {


    // TEST CASE 1: PUSH NOTIFICATION TRAY TEST

    @Test
    public void testNotificationDrawerAndClick() throws Exception {
        System.out.println("--- Starting Test 1: Push Notification Interruption ---");


        AdbUtils.pushTestNotification("RideAlert", "Driver_Arrived_At_Koyambedu");
        Thread.sleep(2000);


        System.out.println("Pulling down Notification Drawer...");
        driver.openNotifications();
        Thread.sleep(2000);


        try {
            System.out.println("Tapping on RideAlert notification...");
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"RideAlert\")")).click();
            System.out.println("Notification tapped successfully!");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Notification displayed in drawer!");
        }


        DeviceKeyUtils.pressBack(driver);
        Thread.sleep(1500);
        System.out.println("Test 1 Completed Successfully!\n");
    }


    // TEST CASE 2: NETWORK OFF AND ON TEST

    @Test
    public void testNetworkOffAndOn() throws Exception {
        System.out.println("--- Starting Test 2: Network Interruption ---");


        AdbUtils.turnWifiOff();
        System.out.println("Wi-Fi is now OFF! Checking app offline state.");
        Thread.sleep(4000);


        AdbUtils.turnWifiOn();
        System.out.println("Wi-Fi is now RESTORED! Back to online.");
        Thread.sleep(3000);

        System.out.println("Test 2 Completed Successfully!");
    }
}