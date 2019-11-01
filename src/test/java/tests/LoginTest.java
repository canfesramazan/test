package tests;

import base.MainTest;
import org.junit.Test;

public class LoginTest extends MainTest {


    public LoginTest(String platform) throws Exception {
        super(platform);
    }


    //Login from "Hediye Çeklerim"

    /** @RC
     * Konum izni varsa kapatıldı.
     * Login sayfası kapatıldı.
     * Account menü açıldı.
     * "Hediye Çeklerim" tabına tıklandı.
     * Açılan login sayfasında login olundu.
     * Login olduktan sonra "Hediye Çeklerim" sayfasına yönlendiği kontrol edildi.
     */

    
    @Test
    public void loginFromGiftVoucher() throws InterruptedException {

        starting()
                .start()
                .closeHxPopup()
                .popOverClose()
                .clickMyAccount()
                .clickGiftVoucher()
                .loginAccountFromMyGiftVoucher()
                .checkMyGiftVoucherTitle()
        ;

    }

    /** @RC
     * Konum izni varsa kapatıldı.
     * Login sayfası kapatıldı.
     * Account menü açıldı.
     * "Müşteri Hizmetleri" tabına tıklandı.
     * "Mesajlarım" a tıklandı.
     * Açılan login sayfasında login olundu.
     * Login olunduktan sonra "Mesajlarım" sayfasına yönlendiği kontrol edildi.
     */
    @Test
    //Login from Customer Service--MyMessage
    public void loginFromCustomerServiceMessages()  throws InterruptedException {
        starting()
                .start()
                .closeHxPopup()
                .popOverClose()
                .clickMyAccount()
                .clickCustomerService()
                .clickMessagesFromCustomerSevice()
                .loginAccountFromMyMessages()
                .checkMyMessagesTitle()
        ;
    }

    /** @RC
     * Konum izni varsa kapatıldı.
     * Login sayfası kapatıldı.
     * Account menü açıldı.
     * "Müşteri Hizmetleri" tabına tıklandı.
     * "Bize Sorun" a tıklandı.
     * Açılan login sayfasından login olundu.
     * Login olunduktan sonra "Bize Sorun" sayfasına yönlendiği kontrol edildi.
     */
    @Test
    //Login from Customer Service--AskUs
    public void loginFromCustomerServiceAskUs()  throws InterruptedException{
        starting()
                .start()
                .closeHxPopup()
                .popOverClose()
                .clickMyAccount()
                .clickCustomerService()
                .clickAskUsFromCustomerService()
                .loginAccountFromAskUs()
                .checkAskUsTitle()
        ;
    }

    /** @RC
     * Konum izni varsa kapatıldı.
     * Login sayfası kapatıldı.
     * Account menü açıldı.
     * "Giriş Yap" a tıklandı.
     * Açılan login sayfasından login olundu.
     * Login olunduktan sonra user account menüdeki "Giriş Yap" alanının değiştiği kontrol edildi.
     */
    @Test
    //Login from user accout at enter count button
    public  synchronized void loginFromEnterCount() throws InterruptedException {
        starting()
                .start()
                .closeHxPopup()
                .popOverClose()
                .clickMyAccount()
                .clickEnterAccout()
                .loginEnterAccount()
                .checkUserLogin()
        ;

    }
    /**
     * @TBA *ŞİFRE DEĞİŞTİRME SAYFASINDAN GİRİŞ
     * <p>
     * Uygulama açılır
     * Gelen izin popup ekranı kapatılır
     * Gelen login ekranı kapatılır
     * Ana sayfanın geldiği görülür.
     * Hesabım butonuna tıklanır.
     * Gelen sayfada Ayarlar butonuna tıklanır.
     * Şifre Değiştirme Sayfasına tıklanır
     * Gelen login sayfası doldurulur.
     * Login butonuna tıklanır.
     * Şifre Değiştirme sayfasının geldiği görülür.
     */
    @Test()
    public void loginFromChangePasswordPageOfSettingsPage()  throws InterruptedException{

        starting()
                .start()
                .closeHxPopup()
                .popOverClose()
                .checkMainPage()
                .clickMyAccount()
                .clickSettingsPage()
                .clickChangePasswordForNonUser()
                .loginAccountChangePassword()
                .checkChangePasswordPage()
        ;

    }

