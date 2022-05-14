package tests;

import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void startUp() {

        if (System.getProperty("autotestBrowser") == "Yandex") {
            System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\yandexdriver.exe");
            Configuration.browserBinary = "C:\\Users\\Antoha\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
        }
    }
}
