package testsTestNG.sigleTests;

import org.testng.annotations.Test;
import testng.ParalelBaseTest;

public class LoginTestTestNG extends ParalelBaseTest {


   /* public LoginTest(String platform) {
        super(platform);
    }
*/
    @Test()
    public void loginTest(){

        starting()
                .start()
                .closeLoginPopup()
                .clickMyAccount()
                .clickGiftVoucher()
                .loginAccountFromMyGiftVoucher()
                .checkMyGiftVoucherTitle()
        ;
    }
}
