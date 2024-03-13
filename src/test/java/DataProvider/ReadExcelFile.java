package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import java.io.File;
//import java.io.FileInputStream;

//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ReadExcelFile {
	XSSFWorkbook work_book;
	XSSFSheet sheet;
 
	public ReadExcelFile(String excelfilePath) {
		try {
			File s = new File(excelfilePath);
			FileInputStream stream = new FileInputStream(s);
			work_book = new XSSFWorkbook(stream);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
 
	public String getData(String sheetname, int row, int column) {
		 //work_book.getSheetAt(1);
		sheet = work_book.getSheet(sheetname);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
 
	public int getRowCount(String sheetname){
		int row = work_book.getSheet(sheetname).getLastRowNum();
		row = row + 1;
		return row;
	}
}