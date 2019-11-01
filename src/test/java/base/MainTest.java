package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.Icommon.ILogin;
import java.util.LinkedList;

@RunWith(ParallelParameterized.class)
public class MainTest {

    PageFactory pageFactory =new PageFactory();
    String currentMobilePlatform=getEnvironment().element();
    String envMobilePlatform = getEnvironment().pollFirst();

    public MainTest(String platform) throws Exception {
        // this.platform = platform;
    }

    @Parameterized.Parameters
    public static LinkedList<String> getEnvironment()  {
        LinkedList<String> env = new LinkedList<String>();
        env.add(MobilePlatform.ANDROID);
        //env.add(MobilePlatform.ANDROID);
        // env.add(new String[]{Platform.ANY.toString()});
        //env.add(MobilePlatform.IOS);
        return env;
    }

    @Before
    public  void setUp() throws Exception {
        AppiumDriver driver =DriverFactory.class.newInstance().createInstance();
        DriverManager.setDriver(driver);
        pageFactory.getInstance().setDriver(driver);
    }

    public  <T> T createPage(Class<T> pageType) {
        return pageFactory.getInstance().createPage(pageType);
    }

    protected  ILogin starting() {
        return createPage(ILogin.class);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Ended " + Thread.currentThread().getName());
        if(DriverManager.getDriver()!=null)
            DriverManager.getDriver().quit();
    }
}
