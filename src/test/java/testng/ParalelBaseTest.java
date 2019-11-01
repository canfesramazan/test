package testng;


import testng.PageFactoryTestNg;
import com.relevantcodes.extentreports.ExtentReports;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.Icommon.ILogin;
import testNGHelper.ExtentManager;
import testng.pagesTestNg.Icommon.ILoginTestNG;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ParalelBaseTest {

                    private  final String APP_PACKAGE = "com.pozitron.hepsiburada.beta";
                    private  final String APP_ACTIVITY = "com.hepsiburada.ui.startup.SplashActivity";
                    protected final  Logger logger = Logger.getLogger(ParalelBaseTest.class);

                    AppiumDriver appiumDriver;
                    protected AppiumDriver getDriver() {
                        return appiumDriver;
                    }
                    private String URL ="http://172.26.50.66:";
                    private  ExtentReports extentReports;
                   //  DesiredCapabilities capabilities = new DesiredCapabilities();

                    String currentMobilePlatform="android";//MobilePlatform.Android
                    String currentMobilePlatform2="ios";//MobilePlatform.IOS


                    @BeforeClass(alwaysRun = true)
    public  void setUp() throws MalformedURLException {
        switch (currentMobilePlatform) {

            case "android": {

                synchronized (this) {
                    System.out.println(Thread.currentThread().getId() + "SETUP STARTING");
                    appiumDriver = new AndroidDriver(new URL(URL + "4441/wd/hub"),androidCapabilities());
                    PageFactoryTestNg.getInstance().setDriver(appiumDriver);
                    System.out.println("mobile will launch");
                    appiumDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                    extentReports = ExtentManager.getReporter();
                    extentReports.addSystemInfo("Hepsiburada", "Appium Test Otomasyon");
                }
                break;
            }
            case "ios":{
                    iosCapabilities();
                    appiumDriver = new AndroidDriver(new URL("http://192.168.1.105:4444/wd/hub"), iosCapabilities());
                    PageFactoryTestNg.getInstance().setDriver(appiumDriver);
                    extentReports = ExtentManager.getReporter();
                    extentReports.addSystemInfo("Hepsiburada", "Appium Test Otomasyon");

                break;
            }

        }

    }
    public DesiredCapabilities androidCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

                    System.out.println("Android application is opening... ");
                    System.out.println("Thread ID => " + Thread.currentThread().getId());
                    System.out.println("Thread Name => " + Thread.currentThread().getName());
                    capabilities.setCapability("platformName", MobilePlatform.ANDROID);
                    capabilities.setCapability("platformName", MobilePlatform.ANDROID);
                    capabilities.setCapability("appPackage", APP_PACKAGE);
                    capabilities.setCapability("appActivity", APP_ACTIVITY);
                    capabilities.setCapability("automationName", "UiAutomator2");
                    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "deviceName");
        return capabilities;
    }
    public DesiredCapabilities iosCapabilities() {
                    System.out.println("IOS application is opening... ");
                    System.out.println("Start " + Thread.currentThread().getId());
                    System.out.println("Start " + Thread.currentThread().getName());
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability("automationName","XCUITest");
                    capabilities.setCapability("platformVersion","12.1");
                    capabilities.setCapability("bundleId", "com.pozitron.hepsiburada");
                    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "x");
                    capabilities.setCapability("useNewWDA", true);
                    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
                    capabilities.setCapability(MobileCapabilityType.UDID, "x");
                    return capabilities;
    }


    protected ILoginTestNG starting() {
        return createPage(ILoginTestNG.class);
    }
    public <T> T createPage(Class<T> pageType) {

        return PageFactoryTestNg.getInstance().createPage(pageType);
    }


    @AfterClass(alwaysRun = true)
    public  void shutDown() throws Exception {
                    System.out.println("Ended " + Thread.currentThread().getName());
                    System.out.println("Ended " + Thread.currentThread().getId());
                    if(appiumDriver==null)
                        appiumDriver.quit();


    }


}

