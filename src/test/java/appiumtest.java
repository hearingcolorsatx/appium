import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.AutomationName; // Import the AutomationName class
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Keys;


import java.net.MalformedURLException;
import java.net.URL;

public class appiumtest {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3a");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        URL appiumServerUrl = new URL("http://127.0.0.1:4723");

        AndroidDriver driver = new AndroidDriver(
                appiumServerUrl, caps
        );

        try {
            // Open Google in the Chrome browser
            driver.get("https://www.google.com");

            // Find the search input element
            WebElement searchInput = driver.findElement(By.name("q"));

            // Type your search query
            searchInput.sendKeys("Bitcoin Price");

            // Submit the search
            searchInput.sendKeys(Keys.ENTER);

            // Wait for some time to see the result (adjust as needed)
            Thread.sleep(5000);
        } finally {
            driver.quit();
        }
    }
}