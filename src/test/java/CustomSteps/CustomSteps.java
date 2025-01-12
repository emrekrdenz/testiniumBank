package CustomSteps;

import Methods.BaseMethods;
import com.thoughtworks.gauge.Step;

public class CustomSteps extends BaseMethods {

    @Step("<key> elementine tikla")
    public void click(String key) {
        findClickableElement(key).click();
    }

    @Step("<url> adresine git")
    public void goToUrl(String url){
        goToUrlAdress(url);
    }

    @Step("<key> elementine <text> textini yaz")
    public void sendKeysText(String key,String text){
        sendKeys(key,text);
    }

    @Step("<key> element var mı kontrol et")
    public void getElementIfExistss(String key) {
        getElementIfExists(key);
    }

    @Step("<element> elementinin text'ini <key> keyi ile hashmap'e ekle")
    public void addHashmapText(String element, String key) {
        addHashmapTextMethod(element,key);
    }

    @Step("<element> elemente random deger yaz")
    public void addHashmapTextRandom(String element) {
        addTextRandomMethod(element);
    }

    @Step("Hashmapin icindeki <hashmapKey> keyinin degeri <hashmapKey2> keyinin degeri ile <type> mı kontrol et")
    public void checkDifferenceHashmap(String hashmapKey, String hashmapKey1, String type) {
        checkDifferenceHashmapMethod(hashmapKey, hashmapKey1, type);
    }

    @Step("<key> elementinin textini sil")
    public void clearElement(String key) {
        clearElementMethod(key);
    }


}
