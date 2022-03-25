  package com.vtiger;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	/**
	 * this method will till the page is loaded or not
	 *
	 */
	public void pageloadtimeout(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method is used to select the dropdown by visible text
	 */
	public void Selectfromdd(WebElement Element,String text) {
		Select select = new Select(Element);
		select.selectByVisibleText(text);
	}
	/**
	 * This method is gonna move to target element
	 */
	public void movetolement(WebDriver driver,WebElement target) {

		Actions action = new Actions(driver);
		action.moveToElement(target).build().perform();

	}
	/**
	 * This method is used to select the dropdown by visible value
	 */
	public void Selectfromdd(String Value,WebElement Element) {
		Select st =new Select(Element);
		st.selectByValue(Value);
	}
	/**
	 * This method is used to select the dropdown by index
	 */
	public void Selectfromdd(int index,WebElement Element) {
		Select sss=new Select(Element);
		sss.selectByIndex(index);
	} 
	/**
	 * this method is going to switch window on the basis of title
	 */
	public void Switchtowindow(String title,WebDriver driver)  {
		Set<String> winids = driver.getWindowHandles();
		for(String string:winids) {
			String currenttitle = driver.switchTo().window(string).getTitle();
			if(currenttitle.contains(title)) {
				break;
			}
		}
	}
	public void Acceptalert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void Dismissalert(WebDriver driver) {
		driver.switchTo().alert().dismiss(); 
	}
	public void Entertext(WebDriver driver,String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	public String Alerttext(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	public void Switchframe(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void Switchframe(WebDriver driver ,String nameorid) {
		driver.switchTo().frame(nameorid);
	}
	public void Switchframe(WebElement element, WebDriver driver) {
		driver.switchTo().frame(element);
	}
	
	
	
	}


