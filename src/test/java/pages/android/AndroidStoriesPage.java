package pages.android;

import base.PageFactory;
import helper.MethodsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.Icommon.IMainPage;
import pages.Icommon.IProductPage;
import pages.Icommon.IStoriesPage;

public class AndroidStoriesPage extends MethodsPage implements IStoriesPage {
    private By firstStoryTitle = By.id("com.pozitron.hepsiburada.beta:id/tv_story_title");
    private By firstStoryBody = By.id("com.pozitron.hepsiburada.beta:id/iv_story_bg");
    private By secondStoryTitle = By.id("com.pozitron.hepsiburada.beta:id/tv_story_title");
    private By firstStorySecondPartTitle = By.id("com.pozitron.hepsiburada.beta:id/tv_story_title");
    private By firstStoryLink = By.id("com.pozitron.hepsiburada.beta:id/tv_story_link");
    private By exitButton = By.id("com.pozitron.hepsiburada.beta:id/iv_story_profile_close");
    private By storyProfile = By.id("com.pozitron.hepsiburada.beta:id/civ_story_profile_preview");

 //   static String firstStoryLinkName = "";

    PageFactory pageFactory=new PageFactory();

    private AndroidMainPage androidMainPage = new AndroidMainPage();

    public IStoriesPage checkFirstStory() {
 //       firstStoryLinkName=findElement(firstStoryLink).getText();
    //    Assert.assertTrue("İlk hikayenin ismi ile hikaye başlığı eşleşmedi", findElement(firstStoryTitle).getText().equals(androidMainPage.getFirstStoryName()));
        return pageFactory.getInstance().createPage(IStoriesPage.class);
    }

    public IStoriesPage clickSecondStoryPart(){
        clickBy(firstStoryBody,"Hikayenin ikinci bölümüne tıklanamdı","Hikayenin ikinci bölümüne tıklandı.");
        return pageFactory.getInstance().createPage(IStoriesPage.class);
    }

    public IMainPage StoryLastClick(){
        clickBy(firstStoryBody,"Hikayenin ikinci bölümüne tıklanamdı","Hikayenin ikinci bölümüne tıklandı.");
        return pageFactory.getInstance().createPage(IMainPage.class);
    }

    public IStoriesPage checkSecondStoryPart(){
        wait(2);
        Assert.assertTrue("Birinci hikayenin ilk partın başlığı ile ikinci partın başlığı eşleşmedi", findElement(firstStoryTitle).getText().equals(findElement(firstStorySecondPartTitle).getText()));
   //     Assert.assertFalse("Birinci hikayenin linki  ile ikinci partın linki eşleşdi", firstStoryLinkName.equals(findElement(firstStoryLink).getText()));
        return pageFactory.getInstance().createPage(IStoriesPage.class);
    }

    public IStoriesPage clickSecondStory() {
        clickBy(firstStoryBody,"ikinci Hikaye bölümüne tıklanamdı","ikinci Hikaye bölümüne tıklandı.");
        return pageFactory.getInstance().createPage(IStoriesPage.class);
    }

    public IStoriesPage checkSecondStory() {
     //   Assert.assertTrue("İkinci hikayenin ismi ile hikaye başlığı eşleşmedi", findElement(secondStoryTitle).getText().equals(androidMainPage.getSecondStoryName()));
        return pageFactory.getInstance().createPage(IStoriesPage.class);
    }

    public IProductPage clickFirstStoryLink() {
        clickBy(firstStoryLink, "İlk hikaye linkine tıklanamadı", "İlk hikaye linkine tıklandı.");
        return pageFactory.getInstance().createPage(IProductPage.class);
    }

    public IProductPage clickSecondStoryLink() {
        clickBy(firstStoryLink, "İkinci hikaye linkine tıklanamadı", "İkinci hikaye linkine tıklandı.");
        return pageFactory.getInstance().createPage(IProductPage.class);
    }

    public IMainPage clickXButton() {
        clickBy(exitButton, "X butonuna tıklanamadı", "X butonuna tıklandı tıklandı.");
        return pageFactory.getInstance().createPage(IMainPage.class);
    }
    public IProductPage clickStoryProfile() {
        clickBy(storyProfile, "Story profile butonuna tıklanamadı", "Story profile butonuna tıklandı.");
         return pageFactory.getInstance().createPage(IProductPage.class);
    }

}
