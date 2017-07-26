package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.helper;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.imdbHomePage;
import Pages.topRatedMovies;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class verifySortingOption {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	@BeforeMethod
	public void setup()
	{
		
		//Generate report and logs using Extent report API and Extent Test API.
		report = new ExtentReports("./Reports/verifySortingOption.html",true);
		logger = new ExtentTest("Verify Sorting option", "This page will check sorting options in IMDb site");
		
		driver = BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getconfig().getApplicationUrl());
		
		//Log info for user readability.
		logger.log(LogStatus.INFO, "Application is up and running");
	}
	
	@Test(priority =0)
	public void verifyTopRatedMoviesPage()
	{
		//to initialize home page
		imdbHomePage home = PageFactory.initElements(driver, imdbHomePage.class);
		String title = home.getApplicationTitle();
		
		//Check if imdb page is opened.
		Assert.assertTrue(title.contains("IMDb - Movies, TV and Celebrities "));
		
		//Log info for user readability.
		logger.log(LogStatus.INFO, "Home Page loaded successfully and verified");
		
		//Initialze top rated movie page.
		topRatedMovies topMoviesList = PageFactory.initElements(driver, topRatedMovies.class); 
		
		topMoviesList.clickTopRatedMovies();
		
		Select sortOption= new Select(driver.findElement(By.name("sort")));
		sortOption.selectByVisibleText("Ranking");
		
		//Check if the list is returning more then 1 value for Ranking option.
		int count = topMoviesList.getTotalMoviesInTheList();
		Assert.assertTrue(count>=1);
		
		//Log info for user readability.
		logger.log(LogStatus.INFO, "Sorted by Ranking option successfully and verified");
		
		sortOption.selectByVisibleText("IMDb Rating");
		
		//Check if the list is returning more then 1 value for IMDb Rating option.
		count = topMoviesList.getTotalMoviesInTheList();
		Assert.assertTrue(count>=1);
		
		//Log info for user readability.
		logger.log(LogStatus.INFO, "Sorted by IMDb Rating option successfully and verified");
				
		
		sortOption.selectByVisibleText("Release Date");
		
		//Check if the list is returning more then 1 value for Release Date option.
		count = topMoviesList.getTotalMoviesInTheList();
		Assert.assertTrue(count>=1);
		
		//Log info for user readability.
		logger.log(LogStatus.INFO, "Sorted by ReleaSE Date option successfully and verified");
				
	
		sortOption.selectByVisibleText("Number of Ratings");
		
		//Check if the list is returning more then 1 value for Number of Ratings option.
		count = topMoviesList.getTotalMoviesInTheList();
		Assert.assertTrue(count>=1);
		
		//Log info for user readability.
		logger.log(LogStatus.INFO, "Sorted by Number of Ratings option successfully and verified");
				
		
		sortOption.selectByVisibleText("Your Rating");
		
		//Check if the list is returning more then 1 value for Your Rating option.
		count = topMoviesList.getTotalMoviesInTheList();
		Assert.assertTrue(count>=1);
		
		//Log info for user readability.
		logger.log(LogStatus.INFO, "Sorted by Your Rating option successfully and verified");
				
		
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path = helper.captureScreenShot(driver, result.getName());
			
			//Attaches screen only for failed test cases.
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}
	
	
	
}
