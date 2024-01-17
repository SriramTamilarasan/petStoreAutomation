package com.utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="AllDataMethod")
	public String[][] getAllData() throws EncryptedDocumentException, IOException {
		
		GettingExcelDataClass xlObj = new GettingExcelDataClass();
		int rownum = xlObj.getRowNum("userdetails1");           //Here userdetails1 is the sheetname of our excel sheet
		int colnum = xlObj.getCellNum("userdetails1", 1);
		
		String[][] data = new String[rownum][colnum];
		
		for(int i=1; i<=rownum; i++) {
			for(int j=0; j<colnum; j++) {
				data[i-1][j] = xlObj.getSingleCellData("userdetails1", i, j);
			}
		}
		
		return data;
	}
	
	@DataProvider(name = "UsernameMethod")
	public String[] getUsername() throws IOException {
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\user_files.xlsx";
		GettingExcelDataClass xlObj = new GettingExcelDataClass();
		int rownum = xlObj.getRowNum("userdetails1");
		
		String data[] = new String[rownum];
		
		for(int i=1; i<=rownum; i++) {
			data[i-1]=xlObj.getSingleCellData("userdetails1", i , 1); 
		}
		
		return data;
	}
}
