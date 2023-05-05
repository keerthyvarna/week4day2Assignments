package week4day2assignments;
/*Salesforce Customer service:
1.Launch the browser
2.Load the url as " https://login.salesforce.com/ "
3.Enter the username as "hari.radhakrishnan@qeagle.com"
4. Enter the password as "Leaf@123 "
5.click on the login button
6.click on the learn more option in the Mobile publisher
7.Switch to the next window using Windowhandles.
8.click on the confirm button in the redirecting page
9.Get the title
10.Get back to the parent window
11.close the browser*/

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Salesforce {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@1234");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> wh = driver.getWindowHandles();
		List<String> whs = new ArrayList<String>(wh);
		driver.switchTo().window(whs.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		String title = driver.getTitle();
		System.out.println("Title:"+title);
		driver.switchTo().window(whs.get(0));
		driver.quit();
		
		
	}

}
