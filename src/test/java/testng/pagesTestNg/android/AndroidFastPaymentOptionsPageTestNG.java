package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.IFastPaymentOptionsPageTestNG;

public class AndroidFastPaymentOptionsPageTestNG extends MethodsPage implements IFastPaymentOptionsPageTestNG {

    private By title=By.id("com.pozitron.hepsiburada:id/tv_toolbar_title");

    public IFastPaymentOptionsPageTestNG checkFastPaymentOptionsPage(){
        System.out.println(findElement(title).getText());
        Assert.assertTrue("Hızlı Ödeme Sayfası Bulunamadı",findElement(title).getText().contains("Hızlı Ödeme Tercihlerim"));
        return PageFactoryTestNg.getInstance().createPage(IFastPaymentOptionsPageTestNG.class);
    }
}
