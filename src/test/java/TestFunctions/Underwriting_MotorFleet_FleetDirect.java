package TestFunctions;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common.BaseClass;
import Common.JiraPolicy;
import Common.WriteExcelData;
import Pages.LandingPage;
import Pages.LoginPage;
import Pages.Underwriting_FleetDirectPage;


public class Underwriting_MotorFleet_FleetDirect extends BaseClass {

	public static WebDriverWait wait;
	public static Actions actions;
	public static Select select;
	@JiraPolicy(logTicketReady = true)
	@Test(priority = 1)
	public void CreateDirectFleet() throws Exception {

		Underwriting_FleetDirectPage objects = new Underwriting_FleetDirectPage(driver);
		WriteExcelData report = new WriteExcelData();
		report.SetStatus(4, "Status", "Not Executed");
		wait = new WebDriverWait(driver, 10);
		Thread.sleep(2000);
		objects.UnderwritingBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.MotorFleet_SubMenu()));
		objects.MotorFleet_SubMenu().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.DirectFleet_Option()));
		objects.DirectFleet_Option().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SelectCust_Lookup()));
		objects.SelectCust_Lookup().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.cust_SearchField()));
		objects.cust_SearchField().sendKeys(prop.getProperty("CustomerCode"));
		wait.until(ExpectedConditions.elementToBeClickable(objects.select_Cust()));
		objects.select_Cust().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.CivilIDField()));
		objects.CivilIDField().sendKeys(prop.getProperty("CivilId"));
		objects.PONum_Field().sendKeys(prop.getProperty("PO"));
		objects.Mobile_Field().sendKeys(prop.getProperty("Mobile"));
		Thread.sleep(3000);
		
		
		select = new Select(objects.selectCity());
		select.selectByValue("012012");
		objects.Fax().click();
		Thread.sleep(2000);	
		actions = new Actions(driver);
		actions.moveToElement(objects.proceedBtn());
		Thread.sleep(2000);	
		actions.moveToElement(objects.proceedBtn());
		actions.perform();

		
		objects.proceedBtn().click();
		report.SetStatus(4, "Status", "Pass");
		
		
		
		
	}
}
