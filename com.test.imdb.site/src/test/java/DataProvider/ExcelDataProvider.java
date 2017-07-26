package DataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
This class is created to access login credentials for IMDB site from external source like Excel.
Note: That this class is not being used for validation as this scenario \
was not part of the assignment.
*/

public class ExcelDataProvider {

	XSSFWorkbook wb;
	
	//Create constructor, so that no need to call this method on creating object.
	
	public ExcelDataProvider(){
File src = new File("./ApplicationTestData/AppData.xlsx");
		
		try {
				FileInputStream fis = new FileInputStream(src);
				wb = new XSSFWorkbook(fis);
		} 
		
		catch (Exception e) {
			
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	
	//Get the data from the excel sheet, login credentials using sheet name or sheet index.
		public String getData(int sheetIndex, int row, int col)
		{
			String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
			return data;
		}
		public String getData(String sheetName, int row, int col)
		{
			String data = wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
			return data;
		}
	
}
