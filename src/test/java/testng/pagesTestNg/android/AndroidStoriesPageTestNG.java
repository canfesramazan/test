package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.IMainPageTestNG;
import testng.pagesTestNg.Icommon.IProductPageTestNG;
import testng.pagesTestNg.Icommon.IStoriesPageTestNG;

public class AndroidStoriesPageTestNG extends MethodsPage implements IStoriesPageTestNG {
    private By firstStoryTitle = By.id("com.pozitron.hepsiburada.beta:id/tv_story_title");
    private By firstStoryBody = By.id("com.pozitron.hepsiburada.beta:id/iv_story_bg");
    private By secondStoryTitle = By.id("com.pozitron.hepsiburada.beta:id/tv_story_title");
    private By firstStorySecondPartTitle = By.id("com.pozitron.hepsiburada.beta:id/tv_story_title");
    private By firstStoryLink = By.id("com.pozitron.hepsiburada.beta:id/tv_story_link");
    private By exitButton = By.id("com.pozitron.hepsiburada.beta:id/iv_story_profile_close");
    private By storyProfile = By.id("com.pozitron.hepsiburada.beta:id/civ_story_profile_preview");

    static String firstStoryLinkName = "";

    private AndroidMainPageTestNG androidMainPage = new AndroidMainPageTestNG();

    public IStoriesPageTestNG checkFirstStory() {
        firstStoryLinkName=findElement(firstStoryLink).getText();
        Assert.assertTrue("İlk hikayenin ismi ile hikaye başlığı eşleşmedi", findElement(firstStoryTitle).getText().equals(androidMainPage.getFirstStoryName()));
        return PageFactoryTestNg.getInstance().createPage(IStoriesPageTestNG.class);
    }

    public IStoriesPageTestNG clickSecondStoryPart(){
        clickBy(firstStoryBody,"Hikayenin ikinci bölümüne tıklanamdı","Hikayenin ikinci bölümüne tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(IStoriesPageTestNG.class);
    }

    public IMainPageTestNG StoryLastClick(){
        clickBy(firstStoryBody,"Hikayenin ikinci bölümüne tıklanamdı","Hikayenin ikinci bölümüne tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(IMainPageTestNG.class);
    }

    public IStoriesPageTestNG checkSecondStoryPart(){
        wait(2);
        Assert.assertTrue("Birinci hikayenin ilk partın başlığı ile ikinci partın başlığı eşleşmedi", findElement(firstStoryTitle).getText().equals(findElement(firstStorySecondPartTitle).getText()));
        Assert.assertFalse("Birinci hikayenin linki  ile ikinci partın linki eşleşdi", firstStoryLinkName.equals(findElement(firstStoryLink).getText()));
        return PageFactoryTestNg.getInstance().createPage(IStoriesPageTestNG.class);
    }

    public IStoriesPageTestNG clickSecondStory() {
        clickBy(firstStoryBody,"ikinci Hikaye bölümüne tıklanamdı","ikinci Hikaye bölümüne tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(IStoriesPageTestNG.class);
    }

    public IStoriesPageTestNG checkSecondStory() {
        Assert.assertTrue("İkinci hikayenin ismi ile hikaye başlığı eşleşmedi", findElement(secondStoryTitle).getText().equals(androidMainPage.getSecondStoryName()));
        return PageFactoryTestNg.getInstance().createPage(IStoriesPageTestNG.class);
    }

    public IProductPageTestNG clickFirstStoryLink() {
        clickBy(firstStoryLink, "İlk hikaye linkine tıklanamadı", "İlk hikaye linkine tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(IProductPageTestNG.class);
    }

    public IProductPageTestNG clickSecondStoryLink() {
        clickBy(firstStoryLink, "İkinci hikaye linkine tıklanamadı", "İkinci hikaye linkine tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(IProductPageTestNG.class);
    }

    public IMainPageTestNG clickXButton() {
        clickBy(exitButton, "X butonuna tıklanamadı", "X butonuna tıklandı tıklandı.");
        return PageFactoryTestNg.getInstance().createPage(IMainPageTestNG.class);
    }
    public IProductPageTestNG clickStoryProfile() {
        clickBy(storyProfile, "Story profile butonuna tıklanamadı", "Story profile butonuna tıklandı.");
         return PageFactoryTestNg.getInstance().createPage(IProductPageTestNG.class);
    }

}
