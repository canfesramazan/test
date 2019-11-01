package pages.android;

import base.PageFactory;
import helper.MethodsPage;
import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.Icommon.IMembership;
import pages.Icommon.IMyGiftVoucherPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class AndroidMyGiftVoucherPage extends MethodsPage implements IMyGiftVoucherPage {

    PageFactory pageFactory=new PageFactory();

    private By MyGiftVouchersTitle = MobileBy.id("tv_toolbar_title");

    public IMyGiftVoucherPage checkMyGiftVoucherTitle(){

        String getMyGiftVoucherTitle = findElement(MyGiftVouchersTitle).getText();

        String mygiftvouchersPageTitleTxt = "Hediye Çeklerim";
        assertThat("Login should be success and check go to vouchers page", getMyGiftVoucherTitle, is(equalTo(mygiftvouchersPageTitleTxt)));
        return pageFactory.getInstance().createPage(IMyGiftVoucherPage.class);
    }

    @Override
    public IMyGiftVoucherPage enterAccountFromMyGiftVoucher() {
        return null;
    }
}
