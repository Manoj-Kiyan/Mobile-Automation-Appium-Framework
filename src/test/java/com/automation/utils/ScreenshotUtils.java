package com.automation.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String captureScreenshot(AndroidDriver driver, String testName) {
        if (driver == null) {
            return null;
        }

        // 1. Unique timestamp format (e.g. 20261015_141500)
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testName + "_" + timeStamp + ".png";

        // 2. Folder directory setup: screenshots/
        String directory = "reports/screenshots/";
        Path dirPath = Paths.get(directory);

        try {
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }

            // 3. Take screenshot as File
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path destination = Paths.get(directory + fileName);
            Files.copy(source.toPath(), destination);

            System.out.println("[EVIDENCE] Failure Screenshot Saved at: " + destination.toAbsolutePath());
            return destination.toAbsolutePath().toString();

        } catch (IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
            return null;
        }
    }
}