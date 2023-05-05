package week4day2assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LeafGround {
	  static String str="100%";

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
        driver.get("https://leafground.com/drag.xhtml");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(3000);
        
       //draggable
        WebElement drag = driver.findElement(By.xpath("//span[text()='Drag me around']"));
        Actions act = new Actions(driver);
        act.dragAndDropBy(drag, 100, 100).perform();
        
       //droppable
        WebElement drag1 = driver.findElement(By.xpath("//div[@id='form:drag_content']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='form:drop_content']"));
        act.dragAndDrop(drag1, drop).perform();
        
		//drag columns
        WebElement target = driver.findElement(By.xpath("//th[@aria-label='Name']"));
        WebElement source = driver.findElement(By.xpath("//th[@aria-label='Category']"));
        act.dragAndDrop(source, target).perform();
        Thread.sleep(3000);
           
		//drag rows
	    WebElement row1 =driver.findElement(By.xpath("(//td[text()='Galaxy Earrings'])[2]"));
   	    WebElement row2 = driver.findElement(By.xpath("(//td[text()='Black Watch'])[2]"));
	    act.dragAndDrop(row1,row2).perform();
	    
	    //progress bar
	    act.keyDown(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Start']")).click();
        Thread.sleep(40000);
        String text = driver.findElement(By.xpath("//div[@class='ui-progressbar-label']")).getText();
        System.out.println("Progress status :"+text);
        if(text.contains(str)) {
        	System.out.println("Completed!");
        }
        else {
        	System.out.println("Not completed!");
        }
        Thread.sleep(3000);
        
        //Range Slider
        WebElement left = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
        WebElement right = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        act.dragAndDropBy(left, 50, 0).perform();
        Thread.sleep(2000);
        act.dragAndDropBy(right, -30, 0).perform();
        Thread.sleep(3000);
        driver.close();
        
	   
		
	}

}
