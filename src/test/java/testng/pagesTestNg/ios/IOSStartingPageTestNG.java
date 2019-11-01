package testng.pagesTestNg.ios;

import base.PageFactory;
import helper.MethodsPage;
import org.openqa.selenium.By;
import testng.pagesTestNg.Icommon.ILoginTestNG;
import testng.pagesTestNg.Icommon.IStartingPageTestNG;

//import sun.jvm.hotspot.debugger.Page;


public class IOSStartingPageTestNG extends MethodsPage implements IStartingPageTestNG {


    private By permissionAllow=By.id("Allow");
    private By closeLoginPopupButton=By.id("Kapat");
    private By closeProductCategoriesPopupButton=By.id("com.pozitron.hepsiburada:id/showcase_button");
    private By logo=By.id("Hepsiburada");

    PageFactory pageFactory=new PageFactory();

    public ILoginTestNG start(){

        clickBy(permissionAllow,"Konum izni verildi");
        clickBy(permissionAllow,"Notification izni verildi");

        return pageFactory.createPage(ILoginTestNG.class);
    }

}
