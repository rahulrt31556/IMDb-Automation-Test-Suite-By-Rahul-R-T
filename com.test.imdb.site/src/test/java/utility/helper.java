package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class helper {

	public static String captureScreenShot(WebDriver driver, String screenShotName)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = "./ScreenShots/"+screenShotName+System.currentTimeMillis()+".png";
		
		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to capture screenshots" +e.getMessage());
		}
		
		return destination;
		
	}
	
}
