package first_time;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class first_time {

    public static void main(String[] args) {
        // Set the path to the Edge WebDriver
        System.setProperty("webdriver.edge.driver", "D:\\softwares\\selenium\\msedgedriver.exe");
        //
        // Initialize the EdgeDriver
        EdgeDriver driver = new EdgeDriver();
        
        // Open the URL
        driver.get("https://github.com/parikshit223933/Coding-Ninjas-Competitive-Programming");
        //System.out.println(driver.getTitle());
        
        
        driver.findElement(By.xpath("//*[@id=\":R55ab:\"]/span/span[2]")).click();
        for(int i=0;i<5000;i++) {
        driver.findElement(By.xpath("//*[@id=\":rb:--label\"]")).click();
        i++;
        }
    }

}

