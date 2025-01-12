package practicum.drivers;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    static String binaryYandexDriverFile = "drivers/yandexdriver.exe";
    // Выбор драйвера для конкретного браузера по его названию
    @Step("Выбор драйвера в зависимости от входных параметров")
    public static WebDriver getDriver(String browserName){
        switch (browserName){
            case "chrome":
                // Добавление свойств браузера Google Chrome
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-fullscreen");
                options.addArguments("--incognito");
                return new ChromeDriver(options);
            case "yandex":
                System.setProperty("webdriver.chrome.driver", binaryYandexDriverFile);
                ChromeOptions yOptions = new ChromeOptions();
                yOptions.addArguments("--start-fullscreen");
                yOptions.addArguments("--incognito");
                return new ChromeDriver(yOptions);
            default:
                throw new RuntimeException("Введено некорректное название браузера");
        }
    }
}
