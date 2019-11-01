package pages.Icommon;

public interface IStoriesPage {
    IStoriesPage checkFirstStory();
    IProductPage clickFirstStoryLink();
    IStoriesPage checkSecondStory();
    IProductPage clickSecondStoryLink();
    IStoriesPage clickSecondStoryPart();
    IStoriesPage checkSecondStoryPart();
    IStoriesPage clickSecondStory();
    IMainPage clickXButton();
    IMainPage StoryLastClick();
    IProductPage clickStoryProfile();

}
