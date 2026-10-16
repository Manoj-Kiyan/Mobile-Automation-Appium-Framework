package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.utils.LocationUtils;
import io.appium.java_client.Location;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GpsLocationTest extends BaseTest {

    @Test
    public void testGpsMockingChennaiLocations() throws Exception {
        System.out.println("--- Step 1: Mocking Location to Chennai Central Railway Station ---");
        LocationUtils.setDeviceLocation(driver, LocationUtils.CHENNAI_CENTRAL_LAT, LocationUtils.CHENNAI_CENTRAL_LON, "Chennai Central Station");
        Thread.sleep(3000);

        // Fetch current device location from driver
        Location currentLocation = driver.getLocation();
        System.out.println("Device Current Latitude: " + currentLocation.getLatitude());
        System.out.println("Device Current Longitude: " + currentLocation.getLongitude());

        // Verify latitude matches Chennai Central
        Assert.assertEquals(Math.round(currentLocation.getLatitude() * 100.0) / 100.0, 13.08, "Failed to mock Chennai Central Latitude!");
        System.out.println("Verification Passed: Phone is now virtually at Chennai Central!");

        System.out.println("\n--- Step 2: Moving Device to Koyambedu Bus Stand (CMBT) ---");
        LocationUtils.setDeviceLocation(driver, LocationUtils.KOYAMBEDU_LAT, LocationUtils.KOYAMBEDU_LON, "Koyambedu Bus Stand");
        Thread.sleep(3000);

        Location newLocation = driver.getLocation();
        System.out.println("Device New Latitude: " + newLocation.getLatitude());
        System.out.println("Device New Longitude: " + newLocation.getLongitude());

        Assert.assertEquals(Math.round(newLocation.getLatitude() * 100.0) / 100.0, 13.07, "Failed to mock Koyambedu Latitude!");
        System.out.println("Verification Passed: Phone moved to Koyambedu Bus Stand!");
    }
}