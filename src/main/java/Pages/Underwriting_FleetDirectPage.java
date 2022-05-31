package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Underwriting_FleetDirectPage {
	WebDriver driver;

	public Underwriting_FleetDirectPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
    }
	
	
	
	@FindBy(xpath = "//li/ul/child::a[1]")
	WebElement UnderwritingBtn;

	public WebElement UnderwritingBtn() {
		return UnderwritingBtn;

	}
	
	@FindBy(xpath = "//li/div[@id='Underwriting_1']/a/span[@class='menuItemArrow']")
	WebElement MotorFleet_SubMenu;

	public WebElement MotorFleet_SubMenu() {
		return MotorFleet_SubMenu;

	}
	
	@FindBy(xpath = "//div[@id='MotorFleet_1_1']/a")
	WebElement DirectFleet_Option;

	public WebElement DirectFleet_Option() {
		return DirectFleet_Option;

	}
	
	@FindBy(xpath = "//*[@id=\"FleetQuoteProcess\"]/div[2]/table/tbody/tr[3]/td[2]/input[2]")
	WebElement SelectCust_Lookup;

	public WebElement SelectCust_Lookup() {
		return SelectCust_Lookup;

	}
	
	
	@FindBy(xpath = "//label[text()='Search:']")
	WebElement cust_SearchField;

	public WebElement cust_SearchField() {
		return cust_SearchField;	
 }
	
	@FindBy(xpath = "//input[@value='101890']")
	WebElement select_Cust;

	public WebElement select_Cust() {
		return select_Cust;	
 }
	
	@FindBy(xpath = "//input[@id='civilId']")
	WebElement CivilIDField;

	public WebElement CivilIDField() {
		return CivilIDField;	
 }
	
	@FindBy(xpath = "//div[@id='message']")
	WebElement errorMsg;

	public WebElement errorMsg() {
		return errorMsg;	
 }
	
	@FindBy(xpath = "//input[@name='poBox']")
	WebElement PONum_Field;

	public WebElement PONum_Field() {
		return PONum_Field;	
 }
	
	@FindBy(xpath = "//input[@name='mobile']")
	WebElement Mobile_Field;

	public WebElement Mobile_Field() {
		return Mobile_Field;	
 }
	
	@FindBy(xpath = "//select[@id='city']")
	WebElement selectCity;

	public WebElement selectCity() {
		return selectCity;	
 }
	
	@FindBy(xpath = "//input[@name='mobile']")
	WebElement proceedBtn;

	public WebElement proceedBtn() {
		return proceedBtn;	
 }
	
	@FindBy(xpath = "//input[@id='fax']")
	WebElement Fax;

	public WebElement Fax() {
		return Fax;	
 }
}