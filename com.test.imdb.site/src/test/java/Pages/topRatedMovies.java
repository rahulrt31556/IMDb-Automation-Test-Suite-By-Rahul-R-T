package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * This Page has the necessary details of the IMDB op rated movies page required for assignment.
 * This can also be used for sorting options.
 *  
 */

public class topRatedMovies {
	
	WebDriver driver;
	
	public topRatedMovies(WebDriver ldriver)
	{
		this.driver= ldriver;
	}
	
	WebElement navTitleMenu= driver.findElement(By.xpath(".//*[@id='navTitleMenu']"));
	WebElement topRatedMovies= driver.findElement(By.linkText("Top Rated Movies"));
			
	//It will store all the web element of list of movies displayed.
	List<WebElement> listOfMovies= driver.findElements(By.name("chart-top250movie"));
		
	public void clickTopRatedMovies()
	{
		topRatedMovies.click();
	}
	
	public int getTotalMoviesInTheList()
	{
		return listOfMovies.size();
	}
	
}
