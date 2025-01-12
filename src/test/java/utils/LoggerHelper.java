package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerHelper {
    private static final Logger logger = LoggerFactory.getLogger(LoggerHelper.class);

    public static void bilgiYaz(String mesaj) {
        logger.info(mesaj);
    }

    public static void hataYaz(String mesaj) {
        logger.error(mesaj);
    }

    public static void hataYaz(String mesaj, Throwable hata) {
        logger.error(mesaj, hata);
    }

    public static void uyariYaz(String mesaj) {
        logger.warn(mesaj);
    }


}
