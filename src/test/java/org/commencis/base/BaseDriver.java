package org.commencis.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.commencis.utilies.ExtentReport;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.TestInstance;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseDriver {
   public static WebDriver driver;
   final static String baseUrl="https://techcrunch.com/";

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        ExtentReport.extentReport();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
    @AfterAll
    void createReport(){
        ExtentReport.tearDown();
    }

}
