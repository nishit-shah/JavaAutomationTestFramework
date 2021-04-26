package com.spec.framework.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelUtil {

	
	//Open Excel Sheet
	//Read Cell Data
	//Store in-memory Collection
	//Read Data from Collection
	
	
	
	static Sheet wrksheet;
	static Workbook wrkbook =null;
	static Hashtable dict= new Hashtable();
	//Create a Constructor
	public ExcelUtil(String FilePath) throws BiffException, IOException
	{
		//Initialize
		wrkbook = Workbook.getWorkbook(new File(FilePath));
		//For Demo purpose the excel sheet path is hardcoded, but not recommended :)
		wrksheet = wrkbook.getSheet("Sheet1");
		
		//Call the column dictionary to store the column names
		ColumnDictionary();
	}

	//Returns the Number of Rows
	public static int RowCount()
	{
		return wrksheet.getRows();
	}

	//Returns the Cell value by taking row and Column values as argument
	private static String ReadCell(int column,int row)
	{
		return wrksheet.getCell(column,row).getContents();
	}
	
	//public method for fetching row values based on column name
	public static String ReadCell(String columnName,int rowNum)
	{
		return ReadCell(GetCell(columnName),rowNum);
	}

	//Create Column Dictionary to hold all the Column Names
	private static void ColumnDictionary()
	{
		//Iterate through all the columns in the Excel sheet and store the value in Hashtable
		for(int col=0;col < wrksheet.getColumns();col++)
		{
			dict.put(ReadCell(col,0), col);
		}
	}

	//Read Column Names
	private static int GetCell(String colName)
	{
		try {
			int value;
			value = ((Integer) dict.get(colName)).intValue();
			return value;
		} catch (NullPointerException e) {
			return (0);

		}
	}
	
	
}
