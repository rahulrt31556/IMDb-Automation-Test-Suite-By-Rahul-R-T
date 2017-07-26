package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configDataProvider {

Properties pro;
	

/*This class is used to access URL of the site, browser driver location 
 * from the configuration file. By performing the below steps.
 * Create constructor of the class with no parameters.
 * create methods to call or get IMDB url and browser driver location.
*/
	public configDataProvider()
	{
		
		File src = new File("./Configuration/config.properties");
		try {
			
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			
			System.out.println("Exception is "+ e.getMessage());
		}
		
	}
	
	
	public String getApplicationUrl()
	{
		String url = pro.getProperty("url");
		return url;
	}
	public String getChromePath()
	{
		String chromePath = pro.getProperty("chromePath");
		return chromePath;
	}
	public String getIEPath()
	{
		String IEPath = pro.getProperty("IEPath");
		return IEPath;
	}
	
}
