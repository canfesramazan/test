package testng.pagesTestNg.Icommon;

public interface IListingPageTestNG {

    ISearchPageTestNG backSearchPage();
    IListingPageTestNG checkSearchWord();
    IListingPageTestNG checkAndClickFirstTooltip();
    IListingPageTestNG checkAndClickSecondTooltip();
    IListingPageTestNG swipeRightAtListingPage();
    IListingPageTestNG checkSwipeAndSuggestion();
    IListingPageTestNG clickListingPageSuggestion();
    IListingPageTestNG checkThereIsNoSuggestion();
    IListingPageTestNG clickSortBtn();
    IListingPageTestNG scrollDown();
    String getProductNameText();
    IListingPageTestNG changeSortSelection();
    IListingPageTestNG checkFirstProductIsChange();
    IListingPageTestNG scrollUp();
    IListingPageTestNG clickFilterAndChangeSelections();
    IListingPageTestNG clearFilterSelection();
    IListingPageTestNG checkThereIsSuggestion();
    ILoginTestNG clickFavoriteIcon();
    IAccountPageTestNG clickAccountIcon();


}
