package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.openqa.selenium.By;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public class LocatorHelper {

    // JSON içeriğindeki locator bilgisini temsil eden POJO sınıfı
    public static class Locator {
        private String key;
        private String value;
        private String type;

        public String getKey() {
            return key;
        }
        public String getValue() {
            return value;
        }
        public String getType() {
            return type;
        }
    }

    private static List<Locator> locators;

    static {
        try (InputStream is = LocatorHelper.class.getResourceAsStream("/locators.json")) {
            if (is == null) {
                throw new RuntimeException("locators.json dosyası bulunamadı.");
            }
            InputStreamReader reader = new InputStreamReader(is);
            Type listType = new TypeToken<List<Locator>>(){}.getType();
            locators = new Gson().fromJson(reader, listType);
        } catch (Exception e) {
            throw new RuntimeException("Locator bilgileri yüklenirken hata oluştu.", e);
        }
    }

    public static Locator findElementInfoByKey(String key) {
        Optional<Locator> opt = locators.stream()
                .filter(loc -> loc.getKey().equalsIgnoreCase(key))
                .findFirst();
        if (opt.isEmpty()) {
            throw new RuntimeException("Locator not found for key: " + key);
        }
        return opt.get();
    }

    public static By getElementInfoToBy(Locator locator) {
        switch (locator.getType().toLowerCase()) {
            case "xpath":
                return By.xpath(locator.getValue());
            case "id":
                return By.id(locator.getValue());
            case "css":
                return By.cssSelector(locator.getValue());
            case "name":
                return By.name(locator.getValue());
            default:
                throw new RuntimeException("Yanlis locator tipi girdiniz: " + locator.getType());
        }
    }
}
