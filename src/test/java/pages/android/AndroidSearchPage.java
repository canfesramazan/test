package pages.android;

import base.PageFactory;
import com.google.common.collect.ImmutableMap;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.Icommon.IListingPage;
import pages.Icommon.ISearchPage;

public class AndroidSearchPage extends MethodsPage implements ISearchPage {

    private By searchBox = By.id("etACBSearchBox");
    private By firstSuggestion = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]");
    private By allHistoryClear = By.id("tvSearchClearSearchHistory");
    private By allowPopup =By.id("android:id/button1");

  //  static String searchKey = "";

    PageFactory pageFactory=new PageFactory();

    public ISearchPage writeWordAndSearch() {
    //    searchKey= getRandomSearchKey();
   //     findElement(searchBox).sendKeys(searchKey);
        return pageFactory.getInstance().createPage(ISearchPage.class);
    }

    public ISearchPage writeOneCharacter(){
        findElement(searchBox).sendKeys(getRandomSearchWithOneCharacter());
        return pageFactory.getInstance().createPage(ISearchPage.class);
    }

    public ISearchPage writeStaticWord(){
        findElement(searchBox).sendKeys("telefon");
        return pageFactory.getInstance().createPage(ISearchPage.class);
    }

 //   public String getSearchKey(){
  //      return searchKey;
  //  }

    public IListingPage searchFromKeyword(){
        mobilDriver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
        return pageFactory.getInstance().createPage(IListingPage.class);
    }

    public ISearchPage searchFromKeywordForOneCharacter(){
        mobilDriver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
        return pageFactory.getInstance().createPage(ISearchPage.class);
    }

    public IListingPage clickFirstSuggestion() {
        clickBy(firstSuggestion, "Suggestion bulunamadı.", "Suggestion'a tıklandı.");
        return pageFactory.getInstance().createPage(IListingPage.class);
    }

    public ISearchPage allHistoryClearAtSearch() {
        clickBy(allHistoryClear, "Tümünü Temizle bulunamdı.", "Tümünü Temizleye tıklandı.");
        clickBy(allowPopup, "Arama geçmişini temizle onayı için buton bulunamadı.", "Arama geçmişi temizleme onayı verildi.");
        return pageFactory.getInstance().createPage(ISearchPage.class);
    }

    public ISearchPage checkAllHistoryClearBtnPresent(){
        Assert.assertFalse(isElementPresent(allHistoryClear));
        return pageFactory.getInstance().createPage(ISearchPage.class);
    }

    public ISearchPage checkThereIsNoSuggestion(){
        Assert.assertFalse(isElementPresent(firstSuggestion));
        return pageFactory.getInstance().createPage(ISearchPage.class);
    }

    public ISearchPage checkNotChangePage(){
        Assert.assertTrue(isElementPresent(searchBox));
        return pageFactory.getInstance().createPage(ISearchPage.class);
    }

}
