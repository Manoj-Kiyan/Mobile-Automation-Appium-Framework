package com.automation.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdbUtils {

    public static void runAdb(String... args) throws Exception {
        List<String> cmd = new ArrayList<>();
        cmd.add("adb");
        cmd.addAll(Arrays.asList(args));

        System.out.println("[ADB Command] " + String.join(" ", cmd));
        Process process = new ProcessBuilder(cmd).start();
        process.waitFor();
    }


    public static void dropBatteryTo(int percentage) throws Exception {
        runAdb("shell", "dumpsys", "battery", "unplug");
        runAdb("shell", "dumpsys", "battery", "set", "level", String.valueOf(percentage));
    }

    public static void resetBattery() throws Exception {
        runAdb("shell", "dumpsys", "battery", "reset");
    }

    // --- Network Simulation Methods ---
    public static void turnWifiOff() throws Exception {
        System.out.println("[ADB Network] Turning Wi-Fi OFF...");
        runAdb("shell", "svc", "wifi", "disable");
    }

    public static void turnWifiOn() throws Exception {
        System.out.println("[ADB Network] Turning Wi-Fi ON...");
        runAdb("shell", "svc", "wifi", "enable");
    }


    public static void pushTestNotification(String title, String message) throws Exception {
        System.out.println("[ADB Notification] Pushing notification: " + title + " -> " + message);
        runAdb("shell", "cmd", "notification", "post", "-t", "\"" + title + "\"", "tag1", "\"" + message + "\"");
    }
}