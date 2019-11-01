package pages.android;

import base.PageFactory;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.Icommon.*;

//import io.appium.java_client.android.AndroidKeyCode;



public class AndroidLogin extends MethodsPage implements ILogin {

    PageFactory pageFactory=new PageFactory();

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
    private By hxPopuoClose = By.id("com.pozitron.hepsiburada.beta:id/dialog_close");


    public ILogin start() {
            log.info("-----------------------------------------------start metodu-------");

        //mobilDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        clickBy(closePopupButton,"popup kapata tıklandı");
        return pageFactory.getInstance().createPage(ILogin.class);
    }
    private void loginSuccess(){

        sendKeys(email,"as@sa.com");
        sendKeys(password,"123qwe");
        clickBy(loginButton,"Login butonuna tıklandı.");
    }
    public IListingPage loginFavoriIConFromListingPage() {
        loginSuccess();
        wait(2);
        return pageFactory.getInstance().createPage(IListingPage.class);
    }
    public IMainPage loginAccountStarting(){
        loginSuccess();
        clickBy(closeLoginSuccessButton, "Login success popupı kapatılıdı.");
        return pageFactory.getInstance().createPage(IMainPage.class);
    }
    public IMyGiftVoucherPage loginAccountFromMyGiftVoucher(){

        loginSuccess();
        return pageFactory.getInstance().createPage(IMyGiftVoucherPage.class);
    }
    public IMyMessages loginAccountFromMyMessages() {
        loginSuccess();
        return pageFactory.getInstance().createPage(IMyMessages.class);
    }
    private void loginSuccessPopupClose(){
        clickBy(closeLoginSuccessButton, "Login success popupı kapatılıdı.");
    }
    public IAskUs loginAccountFromAskUs(){
        loginSuccess();
        return pageFactory.getInstance().createPage(IAskUs.class);
    }
    public IAccountPage loginEnterAccount() {
        log.info("---------------------------------------------loginEnterAccount method-------------------");
        loginSuccess();
        clickBy(closeLoginSuccessButton, "Login success popupı kapatılıdı.");
        return pageFactory.getInstance().createPage(IAccountPage.class);
    }
    public IChangePassword loginAccountChangePassword(){
        loginSuccess();
        return pageFactory.getInstance().createPage(IChangePassword.class);
    }
    public IUpdateMemberInfoPage loginUpdateMemberInfo(){
        loginSuccess();
        return pageFactory.getInstance().createPage(IUpdateMemberInfoPage.class);
    }
    public IFastPaymentOptionsPage loginFastPaymentOptions(){
        loginSuccess();
        return pageFactory.getInstance().createPage(IFastPaymentOptionsPage.class);
    }
    public IFavoritePage loginFavoritePage(){
        loginSuccess();
        return pageFactory.getInstance().createPage(IFavoritePage.class);
    }
    public IAddressPage loginAddressPage(){
        loginSuccess();
        return pageFactory.getInstance().createPage(IAddressPage.class);
    }
    public IMainPage checkUser(){
       // pressAndroidKeyCode(AndroidKeyCode.ENTER);
      //  pressAndroidKeyCode(AndroidKeyCode.ENTER);
        Assert.assertTrue("İsim eşleşmesi yapılamadı.", !(getText(checkUser)==null));
       // pressAndroidKeyCode(AndroidKeyCode.KEYCODE_BACK);

        return pageFactory.getInstance().createPage(IMainPage.class);
    }
    public IRegisterPage clickSignUpBtn() {
        clickBy(signUp, "There is no sign up button" , "Click sign up button");
        return  pageFactory.getInstance().createPage(IRegisterPage.class);
    }


    public IMainPage closeHxPopup() {
        click(hxPopuoClose);
        return pageFactory.getInstance().createPage(IMainPage.class);
    }

}
