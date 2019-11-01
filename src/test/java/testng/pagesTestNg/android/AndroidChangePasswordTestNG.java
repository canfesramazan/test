package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.IChangePasswordTestNG;

public class AndroidChangePasswordTestNG extends MethodsPage implements IChangePasswordTestNG {

    private By changePasswordPageTittle=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]");

    public IChangePasswordTestNG checkChangePasswordPage(){

        Assert.assertTrue("Şifre Değiştirme Sayfası Bulunamadı",findElement(changePasswordPageTittle).getText().contains("Şifre değiştirin"));
        return PageFactoryTestNg.getInstance().createPage(IChangePasswordTestNG.class);
    }
}
