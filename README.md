# android-automation-test

## Prerequisites

- **Java 11+** - `java -version`
- **Maven 3.6+** - `mvn -version`
- **Appium Server** - `npm install -g appium` then `appium driver install uiautomator2`
- **Android SDK** - Install Android Studio and set `ANDROID_HOME`
- **Android Device/Emulator** - Connected and USB debugging enabled

## Setup

1. **Install dependencies**
   ```bash
   mvn clean install
   ```

2. **Start Appium Server**
   ```bash
   appium
   ```

3. **Connect Android device**
   - Enable USB debugging
   - Verify connection: `adb devices`

4. **Configure device** (optional)
   - Edit `config.properties` with your device UDID
   - Find UDID: `adb devices -l`

## Running Tests

```bash
mvn clean test
```

**Test Execution Order:**
1. Login feature
2. Product feature
3. Cart feature
4. Checkout feature

## Test Reports

After running tests, reports are generated in:

- **HTML Report:** `target/cucumber-reports/cucumber.html`
- **JSON Report:** `target/cucumber-reports/cucumber.json`
- **JUnit XML Report:** `target/cucumber-reports/cucumber.xml`

Open the HTML report in your browser to view test results.

## Test Evidence

- **Video Evidence:** `test-reports/evidence-record.mp4`
- **Test Scenarios:** `test-scenario/android_automation_test_scenario.xlsx`

## Troubleshooting

- **Device not detected:** Run `adb devices` and ensure USB debugging is enabled
- **Appium not starting:** Check if port 4723 is available
- **Tests failing:** Check Appium server logs and ensure device is unlocked
