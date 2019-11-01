package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.IAccountPageTestNG;
import testng.pagesTestNg.Icommon.IMainPageTestNG;
import testng.pagesTestNg.Icommon.IProductPageTestNG;

//import io.appium.java_client.android.nativekey.AndroidKey;
//import org.opencv.video.BackgroundSubtractorKNN;

public class AndroidProductPageTestNG extends MethodsPage implements IProductPageTestNG {

    private By favoriteButton=By.id("com.pozitron.hepsiburada:id/tv_product_detail_favourite");
    private By myAccount=By.id("Hesabım");
    private By firstProductHeader = By.id("com.pozitron.hepsiburada.beta:id/tv_toolbar_title");

    public IProductPageTestNG addFavorite(){

        findElementWithSwipe(favoriteButton,4);
        clickBy(favoriteButton,"Favori butonu bulunamadı.","Favori butonuna tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(IProductPageTestNG.class);
    }

    public IAccountPageTestNG clickAccountButton(){

        clickBy(myAccount,"Hesabım butonu bulunamadı.","Hesabım butonuna tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(IAccountPageTestNG.class);
    }

    public IAccountPageTestNG checkStoryProductPage() {

        wait(3);
        Assert.assertTrue("İlk hikayenin ürünü eşleşmedi", findElement(firstProductHeader).getText().contains("iPhone"));
        return PageFactoryTestNg.getInstance().createPage(IAccountPageTestNG.class);
    }

    public IMainPageTestNG checkStoryProfileLinkProductPage() {

        wait(2);
        Assert.assertTrue("İlk hikayenin ürünü eşleşmedi", findElement(firstProductHeader).getText().contains("Apple"));
        goBack();
        return PageFactoryTestNg.getInstance().createPage(IMainPageTestNG.class);
    }
}

