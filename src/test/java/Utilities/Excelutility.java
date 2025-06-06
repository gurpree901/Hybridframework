package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell Cell;
	public CellStyle style;
	String path;
	 //constructor
	public Excelutility(String path)
	{
		this.path=path;
	}
	
	public int getrowcount(String sheetname) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
		
	}
	public int getcellcount(String sheetname,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
		
	}
	
	public String getCellData(String sheetname,int rownum ,int column ) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		Cell=row.getCell(column);
		
		DataFormatter formatter=new DataFormatter();
		String data;
		try
		{
			data=formatter.formatCellValue(Cell);
		}
		catch(Exception e)
		{
			data=" ";
		}
		workbook.close();
		fi.close();
		return data;
	}
	public void setCellData(String sheetame,int rownum,int column,String data) throws IOException
	{
		File xlfile=new File(path);
		if(!xlfile.exists())
		{
			workbook=new XSSFWorkbook();
			fo=new FileOutputStream(path);
			workbook.write(fo);
		}
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		if(workbook.getSheetIndex(sheetame)== -1){
         workbook.createSheet(sheetame);
         workbook.getSheet(sheetame);
         
         if(sheet.getRow(rownum)==null)
        	 sheet.createRow(rownum);
        row= sheet.getRow(rownum);
        
        Cell=row.createCell(column);
         Cell.setCellValue(data);
         fo=new FileOutputStream(path);
         workbook.write(fo);
         workbook.close();
         fi.close();
         fo.close();
		}
	}
	
	public void fillRedColor(String sheetname,int rownum1,int column1) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum1);
		Cell=row.getCell(column1);
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		Cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}

		
		
		
		
		
		
	
	

}
