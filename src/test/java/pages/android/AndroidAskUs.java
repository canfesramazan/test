package pages.android;

import base.PageFactory;
import helper.MethodsPage;
import org.openqa.selenium.By;
import pages.Icommon.IAskUs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class AndroidAskUs extends MethodsPage implements IAskUs {

    private By askUsTittleText = By.id("com.pozitron.hepsiburada.beta:id/tv_toolbar_title");

    PageFactory pageFactory=new PageFactory();

    public IAskUs checkAskUsTitle() {
        String getAskUsTittleText = findElement(askUsTittleText).getText();
        String expectedAskUsTittleText = "Bize Sorun";
        assertThat("Login should be success and check go to vouchers page", getAskUsTittleText, is(equalTo(expectedAskUsTittleText)));
        return pageFactory.getInstance().createPage(IAskUs.class);
    }
}


