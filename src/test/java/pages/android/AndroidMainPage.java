package pages.android;

import base.PageFactory;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.Icommon.*;
import pages.Icommon.IAccountPage;
import pages.Icommon.IMainPage;
import pages.Icommon.IOpportunitiesPage;
import pages.Icommon.ISearchPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class AndroidMainPage extends MethodsPage implements IMainPage {

    private By myAccount = By.id("account_icon");
    private By oppurtunutiesOfDay = By.id("com.pozitron.hepsiburada:id/tv_home_title_deal_of_the_day");
    private By firstStory = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.ImageView");
    private By firstStoryText = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView");
    private By secondStoryText = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView");
    private By secondStory = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView");
    private By secondStoryButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.ImageView");
    private By mainPageTabButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[1]");
    private By searchBar = By.id("tv_explore_search");
    private By popupOkBtn = By.id("button1");
    private By successPopupTittle = By.id("alertTitle");
    private By closePopOver = By.id("pop_over_close");

    private String firstStoryName = "";
    private String secondStoryName = "";

    PageFactory pageFactory=new PageFactory();

    @Override
    public IMainPage start() {
        return null;
    }

    public  IAccountPage clickMyAccount() {
        log.info("------------------------------------------------------clickMyAccount metodu------");
       // mobilDriver.findElement(myAccount).click();
        clickBy(myAccount, "Hesabım butonuna tıklanamadı.");
        return pageFactory.getInstance().createPage(IAccountPage.class);
    }

    public IOpportunitiesPage clickOppurtunutiesOfDay(){
        findElementWithSwipe(oppurtunutiesOfDay,4);
        clickBy(oppurtunutiesOfDay,"Günün fırsatları butonu bulunamadı.","Günün fırsatları butonuna tıklandı.");
        wait(2);
        return pageFactory.getInstance().createPage(IOpportunitiesPage.class);
    }

    public IMainPage checkMainPage() {
        mobilDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertTrue("Anasayfa butonu bulunamadı.", isExist(mainPageTabButton));
        return pageFactory.getInstance().createPage(IMainPage.class);
    }

    public String getFirstStoryName() {

        return firstStoryName;
    }

    public String getSecondStoryName() {
        return secondStoryName;
    }

    public ISearchPage clickSearchBar() {
        clickBy(searchBar, "Search bar bulunamadı." , "Search bar'a tıklandı");
        return pageFactory.getInstance().createPage(ISearchPage.class);
    }

    public IMainPage checkAndClickSuccessLoginPopup() {
        String expectedPopupTitle = "Hoşgeldiniz";
        String popupTitle = findElement(successPopupTittle).getText();
        assertThat("Should be see success popup", expectedPopupTitle, is(equalTo(popupTitle)));
        click(popupOkBtn);
        return pageFactory.getInstance().createPage(IMainPage.class);
    }

    @Override
    public IMainPage enterAccount() {
        return null;
    }

    public void clickMainPageButtonTabBar(){
        clickBy(mainPageTabButton, "Anasayfa butonuna tıklandı.");
    }

    public IStoriesPage clickFirstStory() {

        clickMainPageButtonTabBar();

        firstStoryName = findElement(firstStoryText).getText();
        secondStoryName = findElement(secondStoryText).getText();

        clickBy(firstStory, "İlk hikaye bulunamadı.","İlk hikaye ye tıklandı.");
        return pageFactory.getInstance().createPage(IStoriesPage.class);
    }

    public IStoriesPage clickSecondStory() {

        clickMainPageButtonTabBar();

        clickBy(secondStoryButton, "İkinci hikaye bulunamadı.","İkinci hikayeye tıklandı.");
        return pageFactory.getInstance().createPage(IStoriesPage.class);
    }

    public IMainPage popOverClose(){
        click(closePopOver);
        return pageFactory.getInstance().createPage(IMainPage.class);
    }

}
