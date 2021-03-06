package io.qaquru.owner.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class WebDriverConfig {

    public URL getRemoteUrl() {
        //Зачитываем данные из командной строки
        String remoteUrl = System.getProperty("remoteUrl");
        if (Objects.isNull(remoteUrl)) {
            remoteUrl = "https://selenium:4444/wd/hub";
        }
        //конвертируем в возвращаемый тип
        try {
            return new URL(remoteUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public Browser getBrowser() {
        //Зачитываем данные из командной строки
        String browser = System.getProperty("browser");
        //обрабатываем дефолтное значение
        if (Objects.isNull(browser)) {
            browser = "CHROME";
        }
        //конвертируем в возвращаемый тип
        return Browser.valueOf(browser);
    }
}
