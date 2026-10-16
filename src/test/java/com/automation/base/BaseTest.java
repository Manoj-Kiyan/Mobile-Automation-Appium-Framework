package com.automation.base;

import com.automation.utils.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URI;
import java.time.Duration;
import java.util.Map;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        String platform = ConfigReader.getProperty("platformName");
        String device = ConfigReader.getProperty("deviceName");
        String serverUrl = ConfigReader.getProperty("appiumServerUrl");
        int waitTime = Integer.parseInt(ConfigReader.getProperty("implicitWait"));

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(platform);
        options.setDeviceName(device);
        options.setNoReset(true);

        System.out.println("[BaseTest] Connecting to " + device + " via " + serverUrl);
        driver = new AndroidDriver(URI.create(serverUrl).toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
    }
    public AndroidDriver getDriver() {
        return this.driver;
    }

    public void launchApp(String appPackage, String appActivity) {
        System.out.println("[BaseTest] Dynamically launching: " + appPackage);
        driver.executeScript("mobile: startActivity", Map.of(
                "intent", appPackage + "/" + appActivity
        ));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            System.out.println("[BaseTest] Quitting Driver session...");
            driver.quit();
        }
    }
}