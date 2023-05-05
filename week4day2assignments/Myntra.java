package week4day2assignments;
/*1) Open https://www.myntra.com/
2) Mouse hover on MeN 
3) Click Jackets 
4) Find the total count of the item 
5) Validate the sum of categories count matches
6) Check jackets
7) Click + More options under BRAND
8) Type Duke and click checkbox
9) Close the pop-up x
10) Confirm all the Coats are of brand Duke
    Hint : use List 
11) Sort by Better Discount
12) Find the price of the first displayed item
Click on the first product
13) Take a screen shot
14) Click on WishList Now
15) Close Browser*/

import java.io.File;

import java.nio.file.Files;
//import java.io.File;
//import java.io.File;
//import java.nio.file.Files;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement a = driver.findElement(By.xpath("//a[@class='desktop-main']"));
		Actions action = new Actions(driver);
		action.moveToElement(a).perform();
	    driver.findElement(By.xpath("(//li/a[text()='Jackets'])[1]")).click();
	    String text = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
	    System.out.println("total count of jackets: "+text);
	    WebElement txt1 = driver.findElement(By.xpath("//label[text()='Jackets']"));
        String t1=txt1.getText();
        System.out.println("Category :"+t1);
        WebElement txt2 = driver.findElement(By.xpath("//label[text()='Rain Jacket']"));
        String t2=txt2.getText();
        System.out.println("         :"+t2);
        WebElement prc1 = driver.findElement(By.xpath("(//label/span[@class='categories-num'])[1]"));
        String pc1=prc1.getText();
        String str1=pc1.replaceAll("[^0-9]", "");
        int i=Integer.parseInt(str1);
        WebElement prc2 = driver.findElement(By.xpath("(//label/span[@class='categories-num'])[2]"));
        String pc2=prc2.getText();
        String str2=pc2.replaceAll("[^0-9]", "");
        int j=Integer.parseInt(str2);
        int k=i+j;
        System.out.println("Sum of categories count :"+k);
        driver.findElement(By.xpath("(//label/span[@class='categories-num'])[1]")).click();
        driver.findElement(By.xpath("//div[@class='brand-more']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
        driver.findElement(By.xpath("//label[text()='Duke']")).click();
        driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
        
//        WebElement pages = driver.findElement(By.xpath("//li[@class='pagination-paginationMeta']"));
//        System.out.println(pages.getText());
        
        List<WebElement> list = driver.findElements(By.xpath("//h3[text()='Duke']"));
        List<WebElement> pgl = driver.findElements(By.xpath("//li[@class='pagination-number']"));
        //System.out.println("Pages :"+pgl.size());
        
        int count=0;
        for(int x=1;x<=pgl.size();x++) {
        	driver.findElement(By.xpath("(//li[@class='pagination-number'])"+"["+x+"]")).click();
        	List<WebElement> inList = driver.findElements(By.xpath("//h3[text()='Duke']"));
            
            count=count+inList.size();
        }
        int finalCount=count+list.size();
        System.out.println("The count of brand Duke coats are  :"+finalCount);
        WebElement sort = driver.findElement(By.className("sort-sortBy"));
        action.moveToElement(sort).perform();
        driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
        WebElement firstProPrice = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]"));
        System.out.println("Price of the first displayed item :"+firstProPrice.getText());
        driver.findElement(By.xpath("(//picture[@class='img-responsive'])[1]")).click();
        Set<String> wh = driver.getWindowHandles();
        List<String> whs= new ArrayList<String>(wh);
        driver.switchTo().window(whs.get(1));
      // File obj= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Files.copy(obj, new File("C:\\Users\\Keerthy\\Pictures\\Screenshots\\myntraimg.jpg"));
        driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
        action.pause(1000).perform();
        driver.quit();
  
	}


	}


