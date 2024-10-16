package static_dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class updated_dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "D:\\softwares\\selenium\\msedgedriver.exe");
        
        // Initialize the EdgeDriver
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
        driver.findElement(By.xpath("//*[@id=\"hrefIncAdt\"]")).click();
        
        

	}

}
