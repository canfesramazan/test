package testng.pagesTestNg.Icommon;

public interface IMainPageTestNG {
    IAccountPageTestNG clickMyAccount();
    IOpportunitiesPageTestNG clickOppurtunutiesOfDay();
    IMainPageTestNG enterAccount();
    IMainPageTestNG checkMainPage();
    IStoriesPageTestNG clickFirstStory();
    IStoriesPageTestNG clickSecondStory();
    ISearchPageTestNG clickSearchBar();
    IMainPageTestNG checkAndClickSuccessLoginPopup();
}
