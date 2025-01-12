Terfi Projesi

Bu proje, Selenium, Gauge ve Java kullanılarak yazılmıştır.

Özellikler

Test Frameworkü: Testler Gauge frameworkü ile yazılmıştır.

Raporlama: Gauge Report kullanılarak test raporları oluşturulur. Raporlar report klasöründen erişilebilir. 

Tarayıcı Yönetimi: env/default/default.properties dosyasından tarayıcı seçimi yapılabilir.

Lokator Yönetimi: Tüm lokator bilgileri src/test/resources/locators.json dosyasından okunur.

Senaryolar: Projede aşağıdaki gibi senaryolar bulunmaktadır:

Basarisiz Giris
Basarili Giris
Isim Degistir
Card Number Eksik Giris
Amount Harf Girisi


Nasıl Çalıştırılır?

Proje kök dizininde pom.xml dosyası bulunduğundan Maven kullanılarak bağımlılıkları yükleyin:
mvn clean install
Testleri çalıştırmak için aşağıdaki komutu kullanın:
mvn gauge:execute
Sonuçları görmek için reports klasörü altındaki raporları inceleyebilirsiniz.
Tarayıcı Ayarları

Tarayıcıyı değiştirmek için config.properties dosyasını düzenleyin:

browser=chrome
Alternatif olarak firefox , safari veya edge gibi diğer tarayıcılar seçilebilir.

Lokator Yönetimi

Lokatorlar locators.json dosyasında JSON formatında saklanmaktadır. Örnek bir yapı:

{
"key": "openMoneyTransferButton",
"value": "//div[text() = 'Open Money Transfer']",
"type": "xpath"
} 