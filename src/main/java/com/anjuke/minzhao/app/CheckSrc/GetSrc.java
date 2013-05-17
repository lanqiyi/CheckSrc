package com.anjuke.minzhao.app.CheckSrc;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import jxl.*; 
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.anjukeinc.iata.ui.browser.Browser;
import com.anjukeinc.iata.ui.browser.FactoryBrowser;

public class GetSrc{
	int i,j,maxLine;
	String test = "all-qalist";
	private Browser driver = null;
	String line;
	String srcCode;
	Sheet sheet;
    Workbook book;
    Cell cell1;
    URL url;
    int responsecode;
    HttpURLConnection urlConnection;
    BufferedReader reader;
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
	public void testCheck_resources() {
		try {

       	 url=new URL("http://shanghai.anjuke.com/community/view/2");
         //打开URL
         urlConnection = (HttpURLConnection)url.openConnection();
         //获取服务器响应代码
         responsecode=urlConnection.getResponseCode();
         if(responsecode==200){
             //得到输入流，即获得了网页的内容 
         	System.out.println("200");
             reader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
             while((line=reader.readLine())!=null){
                System.out.println(line);
             }
 
			if(srcCode.contains(test)){
				
			}
			else{
				System.out.println("0");
			}
         }}
         catch (Exception e) {
			System.out.println("获取不到网页的源码,出现异常：" + e);
			e.printStackTrace();
		}
	}
}
