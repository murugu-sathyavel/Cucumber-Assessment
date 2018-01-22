package pages;

import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverImplementation;

public class AddNewBeneficiaryPage extends DriverImplementation{
	
	ResourceBundle element;
	
	public AddNewBeneficiaryPage(){
		
		element = ResourceBundle.getBundle("utils.elements");
		
	}
	
	public void enterPayeeName(String payeeName) {
		try {
			driver.findElement(By.cssSelector(element.getString("BP_payeeName_css"))).sendKeys(payeeName);
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void enterPayeeNickName(String nickName) {
		try {
			driver.findElement(By.xpath(element.getString("BP_payeeNickname_xpath"))).sendKeys(nickName);
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		
	}
	
	public void enterAccountNo(String AccNumber) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(element.getString("BP_AccountNumberOwnBank_xpath")))));
			driver.findElement(By.xpath(element.getString("BP_AccountNumberOwnBank_xpath"))).sendKeys(AccNumber);
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void clickGetAccountDetails() {
		try {
			driver.findElement(By.xpath(element.getString("BP_clickGetAccountDetails_xpath"))).click();;
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public boolean verifyAccountName(String name) {
		boolean bReturn = false;
		try {
			String sText = driver.findElementByXPath(element.getString("BP_verifyAccountName_xpath")).getText();
			if (sText.equalsIgnoreCase(name)){
				bReturn = true;
			}else{
				bReturn = false;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bReturn;
	}
	
	public void clickProceed() {
		try {
			driver.findElement(By.xpath(element.getString("BP_clickProceed_xpath"))).click();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void selectDropdownAccountType(String Option) {
		try {
			driver.findElement(By.className(element.getString("BP_selectAccountTypeDropdown_className"))).click();
			List<WebElement> options = 	driver.findElements(By.xpath(element.getString("BP_SelectAccountType_xpath")));
			for (WebElement opt : options) {
	        	 System.out.println(opt.getText());
	           if (opt.getText().equals(options)) {
	               opt.click();
	              break;
	            }
	        }
			
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void enterOtheBankAccountNo(String val) {
		WebElement accountNo = driver.findElement(By.xpath(element.getString("BP_enterOtherBankAccNo_xpath")));
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(accountNo));
        accountNo.sendKeys(val);
		
	}
	
	public void enterConfirmAccNo(String accountNo) {
		try {
		driver.findElement(By.xpath(element.getString("BP_enteConfirmAccNo_xpath"))).sendKeys(accountNo);
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void enterIFSCCode(String code) {
		try {
			driver.findElement(By.xpath(element.getString("BP_enterIfscCode_xpath"))).sendKeys(code);
			}catch(NoSuchElementException e) {
				e.printStackTrace();
			}
	}
	
	public void enterPayeeMobile(String mobile) {
		WebElement mobileNum = driver.findElement(By.xpath(element.getString("BP_payeeMobile_xpath")));
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(mobileNum));
        mobileNum.sendKeys(mobile);
	}
	
	public void enterPayeeAddress(String address) {
		try {
			driver.findElement(By.xpath(element.getString("BP_PayeeAddress_xpath"))).sendKeys(address);
			}catch(NoSuchElementException e) {
				e.printStackTrace();
			}
	}
	
	public void enterPayeePincode(String code) {
		try {
			driver.findElement(By.xpath(element.getString("BP_payeePin_xpath"))).sendKeys(code);
			}catch(NoSuchElementException e) {
				e.printStackTrace();
			}
	}

}
