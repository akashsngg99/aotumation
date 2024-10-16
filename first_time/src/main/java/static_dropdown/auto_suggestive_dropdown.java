package static_dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class auto_suggestive_dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "D:\\softwares\\selenium\\msedgedriver.exe");
        
        // Initialize the EdgeDriver
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("in");
        Thread.sleep(3000);
        List<WebElement> options= driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement option: options) {
        	System.out.println(option.getText());
        	if(option.getText().equalsIgnoreCase("India")) {
        		option.click();
        		break;
        	}
        }
        
	}

}
