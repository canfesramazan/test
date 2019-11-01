package pages.android;

import base.PageFactory;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.Icommon.IChangePassword;

public class AndroidChangePassword extends MethodsPage implements IChangePassword {

    PageFactory pageFactory=new PageFactory();


    private By changePasswordPageTittle=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]");

    public IChangePassword checkChangePasswordPage(){

        Assert.assertTrue("Şifre Değiştirme Sayfası Bulunamadı",findElement(changePasswordPageTittle).getText().contains("Şifre değiştirin"));
        return pageFactory.getInstance().createPage(IChangePassword.class);
    }
}
