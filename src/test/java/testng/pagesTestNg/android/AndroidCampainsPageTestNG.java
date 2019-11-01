package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.IAccountPageTestNG;
import testng.pagesTestNg.Icommon.ICampainsPageTestNG;

public class AndroidCampainsPageTestNG extends MethodsPage implements ICampainsPageTestNG {

    private By myAccount=By.id("com.pozitron.hepsiburada:id/iv_toolbar_user_account_menu");

    public ICampainsPageTestNG checkUser() {
        return null;
    }

    public IAccountPageTestNG clickMyAccount(){
        clickBy(myAccount,"Hesabım butonu bulunamadı.","Hesabım butonuna tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(IAccountPageTestNG.class);
    }

}
