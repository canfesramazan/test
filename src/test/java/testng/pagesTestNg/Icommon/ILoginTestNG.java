package testng.pagesTestNg.Icommon;

public interface ILoginTestNG {
     ILoginTestNG start();
     IMainPageTestNG checkUser();
     IMainPageTestNG closeLoginPopup() ;
     IMyGiftVoucherPageTestNG loginAccountFromMyGiftVoucher();
     IMyMessagesTestNG loginAccountFromMyMessages();
     IAskUsTestNG loginAccountFromAskUs();
     IAccountPageTestNG loginEnterAccount();
     IChangePasswordTestNG loginAccountChangePassword();
     IUpdateMemberInfoPageTestNG loginUpdateMemberInfo();
     IFastPaymentOptionsPageTestNG loginFastPaymentOptions();
     IFavoritePageTestNG loginFavoritePage();
     IAddressPageTestNG loginAddressPage();
     IMainPageTestNG loginAccountStarting();
     IListingPageTestNG loginFavoriIConFromListingPage();
     IRegisterPageTestNG clickSignUpBtn();

}
