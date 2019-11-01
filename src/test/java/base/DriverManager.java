package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static ThreadLocal<AppiumDriver<MobileElement>> currentDriver = new ThreadLocal<AppiumDriver<MobileElement>>();

    public static AppiumDriver<MobileElement> getDriver() {

        return currentDriver.get();
    }

    public static void setDriver(AppiumDriver<MobileElement> driver) {
            currentDriver.set(driver);
    }
}
