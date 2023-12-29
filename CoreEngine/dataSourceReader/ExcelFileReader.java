package dataSourceReader;

import java.io.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class ExcelFileReader {
	
	// Utility Method to read data from excel dynamically.
	
	public static String filePath = ".//TestData//DMS_Configuration_Data.xlsx"; // 
	public static XSSFSheet sheet = null;
	
	public static String getRowAndColumn(int row, int column) throws IOException {
		File src = new File(filePath);
		FileInputStream file = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		sheet = wb.getSheetAt(0);
		String getRowAndColumn = sheet.getRow(row).getCell(column).getStringCellValue();
		wb.close();
		return getRowAndColumn; 
	}
	
	
	public static String getFormattedRowAndColumn(int row, int column) throws IOException {
		File src             = new File(filePath);
		FileInputStream file = new FileInputStream(src);
		XSSFWorkbook wb      = new XSSFWorkbook(file);
		XSSFSheet sheet      = wb.getSheetAt(0);
		
		XSSFCell cell               = sheet.getRow(row).getCell(column);
		DataFormatter dataFormatter =  new DataFormatter();
		String getRowAndColumn      = dataFormatter.formatCellValue(cell) + "\t\t\t";
		
		wb.close();
		return getRowAndColumn; 
	}

	
	
	
	
	public String rows ( int[] rows , int[] columns) throws IOException {   // not in use as of now: not working as expected
		
		String getRowAndColumn = null;
		
		File src = new File(filePath);
		FileInputStream file = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		for(int i=0; i<=rows.length-1; i++) {
			for(int j=0; j<=columns.length-1; j++) {
		XSSFCell cell = sheet.getRow(rows[i]).getCell(columns[j]);
		DataFormatter dataFormatter =  new DataFormatter();
		 getRowAndColumn = dataFormatter.formatCellValue(cell) + "\t\t\t";
		
			}
		}	
			
		 wb.close();
		 return getRowAndColumn ;
		
	}
	
	
	public static String urlRead () throws IOException {
		//ExcelFileReader excelRead = new ExcelFileReader();
		String url = ExcelFileReader.getRowAndColumn(0, 1);
		return url ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void rowsRead () throws IOException {   // not in use as of now: not working as expected
		ExcelFileReader excelRead = new ExcelFileReader();
		System.out.println(excelRead.rows(new int[] {6,7}, new int[] {0,0}));
		
	}
	
	public static void main(String[] args) throws IOException {
		ExcelFileReader.rowsRead();
		
	}
}


 



 











/*
This is the Utility method, Reading data from excel dynamically.
public String getRowAndCoulmn(int row, int column) {
File src = new File(filePath);
FileInputStream fis = new FileInputStream(src);
XSSFWorkbook wb = new XSSFWorkbook(fis);
XSSFSheet sheet = wb.getSheetAt(0);
String getRowAndColumn = sheet.getRow(row).getCell(column).getStringCellValue();
fis.close();
return getRowAndColumn;

}
*/