package pages.android;

import base.PageFactory;
import helper.MethodsPage;
import org.openqa.selenium.By;
import pages.Icommon.IMyGiftVoucherPage;
import pages.Icommon.IMyMessages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class AndroidMyMessages extends MethodsPage implements IMyMessages {

    private By myMessagesTittleText = By.id("com.pozitron.hepsiburada.beta:id/tv_toolbar_title");

    PageFactory pageFactory=new PageFactory();

    public IMyMessages checkMyMessagesTitle() {
        String getMyMessagesTittleText = findElement(myMessagesTittleText).getText();
        String expectedMyMessagesTittleText = "Mesajlarım";
        assertThat("Login should be success and check go to vouchers page", getMyMessagesTittleText, is(equalTo(expectedMyMessagesTittleText)));
        return pageFactory.getInstance().createPage(IMyMessages.class);
    }


}
