package MobileTesting;

import extentions.MobileActions;
import extentions.Verifications;
import org.testng.annotations.Test;
import utilities.CommonOps;

public class MortgageMobile extends CommonOps {
    @Test( description = "Test01 - verify Mortgage")
    public void Test01_verifyMortgage()  {
        MobileActions.updateText( mortgageMain.txt_amount, "800");
        MobileActions.updateText( mortgageMain.txt_term, "5");
        MobileActions.updateText( mortgageMain.txt_rate, "3");
        MobileActions.tap( mortgageMain.calculate_btn);
        Verifications.verifyTextInElement(mortgageMain.txt_repayment, "£14.56");
    }
}
