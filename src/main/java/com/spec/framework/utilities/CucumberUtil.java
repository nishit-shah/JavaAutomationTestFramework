package com.spec.framework.utilities;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import io.cucumber.datatable.DataTable;

public class CucumberUtil {

	private static List<DataCollection>_dataCollection = new ArrayList<>();
	
	//Converts Data Table into Dictionary and identifies the Column values based on ColumnName
	public static List<DataCollection>ConvertDataTableToDict(DataTable table){
		_dataCollection.clear();
		List<String> data = table.asList();
		int rowNumber = 0;
		for(String col:data) {
			for(int colIndex= 0; colIndex< col.length();colIndex++) {
				_dataCollection.add(rowNumber, new DataCollection(data.get(2),data.get(3),rowNumber));
				rowNumber++;
			}
			
		}
		return _dataCollection;
		
	}
	
public static String GetCellValueWithRowIndex(String ColumnName, int rowNumber) {
		final String[] columnValue = {null};
		
		_dataCollection.forEach(x->{if(x.ColumnName.equals(ColumnName) && x.RowNumber == rowNumber) {
			columnValue[0] = x.ColumnValue;
		}
		});
		
		return columnValue[0];
	}
	
	private static class DataCollection{
		private String ColumnName;
		private String ColumnValue;
		private int RowNumber;
		
		public DataCollection(String columnName,String columnValue,int rowNumber) {
			// TODO Auto-generated constructor stub
			ColumnName = columnName;
			ColumnValue = columnValue;
			RowNumber = rowNumber;
		}
	}

}

