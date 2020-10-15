package page;


import com.codeborne.selenide.ElementsCollection;
import lombok.Data;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

@Data
public class WeatherCollection {
    private final String weatherTablePath = "//div[@class='card']";
    private final String dayNumber = "div[class=card] strong";
    private final String dayOfMonth = "small span:nth-of-type(1)";
    private final String dayOfWeek = "small span:nth-of-type(2)";
    private final String dayPartAndTemp = "td:nth-of-type(1)";
    private final String dayPart = "div[class=weather-table__wrapper] div:nth-of-type(1)";
    private final String dayTemp = "div[class=weather-table__wrapper] div:nth-of-type(2)";

    public ElementsCollection getCollection() {
        return $$(By.xpath(weatherTablePath)).first(7);
//        В соответствии с условием: "Вывести на консоль температуру
//        с сегодняшнего дня на 7 дней вперёд (утром, днём, вечером, ночью)".
    }
}
