package Methods;

import com.testautomation.base.BaseTest;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.LocatorHelper;
import utils.LoggerHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static utils.LoggerHelper.*;

public class BaseMethods extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(LoggerHelper.class);
    HashMap<String,Object> hashMap = new HashMap<>();
    public String randomString(int stringLength) {

        Random random = new Random();
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUWVXYZabcdefghijklmnopqrstuwvxyz0123456789".toCharArray();
        String stringRandom = "";
        for (int i = 0; i < stringLength; i++) {
            stringRandom = stringRandom + chars[random.nextInt(chars.length)];
        }
        return stringRandom;
    }


    public void goToUrlAdress(String url) {
        driver.navigate().to(url);
    }


    public WebElement findElement(String key) {
        LocatorHelper.Locator locator = LocatorHelper.findElementInfoByKey(key);
        By by = LocatorHelper.getElementInfoToBy(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", element);
        return element;
    }


    public List<WebElement> findElements(String key) {
        LocatorHelper.Locator locator = LocatorHelper.findElementInfoByKey(key);
        By by = LocatorHelper.getElementInfoToBy(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public WebElement findClickableElement(String key) {
        bilgiYaz(key + " elementine tiklandi");
        LocatorHelper.Locator locator = LocatorHelper.findElementInfoByKey(key);
        By by = LocatorHelper.getElementInfoToBy(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void clearElementMethod(String key){
        findElement(key).clear();
        bilgiYaz(key+ " degerinin icerigi silindi");
    }


    public void sendKeys(String key, String text) {
       findElement(key).sendKeys(text);
       bilgiYaz(key + " elementine " + text + " yazıldı");
    }


    public void getElementIfExists(String key) {
        try {
            List<WebElement> elements = findElements(key);
            if (elements.size() > 0) {
                bilgiYaz(key + " elementi bulundu.");
            } else {
                Assertions.fail( key + " elementi bulunamadı.");
                hataYaz( key + " elementi bulunamadı.");
            }
        } catch (Exception e) {
            Assertions.fail("Element kontrolü sırasında bir hata oluştu: " + e.getMessage());
            bilgiYaz("Element kontrolü sırasında bir hata oluştu:");
        }
    }


    public void addHashmapTextMethod(String element,String key) {
        hashMap.put(key, findElement(element).getText().toString());
        bilgiYaz(element + " texti hashmape eklendi: " + findElement(element).getText().toString());
    }

    public void addTextRandomMethod(String element) {
        String randomText = randomString(10);
        findElement(element).sendKeys(randomText);
        bilgiYaz(randomText + " degeri eklendi");
    }

    public void checkDifferenceHashmapMethod(String hashmapKey, String hashmapKey1, String type) {
        if ("aynı".equals(type)) {
            assertEquals(hashMap.get(hashmapKey).toString(), hashMap.get(hashmapKey1).toString(), "hashmapteki degerler eslesiyor...");
            System.out.println(hashMap.get(hashmapKey).toString() + " , " + hashMap.get(hashmapKey1).toString() + " ile " + type + "mi kontrol edildi");
        } else if ("farklı".equals(type)) {
            assertNotEquals(hashMap.get(hashmapKey).toString(), hashMap.get(hashmapKey1).toString(), "hashmapteki degerler eslesmiyor...");
            System.out.println(hashMap.get(hashmapKey).toString() + " , " + hashMap.get(hashmapKey1).toString() + " ile " + type + " mi kontrol edildi");
        }
        else if ("iceriyor mu".equals(type)) {
            assertTrue(hashMap.get(hashmapKey).toString().contains(hashMap.get(hashmapKey1).toString()), "hashmapteki degerler eslesmiyor...");
            System.out.println(hashMap.get(hashmapKey).toString() + " , " + hashMap.get(hashmapKey1).toString() + " ile " + type + " mi kontrol edildi");
        }
        else {
            org.junit.jupiter.api.Assertions.fail("Lütfen Gecerli bir tip giriniz");
        }
    }
}


