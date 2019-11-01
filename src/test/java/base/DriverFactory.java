package base;

import helper.MethodsPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class DriverFactory {

    String APP_PACKAGE = "com.pozitron.hepsiburada.beta";
    String APP_ACTIVITY  = "com.hepsiburada.ui.startup.SplashActivity";

    //If there are a lot of interfaces
    //Else you can use String address = InetAddress.getLocalHost().getHostAddress();
    private String getIP(){
        String IP="";

        List<InetAddress> addrList = new ArrayList<InetAddress>();
        Enumeration<NetworkInterface> interfaces = null;
        try {
            interfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        InetAddress localhost = null;

        try {
            localhost = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        while (interfaces.hasMoreElements()) {
            NetworkInterface ifc = interfaces.nextElement();
            Enumeration<InetAddress> addressesOfAnInterface = ifc.getInetAddresses();

            while (addressesOfAnInterface.hasMoreElements()) {
                InetAddress address = addressesOfAnInterface.nextElement();

                if (!address.equals(localhost) && !address.toString().contains(":")) {
                    addrList.add(address);
                    IP = address.getHostAddress();
                }
            }
        }
        return IP;
    }

    DesiredCapabilities androidCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        System.out.println("Android application is opening... ");
        System.out.println("Thread ID => " + Thread.currentThread().getId());
        System.out.println("Thread Name => " + Thread.currentThread().getName());
        capabilities.setCapability("platformName", MobilePlatform.ANDROID);
        capabilities.setCapability("platformName", MobilePlatform.ANDROID);
        capabilities.setCapability("appPackage", APP_PACKAGE);
        capabilities.setCapability("appActivity", APP_ACTIVITY);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
        capabilities.setCapability("newCommandTimeout", 1000);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "deviceName");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
      //  capabilities.setCapability("–session-override",false);

        return capabilities;
    }

    DesiredCapabilities iosCapabilities() {

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

    AppiumDriver<MobileElement> createInstance() throws Exception {

        MainTest baseTest = new MainTest("");
        Logger log = Logger.getLogger(MethodsPage.class);
        AppiumDriver<MobileElement> driver = null;
        String URL = "http://"+getIP()+":";
        String port = "4444/wd/hub";

        log.info("Current IP =>" + getIP());

    if (baseTest.currentMobilePlatform.equals(baseTest.envMobilePlatform)){
        try {
            driver = new AndroidDriver<MobileElement>(new URL(URL + port), androidCapabilities());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
    else
    {
        try {
            driver = new IOSDriver<MobileElement>(new URL(URL + port), iosCapabilities());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
        }

    }
    }


