package tests;

import helper.BaseTest;
import org.junit.Test;


public class
 AllTest extends BaseTest {
    public AllTest(String platform) {
        super(platform);
    }


  /*  public AllTest(String platform) {
         super(platform);
    }*/

    @Test()
    public void loginTest() throws InterruptedException{

        starting().start();/*.
                checkMainPage().
                clickMyAccount().
                clickLoginTab().
                loginAccountStarting().
                checkUser()*/;
    }

    @Test
    public void changeUserInfoTest(){

        starting()/*.
                checkMainPage().
                clickMyAccount().
                clickLoginTab().
                loginAccountStarting().
                checkUser().
                clickMyAccount().
                clickNameButton().
                changeName().
                saveName().
                clickMyAccount().
                checkName()*/;
    }

    @Test
    public void productDetail(){

        starting()/*.
                checkMainPage().
                clickMyAccount().
                clickLoginTab().
                loginAccountStarting().
                checkUser().
                clickOppurtunutiesOfDay().
                clickProduct().
                addFavorite().
                clickAccountButton().
                clickMyFavorite().
                checkfavoriteList()*/;

    }
}
