package week4day2assignments;
/*1. Launch https://www.snapdeal.com/

2. Go to Mens Fashion
3. Go to Sports Shoes
4. Get the count of the sports shoes
5. Click Training shoes
6. Sort by Low to High
7. Check if the items displayed are sorted correctly
8.Select the price range (900-1200)
9.Filter with color Navy 
10 verify the all applied filters 
11. Mouse Hover on first resulting Training shoes
12. click QuickView button
13. Print the cost and the discount percentage
14. Take the snapshot of the shoes.
15. Close the current window
16. Close the main window*/


import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
public class Snapdeal {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[@class='catText']")).click();
		driver.findElement(By.xpath("//span[@class='linkTest']")).click();
		String text = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
        System.out.println("count of sports shoes: "+text);
        driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
        driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
        driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900");
        driver.findElement(By.xpath("//input[@name='toVal']")).clear();
        driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200");
        Actions act =new Actions(driver);
        act.pause(2000).perform();
        
        WebElement go = driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']"));
        driver.executeScript("arguments[0].click();",go);
        WebElement nvy = driver.findElement(By.xpath("//label[@for='Color_s-Navy']"));
        driver.executeScript("arguments[0].click();", nvy);
        WebElement image = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
       
        act.moveToElement(image);
        WebElement View = driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']"));
        driver.executeScript("arguments[0].click();", View);
        String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
        System.out.println("price: Rs."+price);
       
        String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
        System.out.println("Discount: "+discount);
        act.pause(3000).perform();
        
        driver.findElement(By.xpath("//div/div[2]/i[@class='sd-icon sd-icon-delete-sign']")).click();
        act.pause(3000).perform();
        driver.quit();
        
       
	}

}
