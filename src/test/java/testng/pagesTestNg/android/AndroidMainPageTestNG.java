package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class AndroidMainPageTestNG extends MethodsPage implements IMainPageTestNG {

    private By myAccount = By.id("iv_toolbar_user_account_menu");
    private By oppurtunutiesOfDay = By.id("com.pozitron.hepsiburada:id/tv_home_title_deal_of_the_day");
    private By firstStory = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.ImageView");
    private By firstStoryText = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView");
    private By secondStoryText = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView");
    private By secondStory = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView");
    private By secondStoryButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.ImageView");
    private By mainPageTabButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[1]");
     private By searchBar = By.id("tv_home_search");
    private By popupOkBtn = By.id("button1");
    private By successPopupTittle = By.id("alertTitle");

     String firstStoryName = "";
     String secondStoryName = "";

    public synchronized IAccountPageTestNG clickMyAccount() {
        log.info("------------------------------------------------------clickMyAccount metodu------");
        clickBy(myAccount,  "Hesabım butonuna tıklandı.","Hesabım butonuna tıklanamadı.");
        return PageFactoryTestNg.getInstance().createPage(IAccountPageTestNG.class);
    }
    public IOpportunitiesPageTestNG clickOppurtunutiesOfDay(){
        findElementWithSwipe(oppurtunutiesOfDay,4);
        clickBy(oppurtunutiesOfDay,"Günün fırsatları butonu bulunamadı.","Günün fırsatları butonuna tıklandı.");
        wait(2);
        return PageFactoryTestNg.getInstance().createPage(IOpportunitiesPageTestNG.class);
    }

    public IMainPageTestNG checkMainPage() {
        wait(1);
        Assert.assertTrue("Anasayfa butonu bulunamadı.", isExist(mainPageTabButton));
        return PageFactoryTestNg.getInstance().createPage(IMainPageTestNG.class);
    }

    public String getFirstStoryName() {
        return firstStoryName;
    }

    public String getSecondStoryName() {
        return secondStoryName;
    }

    public ISearchPageTestNG clickSearchBar() {
        clickBy(searchBar, "Search bar bulunamadı." , "Search bar'a tıklandı");
        return PageFactoryTestNg.getInstance().createPage(ISearchPageTestNG.class);
    }

    public IMainPageTestNG checkAndClickSuccessLoginPopup() {
        String expectedPopupTitle = "Hoşgeldiniz";
        String popupTitle = findElement(successPopupTittle).getText();
        assertThat("Should be see success popup", expectedPopupTitle, is(equalTo(popupTitle)));
        click(popupOkBtn);
        return PageFactoryTestNg.getInstance().createPage(IMainPageTestNG.class);
    }

    @Override
    public IMainPageTestNG enterAccount() {
        return null;
    }

    public void clickMainPageButtonTabBar(){
        clickBy(mainPageTabButton, "Anasayfa butonuna tıklandı.");
    }

    public IStoriesPageTestNG clickFirstStory() {

        clickMainPageButtonTabBar();

        firstStoryName = findElement(firstStoryText).getText();
        secondStoryName = findElement(secondStoryText).getText();

        clickBy(firstStory, "İlk hikaye bulunamadı.","İlk hikaye ye tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(IStoriesPageTestNG.class);
    }

    public IStoriesPageTestNG clickSecondStory() {

        clickMainPageButtonTabBar();

        clickBy(secondStoryButton, "İkinci hikaye bulunamadı.","İkinci hikayeye tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(IStoriesPageTestNG.class);
    }
}
