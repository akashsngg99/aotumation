package first_time;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class first_time {

    public static void main(String[] args) throws InterruptedException {
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
        driver.manage().window().maximize();
        driver.get("http://www.greenstechnologys.com/");
        WebElement courses = driver.findElement(By.linkText("COURSES"));
        Actions a=new Actions(driver);
        a.moveToElement(courses).perform();
        Thread.sleep(2000);
        WebElement devOpTraining = driver.findElement(By.xpath("//span[text()='DevOps Training']"));
        a.click(devOpTraining).perform();
    }

}

