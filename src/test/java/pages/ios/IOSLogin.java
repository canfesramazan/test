package pages.ios;

import helper.MethodsPage;
import base.PageFactory;
import org.openqa.selenium.By;
import pages.Icommon.*;

public class IOSLogin extends MethodsPage implements ILogin {
    PageFactory pageFactory=new PageFactory();


    private By email = By.id("etLoginEmail");
    private By password = By.id("etLoginPassword");
    private By loginButton = By.xpath("(//XCUIElementTypeButton[@name=\"secureLogin\"])[4]");
    private By permissionAllow=By.id("Allow");

    public ILogin start(){

        clickBy(permissionAllow,"Konum izni verildi");
        clickBy(permissionAllow,"Notification izni verildi");

        return pageFactory.createPage(ILogin.class);
    }


    @Override
    public IMainPage loginAccountStarting() {
        sendKeys(email,"sas@hh.com");
        sendKeys(password,"123qwe");
        clickBy(loginButton,"Login butonuna tıklandı.");
        return pageFactory.createPage(IMainPage.class);
    }

    @Override
    public IListingPage loginFavoriIConFromListingPage() {
        return null;
    }

    @Override
    public IRegisterPage clickSignUpBtn() {
        return null;
    }

    @Override
    public IMainPage closeHxPopup() {
        return null;
    }

    @Override
    public IMainPage checkUser() {
        return null;
    }


    @Override
    public IMyGiftVoucherPage loginAccountFromMyGiftVoucher() {
        return null;
    }

    @Override
    public IChangePassword loginAccountChangePassword() {
        return null;
    }

    @Override
    public IUpdateMemberInfoPage loginUpdateMemberInfo() {
        return null;
    }

    @Override
    public IMyMessages loginAccountFromMyMessages() {
        return null;
    }
    public IFastPaymentOptionsPage loginFastPaymentOptions() {
        return null;
    }

    @Override
    public IAskUs loginAccountFromAskUs() {
        return null;
    }
    public IFavoritePage loginFavoritePage() {
        return null;
    }

    @Override
    public IAccountPage loginEnterAccount() {
        return null;

    }
    public IAddressPage loginAddressPage() {
        return null;
    }

}
