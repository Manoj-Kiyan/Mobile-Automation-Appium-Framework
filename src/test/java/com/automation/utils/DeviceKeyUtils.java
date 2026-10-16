package com.automation.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class DeviceKeyUtils {

    public static void pressBack(AndroidDriver driver) {
        System.out.println("[Hardware Key] Pressing BACK button");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public static void pressHome(AndroidDriver driver) {
        System.out.println("[Hardware Key] Pressing HOME button");
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}