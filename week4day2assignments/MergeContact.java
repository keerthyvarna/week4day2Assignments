package week4day2assignments;
/*
 * //Pseudo Code
 * 
 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
 * 
 * 2. Enter UserName and Password Using Id Locator
 * 
 * 3. Click on Login Button using Class Locator
 * 
 * 4. Click on CRM/SFA Link
 * 
 * 5. Click on contacts Button
 * 	
 * 6. Click on Merge Contacts using Xpath Locator
 * 
 * 7. Click on Widget of From Contact
 * 
 * 8. Click on First Resulting Contact
 * 
 * 9. Click on Widget of To Contact
 * 
 * 10. Click on Second Resulting Contact
 * 
 * 11. Click on Merge button using Xpath Locator
 * 
 * 12. Accept the Alert
 * 
 * 13. Verify the title of the page
 */

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> wh = driver.getWindowHandles();
		List<String>whs = new ArrayList<String>(wh);
		driver.switchTo().window(whs.get(1));
		driver.findElement(By.xpath("//div/a[@class='linktext']")).click();
		driver.switchTo().window(whs.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Thread.sleep(3000);
		Set<String> wh1 = driver.getWindowHandles();
	    List<String> whs1= new ArrayList<String>(wh1);
	    driver.switchTo().window(whs1.get(1));
		driver.findElement(By.xpath("(//div/a[@class='linktext'])[5]")).click();
		driver.switchTo().window(whs1.get(0));
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
