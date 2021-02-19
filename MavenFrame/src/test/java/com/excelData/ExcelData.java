package com.excelData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class ExcelData {
	
	@Test
	public void ExcelReader() throws IOException
	
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\admin\\Desktop\\ExcelData\\Book1.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis); //oopen work book or excel sheet
		
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		XSSFRow row;
		//= sheet.getRow(1);
		 XSSFCell cells;
		
		int rowcount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();

		
		//XSSFCell cell = row.getCell(1);
		
	//	System.out.println(cell);
		
	//	System.out.println(rowcount);
//		for (int i = 0; i <	rowcount; i++) {
//			String data = sheet.getRow(i).getCell(0).getStringCellValue();
//			System.out.println(data);
//			
//		}
//		
//		for (int i=1; i < rowcount;i++){
//			for(int j = 0; j<row.getLastCellNum(); j++) {
//					
//					System.out.println(sheet.getRow(i).getCell(j));
//			//		System.out.println(sheet.getRow(i).getCell(1));
//					
//			}
//			System.out.println();
//
//		}
		
		for (int r = 0; r < rowcount+1; r++) {
		    for (int c = 0; c < colCount; c++) {
		    	row = sheet.getRow(r);
		        cells = row.getCell(c);
		        String cellval = cells.toString();
		        System.out.print(" | " + cellval);   //New line IS NOT printed
		    }
		    System.out.println(" |");                //New line IS printed
		}
		
	}
	
	

}
