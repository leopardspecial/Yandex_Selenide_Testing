package page;


import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

@RequiredArgsConstructor
public class YandexWeatherPage {
    private final String url;
    private Weather weather;

    public void openPage() {
        open(url);
        weather = new Weather();
    }

    public void printWeather(int dayCount) {
        List<Day> dayList = weather.getDayList();
        for (int i = 0; i < dayCount; i++) {
            System.out.println(dayList.get(i));
        }
    }
}
