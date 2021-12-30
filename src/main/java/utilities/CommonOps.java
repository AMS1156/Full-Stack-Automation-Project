package utilitiey;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CommonOps extends Base {

    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrom"))
            driver = initChromDriver();
        else if (browserType.equalsIgnoreCase("firFox"))
            driver = initFireFoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("invalid browser type");
    }

    public static WebDriver initChromDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    @BeforeClass
    public void startSession() {
        String platform = "web";
        if (platform.equalsIgnoreCase("web")) {
            initBrowser("chrom");
        }
        //else if (platform.equalsIgnoreCase("mobile")){
        //   initMobile();
        //}
        else {
            throw new RuntimeException("invalid platform name");
        }
    }

    @AfterClass
    public void closeSession() {
        driver.quit();
    }


}
