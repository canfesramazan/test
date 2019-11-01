package testng.pagesTestNg.Icommon;

public interface ISearchPageTestNG {

    ISearchPageTestNG writeWordAndSearch();
    IListingPageTestNG clickFirstSuggestion();
    IListingPageTestNG searchFromKeyword();
    ISearchPageTestNG allHistoryClearAtSearch();
    ISearchPageTestNG checkAllHistoryClearBtnPresent();
    ISearchPageTestNG writeOneCharacter();
    ISearchPageTestNG checkThereIsNoSuggestion();
    ISearchPageTestNG checkNotChangePage();
    ISearchPageTestNG searchFromKeywordForOneCharacter();
    ISearchPageTestNG writeStaticWord();
}
