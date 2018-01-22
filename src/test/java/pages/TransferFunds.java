package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import drivers.DriverImplementation;

public class TransferFunds extends DriverImplementation{
	
	ResourceBundle element;
	
	List<String>  names;
		
	public TransferFunds(){
		
		element = ResourceBundle.getBundle("utils.elements");
		
	}
	
	public void clickAddNewBeneficiary() {
		try {
			driver.findElement(By.xpath(element.getString("TF_clickAddNewPayee_xpath"))).click();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
public List<String> listOfBeneficiarys(){
		
		names = new ArrayList<String>();
		
		WebElement table = driver.findElement(By.xpath(element.getString("TF_PayeeTable_xpath")));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for(int i=0;i<rows.size();i++){
			
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			
			for(int j=0;j<cols.size();j++){
				
				if(cols.get(j).getText().equalsIgnoreCase("Active")){
					System.out.println(cols.get(j-1).getText());
					names.add(cols.get(j-1).getText());
				}
				
					
				}
			}

		return names;
		
		
	}
	
	public boolean compareBeneficiarys(List<String> l){
		
		List<String> payeeNames = listOfBeneficiarys();
		
		Collections.sort(l);
	    Collections.sort(payeeNames);      
	    return payeeNames.equals(l);

		
	}

}
