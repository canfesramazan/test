package pages.Icommon;

public interface IMainPage {
    IMainPage start();
    IAccountPage clickMyAccount();
    IOpportunitiesPage clickOppurtunutiesOfDay();
    IMainPage enterAccount();
    IMainPage checkMainPage();
    IStoriesPage clickFirstStory();
    IStoriesPage clickSecondStory();
    ISearchPage clickSearchBar();
    IMainPage checkAndClickSuccessLoginPopup();
    IMainPage popOverClose();

}
