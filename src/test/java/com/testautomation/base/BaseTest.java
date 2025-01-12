package com.testautomation.base;

import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.AfterScenario;
import com.testautomation.core.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions actions;
    protected static JavascriptExecutor js;

    @BeforeScenario
    public void setUp() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    @AfterScenario
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
