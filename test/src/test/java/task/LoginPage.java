package task;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class LoginPage {
	@Test
	public  void login() {
		//Step 01: Launch the browser
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
				
				//Step 02: Enter the main URL 
				driver.get("https://demo.actitime.com/");
				String expectedLoginPageTitle = "actiTIME - Login";
				System.out.println("expectedLoginPageTitle  = " + expectedLoginPageTitle);
				String actaualLoginPageTitle = driver.getTitle();
				System.out.println("actaualLoginPageTitle = " + actaualLoginPageTitle);
				String expectedLoginPageUrl = "https://demo.actitime.com/login.do";
				System.out.println("expectedLoginPageUrl = " + expectedLoginPageUrl);
				String actualLoginPageUrl = driver.getCurrentUrl();
				System.out.println("actualLoginPageUrl = " + actualLoginPageUrl);
				if (actaualLoginPageTitle.equals(expectedLoginPageTitle)) {
					System.out.println("The Title of the Login Page is found correct and it is verified.");
					if (actualLoginPageUrl.equals(expectedLoginPageUrl)) {
						System.out.println("The URL of the LOgin Page is found correct and verified.");
						System.out.println("Pass: The Login page is displayed");
						//Step 03: Enter the Valid User name 
						WebElement usernameTextField = driver.findElement(By.id("username"));
						if (usernameTextField.getAttribute("value").isEmpty()) {
							usernameTextField.sendKeys("admin");
						}else {
							System.out.println("Username text is having preoccupied value.");
						}
						//Step 04: Enter the Valid Password
						WebElement passwordTextField = driver.findElement(By.name("pwd"));
						if (passwordTextField.getAttribute("value").isEmpty()) {
							passwordTextField.sendKeys("manager");
						}else {
							System.out.println("Password text field  is having preoccupied value.");
						}
						WebElement loginButton = driver.findElement(By.id("loginButton"));
						//Step 05: Click on Login Button
						loginButton.click();
						String expectedHomePageTitle = "actiTIME - Enter Time-Track";
						System.out.println("expectedHomePageTitle = " + expectedHomePageTitle);
						wait.until(ExpectedConditions.titleIs(expectedHomePageTitle));
						String actualHomePageTitle = driver.getTitle();
						System.out.println("actualHomePageTitle = " + actualHomePageTitle);
						String expectedHomePageUrl = "https://demo.actitime.com/user/submit_tt.do";
						System.out.println("expectedHomePageUrl = " + expectedHomePageUrl);
						String actualHomePageUrl = driver.getCurrentUrl();
						System.out.println("actualHomePageUrl = " + actualHomePageUrl);
		}
				}
				}

	}
