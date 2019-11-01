package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.IUpdateMemberInfoPageTestNG;

public class AndroidUpdateMemberInfoPageTestNG extends MethodsPage implements IUpdateMemberInfoPageTestNG {

    private By title=By.id("com.pozitron.hepsiburada:id/tv_toolbar_title");

    public IUpdateMemberInfoPageTestNG checkMemberInfodPage(){

        Assert.assertTrue("Üyelik Bilgilerim Sayfası Bulunamadı",findElement(title).getText().contains("Üyelik Bilgilerim"));
        return PageFactoryTestNg.getInstance().createPage(IUpdateMemberInfoPageTestNG.class);
    }
}
