package pmxdPackage;

import org.testng.annotations.Test;

import resources.CommonLibraries;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import java.util.ArrayList;
import java.util.Date;
import static org.testng.Assert.assertFalse;
import java.time.*;
import java.time.format.*;


public class TestNGClass {


	CommonLibraries driver = new CommonLibraries();
	Date date = new Date();
	LocalTime time = LocalTime.now();
	DateTimeFormatter tformat = DateTimeFormatter.ofPattern("hh:mm a");
	
		
	  @BeforeClass
	  public void beforeClass() {
		  driver.openBrowser("Chrome");
		  driver.openUrl("http://wccqa.on24.com/webcast/login");
		  
	  }
	 
  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(1000);
  }

  @Test (priority = 0)
  public void getTitle() {
	  System.out.println("Title of the page is " + driver.title());  
  }

  @Test (priority = 1)
  public void strComp1(){
	  driver.sComp(By.xpath("//*[@id=\"userPlaceholderId\"]"), "USERNAME");
	  	  
  }
  
  @Test (priority = 2)
  public void eUsername(){
	  driver.Enter("rohitjharoot", By.xpath("//*[@id=\"login\"]"));
	  	  
  }
  
  @Test (priority = 3)
  public void StrComp2(){
	  driver.sComp(By.xpath("//*[@id=\"passPlaceholderId\"]"), "PASSWORD");
  }
  
  @Test (priority = 4)
  public void ePassword(){
	  driver.Enter("Password02", By.xpath("//*[@id=\"password\"]"));
  
  }
  
  @Test (priority = 5)  public void StrComp3() {
	  driver.sCompvalue(By.xpath("//*[@id=\"loginSubmit\"]"),"Login");
  }


  @Test (priority = 6)  public void login()  {
	
	  driver.Click(By.id("loginSubmit"));
	  System.out.println("Successfully logged in");
  }

  @Test (enabled=false, priority = 7)  public void nClick() throws InterruptedException {
	  driver.Click(By.cssSelector("#password-expiring-form > div > div.channelbottomline > div:nth-child(2) > div > a"));
	  System.out.println("Successfully ByPasseed Password Expiring Message");
  }

  
  @Test (priority=9) public void dropdown() throws InterruptedException {
	  Thread.sleep(10000);
	  driver.ddSelect(By.id("hierarchySelect"),"PMXDMPD");
	  System.out.println("Client Selection Test Successful");
	 
  }
  
  	  
 @Test (priority=8) public void maximize() {
	    
	 driver.maximizeWindow();
	 System.out.println("Maximize Verification successful");
	   }
  @Test (priority=10) public void chooseEvent() throws InterruptedException {
	  Thread.sleep(10000);
	  driver.selectEvent("VPB");
	  Thread.sleep(2000);
  }
	  
@Test (priority=11) public void dateSelect() throws InterruptedException {
	
	  driver.dateSelect(By.className("ui-datepicker-trigger"), By.cssSelector("a.ui-state-default.ui-state-highlight"));
	  System.out.println("Today's Date Selected");
	 
	  	  
  }
@Test (priority=11) public void enterTime() {
	  driver.clear(By.className("timepicker"));
	  driver.Enter((time.plusMinutes(5).format(tformat)),(By.className("timepicker"))) ;
	  driver.tab(By.className("timepicker"));
	  System.out.println("Current Time (+5 minutes) Selected");
	  
	
}

@Test (priority=12) public void tZoneSelect() {
	driver.ddSelect(By.id("timeZone"), "(GMT +5:30) Asia/Calcutta");
}

@Test (priority=13) public void durationSelect() {
	driver.ddSelect(By.cssSelector("select#liveDuration"), "1 hour");
}

@Test (priority=14) public void langSelect() {
	driver.ddSelect(By.cssSelector("select#language"), "English");
}

@Test (priority=15) public void createEvent() throws InterruptedException {
	driver.Click(By.cssSelector("a#create"));
	Thread.sleep(10000);
	driver.sComp(By.xpath("//*[@id=\"NewEliteUXStyle\"]/div[3]/div/div[1]/label"), "Overview");
	System.out.println("Event created Successfully");
}

@Test (priority=16) public void launch_PMXD() throws InterruptedException {
	driver.OpenPMXD(By.className("activeTab"), By.xpath("//*[@id=\"colossusurlanchor\"]"), By.xpath("//*[@id=\"subNavULWrapper\"]/ul/li[1]/div/a"));
}
 
@Test (priority=17) public void loginPMXD() throws InterruptedException{
		Thread.sleep(20000);
		driver.switchTab(1);
	    driver.register("Mayur", "Munshi", "qa2001@inbfw.com", "English");
		driver.loginRole("Producer");
		System.out.println("Successfully Logged-in To Producer");
		//driver.close();
		driver.switchTab(0);
		}


/*
@Test (priority=18) public void loginPMXD1() throws InterruptedException{
	Thread.sleep(20000);
	driver.switchTab(1);
    driver.register("Mayur", "Munshi", "qa2001@inbfw.com", "French");
	driver.loginRole("Presener");
	System.out.println("Successfully Logged-in To Presenter");
	//driver.close();
	driver.switchTab(0);
	}

@Test (priority=19) public void loginPMXD2() throws InterruptedException{
	Thread.sleep(20000);
	driver.switchTab(1);
	driver.register("Mayur", "Munshi", "qa2001@inbfw.com", "Italian");
	driver.loginRole("QA");
	System.out.println("Successfully Logged-in To QA");
	//driver.close();
	driver.switchTab(0);
	}

*/


}

