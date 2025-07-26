package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Assert;
import java.time.Duration;
public class LoginSteps {
    private WebDriver driver;
    private final String BASE_URL = "http://online.iiests.ac.in:1977/CampusPortal/CampusMenu.jsp";

    // --- Before and After Hooks ---
    // @Before hook runs before each scenario
    @Before
    public void setup() {
        // Set up ChromeDriver path.
        // IMPORTANT: Replace "path/to/your/chromedriver" with the actual path to your ChromeDriver executable.
        // Alternatively, ensure ChromeDriver is in your system's PATH.
        // Example for Windows: System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        // Example for Mac/Linux: System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // If ChromeDriver is in PATH, this line might not be strictly necessary.
        System.setProperty("webdriver.chrome.driver", "path/to/your/chromedriver"); // <-- UPDATE THIS LINE

        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless"); // Uncomment to run Chrome in headless mode (without UI)
        options.addArguments("--start-maximized"); // Maximize browser window on start
        options.addArguments("--disable-gpu"); // Applicable to Windows OS only
        options.addArguments("--no-sandbox"); // Bypass OS security model, required for some environments

        driver = new ChromeDriver(options);
        // Set implicit wait to handle element loading
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // @After hook runs after each scenario
    @After
    public void teardown() {
        if (driver != null) {
            driver.quit(); // Close the browser
        }
    }

    // --- Gherkin Step Definitions ---

    @Given("I am on the IIEST Campus Portal login page")
    public void iAmOnTheIIESTCampusPortalLoginPage() {
        driver.get(BASE_URL);
        // Optional: Add a check to ensure the page title is as expected
        Assert.assertTrue("Login page title is incorrect!", driver.getTitle().contains("IIEST - Campus Portal"));
        System.out.println("Navigated to IIEST Campus Portal login page.");
    }

    @When("I enter valid username {string} and password {string}")
    public void iEnterValidUsernameAndPassword(String username, String password) {
        // IMPORTANT: You need to inspect the actual HTML of the login page
        // (http://online.iiests.ac.in:1977/CampusPortal/CampusMenu.jsp)
        // to find the correct IDs, names, or XPaths for the username, password, and login button elements.
        // The IDs 'txtUserId' and 'txtPassword' are common placeholders.
        // Replace them with the actual IDs/names/XPaths from the IIEST portal.

        try {
            WebElement usernameField = driver.findElement(By.id("txtUserId")); // <-- UPDATE THIS ID
            WebElement passwordField = driver.findElement(By.id("txtPassword")); // <-- UPDATE THIS ID

            usernameField.sendKeys(username);
            passwordField.sendKeys(password);
            System.out.println("Entered username and password.");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.err.println("Could not find username or password fields. Please check element IDs/XPaths.");
            throw new RuntimeException("Login fields not found: " + e.getMessage());
        }
    }

    @When("I enter invalid username {string} and password {string}")
    public void iEnterInvalidUsernameAndPassword(String username, String password) {
        // Reusing the same logic for entering credentials
        iEnterValidUsernameAndPassword(username, password);
        System.out.println("Entered invalid username and password.");
    }

    @When("I click the Login button")
    public void iClickTheLoginButton() {
        // IMPORTANT: Find the correct ID, name, or XPath for the login button.
        // 'btnLogin' is a common placeholder.
        try {
            WebElement loginButton = driver.findElement(By.id("btnLogin")); // <-- UPDATE THIS ID
            loginButton.click();
            System.out.println("Clicked the Login button.");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.err.println("Could not find login button. Please check element ID/XPath.");
            throw new RuntimeException("Login button not found: " + e.getMessage());
        }
    }

    @Then("I should be redirected to the dashboard page")
    public void iShouldBeRedirectedToTheDashboardPage() {
        // This assertion needs to be specific to the post-login page.
        // For example, check for a specific element on the dashboard, or a URL change.
        // As a placeholder, we'll check if the URL *does not* contain the login page URL.
        // You might need to adjust this based on the actual dashboard URL/content.
        try {
            // Wait for URL to change or for a specific element to appear, if needed
            // For simplicity, we'll just check the current URL.
            Assert.assertFalse("Still on login page after successful login!",
                    driver.getCurrentUrl().contains("CampusMenu.jsp"));
            // You could also check for a specific element that appears only on the dashboard
            // Assert.assertTrue(driver.findElement(By.id("dashboardWelcomeMessage")).isDisplayed());
            System.out.println("Successfully redirected to dashboard page.");
        } catch (AssertionError e) {
            System.err.println("Redirection to dashboard failed: " + e.getMessage());
            throw e;
        }
    }

    @Then("I should see an error message indicating login failure")
    public void iShouldSeeAnErrorMessageIndicatingLoginFailure() {
        // IMPORTANT: You need to find the element that displays the error message on the login page.
        // 'errorMessage' is a placeholder.
        try {
            WebElement errorMessage = driver.findElement(By.id("errorMessage")); // <-- UPDATE THIS ID
            Assert.assertTrue("Error message is not displayed or is empty!",
                    errorMessage.isDisplayed() && !errorMessage.getText().isEmpty());
            System.out.println("Error message displayed: " + errorMessage.getText());
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.err.println("Could not find error message element. Please check element ID/XPath.");
            throw new RuntimeException("Error message element not found: " + e.getMessage());
        }
    }

    @Then("I should remain on the login page")
    public void iShouldRemainOnTheLoginPage() {
        // Verify that the current URL still contains the login page identifier
        Assert.assertTrue("Not on login page after unsuccessful login!",
                driver.getCurrentUrl().contains("CampusMenu.jsp"));
        System.out.println("Remained on the login page after unsuccessful login.");
    }
}
