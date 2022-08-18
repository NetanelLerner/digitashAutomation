package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTests {
    final String PATH = "https://tashdev.z6.web.core.windows.net/landing";
    final Duration fromSeconds = Duration.ofSeconds(600);
    WebDriver driver;
    WebDriverWait wait;
    DesiredCapabilities capabilities;

    @BeforeClass
    public void setup() throws URISyntaxException, IOException {

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Galaxy S5");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriverManager webDriverManager = WebDriverManager
                .chromedriver()
                .capabilities(chromeOptions);
//                .browserInDocker()
//                .enableVnc()
//                .enableRecording();

        driver = webDriverManager.create();

        /////////////////selenoid//////////////////////////
//        capabilities = new DesiredCapabilities();
////        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//        capabilities.setBrowserName("chrome");
//        capabilities.setVersion("101.0");
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//        capabilities.setCapability("videoName", "aaa");
//        capabilities.setCapability("screenResolution", "1280x1024x24");
//        driver = new RemoteWebDriver(
//                URI.create("http://localhost:4444/wd/hub").toURL(),
//                capabilities
//        );
        /////////////////selenoid//////////////////////////

        wait = new WebDriverWait(driver, fromSeconds);
//        Desktop.getDesktop().browse(webDriverManager.getDockerNoVncUrl().toURI());
        driver.get(PATH);
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        localStorage.setItem("TEST_BYPASS_LOGIN", "true");
        localStorage.setItem("AUTOMATION_USER", "324995273");
        driver.navigate().refresh();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
//        driver.quit();
    }

}
















































































































//package tests;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import net.lightbody.bmp.BrowserMobProxyServer;
//import org.openqa.selenium.Proxy;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.html5.LocalStorage;
//import org.openqa.selenium.html5.WebStorage;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.Map;
//
//public class BaseTests {
//    final String PATH = "https://tashdev.z6.web.core.windows.net/landing";
//    final Duration fromSeconds = Duration.ofSeconds(600);
//    WebDriver driver;
//    WebDriverWait wait;
//    DesiredCapabilities capabilities;
//
//    @BeforeClass
//    public void setup() throws URISyntaxException, IOException {
////        BrowserMobProxyServer proxyServer = new BrowserMobProxyServer();
////        proxyServer.start(18882);
////
////        final var proxyConfig = new Proxy()
////                .setHttpProxy("127.0.0.1:18882")
////                .setSslProxy("127.0.0.1:18882")
////                .setFtpProxy("127.0.0.1:18882");
//
//        Map<String, String> mobileEmulation = new HashMap<>();
//        mobileEmulation.put("deviceName", "Galaxy S5");
//
//        ChromeOptions chromeOptions = new ChromeOptions()
////                .setProxy(proxyConfig)
////                .setAcceptInsecureCerts(true)
//                .setExperimentalOption("mobileEmulation", mobileEmulation)
//                .setExperimentalOption("excludeSwitch", new String[]{"enable-automation"});
//
//
////                .browserInDocker()
////                .enableVnc()
////                .enableRecording();
//
//
//        WebDriverManager webDriverManager = WebDriverManager
//                .chromedriver()
//                .capabilities(chromeOptions);
//        driver = webDriverManager.create();
//
//        /////////////////selenoid//////////////////////////
////        capabilities = new DesiredCapabilities();
//////        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
////        capabilities.setBrowserName("chrome");
////        capabilities.setVersion("101.0");
////        capabilities.setCapability("enableVNC", true);
////        capabilities.setCapability("enableVideo", true);
////        capabilities.setCapability("videoName", "aaa");
////        capabilities.setCapability("screenResolution", "1280x1024x24");
////        driver = new RemoteWebDriver(
////                URI.create("http://localhost:4444/wd/hub").toURL(),
////                capabilities
////        );
//        /////////////////selenoid//////////////////////////
//
//        wait = new WebDriverWait(driver, fromSeconds);
////        Desktop.getDesktop().browse(webDriverManager.getDockerNoVncUrl().toURI());
//        driver.get(PATH);
//        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
//        localStorage.setItem("TEST_BYPASS_LOGIN", "true");
//        localStorage.setItem("AUTOMATION_USER", "324995273");
//        driver.navigate().refresh();
//        driver.manage().window().maximize();
//    }
//
//    @AfterClass
//    public void tearDown() {
////        driver.quit();
//    }
//
//}