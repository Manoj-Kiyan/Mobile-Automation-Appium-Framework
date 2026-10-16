package com.automation.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class SettingsPage {

    private AndroidDriver driver;

    public SettingsPage(AndroidDriver driver) {
        this.driver = driver;
    }


    public void scrollToAboutAndClick() {
        System.out.println("[SettingsPage] Scrolling down to find 'About'...");
        String scrollCommand = "new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().textContains(\"About\"));";

        driver.findElement(AppiumBy.androidUIAutomator(scrollCommand)).click();
        System.out.println("[SettingsPage] Clicked 'About' successfully!");
    }
}