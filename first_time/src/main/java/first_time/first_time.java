package first_time;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class first_time {

    public static void main(String[] args) {
        // Set the path to the Edge WebDriver
        System.setProperty("webdriver.edge.driver", "D:\\softwares\\selenium\\msedgedriver.exe");
        //
        // Initialize the EdgeDriver
        EdgeDriver driver = new EdgeDriver();
        
        // Open the URL
        //driver.get("https://github.com/parikshit223933/Coding-Ninjas-Competitive-Programming");
        //System.out.println(driver.getTitle());
        
        
        //driver.findElement(By.xpath("//*[@id=\":R55ab:\"]/span/span[2]")).click();
        //for(int i=0;i<5000;i++) {
        //driver.findElement(By.xpath("//*[@id=\":rb:--label\"]")).click();
        //i++;
        //}
        driver.get("https://cosmocode.io/automation-practice-webtable/");
		
		List<WebElement> val = (List<WebElement>) driver.findElements(By.xpath("//table[@id='countries']/tbody/tr/td[2]"));
		//List<WebElement> vald=driver.findElements(By.xpath("//table[@id='countries']/tbody/tr/td[2]"));
        
		for(WebElement vals : val) {
			System.out.println(vals.getText());
		}
		driver.close();
    }

}

