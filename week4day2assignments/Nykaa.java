package week4day2assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

/*1) Go to  https://www.nykaa.com/
2) Mouseover on Brands and Search L'Oreal Paris
3) Click L'Oreal Paris
4) Check the title contains L'Oreal Paris(Hint-GetTitle)
5) Click sort By and select customer top rated
6) Click Category and click Hair->Click haircare->Shampoo
7) Click->Concern->Color Protection
8)check whether the Filter is applied with Shampoo
9) Click on L'Oreal Paris Colour Protect Shampoo
10) GO to the new window and select size as 175ml
11) Print the MRP of the product
12) Click on ADD to BAG
13) Go to Shopping Bag 
14) Print the Grand Total amount
15) Click Proceed
16) Click on Continue as Guest
17) Check if this grand total is the same in step 14
18) Close all windows
*/
public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement a = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions action = new Actions(driver);
		action.moveToElement(a).perform();
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		Thread.sleep(3000);
		 driver.findElement(By.linkText("L'Oreal Paris")).click();
		 System.out.println(driver.getTitle());
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//div[@class='filter-open css-1gdff5r']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(//div[@class=' css-1nozswx'])[2]")).click();
		 driver.findElement(By.xpath("(//div[@class=' css-1nozswx'])")).click();
		 driver.findElement(By.xpath("//div[@class='control-indicator checkbox ']")).click();
		 driver.findElement(By.xpath("//span[text()='Concern']")).click();
		 driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[11]")).click();
		 driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();
		 Set<String> wh = driver.getWindowHandles();
		 List<String> whs = new ArrayList<String>(wh);
		 driver.switchTo().window(whs.get(1));
		 driver.findElement(By.xpath("//button[@class=' css-1r0ze8m']")).click();
		 String text1 = driver.findElement(By.xpath("//div[@class='css-1d0jf8e']")).getText();
		 System.out.println("MRP: "+text1);
		 driver.findElement(By.xpath("//button[@class=' css-13zjqg6']")).click();
		 driver.findElement(By.xpath("//button[@class='css-aesrxy']")).click();
		 Thread.sleep(6000);
		 driver.switchTo().frame(0);
		 String text2 = driver.findElement(By.xpath("//span[@class='css-1um1mkq e171rb9k3']")).getText();
		 System.out.println("Grand total: "+ text2);
		 driver.findElement(By.xpath("//div[@class='css-15vhhhd e25lf6d4']")).click();
		 driver.switchTo().defaultContent();
		 driver.findElement(By.xpath("(//button[@class='css-110s749 e8tshxd1'])[2]")).click();
		 driver.findElement(By.xpath("(//img[@class='css-16z7tzi ek8d9s80'])[2]")).click();
		 String text3 = driver.findElement(By.xpath("//p[@class='css-1e59vjt eka6zu20']")).getText();
		 System.out.println(text3);
		 
		 if(text2.equals(text3)) {
			 System.out.println("grand total is the same");
		 }else {
			 System.out.println("not same");
		 }
		 
		 
		 
		 

	}

}
