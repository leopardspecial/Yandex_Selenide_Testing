package page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

public class DayPart {
    private final String dayPart = "div[class=weather-table__wrapper] div:nth-of-type(1)";
    private final String dayTemp = "div[class=weather-table__wrapper] div:nth-of-type(2)";
    @Getter
    private final String title;
    @Getter
    private final String temperature;

    public DayPart(SelenideElement element) {
        this.title = element.$(dayPart).text();
        this.temperature = element.$(dayTemp).text();
    }

    @Override
    public String toString() {
        return String.format("\t%10s -> %s", title, temperature);
    }
}
