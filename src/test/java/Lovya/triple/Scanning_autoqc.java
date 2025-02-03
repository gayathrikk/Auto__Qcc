package Lovya.triple;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
 
import io.restassured.response.Response;

public class Scanning_autoqc {
    private RemoteWebDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        URL url = new URL("http://172.20.23.92:4443/wd/hub");
        driver = new RemoteWebDriver(url, options);
    }

    @Test(priority = 1)
    
    public void Login() throws InterruptedException {
        driver.get("http://apollo2.humanbrain.in/");
        driver.manage().window().maximize();
        System.out.println("The server is Opened successfully");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement viewerSectionLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/gallery.svg']")));
        viewerSectionLink.click();
        System.out.println("The Viewer Icon is clicked");

        String parentWindow = driver.getWindowHandle();
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
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

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
        emailInput.sendKeys("softwaretestingteam9@gmail.com");
        System.out.println("Mail Id is entered");

        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
        nextButton.click();
        System.out.println("The Next Button is clicked");

        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        passwordInput.sendKeys("Health#123");
        System.out.println("Password is entered");

        WebElement next2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
        next2.click();
        System.out.println("The Next Button is clicked");

        Thread.sleep(5000);
        driver.switchTo().window(parentWindow);
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void table() throws InterruptedException {
        String parentWindow = driver.getWindowHandle();

        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement atlas = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/cellreports.svg']")));
            atlas.click();
            Thread.sleep(3000);
            System.out.println("The Dashboard Clicked Successfully");
        } catch (Exception e) {
            System.out.println("The Dashboard is not Clicked: " + e.getMessage());
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement out = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='value outcol click'])[3]")));
            out.click();
            Thread.sleep(3000);
            System.out.println("The Imaging out Clicked Successfully");
        } catch (Exception e) {
            System.out.println("The Imaging out is not Clicked: " + e.getMessage());
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement batchViewerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@class='click link'])[3]")));
            batchViewerButton.click();
            System.out.println("The Batch Viewer Clicked Successfully");

            // Switch to the new window
            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(parentWindow)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

            try {
                WebDriverWait wait10 = new WebDriverWait(driver, 30);
                WebElement bqc = wait10.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Batch QC']")));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", bqc);  // Clicking with JavaScript
                Thread.sleep(3000);
                System.out.println("The Batch QC Button Clicked Successfully");
            } catch (Exception e) {
                System.out.println("The Batch QC Button is not Clicked: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("The Batch Viewer is not Clicked: " + e.getMessage());
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement info = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/info.svg']")));
            info.click();
            Thread.sleep(3000);
            System.out.println("The Info Icon Clicked Successfully");
        } catch (Exception e) {
            System.out.println("The Info Icon is not Clicked: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void checkColorIndicator() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement colorIndicator = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class, 'blue-square')] | //div[contains(@class, 'green-square')]")
            ));

            String colorClass = colorIndicator.getAttribute("class");

            if (colorClass.contains("green-square")) {
                System.out.println("Test Passed: Green Box is displayed (Process started and passed).");
            } else if (colorClass.contains("blue-square")) {
                System.out.println("Test Failed: Blue Box is displayed (Process not started yet).");
            } else {
                System.out.println("Test Inconclusive: Unknown color status.");
            }
        } catch (Exception e) {
            System.out.println("Error: Could not determine color status - " + e.getMessage());
        }
    }
    @Test(priority = 4)
    public void validateQCStatusAPI() {
        // Calling the API
        System.out.println("Calling get_slidebatch_qcstatus API...");
        Response response = RestAssured.given()
                .post("https://apollo2.humanbrain.in/atlas/get_slidebatch_qcstatus");

        // Printing Response
        System.out.println("API Response: " + response.getStatusCode() + " - " + response.getBody().asString());

        // Validating API Response
        if (response.getStatusCode() == 200) {
            System.out.println("✅ QC Status API Call Successful!");
        } else {
            System.out.println("❌ QC Status API Call Failed. Status Code: " + response.getStatusCode());
        }
    }
    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
