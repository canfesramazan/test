package helper;

import base.PageFactory;
import base.ParallelParameterized;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.Icommon.ILogin;

import java.net.URL;
import java.util.LinkedList;

@RunWith(ParallelParameterized.class)
public class BaseTest {

    private String platform;
    private  final String APP_PACKAGE = "com.pozitron.hepsiburada.beta";
    private  final String APP_ACTIVITY  = "com.hepsiburada.ui.startup.SplashActivity";
    private final Logger log = Logger.getLogger(getClass());
    private  ThreadLocal<AppiumDriver<MobileElement>> currentDriver = new ThreadLocal<AppiumDriver<MobileElement>>();
    AppiumDriver driver;
    PageFactory pageFactory =new PageFactory();
    @Parameterized.Parameters
    public  static LinkedList<String> getEnvironment()  {
        LinkedList<String> env = new LinkedList<String>();

     //env.add(MobilePlatform.IOS);
     //env.add(MobilePlatform.IOS);
     env.add(MobilePlatform.ANDROID);
     env.add(MobilePlatform.ANDROID);
     //env.add(MobilePlatform.ANDROID);
    //  env.add(MobilePlatform.ANDROID);
        // env.add(MobilePlatform.IOS);
        // env.add(new String[]{Platform.ANY.toString()});
        return env;
    }

    public BaseTest(String platform) {
       // this.platform = platform;
    }

   // DesiredCapabilities capabilities = new DesiredCapabilities();

    String currentMobilePlatform=MobilePlatform.ANDROID;
    String envMobilePlatform = getEnvironment().pollFirst();
    @Before
    public  void setUp() throws Exception {

        if (currentMobilePlatform.equals(envMobilePlatform)) {

                driver = new AndroidDriver<MobileElement>(new URL("http://172.26.50.74:4441/wd/hub"), androidCapabilities());
                Thread.sleep(1000);
                pageFactory.getInstance().setDriver(driver);
                currentDriver.set(driver);

            // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    else
        {
                driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), iosCapabilities());
                Thread.sleep(1000);
                log.info("INFO : " + driver.getSessionDetails());
                log.info("INFO : " + driver.getDeviceTime());

                currentDriver.set(driver);
                pageFactory.getInstance().setDriver(driver);
            }
    }

    public  <T> T createPage(Class<T> pageType) {
        return pageFactory.getInstance().createPage(pageType);
    }
    protected  ILogin starting() {
        return createPage(ILogin.class);
    }

    public DesiredCapabilities androidCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        System.out.println("Android application is opening... ");
        System.out.println("Thread ID => " + Thread.currentThread().getId());
        System.out.println("Thread Name => " + Thread.currentThread().getName());
        log.info("INFO : " + capabilities.getVersion());
        log.info("INFO : " + capabilities.getPlatform());
        capabilities.setCapability("platformName", MobilePlatform.ANDROID);
        capabilities.setCapability("platformName", MobilePlatform.ANDROID);
        capabilities.setCapability("appPackage", APP_PACKAGE);
        capabilities.setCapability("appActivity", APP_ACTIVITY);
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "deviceName");
        return capabilities;
    }

    public DesiredCapabilities iosCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        System.out.println("IOS application is opening... ");
        System.out.println("Start " + Thread.currentThread().getId());
        System.out.println("Start " + Thread.currentThread().getName());
        log.info("INFO : " + capabilities.getVersion());
        log.info("INFO : " + capabilities.getPlatform());
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("platformVersion","12.1");
        capabilities.setCapability("bundleId", "com.pozitron.hepsiburada");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "x");
        capabilities.setCapability("useNewWDA", true);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.UDID, "x");
        return capabilities;
    }


    @After
    public void tearDown() throws Exception {
        System.out.println("Ended " + Thread.currentThread().getName());
        if(currentDriver.get()!=null)
        currentDriver.get().quit();
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
