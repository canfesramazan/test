package testng;

import base.Initializer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import testng.pagesTestNg.Icommon.*;
import testng.pagesTestNg.android.*;
import testng.pagesTestNg.ios.*;

public class PageFactoryTestNg {

	 static volatile PageFactoryTestNg instance = null;
	 AppiumDriver appiumDriver;
	 ParalelBaseTest baseTest=new ParalelBaseTest();

	private PageFactoryTestNg() {
	}

	public  <T> T  createPage(Class<T> pageType) {
		T t = null;
		if (appiumDriver instanceof AndroidDriver) {
			 if (pageType.isAssignableFrom(IMainPageTestNG.class)) {
				t = (T) new AndroidMainPageTestNG();

			} else if (pageType.isAssignableFrom(ILoginTestNG.class)) {
				t = (T) new AndroidLoginTestNG();

			} else if (pageType.isAssignableFrom(IAccountPageTestNG.class)) {
				t = (T) new AndroidAccountPageTestNG();

			} else if (pageType.isAssignableFrom(ICampainsPageTestNG.class)) {
				t = (T) new AndroidCampainsPageTestNG();

			} else if (pageType.isAssignableFrom(IMembershipTestNG.class)) {
				t = (T) new AndroidMembershipTestNG();

			} else if (pageType.isAssignableFrom(IMyGiftVoucherPageTestNG.class)) {
				t = (T) new AndroidMyGiftVoucherPageTestNG();

			} else if (pageType.isAssignableFrom(ICustomerServicePageTestNG.class)) {
				t = (T) new AndroidCustomerServiceTestNG();

			} else if (pageType.isAssignableFrom(IMyMessagesTestNG.class)) {
				t = (T) new AndroidMyMessagesTestNG();

			} else if (pageType.isAssignableFrom(IAskUsTestNG.class)) {
				t = (T) new AndroidAskUsTestNG();

			} else if (pageType.isAssignableFrom(IOpportunitiesPageTestNG.class)) {
				t = (T) new AndroidOpportunitiesPageTestNG();

			} else if (pageType.isAssignableFrom(IProductPageTestNG.class)) {
				t = (T) new AndroidProductPageTestNG();

			} else if (pageType.isAssignableFrom(ISettingsPageTestNG.class)) {
				t = (T) new AndroidSettingsPageTestNG();

			} else if (pageType.isAssignableFrom(IChangePasswordTestNG.class)) {
				t = (T) new AndroidChangePasswordTestNG();

			} else if (pageType.isAssignableFrom(IUpdateMemberInfoPageTestNG.class)) {
				t = (T) new AndroidUpdateMemberInfoPageTestNG();

			} else if (pageType.isAssignableFrom(IFastPaymentOptionsPageTestNG.class)) {
				t = (T) new AndroidFastPaymentOptionsPageTestNG();

			} else if (pageType.isAssignableFrom(IFavoritePageTestNG.class)) {
				t = (T) new AndroidFavoritePageTestNG();

			} else if (pageType.isAssignableFrom(IAddressPageTestNG.class)) {
				t = (T) new AndroidAddressPageTestNG();

			} else if (pageType.isAssignableFrom(IStoriesPageTestNG.class)) {
				t = (T) new AndroidStoriesPageTestNG();

			} else if (pageType.isAssignableFrom(IListingPageTestNG.class)) {
				t = (T) new AndroidListingPageTestNG();

			} else if (pageType.isAssignableFrom(ISearchPageTestNG.class)) {
				t = (T) new AndroidSearchPageTestNG();

			} else if (pageType.isAssignableFrom(IRegisterPageTestNG.class)) {
				t = (T) new AndroidRegisterPageTestNG();

			}
		} else {
			if (pageType.isAssignableFrom(IStartingPageTestNG.class)) {
				t = (T) new IOSStartingPageTestNG();

			} else if (pageType.isAssignableFrom(IMainPageTestNG.class)) {
				t = (T) new IOSMainPageTestNG();

			} else if (pageType.isAssignableFrom(ILoginTestNG.class)) {
				t = (T) new IOSLoginTestNG();

			} else if (pageType.isAssignableFrom(IAccountPageTestNG.class)) {
				t = (T) new IOSAccountPageTestNG();

			} else if (pageType.isAssignableFrom(ICampainsPageTestNG.class)) {
				t = (T) new IOSCampainsPageTestNG();

			} else if (pageType.isAssignableFrom(IMembershipTestNG.class)) {
				t = (T) new IOSMembershipTestNG();

			} else if (pageType.isAssignableFrom(IMyGiftVoucherPageTestNG.class)) {
				t = (T) new IOSMyGiftVoucherPageTestNG();

			} else if (pageType.isAssignableFrom(ICustomerServicePageTestNG.class)) {
				t = (T) new IOSCustomerServiceTestNG();

			} else if (pageType.isAssignableFrom(IMyMessagesTestNG.class)) {
				t = (T) new IOSMyMessagesTestNG();

			} else if (pageType.isAssignableFrom(IAskUsTestNG.class)) {
				t = (T) new IOSAskUsTestNG();

			} else if (pageType.isAssignableFrom(ISettingsPageTestNG.class)) {
				t = (T) new IOSSettingsPageTestNG();

			} else if (pageType.isAssignableFrom(IChangePasswordTestNG.class)) {
				t = (T) new IOSChangePasswordTestNG();

			} else if (pageType.isAssignableFrom(IUpdateMemberInfoPageTestNG.class)) {
				t = (T) new IOSUpdateMemberInfoPageTestNG();

			} else if (pageType.isAssignableFrom(IFastPaymentOptionsPageTestNG.class)) {
				t = (T) new IOSFastPaymentOptionsPageTestNG();

			} else if (pageType.isAssignableFrom(IFavoritePageTestNG.class)) {
				t = (T) new IOSFavoritePageTestNG();

			} else if (pageType.isAssignableFrom(IAddressPageTestNG.class)) {
				t = (T) new IOSAddressPageTestNG();

			} else if (pageType.isAssignableFrom(IStoriesPageTestNG.class)) {
				t = (T) new IOSStoriesPageTestNG();

			} else if (pageType.isAssignableFrom(IListingPageTestNG.class)) {
				t = (T) new IOSListingPageTestNG();

			} else if (pageType.isAssignableFrom(ISearchPageTestNG.class)) {
				t = (T) new IOSSearchPageTestNG();

			} else if (pageType.isAssignableFrom(IRegisterPageTestNG.class)) {
				t = (T) new IOSRegisterPageTestNG();
			}
		}
		((Initializer) t).setDriver(appiumDriver);
		return t;
	}

	void setDriver(AppiumDriver driver) {
		this.appiumDriver= driver;
	}

	public  static PageFactoryTestNg getInstance() {
		if (instance == null) {
			synchronized (PageFactoryTestNg.class){
				if (instance == null){
					instance = new PageFactoryTestNg();
				}
			}
		}
			return instance;
	}
}




