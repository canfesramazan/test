package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import lombok.Synchronized;
import pages.Icommon.*;
import pages.android.*;
import pages.ios.*;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PageFactory {

	AppiumDriver<MobileElement> appiumDriver;

	static PageFactory instance ;

	public  <T> T  createPage(Class<T> pageType) {

		 T t = null;
		if (appiumDriver instanceof AndroidDriver) {
			 if (pageType.isAssignableFrom(IMainPage.class)) {
				t = (T) new AndroidMainPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(ILogin.class)) {
				t = (T) new AndroidLogin();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IAccountPage.class)) {
				t = (T) new AndroidAccountPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(ICampainsPage.class)) {
				t = (T) new AndroidCampainsPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IMembership.class)) {
				t = (T) new AndroidMembership();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IMyGiftVoucherPage.class)) {
				t = (T) new AndroidMyGiftVoucherPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(ICustomerServicePage.class)) {
				t = (T) new AndroidCustomerService();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IMyMessages.class)) {
				t = (T) new AndroidMyMessages();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IAskUs.class)) {
				t = (T) new AndroidAskUs();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IOpportunitiesPage.class)) {
				t = (T) new AndroidOpportunitiesPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IProductPage.class)) {
				t = (T) new AndroidProductPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(ISettingsPage.class)) {
				t = (T) new AndroidSettingsPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IChangePassword.class)) {
				t = (T) new AndroidChangePassword();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IUpdateMemberInfoPage.class)) {
				t = (T) new AndroidUpdateMemberInfoPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IFastPaymentOptionsPage.class)) {
				t = (T) new AndroidFastPaymentOptionsPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IFavoritePage.class)) {
				t = (T) new AndroidFavoritePage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IAddressPage.class)) {
				t = (T) new AndroidAddressPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IStoriesPage.class)) {
				t = (T) new AndroidStoriesPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IListingPage.class)) {
				t = (T) new AndroidListingPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(ISearchPage.class)) {
				t = (T) new AndroidSearchPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IRegisterPage.class)) {
				t = (T) new AndroidRegisterPage();
				((Initializer) t).setDriver(appiumDriver);
			}
		} else {
			if (pageType.isAssignableFrom(IStartingPage.class)) {
				t = (T) new IOSStartingPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IMainPage.class)) {
				t = (T) new IOSMainPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(ILogin.class)) {
				t = (T) new IOSLogin();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IAccountPage.class)) {
				t = (T) new IOSAccountPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(ICampainsPage.class)) {
				t = (T) new IOSCampainsPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IMembership.class)) {
				t = (T) new IOSMembership();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IMyGiftVoucherPage.class)) {
				t = (T) new IOSMyGiftVoucherPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(ICustomerServicePage.class)) {
				t = (T) new IOSCustomerService();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IMyMessages.class)) {
				t = (T) new IOSMyMessages();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IAskUs.class)) {
				t = (T) new IOSAskUs();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(ISettingsPage.class)) {
				t = (T) new IOSSettingsPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IChangePassword.class)) {
				t = (T) new IOSChangePassword();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IUpdateMemberInfoPage.class)) {
				t = (T) new IOSUpdateMemberInfoPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IFastPaymentOptionsPage.class)) {
				t = (T) new IOSFastPaymentOptionsPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IFavoritePage.class)) {
				t = (T) new IOSFavoritePage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IAddressPage.class)) {
				t = (T) new IOSAddressPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IStoriesPage.class)) {
				t = (T) new IOSStoriesPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IListingPage.class)) {
				t = (T) new IOSListingPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(ISearchPage.class)) {
				t = (T) new IOSSearchPage();
				((Initializer) t).setDriver(appiumDriver);
			} else if (pageType.isAssignableFrom(IRegisterPage.class)) {
				t = (T) new IOSRegisterPage();
				((Initializer) t).setDriver(appiumDriver);
			}
		}
		((Initializer) t).setDriver(appiumDriver);
		System.out.println(appiumDriver.toString());
		return t;
	}

	public void setDriver(AppiumDriver<MobileElement> driver) {
		synchronized (this){
		this.appiumDriver= driver;
		}
	}

	public  PageFactory getInstance() {
			if (instance== null) {
			synchronized (PageFactory.class){
				if ( instance== null){
					instance = new PageFactory();
				}
			}
		}
		return instance;
	}
}




