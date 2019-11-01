package pages.android;

import base.PageFactory;
import helper.MethodsPage;
import org.openqa.selenium.By;
import pages.Icommon.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class AndroidAccountPage extends MethodsPage implements IAccountPage {

    private By loginTab=By.id("llUserAccountLogin");
    private By nameButton=By.id("tvUserAccountUsername");
    private By myFavorite=By.id("ll_user_account_menu_favorites");
    private By myFavoriteProduct=By.id("tv_product_list_item_name");
    private By myGiftVoucher = By.id("ll_user_account_menu_gift_cards");
    private By customerService = By.id("ll_user_account_menu_customer_services");
    private By enterAccountBtn = By.id("llUserAccountLogin");
    private By userAccountUsername = By.id("tvUserAccountUsername");
    private By settingsButton=By.id("ll_user_account_menu_settings");
    private By addressButton=By.id("ll_user_account_menu_addresses");

    PageFactory pageFactory=new PageFactory();
    public ILogin clickLoginTab(){
        wait(1);
        clickBy(loginTab,"Login tabı bulunamadı.","Login tabına tıklandı.");
        return pageFactory.getInstance().createPage(ILogin.class);
    }
    public IMembership clickNameButton(){

        clickBy(nameButton,"İsim butonu bulunamadı.","İsim butonuna tıklandı.");
        return pageFactory.getInstance().createPage(IMembership.class);
    }

    public IAccountPage checkName(){

     //   Assert.assertEquals("İsim bulunamadı",getText(nameButton),AndroidMembership.nameStr);
        return pageFactory.getInstance().createPage(IAccountPage.class);
    }

    public IFavoritePage clickMyFavorite(){
        clickBy(myFavorite,"Favorilerim tabı bulunmadı.","Favorilerim tabına tıklandı.");
        return pageFactory.getInstance().createPage(IFavoritePage.class);
    }

    public ISettingsPage clickSettingsPage(){
        //mobilDriver.findElement(settingsButton).click();
        clickBy(settingsButton,"Ayarlar butonuna tıklandı." );
        return pageFactory.getInstance().createPage(ISettingsPage.class);
    }

    public ILogin clickMyFavoritePage(){
        clickBy(myFavorite,"Favorilerim butonu bulunamadı.","Favorilerim butonuna tıklandı.");
        return pageFactory.getInstance().createPage(ILogin.class);
    }

    public ILogin clickGiftVoucher() {
        wait(1);
        clickBy(myGiftVoucher,"Hediye çeklerim tabına tıklandı.");
        return pageFactory.getInstance().createPage(ILogin.class);
    }

    public ICustomerServicePage clickCustomerService() {
        log.info( "Müsteri hizmetleri tabına tıklandı.");
        clickBy(customerService, "Müşteri hizmetleri bulunamadı.", "Müsteri hizmetleri tabına tıklandı.");
        return pageFactory.getInstance().createPage(ICustomerServicePage.class);
    }

    public synchronized ILogin clickEnterAccout() {
        log.info("---------------------------------------------clickEnterAccout method-------------------");
        //mobilDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickBy(enterAccountBtn,  "Giriş Yap'a tıklandı." );
        return pageFactory.getInstance().createPage(ILogin.class);
    }

    public synchronized IAccountPage checkUserLogin(){
        log.info("---------------------------------------------checkUserLogin method-------------------");

        String getLogoText = findElement(userAccountUsername).getText();
        String expectedLogoText = "Giriş Yap";
        assertThat("Login should be success and check go to vouchers page", getLogoText, is(not(equalTo(expectedLogoText))));
        return pageFactory.getInstance().createPage(IAccountPage.class);

    }
    public ILogin clickAddressPage(){
        clickBy(addressButton,"Address butonu bulunamadı.","Address butonuna tıklandı.");
        return pageFactory.getInstance().createPage(ILogin.class);
    }

}

