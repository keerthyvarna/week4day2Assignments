package week4day2assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionSelect {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
        driver.get("https://jqueryui.com/selectable/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.switchTo().frame(0);
        WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 6']"));
        WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 7']"));
        Actions act = new Actions(driver);
        act.keyDown(Keys.CONTROL).click(item1).click(item2).keyUp(Keys.CONTROL).perform();
        driver.close();
	}

}
