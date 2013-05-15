package com.anjuke.minzhao.app.CheckSrc;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.*;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class WriteExcel {

	public static void main(String[] args) {
		// 工作簿
		
			int i = 0, MAXLINE = 3;
			HSSFWorkbook wb = new HSSFWorkbook();
		// 创建sheet页
			HSSFSheet sheet = wb.createSheet("sheet1");
	
		for (i = 0; i<MAXLINE; i++) {
			HSSFRow row = sheet.createRow(i);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(true);
			System.out.println("1");
		} 
		try{
			FileOutputStream fileoutputstream = new FileOutputStream("d:\\exceltext.xls");
			//fileoutputstream.write(wb);
			wb.write(fileoutputstream);
			fileoutputstream.flush();
			fileoutputstream.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
}
}
