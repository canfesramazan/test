package testsTestNG.regresyon;

import testng.ParalelBaseTest;
import org.testng.annotations.Test;


public class AllTestTestNg extends ParalelBaseTest {
    @Test()
    public void loginTest(){
starting();
     /*   starting().
                checkMainPage().
                clickMyAccount().
                clickLoginTab().
                enterAccount().
                checkUser();*/
    }
    @Test()
    public void changeUserInfoTest(){
        starting();

       /* starting().
                checkMainPage().
                clickMyAccount().
                clickLoginTab().
                enterAccount().
                checkUser().
                clickMyAccount().
                clickNameButton().
                changeName().
                saveName().
                clickMyAccount().
                checkName();*/
    }
    @Test()
    public void productDetail(){
        starting();

      /*  starting().
                checkMainPage().
                clickMyAccount().
                clickLoginTab().
                enterAccount().
                checkUser().
                clickOppurtunutiesOfDay().
                clickProduct().
                addFavorite().
                clickAccountButton().
                clickMyFavorite().
                checkfavoriteList();
*/

    }
}
