package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Initializer {

	protected WebDriverWait webDriverWait;
	public AppiumDriver<MobileElement> mobilDriver;
	public static final int DEFAULTWAIT = 30;

	protected Initializer() {
	}

	public void setDriver(AppiumDriver<MobileElement> driver) {

		setDriver(driver, DEFAULTWAIT);
	}

	public void setDriver(AppiumDriver<MobileElement> driver, int timeOutInSeconds) {

		setDriver(driver, timeOutInSeconds, 1000);
	}

	public void setDriver(AppiumDriver<MobileElement> driver, int timeOutInSeconds, int sleepInMillisecond) {

		if (mobilDriver == null) {
			mobilDriver = driver;
			initializeValue(driver, timeOutInSeconds, sleepInMillisecond);
		}
	}

	private void initializeValue(AppiumDriver<MobileElement> driver, int timeOutInSeconds, int sleepInMillisecond) {

		webDriverWait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillisecond);
	}
}
