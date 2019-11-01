package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.IAskUsTestNG;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class AndroidAskUsTestNG extends MethodsPage implements IAskUsTestNG {

    private By askUsTittleText = By.id("com.pozitron.hepsiburada.beta:id/tv_toolbar_title");

    public IAskUsTestNG checkAskUsTitle() {
        String getAskUsTittleText = findElement(askUsTittleText).getText();
        String expectedAskUsTittleText = "Bize Sorun";
        assertThat("Login should be success and check go to vouchers page", getAskUsTittleText, is(equalTo(expectedAskUsTittleText)));
        return PageFactoryTestNg.getInstance().createPage(IAskUsTestNG.class);
    }
}


