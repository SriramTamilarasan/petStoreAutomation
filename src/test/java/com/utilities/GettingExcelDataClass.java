package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GettingExcelDataClass {
	
	public FileInputStream fis;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFCell cell;
	String path = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\user_files.xlsx";

	public int getRowNum(String sheetName) throws IOException {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
	}
	
	public int getCellNum(String sheetName, int rownum) throws IOException {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		int cellcount = sheet.getRow(rownum).getLastCellNum();
		wb.close();
		fis.close();
		return cellcount;
	}
	
	public String getSingleCellData(String sheetName, int rownum, int colnum) throws IOException {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		cell = sheet.getRow(rownum).getCell(colnum);
		
		DataFormatter format = new DataFormatter();
		String data;
		
		data = format.formatCellValue(cell);
		
		wb.close();
		fis.close();
		
		return data;
	}
	
	
	

}
