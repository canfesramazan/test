package testng.pagesTestNg.android;

import testng.PageFactoryTestNg;
import helper.MethodsPage;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.IMyMessagesTestNG;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class AndroidMyMessagesTestNG extends MethodsPage implements IMyMessagesTestNG {

    private By myMessagesTittleText = By.id("com.pozitron.hepsiburada.beta:id/tv_toolbar_title");

    public IMyMessagesTestNG checkMyMessagesTitle() {
        String getMyMessagesTittleText = findElement(myMessagesTittleText).getText();
        String expectedMyMessagesTittleText = "Mesajlarım";
        assertThat("Login should be success and check go to vouchers page", getMyMessagesTittleText, is(equalTo(expectedMyMessagesTittleText)));
        return PageFactoryTestNg.getInstance().createPage(IMyMessagesTestNG.class);
    }


}
