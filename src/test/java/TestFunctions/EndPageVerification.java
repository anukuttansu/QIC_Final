package TestFunctions;

import java.util.Properties;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Common.StringHelper;
import Common.WriteExcelData;
import Pages.AdditionalInfoPage;
import Pages.EndPage;

public class EndPageVerification extends BaseClass {
	public static WebDriverWait wait;
	public static Actions actions;
	public static Select select;

	@Test
	public void EndPageDetails() throws Exception {
		EndPage objects = new EndPage(driver);
		wait = new WebDriverWait(driver, 10);
		WriteExcelData report = new WriteExcelData();
		report.SetStatus(6, "Status", "Pass");
		//Back to previous page
		wait.until(ExpectedConditions.elementToBeClickable(objects.Back_Button()));
		objects.Back_Button().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.Proceed_Button()));
		objects.Proceed_Button().click();
		
		//Verification Total and net premium
		String TotalGrossAmount = objects.TotalPremium_Verify().getText();
		double Totalamt = StringHelper.getDoubleValue(TotalGrossAmount);
		
		String NetPremiumAmount = objects.NetPremium_Verify().getText();
		double Netamt = StringHelper.getDoubleValue(NetPremiumAmount);
		
		if (Totalamt == Netamt) {
			Assert.assertEquals(Totalamt, Netamt);
			System.out.println("Test case Amount verification passed");
			report.SetStatus(6, "Status", "Pass");

		} else {
			Assert.fail();
			System.out.println("Test case verification failed");
			System.out.println("Amount is not same");
			report.SetStatus(6, "Status", "Fail");

		}
		// Click Save as Quote
		wait.until(ExpectedConditions.elementToBeClickable(objects.SaveAsQuote_Button()));
		objects.SaveAsQuote_Button().click();
		report.SetStatus(14, "Status", "Pass");
		// Getting Quote no and Final verification
		String QuoteNoEndVerify = objects.QuoteNoEnd_Verify().getText(); 
		System.out.println("The Quote no " + QuoteNoEndVerify);
		report.SetStatus(15, "Status", "Pass");
		
		// Approve as policy
		wait.until(ExpectedConditions.elementToBeClickable(objects.ApproveAsPolicy_Button()));
		objects.ApproveAsPolicy_Button().click();
		String PolicyNo = objects.PolicyNo_Text().getText();
		// Printing Policy No
		System.out.println("The policy number is" + PolicyNo);
		// LogOUT
		wait.until(ExpectedConditions.elementToBeClickable(objects.Logout_Button()));
		report.SetStatus(7, "Status", "Pass");
		report.SetStatus(8, "Status", "Pass");
		report.SetStatus(16, "Status", "Pass");
		report.SetStatus(17, "Status", "Pass");
		report.SetStatus(18, "Status", "Pass");
		report.SetStatus(19, "Status", "Pass");
		report.SetStatus(20, "Status", "Pass");
		objects.Logout_Button().click();
	}
}
