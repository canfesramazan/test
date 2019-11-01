package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import com.google.common.collect.ImmutableMap;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.IListingPageTestNG;
import testng.pagesTestNg.Icommon.ISearchPageTestNG;


public class AndroidSearchPageTestNG extends MethodsPage implements ISearchPageTestNG {

    private By searchBox = By.id("etACBSearchBox");
    private By firstSuggestion = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]");
    private By allHistoryClear = By.id("tvSearchClearSearchHistory");
    private By allowPopup =By.id("android:id/button1");

    static String searchKey = "";

    public ISearchPageTestNG writeWordAndSearch() {
        searchKey= getRandomSearchKey();
        findElement(searchBox).sendKeys(searchKey);
        return PageFactoryTestNg.getInstance().createPage(ISearchPageTestNG.class);
    }

    public ISearchPageTestNG writeOneCharacter(){
        findElement(searchBox).sendKeys(getRandomSearchWithOneCharacter());
        return PageFactoryTestNg.getInstance().createPage(ISearchPageTestNG.class);
    }

    public ISearchPageTestNG writeStaticWord(){
        findElement(searchBox).sendKeys("telefon");
        return PageFactoryTestNg.getInstance().createPage(ISearchPageTestNG.class);
    }

    public String getSearchKey(){
        return searchKey;
    }

    public IListingPageTestNG searchFromKeyword(){
        mobilDriver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }

    public ISearchPageTestNG searchFromKeywordForOneCharacter(){
        mobilDriver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
        return PageFactoryTestNg.getInstance().createPage(ISearchPageTestNG.class);
    }

    public IListingPageTestNG clickFirstSuggestion() {
        clickBy(firstSuggestion, "Suggestion bulunamadı.", "Suggestion'a tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }

    public ISearchPageTestNG allHistoryClearAtSearch() {
        clickBy(allHistoryClear, "Tümünü Temizle bulunamdı.", "Tümünü Temizleye tıklandı.");
        clickBy(allowPopup, "Arama geçmişini temizle onayı için buton bulunamadı.", "Arama geçmişi temizleme onayı verildi.");
        return PageFactoryTestNg.getInstance().createPage(ISearchPageTestNG.class);
    }

    public ISearchPageTestNG checkAllHistoryClearBtnPresent(){
        Assert.assertFalse(isElementPresent(allHistoryClear));
        return PageFactoryTestNg.getInstance().createPage(ISearchPageTestNG.class);
    }

    public ISearchPageTestNG checkThereIsNoSuggestion(){
        Assert.assertFalse(isElementPresent(firstSuggestion));
        return PageFactoryTestNg.getInstance().createPage(ISearchPageTestNG.class);
    }

    public ISearchPageTestNG checkNotChangePage(){
        Assert.assertTrue(isElementPresent(searchBox));
        return PageFactoryTestNg.getInstance().createPage(ISearchPageTestNG.class);
    }

}
