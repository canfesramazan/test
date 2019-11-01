package pages.android;

import base.PageFactory;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.Icommon.IFastPaymentOptionsPage;

public class AndroidFastPaymentOptionsPage extends MethodsPage implements IFastPaymentOptionsPage {

    PageFactory pageFactory=new PageFactory();

    private By title=By.id("tv_toolbar_title");

    public IFastPaymentOptionsPage checkFastPaymentOptionsPage(){
        System.out.println(findElement(title).getText());
        Assert.assertTrue("Hızlı Ödeme Sayfası Bulunamadı",findElement(title).getText().contains("Hızlı Ödeme Tercihlerim"));
        return pageFactory.getInstance().createPage(IFastPaymentOptionsPage.class);
    }
}
