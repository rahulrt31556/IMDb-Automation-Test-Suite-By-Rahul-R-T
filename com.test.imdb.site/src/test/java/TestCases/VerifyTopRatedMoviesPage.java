package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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

public class VerifyTopRatedMoviesPage {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setup()
	{
		
		//Generate report and logs using Extent report API and Extent Test API.
		report = new ExtentReports("./Reports/verifyTopRatedMoviesPage.html",true);
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
		logger.log(LogStatus.INFO, "Home Page Loaded successfully and verified");
				
		
		//initialze top rated movie page.
		topRatedMovies topMoviesList = PageFactory.initElements(driver, topRatedMovies.class); 
		
		topMoviesList.clickTopRatedMovies();
		
		//Check if the list is returning more then 1 value.
		int count = topMoviesList.getTotalMoviesInTheList();
		Assert.assertTrue(count>=1);
		
		//Log info for user readability.
		logger.log(LogStatus.INFO, "selected Top Movies list option successfully and verified");
				
		
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
