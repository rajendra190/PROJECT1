package com.vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	public String Readdatafromexcel(String sheetname,int rownum,int cellnum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IAutoconstants.excelpath);
		return WorkbookFactory.create(fis).getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	}

}
