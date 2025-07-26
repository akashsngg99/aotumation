package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.openqa.selenium.WebDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*System.setProperty("webdriver.edge.driver", "D:\\coding\\msedgedriver.exe");
        WebDriver driver= new org.openqa.selenium.edge.EdgeDriver();
        driver.get("https://www.google.com");
        System.out.println("Title of the page is: " + driver.getTitle());
        driver.quit();
        */
        Playwright playwright = Playwright.create();
        Browser br = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge"));
        System.out.println("Browser launched");
        Page page = br.newPage();
        page.navigate("https://www.microsoft.com/en-us/edge");
        System.out.println(page.title());
        br.close();

    }
}