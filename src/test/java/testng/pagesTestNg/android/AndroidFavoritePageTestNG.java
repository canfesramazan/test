package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.IFavoritePageTestNG;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AndroidFavoritePageTestNG extends MethodsPage implements IFavoritePageTestNG {

    private By tittle=By.id("com.pozitron.hepsiburada:id/tv_simple_toolbar_title");
    private By myFavoriteProduct=By.id("com.pozitron.hepsiburada:id/tv_product_list_item_name");
    private By firstProductsName = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView[1]");
    private By deleteProduct = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.CheckBox");


    AndroidListingPageTestNG androidListingPage = new AndroidListingPageTestNG();

    public IFavoritePageTestNG checkfavoriteList(){
        Assert.assertEquals("Favori ürün bulunamadı.",findElement(myFavoriteProduct).getText(),"Versace Dylan Blue Edt 100 Ml Erkek Parfüm");
        return PageFactoryTestNg.getInstance().createPage(IFavoritePageTestNG.class);
    }

    public IFavoritePageTestNG checkAddCorrectProduct() {
        String sedfsd = findElement(firstProductsName).getText();
        assertThat("rwee", sedfsd, is(equalTo(androidListingPage.productName())));
        clickBy(deleteProduct, "Ürün favorilerden çıkartılamadı.", "Ürün favorilerden çıkartıldı.");
        return PageFactoryTestNg.getInstance().createPage(IFavoritePageTestNG.class);
    }


    public IFavoritePageTestNG checkFavoritePage(){
        Assert.assertTrue("Favorilerim Sayfası Bulunamadı",getText(tittle).contains("Favori Listem"));
        return PageFactoryTestNg.getInstance().createPage(IFavoritePageTestNG.class);

    }

}
