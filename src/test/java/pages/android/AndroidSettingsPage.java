package pages.android;

import base.PageFactory;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.Icommon.ILogin;
import pages.Icommon.ISettingsPage;

public class AndroidSettingsPage extends MethodsPage implements ISettingsPage {

    PageFactory pageFactory=new PageFactory();

    private By tittle=By.id("tv_toolbar_title");
    private By updateMemberInfo=By.id("tvSettingsUpdateUserProfile");
    private By clickChangePassword=By.id("tvSettingsUpdatePassword");
    private By fastPayment=By.id("tvSettingsOpcProfiles");

    public void assertSettingsPage(){
        System.out.println(findElement(tittle).getText());
        Assert.assertTrue("Ayarlar sayfası bulunamadı.",findElement(tittle).getText().equals("Ayarlar"));
    }

    public ILogin checkSettingsPage(){
        assertSettingsPage();
        return pageFactory.getInstance().createPage(ILogin.class);
    }

    public ILogin clickChangePasswordForNonUser(){
        clickBy(clickChangePassword,"Şifre Değişikliği Butonu Bulunamadı.","Şifre Değişikliği butonuna tıklandı.");
        return pageFactory.getInstance().createPage(ILogin.class);
    }

    public ILogin clickUpdateMemberInfo(){
         //clickBy(updateMemberInfo,"Üyelik bilgisi güncelle butonuna tıklandı.");
        click(updateMemberInfo);
        return pageFactory.getInstance().createPage(ILogin.class);
    }

    public ILogin clickFastPayment(){
        clickBy(fastPayment,"Hızlı ödeme sayfası butonu bulunamadı.","Hızlı ödeme sayfası butonuna tıklandı.");
        return pageFactory.getInstance().createPage(ILogin.class);
    }
}
