package week4day2assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundFrames {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
        driver.get("https://leafground.com/frame.xhtml;jsessionid=node05us3gij8ed091h38fieurov685953.node0");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("(//button[text()='Click Me'])[1]")).click();
        WebElement result1 = driver.findElement(By.xpath("//button[contains(text(),'You Clicked')]"));
        System.out.println(result1.getText());
        driver.switchTo().defaultContent();
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println("Total frames in this pages are :"+frames.size());
       // WebElement outerFrame = driver.findElement(By.xpath("(//iframe)[3]"));
       // driver.switchTo().frame(outerFrame);
        driver.switchTo().frame(2);
        driver.switchTo().frame("frame2");
        driver.findElement(By.id("Click")).click();
        WebElement result2 = driver.findElement(By.xpath("//button[contains(text(),'You Clicked')]"));
        System.out.println("Inside nested frame :"+result2.getText());   
        driver.close();
	}


	}


