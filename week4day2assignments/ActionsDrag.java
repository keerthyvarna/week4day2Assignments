package week4day2assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDrag {

	public static void main(String[] args) {
		
			ChromeDriver driver=new ChromeDriver();
	        driver.get("https://jqueryui.com/draggable/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        driver.switchTo().frame(0);
	        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
	        Actions act = new Actions(driver);
	        act.dragAndDropBy(drag, 200,200).perform();
	        driver.close();
	}

}
