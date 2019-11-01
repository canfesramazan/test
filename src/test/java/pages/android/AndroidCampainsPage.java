package pages.android;

import base.PageFactory;
import helper.MethodsPage;
import org.openqa.selenium.By;
import pages.Icommon.IAccountPage;
import pages.Icommon.ICampainsPage;

public class AndroidCampainsPage extends MethodsPage implements ICampainsPage {

    private By myAccount=By.id("com.pozitron.hepsiburada:id/iv_toolbar_user_account_menu");

    PageFactory pageFactory=new PageFactory();

    public ICampainsPage checkUser() {
        return null;
    }

    public IAccountPage clickMyAccount(){
        clickBy(myAccount,"Hesabım butonu bulunamadı.","Hesabım butonuna tıklandı.");
        return pageFactory.getInstance().createPage(IAccountPage.class);
    }

}
