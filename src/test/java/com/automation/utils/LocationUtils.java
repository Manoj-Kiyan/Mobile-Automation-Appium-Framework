package com.automation.utils;

import io.appium.java_client.Location;
import io.appium.java_client.android.AndroidDriver;



public class LocationUtils {
    public static final double CHENNAI_CENTRAL_LAT =  13.0827;
    public static final double CHENNAI_CENTRAL_LON = 80.2755;


    public static final double KOYAMBEDU_LAT = 13.0694;
    public static final double KOYAMBEDU_LON = 80.1948;

    public static  void setDeviceLocation(AndroidDriver driver,double latitude,double longitude,String locationName){
        System.out.println("[GPS MOCK] Moving device to :"+locationName + "( "+latitude +", "+ longitude + ")");

        driver.setLocation(new Location(latitude, longitude, 10.0));
    }

}
