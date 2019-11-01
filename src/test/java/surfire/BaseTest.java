package surfire;

import base.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.Icommon.ILogin;

import java.net.URL;


public class BaseTest {

    private static final String APP_PACKAGE = "com.pozitron.hepsiburada";
    private static final String APP_ACTIVITY  = "com.hepsiburada.ui.startup.SplashActivity";
    private final Logger log = Logger.getLogger(getClass());
  //  protected static ThreadLocal<AppiumDriver<MobileElement>> driverx;
  //  private static final Set<AppiumDriver> drivers = Collections.newSetFromMap(new ConcurrentHashMap<>());

    PageFactory pageFactory=new PageFactory();

    AppiumDriver driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    String currentMobilePlatform= MobilePlatform.ANDROID;
    String envMobilePlatform = "Android";

    @Before
    public void setUp() throws Exception {

        if (currentMobilePlatform.equals(envMobilePlatform)) {

            System.out.println("Start " + Thread.currentThread().getId());
            System.out.println("Android Session Starting");
            System.out.println("Start " + Thread.currentThread().getName());

            capabilities.setCapability("appPackage", APP_PACKAGE);
            capabilities.setCapability("appActivity", APP_ACTIVITY);
            capabilities.setCapability("platformName", MobilePlatform.ANDROID);
            capabilities.setCapability("deviceName", "x");

            //capabilities.setCapability("app", "/Users/rcanfes/Desktop/tmp/hb-beta.apk");
            //capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
            capabilities.setCapability("automationName", "UiAutomator2");

            driver = new AndroidDriver<MobileElement>(new URL("http://172.26.50.74:4444/wd/hub"), capabilities);

            log.info("INFO : " + driver.getSessionDetails());
            log.info("INFO : " + capabilities.getVersion());
            log.info("INFO : " + capabilities.getPlatform());
            log.info("INFO : " + driver.getDeviceTime());

         //   driverx = ThreadLocal.withInitial(() -> {
         //       drivers.add(driver);
         //       return driver;
         //   });

            pageFactory.setDriver(driver);
            }
    else
           {
            System.out.println("IOS Session Starting");
            System.out.println("Start " + Thread.currentThread().getName());

            capabilities.setCapability("automationName","XCUITest");
            capabilities.setCapability("platformVersion","12.1");
            //capabilities.setCapability("bundleId", "com.pozitron.hepsiburada");
            capabilities.setCapability("app", "/Users/rcanfes/Desktop/tmp/Hepsiburada.app");
         //   capabilities.setCapability("platformName", Platform.IOS);
            capabilities.setCapability("deviceName", "iPhone 8");
            //capabilities.setCapability("useNewWDA", true);
            capabilities.setCapability("xcodeOrgId", "ZHD57Y6N39");
            capabilities.setCapability("xcodeSigningId", "iPhone Developer");
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
           // capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
            driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            log.info("INFO : " + driver.getSessionDetails());
            log.info("INFO : " + capabilities.getVersion());
            log.info("INFO : " + capabilities.getPlatform());
            log.info("INFO : " + driver.getDeviceTime());

            pageFactory.setDriver(driver);
            }
    }
    
    public <T> T createPage(Class<T> pageType) {

        return pageFactory.createPage(pageType);
    }

    protected ILogin starting() throws InterruptedException {
        return createPage(ILogin.class).start();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Ended " + Thread.currentThread().getName());
        driver.quit();
    }
    /*/TakeScreenShot
    public void takeScreenShot () throws MalformedURLException {
        currentDriver = (ThreadLocal<AppiumDriver>) new Augmenter().augment(currentDriver.get());
        File srcFile = ((TakesScreenshot) currentDriver).getScreenshotAs(OutputType.FILE);
        String screenshotName = getClass().getSimpleName();
        System.out.println("ScreenShotName: " + screenshotName);
        try {
            FileUtils.copyFile(srcFile, new File("Screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
}
