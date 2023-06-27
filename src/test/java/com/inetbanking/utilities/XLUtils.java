package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	public static FileInputStream fi;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;
	}
	
	public static int getColumnCount(String xlfile, String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		int colCount = sheet.getRow(0).getLastCellNum();
		workbook.close();
		fi.close();
		return colCount;
	}
	
	public static String getCellData(String xlfile, String xlsheet, int i, int j) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
		return cellValue;
		
	}
	
	
}





