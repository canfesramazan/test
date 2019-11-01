package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.IMyGiftVoucherPageTestNG;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class AndroidMyGiftVoucherPageTestNG extends MethodsPage implements IMyGiftVoucherPageTestNG {

    private By MyGiftVouchersTitle = MobileBy.id("tv_toolbar_title");

    public IMyGiftVoucherPageTestNG checkMyGiftVoucherTitle(){
        String getMyGiftVoucherTitle = findElement(MyGiftVouchersTitle).getText();
        String mygiftvouchersPageTitleTxt = "Hediye Çeklerim";
        assertThat("Login should be success and check go to vouchers page", getMyGiftVoucherTitle, is(equalTo(mygiftvouchersPageTitleTxt)));
        return PageFactoryTestNg.getInstance().createPage(IMyGiftVoucherPageTestNG.class);
    }

    @Override
    public IMyGiftVoucherPageTestNG enterAccountFromMyGiftVoucher() {
        return null;
    }
}
