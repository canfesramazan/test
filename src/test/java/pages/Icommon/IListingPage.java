package pages.Icommon;

public interface IListingPage {

    ISearchPage backSearchPage();
    IListingPage checkSearchWord();
    IListingPage checkAndClickFirstTooltip();
    IListingPage checkAndClickSecondTooltip();
    IListingPage swipeRightAtListingPage();
    IListingPage checkSwipeAndSuggestion();
    IListingPage clickListingPageSuggestion();
    IListingPage checkThereIsNoSuggestion();
    IListingPage clickSortBtn();
    IListingPage scrollDown();
    String getProductNameText();
    IListingPage changeSortSelection();
    IListingPage checkFirstProductIsChange();
    IListingPage scrollUp();
    IListingPage clickFilterAndChangeSelections();
    IListingPage clearFilterSelection();
    IListingPage checkThereIsSuggestion();
    ILogin clickFavoriteIcon();
    IAccountPage clickAccountIcon();


}
