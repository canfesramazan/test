package pages.android;

import base.PageFactory;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.Icommon.IUpdateMemberInfoPage;

public class AndroidUpdateMemberInfoPage extends MethodsPage implements IUpdateMemberInfoPage {

    PageFactory pageFactory=new PageFactory();

    private By title=By.id("tv_toolbar_title");

    public IUpdateMemberInfoPage checkMemberInfodPage(){

        Assert.assertTrue("Üyelik Bilgilerim Sayfası Bulunamadı",findElement(title).getText().contains("Üyelik Bilgilerim"));
        return pageFactory.getInstance().createPage(IUpdateMemberInfoPage.class);
    }
}
