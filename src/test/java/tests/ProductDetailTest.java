package tests;

import helper.BaseTest;
import org.junit.Test;

public class ProductDetailTest  extends BaseTest {

    public ProductDetailTest(String platform) {
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
    public void clickProductDetailAndCheck() throws InterruptedException {
        starting()
                .start()
                .closeHxPopup()
                .clickFirstStory()
                .checkFirstStory()
                .clickFirstStoryLink()
        ;
    }
}
