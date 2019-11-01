package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
//import io.appium.java_client.android.AndroidKeyCode;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.*;


public class AndroidLoginTestNG extends MethodsPage implements ILoginTestNG {

    private By email=By.id("etLoginEmail");
    private By password=By.id("etLoginPassword");
    private By loginButton=By.id("btnLoginLogin");
    private By checkUser=By.id("tvUserAccountUsername");
    private By closeLoginSuccessButton=By.id("android:id/button1");
    private By closeButton=By.id("com.pozitron.hepsiburada:id/btnUserAccountClose");
    private By closeButtonXpath=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    private By closePopupButton=By.id("android:id/button2");
    private By closeLoginPopupButton=By.id("ivLoginClose");
    private By signUp = By.id("tvLoginSignup");
    private By closeProductCategoriesPopupButton=By.id("com.pozitron.hepsiburada:id/showcase_button");
    private By logo =By.id("Hepsiburada");
    private By closeAccountPage = By.id("com.pozitron.hepsiburada.beta:id/btnUserAccountClose");

    Logger log= Logger.getLogger(getClass());
    public synchronized ILoginTestNG start(){
            log.info("-----------------------------------------------start metodu-------");
            mobilDriver.findElement(closePopupButton);
            clickBy(closePopupButton,"popup kapata tıklandı");
        return PageFactoryTestNg.getInstance().createPage(ILoginTestNG.class);
    }
    private  void loginSuccess(){
        sendKeys(email,"as@sa.com");
        sendKeys(password,"123qwe");
        clickBy(loginButton,"Login butonuna tıklandı.");
    }
    public IListingPageTestNG loginFavoriIConFromListingPage() {
        loginSuccess();
        wait(2);
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }
    public IMainPageTestNG loginAccountStarting(){
        loginSuccess();
        clickBy(closeLoginSuccessButton, "Login success popupı kapatılıdı.");
        return PageFactoryTestNg.getInstance().createPage(IMainPageTestNG.class);
    }
    public IMyGiftVoucherPageTestNG loginAccountFromMyGiftVoucher(){
        loginSuccess();
        return PageFactoryTestNg.getInstance().createPage(IMyGiftVoucherPageTestNG.class);
    }
    public IMyMessagesTestNG loginAccountFromMyMessages() {
        loginSuccess();
        return PageFactoryTestNg.getInstance().createPage(IMyMessagesTestNG.class);
    }
    private void loginSuccessPopupClose(){
        clickBy(closeLoginSuccessButton, "Login success popupı kapatılıdı.");
    }
    public IAskUsTestNG loginAccountFromAskUs(){
        loginSuccess();
        return PageFactoryTestNg.getInstance().createPage(IAskUsTestNG.class);
    }
    public synchronized IAccountPageTestNG loginEnterAccount() {
        log.info("---------------------------------------------loginEnterAccount method-------------------");
        loginSuccess();
        clickBy(closeLoginSuccessButton, "Login success popupı kapatılıdı.");
        return PageFactoryTestNg.getInstance().createPage(IAccountPageTestNG.class);
    }
    public IChangePasswordTestNG loginAccountChangePassword(){
        loginSuccess();
        return PageFactoryTestNg.getInstance().createPage(IChangePasswordTestNG.class);
    }

    public IUpdateMemberInfoPageTestNG loginUpdateMemberInfo(){
        loginSuccess();
        return PageFactoryTestNg.getInstance().createPage(IUpdateMemberInfoPageTestNG.class);
    }
    public IFastPaymentOptionsPageTestNG loginFastPaymentOptions(){
        loginSuccess();
        return PageFactoryTestNg.getInstance().createPage(IFastPaymentOptionsPageTestNG.class);
    }
    public IFavoritePageTestNG loginFavoritePage(){
        loginSuccess();
        return PageFactoryTestNg.getInstance().createPage(IFavoritePageTestNG.class);
    }
    public IAddressPageTestNG loginAddressPage(){
        loginSuccess();
        return PageFactoryTestNg.getInstance().createPage(IAddressPageTestNG.class);
    }
    public IMainPageTestNG checkUser(){
      //  pressAndroidKeyCode(AndroidKeyCode.ENTER);
      //  pressAndroidKeyCode(AndroidKeyCode.ENTER);
        Assert.assertTrue("İsim eşleşmesi yapılamadı.", !(getText(checkUser)==null));
      //  pressAndroidKeyCode(AndroidKeyCode.KEYCODE_BACK);

        return PageFactoryTestNg.getInstance().createPage(IMainPageTestNG.class);
    }

    public synchronized IMainPageTestNG closeLoginPopup()  {
        log.info("---------------------------------------------------closeLoginPopup metodu------");
       // mobilDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickBy(closeLoginPopupButton,"Login Popup kapat butona tıklandı");
        return PageFactoryTestNg.getInstance().createPage(IMainPageTestNG.class);
    }
    public IRegisterPageTestNG clickSignUpBtn() {
        clickBy(signUp, "There is no sign up button" , "Click sign up button");
        return  PageFactoryTestNg.getInstance().createPage(IRegisterPageTestNG.class);
    }

}
