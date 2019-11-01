package pages.Icommon;

public interface ISearchPage {

    ISearchPage writeWordAndSearch();
    IListingPage clickFirstSuggestion();
    IListingPage searchFromKeyword();
    ISearchPage allHistoryClearAtSearch();
    ISearchPage checkAllHistoryClearBtnPresent();
    ISearchPage writeOneCharacter();
    ISearchPage checkThereIsNoSuggestion();
    ISearchPage checkNotChangePage();
    ISearchPage searchFromKeywordForOneCharacter();
    ISearchPage writeStaticWord();
}
