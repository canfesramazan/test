package testng.pagesTestNg.ios;

import base.PageFactory;
import helper.MethodsPage;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.*;

public class IOSLoginTestNG extends MethodsPage implements ILoginTestNG {

    PageFactory pageFactory=new PageFactory();


    private By email = By.id("etLoginEmail");
    private By password = By.id("etLoginPassword");
    private By loginButton = By.xpath("(//XCUIElementTypeButton[@name=\"secureLogin\"])[4]");
    private By permissionAllow=By.id("Allow");

    public ILoginTestNG start(){

        clickBy(permissionAllow,"Konum izni verildi");
        clickBy(permissionAllow,"Notification izni verildi");

        return pageFactory.createPage(ILoginTestNG.class);
    }


    @Override
    public IMainPageTestNG loginAccountStarting() {
        sendKeys(email,"sas@hh.com");
        sendKeys(password,"123qwe");
        clickBy(loginButton,"Login butonuna tıklandı.");
        return pageFactory.createPage(IMainPageTestNG.class);
    }

    @Override
    public IListingPageTestNG loginFavoriIConFromListingPage() {
        return null;
    }

    @Override
    public IRegisterPageTestNG clickSignUpBtn() {
        return null;
    }

    @Override
    public IMainPageTestNG checkUser() {
        return null;
    }

    @Override
    public IMainPageTestNG closeLoginPopup() {
        return null;
    }


    @Override
    public IMyGiftVoucherPageTestNG loginAccountFromMyGiftVoucher() {
        return null;
    }

    @Override
    public IChangePasswordTestNG loginAccountChangePassword() {
        return null;
    }

    @Override
    public IUpdateMemberInfoPageTestNG loginUpdateMemberInfo() {
        return null;
    }

    @Override
    public IMyMessagesTestNG loginAccountFromMyMessages() {
        return null;
    }
    public IFastPaymentOptionsPageTestNG loginFastPaymentOptions() {
        return null;
    }

    @Override
    public IAskUsTestNG loginAccountFromAskUs() {
        return null;
    }
    public IFavoritePageTestNG loginFavoritePage() {
        return null;
    }

    @Override
    public IAccountPageTestNG loginEnterAccount() {
        return null;

    }
    public IAddressPageTestNG loginAddressPage() {
        return null;
    }

}
