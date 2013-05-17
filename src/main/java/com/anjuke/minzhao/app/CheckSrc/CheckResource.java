package com.anjuke.minzhao.app.CheckSrc;
import java.io.File;
import java.io.FileInputStream;   
import java.io.FileNotFoundException;
import java.io.FileOutputStream;  
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;   
import org.apache.poi.ss.usermodel.Row;   
import org.apache.poi.ss.usermodel.Sheet;   
import org.apache.poi.ss.usermodel.Workbook;   
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.anjukeinc.iata.ui.browser.Browser;
import com.anjukeinc.iata.ui.browser.FactoryBrowser;

public class CheckResource {
	int i,j,maxLine;
	String test = "all-qalist";
	private Browser driver = null;
	String line;
	String srcCode;
	Sheet readSheet;
    Workbook book;
    Cell cell1;
    int cellValue;
	@BeforeMethod
	public void setUp() throws Exception {
		driver = FactoryBrowser.factoryBrowser();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
		driver = null;
	}

	@Test
	public void testCheckResources() {
		i=2;
		maxLine=1;
		
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet targetSheet = wb.createSheet("sheet2");
			
			HSSFRow targetRow = targetSheet.createRow(0);
			HSSFCell cellID_String = targetRow.createCell(0);
			cellID_String.setCellValue("小区id");
			HSSFCell cellBool = targetRow.createCell(1);
			cellBool.setCellValue("T OR F");
			
			File file = new File("E:/项目/[14863]SEO小区单页优化/BOOK.xls");
			FileInputStream fint = new FileInputStream(file);
			POIFSFileSystem poiFileSystem = new POIFSFileSystem(fint);
			HSSFWorkbook book = new HSSFWorkbook(poiFileSystem);
			readSheet=book.getSheetAt(0); 
			
			for(j=0;j<=maxLine;j++)
			{
				Row readRow = readSheet.getRow(j);   
				cell1=readRow.getCell(i);
				cellValue=(int)cell1.getNumericCellValue();
				//System.out.println(cellValue);
				String uuu = "view-source:http://shanghai.anjuke.com/community/view/"+cellValue;
				driver.get(uuu);
				srcCode=driver.getText("html", "");
				HSSFRow targetRow1 = targetSheet.createRow(j+1);
				HSSFCell cellID = targetRow1.createCell(0);
				cellID.setCellValue(cellValue);
				HSSFCell cellResult = targetRow1.createCell(1);
//				driver.assertContains(srcCode, test);
				if(srcCode.contains(test)){
					cellResult.setCellValue(true);
				}
				else{
					cellResult.setCellValue(false);
				}
			}
			try{
				FileOutputStream fileoutputstream = new FileOutputStream("E:/项目/[14863]SEO小区单页优化/target.xls");
				wb.write(fileoutputstream);
				fileoutputstream.flush();
				fileoutputstream.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		
		} 
		catch (Exception e) {
			System.out.println("获取不到网页的源码,出现异常：" + e);
			e.printStackTrace();
		}
		
		
	}
	
}
