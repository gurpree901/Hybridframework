package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders {
	
	//Dataproviders 1
	@DataProvider(name="logindata")
	public String[][] getdata() throws IOException
	{
		String path=".\\TestData\\Testdata.xlsx";  //taking exl file from the test data
		Excelutility xlutil=new Excelutility(path); //creating object for xlutility
		int totalrows=xlutil.getrowcount("sheet1");
		int totalcolns=xlutil.getcellcount("sheet1", 1);
		String logindata[][]=new String[totalrows][totalcolns];   //create for 2 dimesional array to store data
		for(int i=1;i<totalrows;i++)
		{
			for(int j=0;j<totalcolns;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("sheet1", i, j);
			}
		}
		return logindata;
		
	}

}
