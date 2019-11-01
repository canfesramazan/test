package pages.android;

import base.PageFactory;
import helper.MethodsPage;
import org.openqa.selenium.By;
import pages.Icommon.ICustomerServicePage;
import pages.Icommon.ILogin;

public class AndroidCustomerService extends MethodsPage implements ICustomerServicePage {

    PageFactory pageFactory=new PageFactory();

    private By myMessages = By.xpath("//android.widget.RelativeLayout[@content-desc=\"Mesajlarım\"]/android.view.ViewGroup");
    private By askUs = By.xpath("//android.widget.RelativeLayout[@content-desc=\"Bize Sorun\"]/android.view.ViewGroup");

    public ILogin clickMessagesFromCustomerSevice() {
        clickBy(myMessages, "Mesajlarım bulunamadı.", "Mesajlarıma tıklandı.");
        return pageFactory.getInstance().createPage(ILogin.class);
    }

    public ILogin clickAskUsFromCustomerService() {
        clickBy(askUs, "Bize Sorun bulunamadı", "Bize Sorun'a tıklandı.");
        return pageFactory.getInstance().createPage(ILogin.class);
    }


}
