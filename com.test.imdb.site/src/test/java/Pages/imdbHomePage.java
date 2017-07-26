package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * This Page has the necessary details of the IMDB home page required for for assignment.
 *  
 */

public class imdbHomePage {

	WebDriver driver;
	
	public imdbHomePage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	WebElement fbSignIn= driver.findElement(By.xpath(".//*[@id='facebook-signin-link']"));
	WebElement otherSignIn= driver.findElement(By.xpath(".//*[@id='nblogin']"));
	
	public String getApplicationTitle()
	{
		return driver.getTitle();
	}
}
