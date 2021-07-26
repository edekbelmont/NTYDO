package TestPack;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class TwitterLogin {

	public static void main(String[] args) throws InterruptedException, IOException {
	
		WebDriver driver;
		
		String user="";
		String pass="";
		
		ChromeOptions coptions = new ChromeOptions();
		
		System.setProperty("webdriver.chrome.driver", "/Users/abc/Desktop/chromedriver");
		
		driver = new ChromeDriver(coptions);
		
		driver.get("http://twitter.com/login");
		
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@placeholder='Phone, email or username']")));
		
		WebElement userTextField = driver.findElement(By.xpath(".//input[@placeholder='Phone, email or username']"));
		userTextField.sendKeys(user);
		
		WebElement PassTextField = driver.findElement(By.xpath(".//input[@class='js-password-field']"));
		PassTextField.sendKeys(pass);
		
		driver.findElement(By.xpath(".//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		
		WebElement tweetBox = driver.findElement(By.id("tweet-box-home-timeline"));
		tweetBox.click();
		tweetBox.sendKeys("Buying GF");
		
		driver.findElement(By.xpath(".//button[@class='tweet-action EdgeButton EdgeButton--primary js-tweet-btn']")).click();
		
		Thread.sleep(2000);
		
		File srce = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		Files.copy(srce, new File("/Users/abc/Desktop/Screenshots/Tweet.png"));
		
		driver.findElement(By.id("user-dropdown-toggle")).click();
		
		WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.id("signout-button")));
		logout.click();
		
		Thread.sleep(2000);
		
		driver.quit();
	}
}