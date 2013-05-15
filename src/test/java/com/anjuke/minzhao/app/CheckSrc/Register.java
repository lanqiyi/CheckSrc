package com.anjuke.minzhao.app.CheckSrc;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.anjuke.minzhao.*;
import com.anjukeinc.iata.ui.browser.Browser;
import com.anjukeinc.iata.ui.browser.FactoryBrowser;

public class Register {
	private Browser driver = null;
	//Excel所在的路径
	String filePath = "e:\\usernamecheck.xls";
	//sheetName的值为Excel工作表的名字
	String sheetName = "checkList";
	
	int count =0;
	int error = 0;
	int a,b,c,d,e=0 ;
	
	
	
	@BeforeClass
	public void startDriver() throws Exception {
		driver = FactoryBrowser.factoryBrowser();
		//版本切换
//		driver.getUrl("http://member.anjuke.com/cookie.php?version=2012_20_05");
//		driver.getUrl("http://shanghai.anjuke.com/version/switch?f1=2012_29_14&f2=beta");
	}
	
	@AfterClass
	public void closeBrowse() throws Exception {
	
		driver.close();
	}
	
	@DataProvider(name = "dp")
    public Iterator<Object[]> dataFortestMethod(Method method) throws IOException{
    	
//		return new ExcelDataProvider(this.getClass().getName(),method.getName()); 
        return new ExcelDataProvider(this.getClass().getName(),sheetName, filePath); 
    }
	
	//安居客
	@Test(dataProvider = "dp" )
    public void checkList(Map<String,String> data) {
			//获取列表名为USERNAME的值
			String username = data.get("USERNAME");
			driver.get("http://my.anjuke.com/register");
//			driver.getFindElement(By.id("username")).sendKeys(username);
//			driver.getFindElement(By.id("password")).click();
//			driver.waitForPageToLoad(600);
//			String checkResult = driver.getFindElement(By.xpath("//span[@id='checkusername_new']")).getText();
//			System.out.println(username + "------" + checkResult + "---------");
//			if(checkResult.equals("不能使用纯数字为账户名")) a++;
//				if(checkResult.equals("用户名只能由中英文、数字和下划线“_”组成")) b++;
//					if(checkResult.equals("名字已经被别人用了，换个别的吧")) c++;
//						if(checkResult.equals("太短了，至少2个字")) d++;
//							if(checkResult.equals("2-15个字，中英文均可。")) e++;
//								if(checkResult.equals("")) System.out.println("AAAAAAAA:"+ username);;
	}
	
//    //爱房
////	@Test(dataProvider = "dp" )
//    public void checkList1(Map<String,String> data) {
//			String username = data.get("USERNAME");
//			driver.getUrl("http://member.anjuke.com/register?sid=aifang&url=aHR0cDovL3NoYW5naGFpLmFpZmFuZy5jb20v&cityid=11");
//			driver.getFindElement(By.xpath(".//*[@id='member_register_left_1_1']/input")).sendKeys(username);
//			driver.getFindElement(By.id("member_rigister_ok")).click();
//			String checkResult = driver.getFindElement(By.id("member_register_left_1_2")).getText();
//			if(checkResult.equals("该用户名已被占用，请另起个吧")) a++;
//				if(checkResult.equals("2-15个字符，中英文均可。")) b++;
//					if(checkResult.equals("对不起，用户名包含敏感字符或被系统屏蔽")) c++;
//						if(checkResult.equals("用户名不能为纯数字")) d++;
//							if(checkResult.equals("用户名含有非法字符")) e++;
//			System.out.println(username + "------" + checkResult + "---------");
//	}
//	
//    //总部API接口
////	@Test(dataProvider = "dp" )
//    public void checkList2(Map<String,String> data) throws UnsupportedEncodingException {
//			String username = data.get("USERNAME");
//			try{
//				String name = URLEncoder.encode("_d_"+username , "UTF-8");
//				String url = "http://member.anjuke.com/memberapi/s/?act=check_username_invalid&username=" + name;
//				driver.getUrl(url);
//			}catch(UnsupportedEncodingException e){
//				e.printStackTrace(); 
//			}
////			System.out.println(driver.getCurrentUrl());
//			String checkResult = driver.getFindElement(By.xpath("html/body")).getText();
//			if(checkResult.equals("false")){
//				count++;
//			}else{
//				System.out.println(username+ "--"+ checkResult);
//				error++;
//			}
//			
//	}
//	
//	public void resultApi(){
//		int number = error + count;
//		System.out.println("总验证数据总数："+ number);
//		System.out.println("验证返回true数："+ error);
//		System.out.println("验证返回false数："+ count);
//	}
//	public void resultaifang(){
//		System.out.println("a：该用户名已被占用，请另起个吧:"+ a);
//		System.out.println("b：2-15个字符，中英文均可。"+ b);
//		System.out.println("c：对不起，用户名包含敏感字符或被系统屏蔽"+ c);
//		System.out.println("d：用户名不能为纯数字"+ d);
//		System.out.println("e：用户名含有非法字符"+ d);
//	}
//	
//	public void resultanjuke(){
//		System.out.println("a：不能使用纯数字为账户名:"+ a);
//		System.out.println("b：用户名只能由中英文、数字和下划线“_”组成"+ b);
//		System.out.println("c：名字已经被别人用了，换个别的吧"+ c);
//		System.out.println("d：太短了，至少2个字"+ d);
//		System.out.println("e：2-15个字，中英文均可。"+ d);
//	}
//	
//	//注册
////	@Test
//	public void registerTest(){
//		driver.getUrl("http://my.anjuke.com/register");
//		driver.getFindElement(By.id("username")).sendKeys("ad发阿斯多夫");
//		driver.getFindElement(By.id("password")).sendKeys("111111");
//		driver.getFindElement(By.id("tipemail_div")).sendKeys("111111@fdsafad.com");
//		driver.getFindElement(By.id("my_register_submit")).click();
//		String checkResult = driver.getFindElement(By.xpath("//span[@id='checkusername_new']")).getText();
//		System.out.println("e：2-15个字，中英文均可。"+ checkResult);
//	}
	
	
}

