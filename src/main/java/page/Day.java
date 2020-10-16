package page;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class Day {
    private final String dayNumber = "div[class=card] strong";
    private final String dayOfMonth = "small span:nth-of-type(1)";
    private final String dayOfWeek = "small span:nth-of-type(2)";
    private final String dayPartPath = "td:nth-of-type(1)";
    @Getter
    private final String title;
    @Getter
    private final List<DayPart> dayParts;

    public Day(SelenideElement element) {
        this.title = element.$(dayNumber).text() + " " +
                element.$(dayOfMonth).text() + " " +
                element.$(dayOfWeek).text();
        dayParts = element.$$(dayPartPath)
                .stream()
                .map(elem -> new DayPart(elem))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return title + " " + dayParts.stream()
                .map(part -> part.toString())
                .collect(Collectors.joining(";\n", "\n", ""));
    }
}
