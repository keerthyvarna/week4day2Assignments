package week4day2assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionResize {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
        driver.get("https://jqueryui.com/resizable/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.switchTo().frame(0);
        WebElement res = driver.findElement(By.xpath("//div[contains(@class,'ui-resizable-handle ui-resizable-se ui-icon ui-icon-grips')]"));
        Actions act = new Actions(driver);
        act.clickAndHold(res).moveByOffset(100, 100).perform();
		driver.close();
	}

}
