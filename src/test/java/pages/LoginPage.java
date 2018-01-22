package pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.NoSuchElementException;

import drivers.DriverImplementation;
//import drivers.DriverImplementation;
//import stepdefenition.TestBase;

//import stepdefenition.Hooks;

public class LoginPage extends DriverImplementation{
	
	ResourceBundle element;
	//RemoteWebDriver driver;
	ResourceBundle config;
	String username, password;
	
	public LoginPage(){
		
		//this.driver = driver;
		element = ResourceBundle.getBundle("utils.elements");
		config = ResourceBundle.getBundle("utils.config");
	
	}
	
	public void enterUsername(){
		try {
		driver.findElement(By.id(element.getString("login_username_id"))).sendKeys(config.getString("username"));
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void enterPassword(){
		try {
		driver.findElement(By.id(element.getString("login_password_id"))).sendKeys(config.getString("password"));
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void clickLoginButton(){
		try {
		driver.findElement(By.cssSelector(element.getString("login_clickLogin_css"))).click();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}

}
