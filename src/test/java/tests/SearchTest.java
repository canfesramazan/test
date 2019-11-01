package tests;

import surfire.BaseTest;
import org.junit.Test;

public class SearchTest extends BaseTest {

  /*  public SearchTest(String platform) {
        super(platform);
    }
*/
    /** @RC
     * Konum izni varsa kapatıldı.
     * Login sayfası kapatıldı.
     * Arama kutusuna tıklandı.
     * Standart kelime yazıldı.
     * Klavyeden arama tuşuna basıldı.
     * Listeleme sayfasından arama sayfasına geri dönüldü.
     * Arama geçmişi temizlendi.
     * Arama geçmişinin temizlendiği kontrol edildi.
     */
    @Test
    public void searchWithStandardWord() throws InterruptedException{
        starting()
                .start()
                .closeHxPopup()
                .popOverClose()
                .clickSearchBar()
                .writeWordAndSearch()
                .searchFromKeyword()
                .checkSearchWord()
                .backSearchPage()
                .allHistoryClearAtSearch()
                .checkAllHistoryClearBtnPresent();
    }

    /** @RC
     * Konum izni varsa kapatıldı.
     * Login sayfası kapatıldı.
     * Arama kutusuna tıklandı.
     * Standart kelime yazıldı.
     * İlk suggestiona tıklandı.
     * Listeleme sayfasından arama sayfasına geri dönüldü.
     * Arama geçmişi temizlendi.
     * Arama geçmişinin temizlendiği kontrol edildi.
     */
    @Test
    public void searchWithStandardWordAndSuggestion()throws InterruptedException{
        starting()
                .start()
                .closeHxPopup()
                .clickSearchBar()
                .writeWordAndSearch()
                .clickFirstSuggestion()
                .backSearchPage()
                .allHistoryClearAtSearch()
                .checkAllHistoryClearBtnPresent();
    }

    /** @RC
     * Konum izni varsa kapatıldı.
     * Login sayfası kapatıldı.
     * Arama kutusuna tıklandı.
     * 1 karakter yazıldı.
     * Klavyeden arama tuşuna basıldı.
     * Suggesitonun çıkmadığı kontrol edilmeli.
     * Aramaya basınca sayfanın değişmediği kontrol edilmeli.
     */
    @Test
    public void searchWithOnecharacter()throws InterruptedException{
        starting()
                .start()
                .closeHxPopup()
                .clickSearchBar()
                .writeOneCharacter()
                .searchFromKeywordForOneCharacter()
                .checkThereIsNoSuggestion()
                .checkNotChangePage();
    }


    /**
     * Konum izni varsa kapatıldı.
     * Login sayfası kapatıldı.
     * Arama kutusuna tıklandı.
     * Statik bir kelime ile arama yapılır.
     * Klavyeden arama tuşuna basıldı.
     * 1. tooltip'in geldiği kontrol edilir ve kapatılır.
     * 2. tooltip'in geldiği kontrol edilir ve kapatılır.
     * Öneriler alan sağa doğru kaydırılır.
     * Sağa kaydırılabildiği ve ve en sondaki öneri kutusu kontrol edilir.
     * Öneri kutusuna tıklanır.
     * Açılan sayfada önerilerin gösterilmediği kontrol edilir.
     */
    @Test
    public void listingPageSuggestion() throws InterruptedException{
        starting()
                .start()
                .closeHxPopup()
                .clickSearchBar()
                .writeStaticWord()
                .searchFromKeyword()
                .checkAndClickFirstTooltip()
                .checkAndClickSecondTooltip()
                .swipeRightAtListingPage()
                .checkSwipeAndSuggestion()
                .clickListingPageSuggestion()
                .checkThereIsNoSuggestion();
    }

    /**
     * Konum izni varsa kapatıldı.
     * Login sayfası kapatıldı.
     * Arama kutusuna tıklandı.
     * Statik bir kelime ile arama yapılır.
     * Klavyeden arama tuşuna basıldı.
     * 1. tooltip'in geldiği kontrol edilir ve kapatılır.
     * 2. tooltip'in geldiği kontrol edilir ve kapatılır.
     * Aşağıya doğru scroll edilir.
     * Sıralama seçeneği değiştirilir.
     * İlk ürünün değiştiği kontrol edilir.
     */
    @Test
    public void listingPageChangeSortSettings() throws InterruptedException{
        starting()
                .start()
                .closeHxPopup()
                .clickSearchBar()
                .writeStaticWord()
                .searchFromKeyword()
                .checkAndClickFirstTooltip()
                .checkAndClickSecondTooltip()
                .scrollDown()
                .changeSortSelection()
                .checkFirstProductIsChange();
    }

    /**
     * Konum izni varsa kapatıldı.
     * Login sayfası kapatıldı.
     * Arama kutusuna tıklandı.
     * Statik bir kelime ile arama yapılır.
     * Klavyeden arama tuşuna basıldı.
     * 1. tooltip'in geldiği kontrol edilir ve kapatılır.
     * 2. tooltip'in geldiği kontrol edilir ve kapatılır.
     * Aşağıya doğru scroll edilir.
     * Filtre alanına tıklanır ve filtreleme yapılır.
     * Yukarıya doğru scroll edilir.
     * Öneri kutularının olmadığı kontrol edilir.
     * Filtreler temizlenir.
     * Yukarıya doğru scroll edilir.
     * Öneri kutularının olduğu kontrol edilir.
     */
    @Test
    public void listingPageChangeFilterSettings() throws InterruptedException{
        starting()
                .start()
                .closeHxPopup()
                .clickSearchBar()
                .writeStaticWord()
                .searchFromKeyword()
                .checkAndClickFirstTooltip()
                .checkAndClickSecondTooltip()
                .scrollDown()
                .clickFilterAndChangeSelections()
                .scrollUp()
                .checkThereIsNoSuggestion()
                .clearFilterSelection()
                .scrollUp()
                .checkThereIsSuggestion();
    }


}
