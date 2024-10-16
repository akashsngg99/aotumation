package static_dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class static_Dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "D:\\softwares\\selenium\\msedgedriver.exe");
        
        // Initialize the EdgeDriver
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //dropdwon with select tag --static
        WebElement staticDropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        
        Select dropdown= new Select(staticDropdown);
        
        dropdown.selectByValue("USD");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        
        

	}

}
