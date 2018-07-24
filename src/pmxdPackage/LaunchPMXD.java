package pmxdPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import resources.CommonLibraries;

public class LaunchPMXD {
	CommonLibraries driver= new CommonLibraries();
	
	 @BeforeClass
	  public void beforeClass() {
		  driver.openBrowser("Firefox");
		  driver.openUrl("https://wccqa.on24.com/webcast/present?e=11017826&k=E1D4DD2C2DC8D6C1A99F36B4D5545FB5");
		  
		  
	  }
	 
	 
	 @AfterMethod
	  public void afterMethod() throws InterruptedException {
		  Thread.sleep(1000);
	  }
	
	 @Test (priority=1)
	 public void loginRegistration() throws InterruptedException {
		 Thread.sleep(5000);
		 driver.register("Mayur", "Munshi", "qa2001@inbfw.com","English");
	 }

	 
	  @Test (priority=3)
	  public void pLogin() throws InterruptedException {
		  Thread.sleep(10000);
		  driver.loginRole("Producer");
		  Thread.sleep(10000);

		  
	  }
	  	
	 
	  /*
	  @Test
	  public void pLogin1() throws InterruptedException {
		  Thread.sleep(10000);
		  driver.loginRole("Presenter");
	  		  
	  }
	  
	  @Test
	  public void pLogin2() throws InterruptedException {
		  Thread.sleep(10000);
		  driver.loginRole("QA");
		  
	  }
	  */
	  @Test (priority=2, enabled=false) public void loginPMXD() throws InterruptedException{
			Thread.sleep(20000);
			//driver.switchTab(1);
		    driver.register("Mayur", "Munshi", "qa2001@inbfw.com", "English");
			driver.loginRole("Producer");
			System.out.println("Successfully Logged-in To Producer");
			//driver.close();
			//driver.switchTab(0);
			}
	  
	  @Test (priority=4) public void openQA() throws Exception{
			Thread.sleep(50000);
			driver.Click(By.xpath("//a[contains(text(),'Q&A')]"));
			driver.Click(By.xpath("//*[@id=\"add_folder\"]"));
			driver.Click(By.xpath("//td[contains(text(),'Inbox')]"));
			Thread.sleep(5000);
			//driver.Click(By.xpath("//td[contains(text(),'New Folder')]"));
			//driver.Click(By.xpath("//td[contains(text(),'New Folder')]"));
			//driver.doubleClick(By.xpath("//td[contains(text(),'New Folder')]"));
			CommonLibraries.dClick(driver.find(By.xpath("//td[contains(text(),'New Folder')]")));

			
	  }
			
			
		/*
				if (driver.find("//td[contains(text(),'New')]))
			{
				System.out.println("New Folder Found");
				driver.doubleClick(By.name("New Folder"));
				driver.Enter("‡ËÏÚ˘¿»Ã“Ÿ", By.name("New Folder"));
			}
			
			else
			{
				System.out.println("Not Available");
			}				
				
			 */
	  
	
	  
}
