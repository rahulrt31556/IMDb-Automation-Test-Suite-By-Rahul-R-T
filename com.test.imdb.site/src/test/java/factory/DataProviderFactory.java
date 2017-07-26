package factory;

/*
 * All the external data and configuration data can be accessed using this class.
 * 
 */


import DataProvider.ExcelDataProvider;
import DataProvider.configDataProvider;

public class DataProviderFactory {

	public static ExcelDataProvider getExcel()
	{
		
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel;
		
	}

	public static configDataProvider getconfig() {
		configDataProvider config = new configDataProvider();
		return config;
		
	}

}


