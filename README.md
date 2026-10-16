# 📱 Enterprise Android Automation Framework
### *An End-to-End, Production-Grade Mobile Test Automation Engine powered by Appium 3.x, Java 21, and ADB*

[![Java](https://img.shields.io/badge/Java-21%20LTS-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Appium](https://img.shields.io/badge/Appium-3.8.0-662d91?style=for-the-badge&logo=appium&logoColor=white)](https://appium.io/)
[![UiAutomator2](https://img.shields.io/badge/Driver-UiAutomator2%208.7.0-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://github.com/appium/appium-uiautomator2-driver)
[![TestNG](https://img.shields.io/badge/TestNG-7.11.0-FF7F00?style=for-the-badge&logo=testng&logoColor=white)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![Platform](https://img.shields.io/badge/Platform-Real%20Android%20Device-brightgreen?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/)

---

## 📌 Executive Summary

This repository contains an **Enterprise-Grade Mobile Test Automation Framework** engineered for native Android applications. Going far beyond basic element clicking, this framework incorporates **deep OS-level control, hardware event simulation, and realistic device edge cases** (battery drain, GPS mocking, network drops, and push notification interruptions) via **ADB (Android Debug Bridge)** and **Appium 3.x**.

Architected from the ground up using the **Hybrid Page Object Model (POM)** pattern, this project ensures zero hard-coding, reusable utilities, dynamic application provisioning, and automated defect proof capture.

---

## 🌟 Key Engineering Highlights

### 1. 🏗️ Hybrid Page Object Model (POM) & Centralized Config
* **Zero Hard-Coding:** All device configs (`deviceName`, `platformName`, `appiumServerUrl`, `implicitWait`) and app credentials are fully externalized into `src/test/resources/config.properties`.
* **Dynamic App Launcher:** Single unified `BaseTest` capable of hot-swapping and driving multiple target apps dynamically (`launchApp(pkg, act)`) without restarting Appium sessions.

### 2. ⚡ Advanced Hardware & OS State Automation (ADB Integration)
* **🔋 Battery Edge-Case Simulation:** Automated battery level drops (100% down to 10%) via `dumpsys battery set level 10` to validate low-power warnings, with guaranteed teardown reset (`dumpsys battery reset`) in `@AfterMethod`.
* **📍 GPS Co-ordinate Mocking (Ride-Hailing Style):** Simulates location jumps between **Chennai Central Station** (`13.0827, 80.2755`) and **Koyambedu Bus Stand** (`13.0694, 80.1948`) using modern Appium Geolocation APIs for location-based pricing validation.
* **📶 Network Interruption Recovery:** Toggles device Wi-Fi state dynamically (`svc wifi disable / enable`) to assert application offline behavior and automatic recovery.
* **🔔 Push Notification Drawer Automation:** Posts native mock shell notifications, expands the Android notification drawer (`driver.openNotifications()`), interacts with notification cards, and recovers state.

### 3. 👆 Native Gestures & Physical KeyEvents
* **Smart Dynamic Scrolling:** Implements Android's native `UiScrollable.scrollIntoView()` to automatically navigate through long scrollable views without static coordinates.
* **Hardware Key Simulation:** Controls hardware navigation keys (`AndroidKey.BACK`, `AndroidKey.HOME`) and validates application state persistence via `driver.activateApp()`.

### 4. 📸 Automated Defect Proof Engine (TestNG Listener)
* Integrates a custom `ITestListener` that automatically detects test failures, captures high-resolution screenshots from the real device, and archives them with unique timestamps in `reports/screenshots/`.

---

## 🏛️ Framework Architecture

```text
MobileAutomationFramework/
├── src/
│   └── test/
│       ├── java/
│       │   └── com/automation/
│       │       ├── base/
│       │       │   └── BaseTest.java               # Lifecycle manager & dynamic app launcher
│       │       ├── pages/
│       │       │   ├── CalculatorPage.java         # Calculator locators & action methods
│       │       │   └── SettingsPage.java           # Settings locators & scroll actions
│       │       ├── utils/
│       │       │   ├── AdbUtils.java               # Low-level ProcessBuilder shell bridge
│       │       │   ├── ConfigReader.java           # Singleton property reader engine
│       │       │   ├── DeviceKeyUtils.java         # Hardware key actions (Back, Home)
│       │       │   ├── LocationUtils.java          # GPS Mocking coordinates repository
│       │       │   ├── ScreenshotUtils.java        # TakesScreenshot file storage engine
│       │       │   └── TestListener.java           # TestNG failure observer spy
│       │       └── tests/
│       │           ├── CalculatorPomTest.java      # Mathematics business logic verification
│       │           ├── SettingsScrollTest.java     # Gestures & back navigation verification
│       │           ├── BatteryScenarioTest.java    # Low battery (10%) edge case
│       │           ├── SettingsAndBatteryTest.java # Full device lifecycle integration test
│       │           ├── GpsLocationTest.java        # Coordinates simulation verification
│       │           └── NetworkAndInterruptionTest.java # Drawer notifications & Wi-Fi toggle
│       └── resources/
│           └── config.properties                   # Centralized configuration source
├── reports/
│   └── screenshots/                                # Automated failure evidence archive
├── testng.xml                                      # Master Regression Suite Runner
├── pom.xml                                         # Maven dependency management
└── README.md                                       # Documentation
```

---

## 📊 Comprehensive Test Suite Overview

| # | Test Class | Tested Scenarios | Technical Mechanism |
|---|---|---|---|
| **1** | `CalculatorPomTest` | Basic operations, number clicks, arithmetic verification | `AppiumBy.id`, POM, TestNG `Assert.assertEquals` |
| **2** | `SettingsScrollTest` | Long list scrolling, targeting hidden "About" section | Native Android `UiScrollable.scrollIntoView()` |
| **3** | `BatteryScenarioTest` | Battery drop from 100% to 10%, low power alert | Java `ProcessBuilder`, `adb shell dumpsys battery` |
| **4** | `SettingsAndBatteryTest` | End-to-end user journey with interruptions & resume | `AndroidKey.HOME`, `driver.activateApp()`, Battery Drop |
| **5** | `GpsLocationTest` | Multi-point location mocking (Chennai Central & CMBT) | `driver.setLocation(new Location(lat, lon, alt))` |
| **6** | `NetworkAndInterruptionTest` | Status bar push notification click, Wi-Fi off/on toggle | `driver.openNotifications()`, `adb shell svc wifi` |

---

## 🛠️ Technology Stack

| Category | Tool / Library | Version | Purpose |
|---|---|---|---|
| **Language** | Java | 21 (LTS) | Core object-oriented test programming |
| **Mobile Engine** | Appium Server | 3.8.0 | Client-Server protocol bridge |
| **Driver** | UiAutomator2 Driver | 8.7.0 | Android native OS touch & inspect driver |
| **Client Library** | Appium Java Client | 9.4.0 | Modern Appium 9 W3C bindings |
| **Test Runner** | TestNG | 7.11.0 | Test lifecycle, assertions, and suite runner |
| **Build Tool** | Apache Maven | 3.x | Dependency management and build lifecycle |
| **Device Bridge** | Android Debug Bridge | 1.0.41 | Direct hardware and daemon control |
| **Inspector** | Appium Inspector | 2026.x | UI XML hierarchy inspection & locator discovery |

---

## 🚀 Setup & Execution Guide

### Prerequisites
1. **Java JDK 21** installed and configured in `JAVA_HOME`.
2. **Node.js LTS (v24+)** installed.
3. **Android SDK & Platform Tools** configured in `ANDROID_HOME` & system `Path`.
4. Real Android device connected with **USB Debugging enabled**.

### Quick Start

1. **Verify Device Connection:**
   ```bash
   adb devices
   # Expected output: <device_serial>   device
   ```

2. **Start Appium Server:**
   ```bash
   appium
   # Server should start listening on http://0.0.0.0:4723
   ```

3. **Configure Environment:**
   Update your connected device UDID inside `src/test/resources/config.properties`:
   ```properties
   deviceName=YOUR_DEVICE_SERIAL
   ```

4. **Run Entire Regression Suite:**
   Execute via Maven:
   ```bash
   mvn clean test
   ```
   *Or right-click `testng.xml` inside IntelliJ IDEA and select **Run 'testng.xml'**.*

---

## 💡 Real-World Design Decisions

* **Why Appium 3.x over Appium 1.x?**
  Appium 3 utilizes completely decoupled, modular driver architectures (`uiautomator2`), fully adhering to the W3C WebDriver specification.
* **Why `UiScrollable` instead of TouchActions?**
  `TouchAction` has been completely deprecated in modern Appium. Leveraging Android's native `UiScrollable` offloads the swipe calculation logic directly to the device OS, guaranteeing non-flaky scrolls across differing screen densities.
* **Why ADB inside Automation?**
  Real-world mobile apps encounter unpredictable operating conditions. Simulating battery drops, network degradation, and push notifications directly within Java code allows true production-readiness testing before release.

---

## 👨‍💻 Author

**Manoj Kiyan M**  
*QA Automation Engineer / SDET*  
Specializing in Web & Mobile Test Automation (Selenium, Appium, Java, TestNG, CI/CD)
