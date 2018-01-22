package pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.Actions;

import drivers.DriverImplementation;

//import stepdefenition.Hooks;

public class DashBoard extends DriverImplementation{
	
	ResourceBundle element;
	//RemoteWebDriver driver;
	
	public DashBoard(){
		
		//this.driver = driver;
		
		element = ResourceBundle.getBundle("utils.elements");
		
	}
	
public boolean verifyBalanceInDashBoard(String amount){
		
		String balanceAmount = getBalanceAmount();
		
		if(amount.equals(balanceAmount)){
			return true;
		}else{
			return false;
		}
	}

public String getBalanceAmount(){
	
	String balance = null;
	
	try {
	
	WebElement row = driver.findElement(By.className(element.getString("db_balanceAmounttableRow_className")));
	
	List<WebElement> cols = row.findElements(By.tagName("td"));
	
	System.out.println(cols.size());
	
	String amountString = cols.get(5).getText();
	
	System.out.println(amountString);
	
	int index = amountString.lastIndexOf(")");
	
	balance = amountString.substring(index+1);
	
	System.out.println(balance);
	}catch(NoSuchElementException e) {
		e.printStackTrace();
	}
	
	return balance;
	}

	public void moveToPayments() {
		
		
			try{
				new Actions(driver).moveToElement(driver.findElement(By.xpath(element.getString("db_clickpayments_xpath")))).build().perform();
				Thread.sleep(5000);
			}catch(NoSuchElementException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		
	}
	
	public void clickTransferFunds() {
		try {
			driver.findElement(By.xpath(element.getString("db_clickTransferFunds_xpath"))).click();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		
	}


}
