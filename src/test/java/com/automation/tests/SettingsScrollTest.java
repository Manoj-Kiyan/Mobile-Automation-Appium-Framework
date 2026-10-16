package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.SettingsPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DeviceKeyUtils;
import org.testng.annotations.Test;

public class SettingsScrollTest extends BaseTest {

    @Test
    public void testSettingsScroll() throws Exception {

        launchApp(ConfigReader.getProperty("settingsPackage"), ConfigReader.getProperty("settingsActivity"));

        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.scrollToAboutAndClick();
        Thread.sleep(2000);

        DeviceKeyUtils.pressBack(driver);
        System.out.println("Settings Scroll Test Passed Successfully!");
    }
}