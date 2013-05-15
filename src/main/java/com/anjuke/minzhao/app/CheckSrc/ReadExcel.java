package com.anjuke.minzhao.app.CheckSrc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import jxl.*;

public class ReadExcel {

	public static void main(String[] args) {
		int i, j, maxLine;
		Sheet sheet;
		Workbook book;
		Cell cell1;
		
		String test = "all-qalist";
		
		try {
			String sourcefile = "E:/项目/[14863]SEO小区单页优化/BOOK.xls";
			InputStream is = new FileInputStream(sourcefile);
			book = Workbook.getWorkbook(is);
			// 获得第一个工作表对象(excel中sheet的编号从0开始,0,1,2,3,....)
			sheet = book.getSheet(0);
			i = 2;
			maxLine = 8200;
			j = 0;
			cell1 = sheet.getCell(i, j);// （列，行）
			String url = "http://shanghai.anjuke.com/community/view/"+ cell1.toString();
			System.out.println(url);
			j++;
			book.close();
		} catch (Exception e) {
			System.out.println("no work");
			e.printStackTrace();
		}
	}
}
