package com.anjuke.minzhao.app.CheckSrc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import jxl.*; 
public class ReadExcel{
	
    public static void main(String[] args) {
        int i,j,maxLine;
        Sheet sheet;
        Workbook book;
        Cell cell1;
        URL url1;
        String test="all-qalist";
        int responsecode;
        HttpURLConnection urlConnection;
        BufferedReader reader;
        try { 
        	 String sourcefile = "E:/项目/[14863]SEO小区单页优化/BOOK.xls";
        	 InputStream is = new FileInputStream(sourcefile);
        	 book = Workbook.getWorkbook(is);         
        	 //获得第一个工作表对象(excel中sheet的编号从0开始,0,1,2,3,....)
        	 sheet=book.getSheet(0); 
            i=2;
            maxLine=8200;
          j=0;
//            for(j=0;maxLine>0;maxLine--)
//            {
               // 获取每一行的单元格 
            	cell1=sheet.getCell(i,j);//（列，行）
            	String url="http://shanghai.anjuke.com/community/view/"+cell1;
            	url1=new URL(url);
            	System.out.println(url1);
                //打开URL
                urlConnection = (HttpURLConnection)url1.openConnection();
                //获取服务器响应代码
                responsecode=urlConnection.getResponseCode();
                if(responsecode==200){
                    //得到输入流，即获得了网页的内容 
                    reader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
                    if(reader.equals(test)){
                    	System.out.println("1");
                    }
                    else{System.out.println("0");}
                    System.out.println(cell1.getContents());
                 }
                j++;
            book.close(); 
//            }
        }
        catch(Exception e)  {
        	System.out.println("no work");
        	e.printStackTrace();
        } 
    }
}
