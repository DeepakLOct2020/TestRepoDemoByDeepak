package Commerce.MyAmazon.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

	static Workbook wb;
	
	public static Object[][] getExcelData(String fileName, String sheetName) throws IOException {
		
		String filePath = "./resources/TestData/"+ fileName;
		
		File src = new File(filePath);
		
		FileInputStream fis = new FileInputStream(src);
		
		if(filePath.contains(".xlsx")) {
		
			wb = new XSSFWorkbook(fis);
		}
			
		else if(filePath.contains(".xls")) {
			
			wb = new HSSFWorkbook(fis);
		}
			
		Sheet sheet = wb.getSheet(sheetName);
		
		int totalRows = sheet.getLastRowNum();
		
		System.out.println("Total Number of rows are :"+ totalRows);
		
		int totalCols = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Total Number of cols are :"+ totalCols);
		
		String[][] data = new String[totalRows][totalCols];
		
		for(int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			 
			for(int colIndex = 0 ; colIndex < totalCols; colIndex++) {
				
				//System.out.print(sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue()+ " ");
				
				data[rowIndex-1][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
			}
		}
		
		return data;
			
	}

	
	public static void main(String[] args) throws IOException {
		
		getExcelData("Test_Data.xlsx", "Create_Account_TestData");
	}
	
	
	
}