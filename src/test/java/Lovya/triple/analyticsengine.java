package Lovya.triple;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Set;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
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

public class analyticsengine {
	private RemoteWebDriver driver;

	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		URL url = new URL("http://172.20.23.92:4443/wd/hub");
		driver = new RemoteWebDriver(url, dc);
	}

	@Test(priority = 1)
	public void Login() throws InterruptedException {
		driver.get("http://apollo2.humanbrain.in/");
		driver.manage().window().maximize();
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The server is Opened sucessfully");
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement viewerSectionLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/gallery.svg']")));
		viewerSectionLink.click();
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The Viewer Icon is clicked");
		String parentWindow = driver.getWindowHandle();
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement login = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
		login.click();
		System.out.println("--------------------------*****************-----------------------");
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
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		WebElement emailInput = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
		emailInput.sendKeys("softwaretestingteam9@gmail.com");
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("Mail I'd is entered");
		WebDriverWait wait3 = new WebDriverWait(driver, 20);
		WebElement Next = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		Next.click();
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The Next Button is clicked");
		WebDriverWait wait4 = new WebDriverWait(driver, 20);
		System.out.println("--------------------------*****************-----------------------");
		WebElement PasswordInput = wait4
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
		PasswordInput.sendKeys("Health#123");
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("Password is entered");
		WebDriverWait wait5 = new WebDriverWait(driver, 20);
		WebElement Next2 = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		Next2.click();
		System.out.println("--------------------------*****************-----------------------");
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
			WebElement table1 = wait6
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search tags']")));
			table1.sendKeys("AuTest\n");
			Thread.sleep(3000);
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The number Entered Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The number is not Entered successfully");
		}
		try {
			WebDriverWait wait7 = new WebDriverWait(driver, 30);
			WebElement table2 = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//nb-icon[@nbtooltip='Atlas Editor']")));
			table2.click();
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Altas Editor is clicked");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Atlas Editor is not clicked");
		}
		Thread.sleep(4000);
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}
	@Test(priority = 3)
	public void contributor() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement gt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/oldmenu.svg']")));
			gt.click();
			Thread.sleep(3000);
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("Edit Menu selected Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("Edit Menu  is not selected");
		}
		try {
			WebDriverWait wait6 = new WebDriverWait(driver, 30);
			WebElement contri = wait6.until(ExpectedConditions.elementToBeClickable(By.xpath(" //nb-accordion-item-header[text()='Contributors']")));
			contri.click();
			Thread.sleep(3000);
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("Our contributor selected Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("Our Contributor   is not selected");
		}
	try {
		WebDriverWait wait6 = new WebDriverWait(driver, 30);
		WebElement radio = wait6.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='radio'])[2]")));
		radio.click();
		Thread.sleep(3000);
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The software Team contributor is selected Successfully");
	} catch (Exception e) {
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The software Team contributor is  not selected");
	}
	
	try {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement draw = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/paintbrush.svg']")));
		draw.click();
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The draw menu button is clicked");
	} catch (Exception e) {
		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The draw menu button is not clicked");
	}  
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);

			// Click on the annotation icon
			WebElement ww = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//button[text()='Unlock']")));
			ww.click();

			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Unlock button is selected");

		} catch (Exception e) {
			System.out.println("The Unlock button is not selected");
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);

			// Click on the annotation icon
			WebElement WorkArea = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//nb-accordion-item-header[text()=' Work Area ']")));
			WorkArea.click();

			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The WorkArea Option is selected");

		} catch (Exception e) {
			System.out.println("The WorkArea Option is not selected");
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);

			// Click on the annotation icon
			WebElement Select = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='select2']")));
			Select.click();

			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Select Option is selected");

		} catch (Exception e) {
			System.out.println("The Select Option is not selected");
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);

			// Click on the annotation icon
			WebElement section = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//option[text()=' 142 ']")));
			section.click();

			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Section Number is selected");

		} catch (Exception e) {
			System.out.println("The Section Number is not selected");
		}
	
	try {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		// Click on the annotation icon
		WebElement ContriSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='contributor-select']")));
		ContriSelect.click();

		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The Contributor Select Option is selected");

	} catch (Exception e) {
		System.out.println("The Contributor Option is not selected");
	}
	try {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		// Click on the annotation icon
		WebElement section = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//option[text()=' Base Atlas ']")));
		section.click();

		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The BaseAtlas is selected");

	} catch (Exception e) {
		System.out.println("The BaseAtlas is not selected");
	}
	try {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		// Click on the annotation icon
		WebElement CheckBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='custom-checkbox'])[1]")));
		CheckBox.click();

		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The CheckBox is Clicked");

	} catch (Exception e) {
		System.out.println("The CheckBox is not Clicked");
	}
	try {
	    WebDriverWait wait = new WebDriverWait(driver, 50);

	    // Click on the annotation icon
	    WebElement copyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Copy GeoJson']")));
	    Thread.sleep(3000);
	    copyButton.click();
	    Thread.sleep(3000);
	    System.out.println("--------------------------*****************-----------------------");
	    System.out.println("The CopyButton is Clicked");

	    // Make API call
	    String apiUrl = "https://apollo2.humanbrain.in/imaging_service/i2iregdev"; // API URL
	    URL url = new URL(apiUrl);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    connection.setRequestMethod("GET");  // or POST based on the API method
	    
	    // Set headers if necessary
	    connection.setRequestProperty("Content-Type", "application/json");
	    
	    int responseCode = connection.getResponseCode();
	    if (responseCode == HttpURLConnection.HTTP_OK) { // 200
	        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	        }
	        in.close();
	        System.out.println("API Response: " + response.toString());
	    } else if (responseCode == HttpURLConnection.HTTP_FORBIDDEN) { // 403
	        System.out.println("API Request failed with 403 Forbidden. Test case will fail.");
	        throw new Exception("API Request failed with 403 Forbidden.");
	    } else {
	        System.out.println("API Request failed. Response Code: " + responseCode);
	        throw new Exception("API Request failed with code: " + responseCode);
	    }
	} catch (TimeoutException e) {
	    System.out.println("Timeout occurred: The CopyButton was not found.");
	    e.printStackTrace();
	} catch (IOException e) {
	    System.out.println("API Request failed: " + e.getMessage());
	    e.printStackTrace();
	} catch (Exception e) {
	    System.out.println("Test case failed: " + e.getMessage());
	    e.printStackTrace();
	}
	try {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		Thread.sleep(3000);
		WebElement annotation = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//nb-accordion-item-header[text()='Annotation']")));
		Thread.sleep(3000);
		annotation.click();

		System.out.println("-------------------------------------------------");
		System.out.println("The annotation icon is clicked");

	} catch (Exception e) {
		System.out.println("The annotation icon is not clicked");
	}
	try {
		Actions actions = new Actions(driver);
		Thread.sleep(3000);
		actions.keyDown(Keys.ALT).sendKeys("v").keyUp(Keys.ALT).build().perform();
		Thread.sleep(3000);
		System.out.println("-------------------------------------------------");
		System.out.println("Action executed successfully!");

	} catch (NoSuchElementException e) {
		System.out.println("Element not found: " + e.getMessage());
	} catch (Exception e) {
		System.out.println("Error executing action: " + e.getMessage());
	}
	try {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement search = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
		search.sendKeys("brain");
		Thread.sleep(3000);
		System.out.println("-------------------------------------------------");
		System.out.println("The search icon is clicked");
	} catch (Exception e) {
		System.out.println("The search icon is not clicked");
	}
	try {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		// Click on the annotation icon
		WebElement id = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='1_anchor']")));
		Thread.sleep(3000);
		id.click();
		Thread.sleep(3000);

		System.out.println("--------------------------*****************-----------------------");
		System.out.println("The Brain name has clicked");

	} catch (Exception e) {
		System.out.println("The Brain name has not clicked");
	}}
//	try {
//		Actions actions = new Actions(driver);
//		Thread.sleep(3000);
//
//		// Press p + V
//		actions.keyDown(Keys.ALT).sendKeys("v").keyUp(Keys.ALT).build().perform();
//		Thread.sleep(3000);
//		System.out.println("-------------------------------------------------");
//		System.out.println("Action executed successfully!");
//
//	} catch (NoSuchElementException e) {
//		System.out.println("Element not found: " + e.getMessage());
//	} catch (Exception e) {
//		System.out.println("Error executing action: " + e.getMessage());
//	}
	@Test (priority=4)
	public void vlaidate() throws Exception {
	try {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		// Click on the annotation icon
		WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' 1 : Brain-Br ']")));
		Thread.sleep(3000);
		 text.getText();
		 Thread.sleep(3000);
		 String t1 = text.getText();
			String expectedText = "1 : Brain-Br";
			Assert.assertEquals(t1, expectedText);
			System.out.println("Assertion passed: " + t1 + " matches the expected value.");
		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());
			// Re-throw the AssertionError
			throw e;
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			// Re-throw the Exception
			throw e;
		}
	}
	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}