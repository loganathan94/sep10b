package basce.clas;

import java.security.PublicKey;
import java.sql.Driver;
import java.sql.DriverAction;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasceClass {
	
	public static WebDriver driver;
	
	public static WebDriver launchBrowser(String browsername) {
	switch (browsername) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		break;
	case"firefox":
  WebDriverManager.firefoxdriver().setup();
	 driver=new FirefoxDriver();
    break;
	case"edge":
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
	break;
	
	default:
		System.err.println(">>invalid Browser<<");
		break;
	}
	return driver;
		 
	}
	
	public static void max() {
		driver.manage().window().maximize();
	}

public static void timewait(int sec) {
	driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
}


  public static WebElement findelement(String locatorname,String value) {
	  WebElement e=null;
	if (locatorname.equalsIgnoreCase("id")) {
		e=driver.findElement(By.id(value));
	}
	else if (locatorname.equalsIgnoreCase("name")) {
		e=driver.findElement(By.name(value));
		
	}
else if (locatorname.equalsIgnoreCase("xpath")) {
	e=driver.findElement(By.xpath(value));
}
	return e;
	}
  
  
  public static void filltext(WebElement e,String value) {
	e.sendKeys(value);
  }
	
  public static void btn(WebElement e) {
	e.click();
}
  public static String  getattribute(WebElement e) {
	return e.getAttribute("value");
}
  public static WebElement jsset(WebElement e,String input) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeAsyncScript("arguments[0].setAttribute('value','"+input+"')",e);
	return e;
}
 
  public static void returnattribute(WebElement e,String input) {
	
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeAsyncScript("retun arguments[0].getAttribute('value','"+input+"')",e);
}
  public static void scrolldown(WebElement e) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoview(true)", e);
}
  
  
public static String currenturl() {
	 return driver.getCurrentUrl();
}
	

  public static void launchurl(String pageid) {
	driver.get(pageid);
	
}
 
	public static WebDriver windowswich(int index) {
		
		 Set<String> window = driver.getWindowHandles();
	        java.util.List<String> list=new ArrayList<String>(window);
	        return driver.switchTo().window(list.get(index));
	}
	
	
	
	
public static void selectdropd(WebElement e,int a) {
	Select s=new Select(e);
	s.selectByIndex(a); 
	
	
}
	


}
  
  
