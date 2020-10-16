package page;


import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;


public class Weather {
    private final String weatherTablePath = "//div[@class='card']";
    @Getter
    private final List<Day> dayList;

    public Weather() {
        dayList = $$x(weatherTablePath)
                .stream()
                .map(elem -> new Day(elem))
                .collect(Collectors.toList());
    }
}
