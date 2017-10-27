package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class app {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\CesarPc\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("https://www.google.cl");
			wait = new WebDriverWait(driver, 1);
			searchInGoogle();
			
			
			driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void searchInGoogle() {
		try {
			driver.findElement(By.id("lst-ib")).sendKeys("hola");
			
			WebElement click1 =driver.findElement(By.className("lsb"));
			wait.until(ExpectedConditions.elementToBeClickable(click1));
			click1.click();
			
			driver.findElement(By.id("lst-ib")).clear();
			driver.findElement(By.id("lst-ib")).sendKeys("hola2");
			WebElement click2 = driver.findElement(By.name("btnG"));
			wait.until(ExpectedConditions.elementToBeClickable(click2));
			click2.click();
			
			WebElement page = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/h3/a"));
			wait.until(ExpectedConditions.elementToBeClickable(page));
			page.click();
			
			
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		app myObj = new app();
		myObj.invokeBrowser();

	}

}
