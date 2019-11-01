package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.ICustomerServicePageTestNG;
import testng.pagesTestNg.Icommon.ILoginTestNG;

public class AndroidCustomerServiceTestNG extends MethodsPage implements ICustomerServicePageTestNG {

    private By myMessages = By.xpath("//android.widget.RelativeLayout[@content-desc=\"Mesajlarım\"]/android.view.ViewGroup");
    private By askUs = By.xpath("//android.widget.RelativeLayout[@content-desc=\"Bize Sorun\"]/android.view.ViewGroup");

    public ILoginTestNG clickMessagesFromCustomerSevice() {
        clickBy(myMessages, "Mesajlarım bulunamadı.", "Mesajlarıma tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(ILoginTestNG.class);
    }

    public ILoginTestNG clickAskUsFromCustomerService() {
        clickBy(askUs, "Bize Sorun bulunamadı", "Bize Sorun'a tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(ILoginTestNG.class);
    }


}
