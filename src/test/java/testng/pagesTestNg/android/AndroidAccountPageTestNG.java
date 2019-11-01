package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class AndroidAccountPageTestNG extends MethodsPage implements IAccountPageTestNG {

    private By loginTab=By.id("llUserAccountLogin");
    private By nameButton=By.id("tvUserAccountUsername");
    private By myFavorite=By.id("ll_user_account_menu_favorites");
    private By myFavoriteProduct=By.id("tv_product_list_item_name");
    private By myGiftVoucher = By.id("ll_user_account_menu_gift_cards");
    private By customerService = By.id("ll_user_account_menu_customer_services");
    private By enterAccountBtn = By.id("llUserAccountLogin");
    private By userAccountUsername = By.id("tvUserAccountUsername");
    private By settingsButton=By.id("com.pozitron.hepsiburada:id/ll_user_account_menu_settings");
    private By addressButton=By.id("com.pozitron.hepsiburada:id/ll_user_account_menu_addresses");

    public ILoginTestNG clickLoginTab(){
        wait(1);
        clickBy(loginTab,"Login tabı bulunamadı.","Login tabına tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(ILoginTestNG.class);
    }
    public IMembershipTestNG clickNameButton(){

        clickBy(nameButton,"İsim butonu bulunamadı.","İsim butonuna tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(IMembershipTestNG.class);
    }

    public IAccountPageTestNG checkName(){

        Assert.assertEquals("İsim bulunamadı",getText(nameButton), AndroidMembershipTestNG.nameStr);
        return PageFactoryTestNg.getInstance().createPage(IAccountPageTestNG.class);
    }

    public IFavoritePageTestNG clickMyFavorite(){
        clickBy(myFavorite,"Favorilerim tabı bulunmadı.","Favorilerim tabına tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(IFavoritePageTestNG.class);
    }

    public ISettingsPageTestNG clickSettingsPage(){
        clickBy(settingsButton,"Ayarlar butonu bulunamadı.","Ayarlar butonuna tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(ISettingsPageTestNG.class);
    }

    public ILoginTestNG clickMyFavoritePage(){
        clickBy(myFavorite,"Favorilerim butonu bulunamadı.","Favorilerim butonuna tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(ILoginTestNG.class);
    }

    public ILoginTestNG clickGiftVoucher() {

        clickBy(myGiftVoucher, "Hediye çeklerim bulunamadı.", "Hediye çeklerim tabına tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(ILoginTestNG.class);
    }

    public ICustomerServicePageTestNG clickCustomerService() {
        log.info( "Müsteri hizmetleri tabına tıklandı.");
        clickBy(customerService, "Müşteri hizmetleri bulunamadı.", "Müsteri hizmetleri tabına tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(ICustomerServicePageTestNG.class);
    }

    public synchronized ILoginTestNG clickEnterAccout() {
        log.info("---------------------------------------------clickEnterAccout method-------------------");
        //mobilDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickBy(enterAccountBtn,  "Giriş Yap'a tıklandı." );
        return PageFactoryTestNg.getInstance().createPage(ILoginTestNG.class);
    }

    public synchronized IAccountPageTestNG checkUserLogin(){
        log.info("---------------------------------------------checkUserLogin method-------------------");

        String getLogoText = findElement(userAccountUsername).getText();
        String expectedLogoText = "Giriş Yap";
        assertThat("Login should be success and check go to vouchers page", getLogoText, is(not(equalTo(expectedLogoText))));
        return PageFactoryTestNg.getInstance().createPage(IAccountPageTestNG.class);

    }
    public ILoginTestNG clickAddressPage(){
        clickBy(addressButton,"Address butonu bulunamadı.","Address butonuna tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(ILoginTestNG.class);
    }

}

