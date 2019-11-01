package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.Buyer;
import helper.MethodsPage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.IMainPageTestNG;
import testng.pagesTestNg.Icommon.IRegisterPageTestNG;


public class AndroidRegisterPageTestNG extends MethodsPage implements IRegisterPageTestNG {

    private By firstNameBtn = MobileBy.id("etRegisterFirstName");
    private By lastNameBtn = MobileBy.id("etRegisterLastName");
    private By emailBtn = MobileBy.id("etRegisterEmail");
    private By password = MobileBy.id("etRegisterPassword");
    private By rePassword = MobileBy.id("etRegisterRePassword");
    private By registerSend = MobileBy.id("btnRegisterSend");

    public IMainPageTestNG fillRegisterForm(Buyer buyer) {
    /*    type(firstNameBtn, buyer.getName());
        type(lastNameBtn, buyer.getSurname());
        type(emailBtn, buyer.getEmail());
        type(password, buyer.getPassword());
        type(rePassword, buyer.getRepassword());
        scrollOnApplication("down");
        click(registerSend);*/
        return PageFactoryTestNg.getInstance().createPage(IMainPageTestNG.class);
    }

}
