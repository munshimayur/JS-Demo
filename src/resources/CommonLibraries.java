package resources;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.remote.server.handler.GetElementText;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

import java.util.ArrayList;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
public class CommonLibraries {
	static  WebDriver driver;
	

	public void openBrowser(String Browser) {
	if (Browser.equalsIgnoreCase("Firefox")){                                                   
	System.setProperty("webdriver.gecko.driver","D:/PMXD_Drivers/geckodriver/geckodriver.exe");
	driver = new FirefoxDriver();
	}
	
	else if (Browser.equals("Chrome")){
	System.setProperty("webdriver.chrome.driver", "D:/PMXD_Drivers/chromedriver/chromedriver.exe");
	driver=new ChromeDriver();
	}
	
	else {
		System.setProperty("webdriver.gecko.driver","D:/PMXD_Drivers/geckodriver/geckodriver.exe");
		driver=new FirefoxDriver();
	}

	
}
	
	public void switchTab(int TabNo) {
		String WindowHandle = driver.getWindowHandle();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(TabNo));
	}
	

	public void openUrl(String URL) {
		driver.get(URL);
	}
	
	public WebElement find(By Locator) {
		
		return driver.findElement(Locator);
		
	}
	
	
	public Boolean enable(By Locator) {
		boolean enabled = driver.findElement(Locator).isEnabled();
		if (enabled==true) {
			System.out.println("It is enabled");
		}
		
		else
			System.out.println("It is disabled");
		
		return enabled;
	}
			
	
	public void Click(By Locator) {
		//find(Locator).click();
		driver.findElement(Locator).click();
			
	}
		
	
	public boolean verifySelected(By Locator) {
		boolean radioChecked = find(Locator).isSelected();
		if (radioChecked==true) {
			System.out.println("The radio button is selected");
		}
		
		else {
			System.out.println("The radio button is not selected");
		}
		return radioChecked;	
		
	}
	
	

	public boolean verifyDisplayed(By Locator) {
		boolean radioDisplayed=find(Locator).isDisplayed();
		if (radioDisplayed==true) {
			System.out.println("The radio button is displayed");
		}
		
		else {
			System.out.println("The radio button is not displayed");
		}
		
		return radioDisplayed;
	}
	
	
	
	public void Enter(String text, By Locator) {
		find(Locator).sendKeys(text);
	}
	
	public Boolean sComp(By Locator, String expected) {
		
		boolean result = find(Locator).getText().equals(expected);
		if (result==true) {
			System.out.println("The String "+ expected + " is matched");
		}
		
		else 
		{
			System.out.println("The String " + expected + " is not matched");
		}
		return result;
	
	}
	
	public Boolean sCompvalue(By Locator, String expected) {
		
		boolean result = find(Locator).getAttribute("Value").equals(expected);
		if (result==true) {
			System.out.println("The String "+ expected + " is matched");
		}
		
		else 
		{
			System.out.println("The String " + expected + " is not matched");
		}
		return result;
	
	}
	
	public void ddSelect(By Locator, String Option)
	{
		Select driver = new Select(find(Locator));
		driver.selectByVisibleText(Option);
						
	}
	public void selectEvent(String option)
	{
		Click(By.xpath("//*[@id=\"globalNavBar\"]/div[2]/div/a/img"));
		  System.out.println("Clicked on Create Event Button");
		  sComp(By.xpath("//*[@id=\"NewEliteUXStyle\"]/div[3]/div/div/div/label"), "Create New");
		  System.out.println("Entered on Create Event Page");
			
		  if (option.equalsIgnoreCase("phone"))
			{
		Enter("Mayur "+option+" Event", By.xpath("//*[@id=\"title\"]"));
		ddSelect(By.xpath("//*[@id=\"webcastType\"]"), "Live Audio (screen share)");
		System.out.println("Phone Event Is Selected");
	}
	
	else if (option.equalsIgnoreCase("webcam")){
		Enter("Mayur "+option+" Event", By.xpath("//*[@id=\"title\"]"));
		ddSelect(By.xpath("//*[@id=\"webcastType\"]") , "Present using Webcam");
		System.out.println("Webcam Event Is Selected");
				
	}
	
	else if (option.equalsIgnoreCase("pcMic")){
		Enter("Mayur "+option+" Event", By.xpath("//*[@id=\"title\"]"));
		ddSelect(By.xpath("//*[@id=\"webcastType\"]") , "Present using PC microphone");
		System.out.println("PC-Mic Event Is Selected");
				
	}
	
	else if (option.equalsIgnoreCase("vpb")){
		Enter("Mayur "+option+" Event", By.xpath("//*[@id=\"title\"]"));
		ddSelect(By.xpath("//*[@id=\"webcastType\"]") , "Live Video and Audio (screen share)");
		System.out.println("VPB Event Is Selected");
		
	}
		  
			
	else if ((option.equalsIgnoreCase("Broadcast Video"))||(option.equalsIgnoreCase("BV")))
			{
		Enter("Mayur "+option+" Event", By.xpath("//*[@id=\"title\"]"));
		ddSelect(By.xpath("//*[@id=\"webcastType\"]"), "Broadcast Video");
		System.out.println(option+" Event Is Selected");
			}
			
	
	
	}
		
	public String fetch(By Locator) {
		return find(Locator).getText();	
		
	}
	
	public String title() {
		return driver.getTitle();
		
	}
	
	public void tab(By Locator) {
		driver.findElement(Locator).sendKeys(Keys.TAB);
	}
	
	public void dateSelect(By Calender,By Date) {
		Click(Calender);
		Click (Date);
	}
			
	public void refresh() {
		driver.navigate().refresh();
	}
	
	public void clear(By Locator) {
		driver.findElement(Locator).clear();
	}
	
	public void close() {
		driver.close();
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void OpenPMXD(By Active_Tab_Classname, By PMXD_Locator, By OverviewLocator) throws InterruptedException {
		if (Active_Tab_Classname.equals("Overview")) {
			Click(PMXD_Locator);
					
		}
		
		else
		{
			Click(OverviewLocator);
			Thread.sleep(5000);
			Click(PMXD_Locator);
			
		}
		
	}
	
	public void loginRole(String Role)
	{
		if (Role.equalsIgnoreCase("Producer")) {
		Click(By.xpath("//*[@id=\"loginButton\"]"));
			
		}
		
		else if (Role.equalsIgnoreCase("Presenter")) {
			Click(By.xpath("//*[@id=\"presenterLogin\"]/div"));
		}
	
		else if ((Role.equalsIgnoreCase("QA"))||(Role.equalsIgnoreCase("QASCREENER"))) {
			Click(By.xpath("//*[@id=\"screenerLogin\"]/div/div"));
		}
	}
	
	public void register(String Fname,String Lname,String Email, String Language ) {
		Enter(Fname, By.xpath("//*[@id=\"firstname\"]"));
		Enter (Lname, By.xpath("//*[@id=\"lastname\"]"));
		Enter (Email, By.xpath("//*[@id=\"email\"]"));
		ddSelect(By.cssSelector("select#language_dropdown"),Language);
			
	}
	
	public void doubleClick(By Locator) {
		  WebElement folder = driver.findElement(Locator);
	        Actions action = new Actions (driver);
	        action.doubleClick(folder).sendKeys("‡ËÏÚ˘¿»Ã“Ÿ").build().perform();
	        action.sendKeys(Keys.TAB).build().perform();
	        
            
    }
	
	public void wait (By Element_to_be_Clickable, int wait_time) {
		WebDriverWait wait=new WebDriverWait(driver, wait_time);
		wait.until(ExpectedConditions.elementToBeClickable(Element_to_be_Clickable));
		
	}
	
	public void countLinks(){
		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		System.out.println(linklist.size());
	
	}
	
	public void printLinks() {
		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		
		
		for (int i=0;i<linklist.size();i++) {
			String s  = linklist.get(i).getText();
			System.out.println("The link"+ i +"text is "+s);
		}

	}
	
	public void quit() {
		driver.quit();
	}
	
	public static void dClick(WebElement element) throws InterruptedException {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;

	js.executeScript("var evt = document.createEvent('MouseEvents');"
			+ "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false,false, 0,null); arguments[0].dispatchEvent(evt);", element);
			js.executeScript("arguments[0].value='Kirtesh';", element);
	}
	
}
