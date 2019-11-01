package pages.ios;

import base.PageFactory;
import helper.MethodsPage;
import org.openqa.selenium.By;
import pages.Icommon.*;

public class IOSStartingPage extends MethodsPage implements IStartingPage {

    PageFactory pageFactory=new PageFactory();

    private By permissionAllow=By.id("Allow");
    private By closeLoginPopupButton=By.id("Kapat");
    private By closeProductCategoriesPopupButton=By.id("com.pozitron.hepsiburada:id/showcase_button");
    private By logo=By.id("Hepsiburada");

    public ILogin start(){

        clickBy(permissionAllow,"Konum izni verildi");
        clickBy(permissionAllow,"Notification izni verildi");

        return pageFactory.createPage(ILogin.class);
    }

}
