import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.AutomationName; // Import the AutomationName class
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Keys;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HearingColorsGitHub {

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
            driver.get("https://www.google.com");
            WebElement searchInput = driver.findElement(By.name("q"));
            searchInput.sendKeys("Hearing Colors LLC");
            searchInput.sendKeys(Keys.ENTER);
            Thread.sleep(4000);

            List<WebElement> searchResults = driver.findElements(By.cssSelector("a"));

            boolean hearingColorsLinkFound = false;

            for (WebElement link : searchResults) {
                String href = link.getAttribute("href");
                if (href != null) {
                    if (href.contains("hearingcolors.com")) {
                        link.click();
                        hearingColorsLinkFound = true;
                        break;
                    }
                }
            }

            if (hearingColorsLinkFound) {
                Thread.sleep(2000);
                List<WebElement> githubLinksOnHearingColorsPage = driver.findElements(By.cssSelector("a"));

                boolean githubLinkFound = false;

                for (WebElement link : githubLinksOnHearingColorsPage) {
                    String href = link.getAttribute("href");
                    if (href != null && href.contains("github.com")) {
                        link.click();
                        githubLinkFound = true;
                        break;
                    }
                }

                if (!githubLinkFound) {
                    System.out.println("No GitHub link found on the Hearing Colors page.");
                }
            } else {
                System.out.println("No Hearing Colors link found.");
            }
            Thread.sleep(4000);
        } finally {
            driver.quit();
        }
    }
}