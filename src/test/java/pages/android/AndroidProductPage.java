package pages.android;

import base.PageFactory;
import helper.MethodsPage;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.nativekey.AndroidKey;
import org.junit.Assert;
//import org.opencv.video.BackgroundSubtractorKNN;
import org.openqa.selenium.By;
import pages.Icommon.IAccountPage;
import pages.Icommon.IMainPage;
import pages.Icommon.IProductPage;

public class AndroidProductPage extends MethodsPage implements IProductPage {

    PageFactory pageFactory=new PageFactory();

    private By favoriteButton=By.id("com.pozitron.hepsiburada:id/tv_product_detail_favourite");
    private By myAccount=By.id("Hesabım");
    private By firstProductHeader = By.id("com.pozitron.hepsiburada.beta:id/tv_toolbar_title");

    public IProductPage addFavorite(){

        findElementWithSwipe(favoriteButton,4);
        clickBy(favoriteButton,"Favori butonu bulunamadı.","Favori butonuna tıklandı.");
        return pageFactory.getInstance().createPage(IProductPage.class);
    }

    public IAccountPage clickAccountButton(){

        clickBy(myAccount,"Hesabım butonu bulunamadı.","Hesabım butonuna tıklandı.");
        return pageFactory.getInstance().createPage(IAccountPage.class);
    }

    public IAccountPage checkStoryProductPage() {

        wait(3);
        Assert.assertTrue("İlk hikayenin ürünü eşleşmedi", findElement(firstProductHeader).getText().contains("iPhone"));
        return pageFactory.getInstance().createPage(IAccountPage.class);
    }

    public IMainPage checkStoryProfileLinkProductPage() {

        wait(2);
        Assert.assertTrue("İlk hikayenin ürünü eşleşmedi", findElement(firstProductHeader).getText().contains("Apple"));
        goBack();
        return pageFactory.getInstance().createPage(IMainPage.class);
    }
}

