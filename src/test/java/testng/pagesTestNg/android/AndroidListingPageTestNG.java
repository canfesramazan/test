package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.IAccountPageTestNG;
import testng.pagesTestNg.Icommon.IListingPageTestNG;
import testng.pagesTestNg.Icommon.ILoginTestNG;
import testng.pagesTestNg.Icommon.ISearchPageTestNG;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsEqual.equalTo;

//import io.appium.java_client.android.nativekey.AndroidKey;
//import io.appium.java_client.android.nativekey.KeyEvent;


public class AndroidListingPageTestNG extends MethodsPage implements IListingPageTestNG {

    private By clearSearchBox = By.id("ivACBClearSearchBox");
    private By toolbarTitle =By.id("tv_toolbar_editable_title");
    private By firstTooltip = By.id("tv_tooltip");
    private By secondTooltip = By.id("tv_tooltip");
    private By sortBtn = By.id("tv_product_list_options_bar_sort");
    private By changeSortSelection = By.id("lyt_product_list_options_bar_sort");
    private By highestPrice = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.RadioButton");
    private By productName = By.id("tv_product_list_item_name");
    private By filterBar = By.id("tv_product_list_options_bar_filter");
    private By applyAndCloseFilterBtn =By.id("btn_filters_main_close");
    private By clearFilters = By.id("lyt_menu_item_filters_clear");
    private By filterApplyBtn = By.id("btn_filters_apply");
    private By favoriteIcon = By.id("cb_product_list_item_favourite");
    private By accountIcon = By.id("iv_toolbar_user_account_menu");
    private By clickBrandAtFilter = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]");
    private By selectBrand = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.CheckBox");
    private By productNAme2 = By.xpath("//android.view.ViewGroup[@content-desc=\"Ürün 5\"]/android.widget.LinearLayout/android.widget.TextView");
    private By changeAppearance = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageSwitcher/android.widget.ImageView");
    private By firstSuggestion = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/com.google.android.material.chip.Chip[1]");
    private By thirdSuggestion = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/com.google.android.material.chip.Chip[2]");

    AndroidSearchPageTestNG androidSearchPage = new AndroidSearchPageTestNG();

    static String productNameText ="";

    public IListingPageTestNG scrollDown() {
        scrollOnApplication("down");
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }

    public IListingPageTestNG scrollUp() {
        scrollOnApplications("up");
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }

    public String productName(){
        return productNameText;
    }

    public ISearchPageTestNG backSearchPage(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
   //     ((AndroidDriver) mobilDriver).pressKey(new KeyEvent(AndroidKey.BACK));
        clickBy(clearSearchBox, "Arama alanı temizlenemedi.", "Arama alanı temizlendi.");
        return PageFactoryTestNg.getInstance().createPage(ISearchPageTestNG.class);
    }

    public IListingPageTestNG checkSearchWord(){
  //      assertTrue("Arama kelimesi farklı.",findElement(toolbarTitle).getText().contains(androidSearchPage.getSearchKey()));
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }

    public IListingPageTestNG checkAndClickFirstTooltip() {
        String firstTooltipText = findElement(firstTooltip).getText();
        String expectedFirtTooltipText = "Görünüm değiştirmek için bu alanı kullanın.";
        assertThat("There isn't expected tooltip", firstTooltipText, is(equalTo(expectedFirtTooltipText)));
        clickBy(firstTooltip, "There isn't tooltip", "There is tooltip");
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }

    public IListingPageTestNG checkAndClickSecondTooltip() {
        String firstTooltipText = findElement(secondTooltip).getText();
        String expectedFirtTooltipText = "Aradığınız ürünü daha kolay bulmak için ilgili kategoriler filtresini kullanın.";
        assertThat("There isn't expected tooltip", firstTooltipText, is(equalTo(expectedFirtTooltipText)));
        clickBy(secondTooltip, "There isn't tooltip", "There is tooltip");
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }

    public IListingPageTestNG swipeRightAtListingPage(){
        leftSwipeAtListingSuggestion("right");
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }

    public IListingPageTestNG checkSwipeAndSuggestion() {
        Assert.assertTrue(isElementPresent(thirdSuggestion));
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }

    public IListingPageTestNG clickListingPageSuggestion() {
        clickBy(thirdSuggestion, "3. suggestion bulunamadı.", "3. suggestiona tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }

    public IListingPageTestNG checkThereIsNoSuggestion() {
        Assert.assertFalse(isElementPresent(firstSuggestion));
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }

    public IListingPageTestNG checkThereIsSuggestion() {
        Assert.assertTrue(isElementPresent(firstSuggestion));
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }

    public IListingPageTestNG clickSortBtn() {
        clickBy(sortBtn, "Sırala butonu bulunamadı.", "Sırala butonuna basıldı.");
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }

    public String getProductNameText() {

        if (isElementPresent(productName) == true){
            String firstProductName= findElement(productName).getText();
            return firstProductName;
        }
        else {
             clickBy(changeAppearance, "Görünüm değiştirme butonu bulunamadı." ,"Görünüm değiştir butonuna basıldı.");
            String firstProductName = findElement(productNAme2).getText();
            return firstProductName;
        }

    }
    public IListingPageTestNG changeSortSelection() {
        productNameText = getProductNameText();
        clickBy(changeSortSelection,    "Sırala butonu bulunamadı." , "Sırala butonuna tıklandı.");
        clickBy(highestPrice, "En Yüksek Fiyat seçeneği bulunmaadı.", "En Yüksek Fiyat seçeneği seçildi.");
        wait(2000);
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }

    public IListingPageTestNG checkFirstProductIsChange() {
        String productNameAfterChangeSelection = findElement(productName).getText();
        assertThat("First product should be change.", productNameText, is(not(equalTo(productNameAfterChangeSelection))));
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }

    public IListingPageTestNG clickFilterAndChangeSelections() {
        clickWithBy(filterBar);
        clickWithBy(clickBrandAtFilter);
        clickWithBy(selectBrand);
        clickWithBy(filterApplyBtn);
        clickWithBy(applyAndCloseFilterBtn);
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }

    public IListingPageTestNG clearFilterSelection() {
        clickWithBy(filterBar);
        clickWithBy(clearFilters);
        clickWithBy(applyAndCloseFilterBtn);
        return PageFactoryTestNg.getInstance().createPage(IListingPageTestNG.class);
    }

    public ILoginTestNG clickFavoriteIcon()  {
        clickBy(favoriteIcon, "Favori ikonu bulunamadı.", "Favori ikonuna tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(ILoginTestNG.class);
    }

    public IAccountPageTestNG clickAccountIcon() {
        productNameText = getProductNameText();
        clickBy(accountIcon, "Hesabım ikonu bulunmadı.", "Hesabım ikonuna tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(IAccountPageTestNG.class);
    }

}
