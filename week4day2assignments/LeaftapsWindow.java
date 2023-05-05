package week4day2assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeaftapsWindow {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
        driver.get("https://leafground.com/window.xhtml;jsessionid=node0ohpw87cjok1dz9p1fgudvj6l12019.node0");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//span[text()='Open']")).click();
        Set<String> wh = driver.getWindowHandles();
        List<String> whs= new ArrayList<String>(wh);
        driver.switchTo().window(whs.get(1));
        System.out.println("New window title :"+driver.getTitle());
        driver.close();
        driver.switchTo().window(whs.get(0));
        driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
        Set<String> wh1 = driver.getWindowHandles();
        List<String> whs1= new ArrayList<String>(wh1);
        System.out.println("number of tabs opened:"+whs1.size());
        driver.switchTo().window(whs1.get(2));
        driver.close();
        driver.switchTo().window(whs1.get(1));
        driver.close();
        driver.switchTo().window(whs1.get(0));
        driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
        Set<String> wh2 = driver.getWindowHandles();
        List<String> whs2= new ArrayList<String>(wh2);
        
        for (int i = whs2.size()-1; i>0 ; i--) {
        	driver.switchTo().window(whs2.get(i));
            driver.close();
            System.out.println("windows closed");
		}
		
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		  Thread.sleep(6000);
		  Set<String> wh3 = driver.getWindowHandles(); List<String>
		  whs3= new ArrayList<String>(wh3); driver.switchTo().window(whs3.get(1));
		  driver.close(); driver.switchTo().window(whs3.get(2)); driver.close();
		  driver.switchTo().window(whs3.get(0));
		 
	}

	}


