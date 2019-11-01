package pages.Icommon;

public interface  ILogin  {
     ILogin start() throws InterruptedException;
     IMainPage checkUser();
     IMyGiftVoucherPage loginAccountFromMyGiftVoucher();
     IMyMessages loginAccountFromMyMessages();
     IAskUs loginAccountFromAskUs();
     IAccountPage loginEnterAccount();
     IChangePassword loginAccountChangePassword();
     IUpdateMemberInfoPage loginUpdateMemberInfo();
     IFastPaymentOptionsPage loginFastPaymentOptions();
     IFavoritePage loginFavoritePage();
     IAddressPage loginAddressPage();
     IMainPage loginAccountStarting();
     IListingPage loginFavoriIConFromListingPage();
     IRegisterPage clickSignUpBtn();
     IMainPage closeHxPopup();


}
