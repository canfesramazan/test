package tests;

import helper.BaseTest;
import org.junit.Test;

public class StoriesTest extends BaseTest {


    public StoriesTest(String platform) {
        super(platform);
    }

    /**
     *  *Hikaye Üzerinden Ürün Sayfasına Gitme
     *
     * Uygulama açılır
     * Gelen izin popup ekranı kapatılır
     * Gelen login ekranı kapatılır
     * Ana sayfanın geldiği görülür.
     * Ana sayfa yenilenir.
     * Hikayeler bölümünün geldiği görülür.
     * İlk hikayeye tıklanır.
     * Hikaye sayfasının geldiği görülür.
     * Hikaye linkine tıklanır.
     * Ürün sayfasının geldiği görülür.
     */
    @Test
    public void firstStoryClick() throws InterruptedException {
    starting()
                .start()
                .closeHxPopup()
                .clickFirstStory()
                .checkFirstStory()
                .clickFirstStoryLink()
                .checkStoryProductPage()
            ;
    }

    /*
    /**
     *  *Hikaye Üzerinden Ürün Sayfasına Gitme (İkinci Hikayeden)
     *
     * Uygulama açılır
     * Gelen izin popup ekranı kapatılır
     * Gelen login ekranı kapatılır
     * Ana sayfanın geldiği görülür.
     * Ana sayfa yenilenir.
     * Hikayeler bölümünün geldiği görülür.
     * İlk hikayeye tıklanır ardından hikayenin ikinci bölümüne geçilir.
     * İkinci bölümden sonra ikinci hikayeye geçilir.
     * Hikaye sayfasının geldiği görülür.
     * Hikaye linkine tıklanır.
     * Ürün sayfasının geldiği görülür.
     */
    /*@Test
    public void SecondStoryClick(){
    starting()
                .start()
                .closeLoginPopup()
                .clickFirstStory()
                .checkFirstStory()
                .clickSecondStoryPart()
                .checkSecondStoryPart()
                .clickSecondStory()
                .checkSecondStory()
                .clickSecondStoryLink()
                .checkStoryProductPage()
            ;
    }*/

    /**
     *  *Hikayeden Çıkma
     *
     * Uygulama açılır
     * Gelen izin popup ekranı kapatılır
     * Gelen login ekranı kapatılır
     * Ana sayfanın geldiği görülür.
     * Ana sayfa yenilenir.
     * Hikayeler bölümünün geldiği görülür.
     * İlk hikayeye tıklanır ardından hikayenin ikinci bölümüne geçilir.
     * İkinci bölümden sonra ikinci hikayeye geçilir.
     * Hikaye sayfasının geldiği görülür.
     * "X" butonuna tıklanır
     * Hikayeden çıkıldığı ve ana sayfanın geldiği gözlenir
     * İkinci Hikayeye tıklanır
     * Son tıklama yapılır
     * Hikayeden çıkıldığı ve ana sayfanın geldiği gözlenir
     */
    /*@Test
    public void ExitStory(){
        starting()
                .start()
                .closeLoginPopup()
                .clickFirstStory()
                .checkFirstStory()
                .clickSecondStoryPart()
                .checkSecondStoryPart()
                .clickSecondStory()
                .checkSecondStory()
                .clickXButton()
                .checkMainPage()
                .clickSecondStory()
                .StoryLastClick()
                .checkMainPage()
                ;
        }*/

    /**
     *  *Hikaye logosundaki linke gitme
     *
     * Uygulama açılır
     * Gelen izin popup ekranı kapatılır
     * Gelen login ekranı kapatılır
     * Ana sayfanın geldiği görülür.
     * Ana sayfa yenilenir.
     * Hikayeler bölümünün geldiği görülür.
     * İlk hikayeye tıklanır
     * Hikaye logosuna tıklanır
     * Sayfanın geldiği görülür.
     */
    /*@Test
    public void storyImageLink(){
        starting()
                .start()
                .closeLoginPopup()
                .clickFirstStory()
                .checkFirstStory()
                .clickStoryProfile()
                .checkStoryProfileLinkProductPage()
                .checkMainPage()
                ;

        }*/
    }
