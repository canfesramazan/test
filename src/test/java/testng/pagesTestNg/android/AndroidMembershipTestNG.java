package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.IMainPageTestNG;
import testng.pagesTestNg.Icommon.IMembershipTestNG;

public class AndroidMembershipTestNG extends MethodsPage implements IMembershipTestNG {

    private By name=By.id("com.pozitron.hepsiburada:id/etUserFirstName");
    private By update=By.id("com.pozitron.hepsiburada:id/btnOkSend");
    private By okButton=By.id("android:id/button1");
    private By popupMessage=By.id("android:id/message");

    public static String nameStr="";

    public IMembershipTestNG changeName(){
        sendKeys(name," taha ");
        nameStr=getText(name);
        return PageFactoryTestNg.getInstance().createPage(IMembershipTestNG.class);
    }

    public IMainPageTestNG saveName(){
        clickBy(update,"Güncelle butonuna tıklandı.");
        Assert.assertEquals("Bilgileriniz kaydedildi popup ı bulunamadı","Bilgileriniz başarıyla kaydedildi.",getText(popupMessage));
        clickBy(okButton,"Popup tamam seçeneğine tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(IMainPageTestNG.class);
    }
}
