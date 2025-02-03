package Lovya.triple;
import java.net.MalformedURLException;
import org.testng.annotations.Test;


import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class add {
	private RemoteWebDriver driver;
	@BeforeTest
	public void setup() throws MalformedURLException 
	{
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		URL url = new URL("http://172.20.23.92:4443/wd/hub");
		driver = new RemoteWebDriver(url, dc);
	}
	@Test(priority=1)
	public void Login() throws InterruptedException {
		driver.get("http://apollo2.humanbrain.in/");
		driver.manage().window().maximize();
		System.out.println("The server is Opened sucessfully");
		WebDriverWait wait = new WebDriverWait(driver, 50);
		 WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/gallery.svg']")));
		loginButton.click();
		System.out.println("The Viewer Icon is clicked");
		String parentWindow = driver.getWindowHandle();
		WebDriverWait wait1= new WebDriverWait(driver, 20);
		WebElement login = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
		login.click();
		System.out.println("The login Button is clicked");
		Thread.sleep(4000);
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		Thread.sleep(4000);
		WebDriverWait wait2 = new WebDriverWait(driver,20);
		WebElement  emailInput = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
		emailInput.sendKeys("softwaretestingteam9@gmail.com");
		System.out.println("Mail I'd is entered");
		WebDriverWait wait3 = new WebDriverWait(driver,20);
		WebElement  Next = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		Next.click();
		System.out.println("The Next Button is clicked");
		WebDriverWait wait4 = new WebDriverWait(driver,20);
		WebElement  PasswordInput = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
		PasswordInput.sendKeys("Health#123");
		System.out.println("Password is entered");
		WebDriverWait wait5 = new WebDriverWait(driver,20);
		WebElement  Next2 = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		Next2.click();		
		System.out.println("The Next Button is clicked");
		Thread.sleep(5000);
		driver.switchTo().window(parentWindow);
		Thread.sleep(5000);
	}
	@Test(priority = 2)
	public void table() throws InterruptedException {
	    String parentWindow = driver.getWindowHandle();
	    try {
	        WebDriverWait wait6 = new WebDriverWait(driver, 30);
	        WebElement table1 = wait6.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search tags']")));
	        table1.sendKeys("222\n");
	        Thread.sleep(3000);
	        System.out.println("-------------------------------------------------");
	        System.out.println("The number Entered Successfully");
	    } catch (Exception e) {
	        System.out.println("-------------------------------------------------");
	        System.out.println("The number is not Entered successfully");
	    }
	    try {
	        WebDriverWait wait7 = new WebDriverWait(driver, 30);
		 WebElement table2 = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//nb-icon[@icon='viewer']")));
		    table2.click();
	        System.out.println("-------------------------------------------------");
	        System.out.println("The viewer icon is clicked");
	    } catch (Exception e) {
	        System.out.println("-------------------------------------------------");
	        System.out.println("The viewer icon is not clicked");
	    }
	    Thread.sleep(4000);
	    Set<String> allWindows = driver.getWindowHandles();
	    for (String window : allWindows) {
	        if (!window.equals(parentWindow)) {
	            driver.switchTo().window(window);
	            break;
	        }
	    }
	    try {
	        WebDriverWait wait8 = new WebDriverWait(driver, 30);
	        WebElement table3 = wait8.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='940'])[1]")));
	        Thread.sleep(3000);
	        table3.click();
	        System.out.println("-------------------------------------------------");
	        System.out.println("The number is clicked");
	    } catch (Exception e) {
	        System.out.println("-------------------------------------------------");
	        System.out.println("The number is not clicked");
	    }
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/viewer/assets/images/colorsvg/viewAtlas.svg']")));
	        icon.click();
	        Thread.sleep(3000);
	        System.out.println("-------------------------------------------------");
	        System.out.println("The Atlas editor is clicked");
	    } catch (Exception e) {
	        System.out.println("The Atlas editor is not clicked");
	    }
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/viewer/assets/images/colorsvg/oldmenu.svg']")));
	        edit.click();
	        Thread.sleep(3000);
	        System.out.println("-------------------------------------------------");
	        System.out.println("The Edit icon is clicked");
	    } catch (Exception e) {
	        System.out.println("The Edit icon is not clicked");
	    }
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 50);
	        WebElement draw = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/viewer/assets/images/colorsvg/paintbrush.svg']")));
	        draw.click();
	        Thread.sleep(3000);
	        System.out.println("-------------------------------------------------");
	        System.out.println("The Draw icon is clicked");
	    } catch (Exception e) {
	        System.out.println("The Draw icon is not clicked");
	    }
	}
	    @Test (priority=3)
	    public void atlas() throws InterruptedException {
	    	try {
		        WebDriverWait wait = new WebDriverWait(driver, 50);
		        WebElement workarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nb-accordion-item-header[text()=' Work Area ']")));
		       workarea.click();
		        Thread.sleep(3000);
		        System.out.println("-------------------------------------------------");
		        System.out.println("The work area is selected");
		    } catch (Exception e) {
		        System.out.println("The work area is not selectedd");
		    }
	   
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 50);
	        Thread.sleep(3000);
	        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[text()=' 937 ']")));
	       section.click();
	        Thread.sleep(3000);
	        System.out.println("-------------------------------------------------");
	        System.out.println("The section is selected");
	    } catch (Exception e) {
	        System.out.println("The section is not selectedd");
	    }
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 50);
	        WebElement contributor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[text()=' Base Atlas ']")));
	       contributor.click();
	        Thread.sleep(3000);
	        System.out.println("-------------------------------------------------");
	        System.out.println("The contributor is selected");
	    } catch (Exception e) {
	        System.out.println("The contributor is not selectedd");
	    }
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 50);
	        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[text()='Append']")));
	       option.click();
	        Thread.sleep(3000);
	        System.out.println("-------------------------------------------------");
	        System.out.println("The option is selected");
	    } catch (Exception e) {
	        System.out.println("The option is not selectedd");
	    }
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 50);
	        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Copy GeoJson']")));
	        button.click();
	        Thread.sleep(3000);
	        System.out.println("-------------------------------------------------");
	        System.out.println("The copy button is clicked");
	    } catch (Exception e) {
	        System.out.println("The copy button is not clicked");
	    }
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 50);
	        WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/viewer/assets/images/colorsvg/saved.svg']")));
	        save.click();
	        Thread.sleep(3000);
	        System.out.println("-------------------------------------------------");
	        System.out.println("The save button is clicked");
	    } catch (Exception e) {
	        System.out.println("The save button is not clicked");
	    }
	    

	    WebElement canvas = driver.findElement(By.xpath("//canvas"));
	    Thread.sleep(3000);
        Actions actions = new Actions(driver);
        int centerX = 0; 
        int centerY = 0; 

        
        actions.moveToElement(canvas, centerX, centerY)
                .click()
                .perform();
	   
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 50);
	        WebElement del1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/viewer/assets/images/colorsvg/deleted.svg']")));
	        del1.click();
	        Thread.sleep(3000);
	        System.out.println("-------------------------------------------------");
	        System.out.println("The Delete1 button is clicked");
	    } catch (Exception e) {
	        System.out.println("The Delete button is not clicked");
	    }
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 50);
	        WebElement del = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Delete']")));
	        del.click();
	        Thread.sleep(3000);
	        System.out.println("-------------------------------------------------");
	        System.out.println("The Delete button is clicked");
	    } catch (Exception e) {
	        System.out.println("The Delete button is not clicked");
	    }
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 50);
	        Thread.sleep(3000);
	        WebElement save1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/viewer/assets/images/colorsvg/saved.svg']")));
	        save1.click();
	        Thread.sleep(3000);
	        System.out.println("-------------------------------------------------");
	        System.out.println("The save button is clicked");
	    } catch (Exception e) {
	        System.out.println("The save button is not clicked");
	    }
	    
	       	}
	    @AfterTest
		public void tearDown() {
			if (driver != null) {
				driver.quit();
			}}
	}