package com.nashtech.demoqa.tests.ui_tests;

import java.awt.*;
import java.io.IOException;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.nashtech.demoqa.tests.modals.StudentData;
import com.nashtech.demoqa.utils.JsonUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteListenerAdapter;
import com.nashtech.demoqa.utils.PropertiesFileUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners({ ExtentIReporterSuiteListenerAdapter.class })
public class BaseTest {
    public WebDriver driver;
    public static StudentData studentData;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void beforeSuite() throws IOException{
        Properties properties = PropertiesFileUtil.loadPropertiesFromFile(System.getProperty("env.properties"));
        PropertiesFileUtil.appendSystemProperties(properties);
        Gson gson = new Gson();
        JsonReader reader = JsonUtil.loadJsonfile("RegisterStudentTestData.json");
        studentData = gson.fromJson(reader, StudentData.class);
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void beforeMethod(String browser) throws InterruptedException, AWTException {
        String browserType = (browser!=null)? browser:System.getProperty("BROWSER_TYPE");
//        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        driver = new ChromeDriver(options);
        switch (browserType) {
            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.get(System.getProperty("BASE_URL"));

    }

    @AfterMethod
    public void AfterMethod() {
        driver.quit();
    }
}
