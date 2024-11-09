package mmt;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class mmt_flight {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stubc
System.setProperty("webdriver.edge.driver", "D:\\softwares\\selenium\\msedgedriver.exe");
        
        // Initialize the EdgeDriver
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/span")).click();
        
        driver.findElement(By.xpath("//li[@class='menu_Trains']")).click();
        //Thread thread = new Thread();
        Thread.sleep(20000);
		driver.findElement(By.xpath("//li[@class='menu_Flights']")).click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		driver.close();
        
		

	}

}
