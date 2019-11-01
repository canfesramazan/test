package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.ILoginTestNG;
import testng.pagesTestNg.Icommon.ISettingsPageTestNG;

public class AndroidSettingsPageTestNG extends MethodsPage implements ISettingsPageTestNG {

    private By tittle=By.id("com.pozitron.hepsiburada:id/tv_toolbar_title");
    private By updateMemberInfo=By.id("com.pozitron.hepsiburada:id/tvSettingsUpdateUserProfile");
    private By clickChangePassword=By.id("com.pozitron.hepsiburada:id/tvSettingsUpdatePassword");
    private By fastPayment=By.id("com.pozitron.hepsiburada:id/tvSettingsOpcProfiles");

    public void checkSettingsPages(){
        System.out.println(findElement(tittle).getText());
        Assert.assertTrue("Ayarlar sayfası bulunamadı.",findElement(tittle).getText().contains("Ayarlar"));
    }

    public ILoginTestNG checkSettingsPage(){
        checkSettingsPages();
        return PageFactoryTestNg.getInstance().createPage(ILoginTestNG.class);
    }

    public ILoginTestNG clickChangePasswordForNonUser(){
        checkSettingsPage();
        clickBy(clickChangePassword,"Şifre Değişikliği Butonu Bulunamadı.","Şifre Değişikliği butonuna tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(ILoginTestNG.class);
    }

    public ILoginTestNG clickUpdateMemberInfo(){
        checkSettingsPage();
        clickBy(updateMemberInfo,"Üyelik bilgisi güncelle butonu bulunamadı.","Üyelik bilgisi güncelle butonuna tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(ILoginTestNG.class);
    }

    public ILoginTestNG clickFastPayment(){
        checkSettingsPage();
        clickBy(fastPayment,"Hızlı ödeme sayfası butonu bulunamadı.","Hızlı ödeme sayfası butonuna tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(ILoginTestNG.class);
    }
}
