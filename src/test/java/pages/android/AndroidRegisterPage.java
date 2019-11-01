package pages.android;

import base.PageFactory;
import helper.Buyer;
import helper.MethodsPage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import pages.Icommon.IMainPage;
import pages.Icommon.IRegisterPage;


public class AndroidRegisterPage extends MethodsPage implements IRegisterPage {

    PageFactory pageFactory=new PageFactory();

    private By firstNameBtn = MobileBy.id("etRegisterFirstName");
    private By lastNameBtn = MobileBy.id("etRegisterLastName");
    private By emailBtn = MobileBy.id("etRegisterEmail");
    private By password = MobileBy.id("etRegisterPassword");
    private By rePassword = MobileBy.id("etRegisterRePassword");
    private By registerSend = MobileBy.id("btnRegisterSend");

    public IMainPage fillRegisterForm(Buyer buyer) {
   /*     type(firstNameBtn, buyer.getName());
        type(lastNameBtn, buyer.getSurname());
        type(emailBtn, buyer.getEmail());
        type(password, buyer.getPassword());
        type(rePassword, buyer.getRepassword());
        scrollOnApplication("down");
        click(registerSend);*/
        return pageFactory.getInstance().createPage(IMainPage.class);
    }

}
