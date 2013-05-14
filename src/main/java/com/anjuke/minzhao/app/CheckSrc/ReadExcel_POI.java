package com.anjuke.minzhao.app.CheckSrc;
import java.io.File;
import java.io.FileInputStream;   
import java.io.InputStream;   
  
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;   

  
import org.apache.poi.ss.usermodel.Row;   
import org.apache.poi.ss.usermodel.Sheet;   
import org.apache.poi.ss.usermodel.Workbook;   

public class ReadExcel_POI{

	public static void main(String args[]){
		int i,j,maxLine;
	    Sheet sheet;
	   // Workbook book;
	    Cell cell1;
	    double cellValue;
		try{
			File file = new File("E:/项目/[14863]SEO小区单页优化/BOOK.xls");
			FileInputStream fint = new FileInputStream(file);
			POIFSFileSystem poiFileSystem = new POIFSFileSystem(fint);
			HSSFWorkbook book = new HSSFWorkbook(poiFileSystem);
			sheet=book.getSheetAt(0); 
			i=2;
			maxLine=8200;
			for(j=0;maxLine>0;maxLine--)
			{
				Row row = sheet.getRow(j);   
        	//获取每一行的单元格 
				cell1=row.getCell(i);
				cellValue=cell1.getNumericCellValue();
				
				System.out.println(cellValue);
				j++;
			}
       
			}
		catch(Exception e)  {
			System.out.println("no work");
			e.printStackTrace();
		} 
		}
	
	
}