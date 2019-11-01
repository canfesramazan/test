package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.IAddressPageTestNG;

public class AndroidAddressPageTestNG extends MethodsPage implements IAddressPageTestNG {

    private By tittle=By.id("com.pozitron.hepsiburada:id/tv_toolbar_title");

    public IAddressPageTestNG checkAddressPage(){
        System.out.println(findElement(tittle).getText());
        Assert.assertTrue("Adreslerim Sayfası Bulunamadı",findElement(tittle).getText().contains("Adreslerim"));
        return PageFactoryTestNg.getInstance().createPage(IAddressPageTestNG.class);
    }

}
