package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/*
 * This Page has the necessary details of the Top movies selected by 
 * Western Genre page required for for assignment.
 *  
 */

public class topMoviesByWesternGenre {

	WebDriver driver;
	
	public topMoviesByWesternGenre(WebDriver ldriver)
	{
		this.driver= ldriver;
	}
	int total;
	public int totalMoviesInGenreList() {
		WebElement element = driver.findElement(By.linkText("Western"));
		List<WebElement> listOfMovies= driver.findElements(By.name("chart-top250movie"));
		element.click();
		total = listOfMovies.size();
		return total;
		
	}
	
}
