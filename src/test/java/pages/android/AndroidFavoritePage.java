package pages.android;

import base.PageFactory;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.Icommon.IAccountPage;
import pages.Icommon.IFastPaymentOptionsPage;
import pages.Icommon.IFavoritePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AndroidFavoritePage  extends MethodsPage implements IFavoritePage {

    private By tittle=By.id("tv_simple_toolbar_title");
    private By myFavoriteProduct=By.id("tv_product_list_item_name");
    private By firstProductsName = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView[1]");
    private By deleteProduct = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.CheckBox");

    PageFactory pageFactory=new PageFactory();


    //  AndroidListingPage androidListingPage = new AndroidListingPage();

    public IFavoritePage checkfavoriteList(){
        Assert.assertEquals("Favori ürün bulunamadı.",findElement(myFavoriteProduct).getText(),"Versace Dylan Blue Edt 100 Ml Erkek Parfüm");
        return pageFactory.getInstance().createPage(IFavoritePage.class);
    }

    public IFavoritePage checkAddCorrectProduct() {
        String sedfsd = findElement(firstProductsName).getText();
      //  assertThat("rwee", sedfsd, is(equalTo(androidListingPage.productName())));
        clickBy(deleteProduct, "Ürün favorilerden çıkartılamadı.", "Ürün favorilerden çıkartıldı.");
        return pageFactory.getInstance().createPage(IFavoritePage.class);
    }


    public IFavoritePage checkFavoritePage(){
        Assert.assertTrue("Favorilerim Sayfası Bulunamadı",getText(tittle).contains("Favori Listem"));
        return pageFactory.getInstance().createPage(IFavoritePage.class);

    }

}
