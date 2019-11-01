package pages.android;

import base.PageFactory;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.Icommon.IMainPage;
import pages.Icommon.IMembership;

public class AndroidMembership extends MethodsPage implements IMembership {

    private By name=By.id("com.pozitron.hepsiburada:id/etUserFirstName");
    private By update=By.id("com.pozitron.hepsiburada:id/btnOkSend");
    private By okButton=By.id("android:id/button1");
    private By popupMessage=By.id("android:id/message");

    PageFactory pageFactory=new PageFactory();

    //  public static String nameStr="";

    public IMembership changeName(){
        sendKeys(name," taha ");
 //       nameStr=getText(name);
        return pageFactory.getInstance().createPage(IMembership.class);
    }

    public IMainPage saveName(){
        clickBy(update,"Güncelle butonuna tıklandı.");
        Assert.assertEquals("Bilgileriniz kaydedildi popup ı bulunamadı","Bilgileriniz başarıyla kaydedildi.",getText(popupMessage));
        clickBy(okButton,"Popup tamam seçeneğine tıklandı.");
        return pageFactory.getInstance().createPage(IMainPage.class);
    }
}
