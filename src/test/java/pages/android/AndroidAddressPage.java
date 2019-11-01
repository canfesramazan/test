package pages.android;

import base.PageFactory;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.Icommon.IAddressPage;
import pages.Icommon.IFavoritePage;

public class AndroidAddressPage extends MethodsPage implements IAddressPage {

    private By tittle=By.id("tv_toolbar_title");

    PageFactory pageFactory=new PageFactory();


    public IAddressPage checkAddressPage(){
        System.out.println(findElement(tittle).getText());
        Assert.assertTrue("Adreslerim Sayfası Bulunamadı",findElement(tittle).getText().contains("Adreslerim"));
        return pageFactory.getInstance().createPage(IAddressPage.class);
    }

}