    /**
     * @TBA *ÜYELİK BİLGİLERİ GÜNCELLEME SAYFASINDAN GİRİŞ
     * <p>
     * Uygulama açılır
     * Gelen izin popup ekranı kapatılır
     * Gelen login ekranı kapatılır
     * Ana sayfanın geldiği görülür.
     * Hesabım butonuna tıklanır.
     * Gelen sayfada Ayarlar butonuna tıklanır.
     * Üyelik Bilgileri Güncelleme Sayfasına tıklanır
     * Gelen login sayfası doldurulur.
     * Login butonuna tıklanır.
     * Üyelik Bilgileri Güncelleme sayfasının geldiği görülür.
     */
    @Test()
    public void loginFromUpdateMemberInfoOfSettingsPage() throws InterruptedException {

        starting()
                .start()
                .closeHxPopup()
                .popOverClose()
                .checkMainPage()
                .clickMyAccount()
                .clickSettingsPage()
                .clickUpdateMemberInfo()
                .loginUpdateMemberInfo()
                .checkMemberInfodPage()
        ;
    }

    /**
     * @TBA *ÜYELİK BİLGİLERİ GÜNCELLEME SAYFASINDAN GİRİŞ
     * <p>
     * Uygulama açılır
     * Gelen izin popup ekranı kapatılır
     * Gelen login ekranı kapatılır
     * Ana sayfanın geldiği görülür.
     * Hesabım butonuna tıklanır.
     * Gelen sayfada Ayarlar butonuna tıklanır.
     * Üyelik Bilgileri Güncelleme Sayfasına tıklanır
     * Gelen login sayfası doldurulur.
     * Login butonuna tıklanır.
     * Üyelik Bilgileri Güncelleme sayfasının geldiği görülür.
     */
    @Test()
    public void loginFromFastPaymentOptionsOfSettingsPage() throws InterruptedException {

        starting()
                .start()
                .closeHxPopup()
                .popOverClose()
                .checkMainPage()
                .clickMyAccount()
                .clickSettingsPage()
                .clickFastPayment()
                .loginFastPaymentOptions()
                .checkFastPaymentOptionsPage()
        ;
    }

    /**
     * @TBA *FAVORİLERİM SAYFASINDAN GİRİŞ
     * <p>
     * Uygulama açılır
     * Gelen izin popup ekranı kapatılır
     * Gelen login ekranı kapatılır
     * Ana sayfanın geldiği görülür.
     * Hesabım butonuna tıklanır.
     * Favorilerim Sayfasına tıklanır
     * Gelen login sayfası doldurulur.
     * Login butonuna tıklanır.
     * Favorilerim sayfasının geldiği görülür.
     */
    @Test()
    public void loginFromMyFavoritePage()  throws InterruptedException{

        starting()
                .start()
                .closeHxPopup()
                .popOverClose()
                .checkMainPage()
                .clickMyAccount()
                .clickMyFavoritePage()
                .loginFavoritePage()
                .checkFavoritePage()
        ;
    }

    /**
     * @TBA *ADRESLERİM SAYFASINDAN GİRİŞ
     * <p>
     * Uygulama açılır
     * Gelen izin popup ekranı kapatılır
     * Gelen login ekranı kapatılır
     * Ana sayfanın geldiği görülür.
     * Hesabım butonuna tıklanır.
     * Adreslerim Sayfasına tıklanır
     * Gelen login sayfası doldurulur.
     * Login butonuna tıklanır.
     * Adreslerim sayfasının geldiği görülür.
     */
    @Test()
    public void loginFromAddressPage() throws InterruptedException {

        starting()
                .start()
                .closeHxPopup()
                .popOverClose()
                .clickMyAccount()
                .clickAddressPage()
                .loginAddressPage()
                .checkAddressPage()
        ;
    }
    /** @RC
     * Konum izni varsa kapatıldı.
     * Login sayfası kapatıldı.
     * Arama barına tıklandı.
     * Arama yapıldı.
     * Tooltipler kapatıldı.
     * Favori ikonuna tıklandıç
     * Login olundu.
     * Aşağıya doğru scroll edilir.
     * Hesabım ikonuna tıklanır.
     * Login olunup olunmadığı kontrol edilir.
     * Favorilerim sayfasına gidilir.
     * Ürününün favoriler sayfasına eklenip eklnemedi kontrol edilir.
     */
    @Test
    public  void loginFromListingPageWithFavoriteIcon()  throws InterruptedException{
        starting()
                .start()
                .closeHxPopup()
                .popOverClose()
                .clickSearchBar()
                .writeStaticWord()
                .searchFromKeyword()
                .checkAndClickFirstTooltip()
                .checkAndClickSecondTooltip()
                .clickFavoriteIcon()
                .loginFavoriIConFromListingPage()
                .scrollDown()
                .clickAccountIcon()
                .checkUserLogin()
                .clickMyFavorite()
                .checkAddCorrectProduct();
    }

    @Test
    public void registerScenario()  throws InterruptedException{
       starting()
               .start()
               .clickSignUpBtn();
              /* .fillRegisterForm(Buyer.getGuestBuyer())
               .checkAndClickSuccessLoginPopup();
  */  }

}

