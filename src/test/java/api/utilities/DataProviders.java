package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="AllData")
	public String [][] AllDataProvider()
	{
		String fName = System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		
		int ttlRowCnt = ReadExcelFile.getRowCount(fName, "Sheet1");
		int ttlColCnt= ReadExcelFile.getColCount(fName, "Sheet1");
		
		String userData[][] = new String[ttlRowCnt-1][ttlColCnt];
		
		for(int rowNo = 1; rowNo<ttlRowCnt; rowNo++)
		{
			for(int colNo=0; colNo<ttlColCnt; colNo++)
			{
				userData[rowNo-1][colNo] = ReadExcelFile.getCellValue(fName, "Sheet1", rowNo, colNo);
			}
			
		}
		return userData;
	}
	
	
	@DataProvider(name="UserNamesData")
	public String [] UserNamesDataProvider()
	{
		String fName = System.getProperty("user.dir")+"//TestData//TestData.xlsx";
		
		int ttlRowCnt = ReadExcelFile.getRowCount(fName, "Sheet1");
	//	int ttlColCnt= ReadExcelFile.getColCount(fName, "Sheet1");
		
		String userNamesData[] = new String[ttlRowCnt-1];
		
		for(int rowNo = 1; rowNo<ttlRowCnt; rowNo++)
		{
			userNamesData[rowNo-1] = ReadExcelFile.getCellValue(fName, "Sheet1", rowNo, 1);
			
		}
		return userNamesData;
	}
	
	
}
