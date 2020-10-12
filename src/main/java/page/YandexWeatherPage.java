package page;


import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Selenide.open;

@Data
public class YandexWeatherPage {
    private final String url;


    public void openPage() {
        open(this.getUrl());
    }


    public void printElementCollection(WeatherCollection weatherCollection) {

        for (SelenideElement titleElementOfTable : weatherCollection.getCollection()) {
            System.out.println(titleElementOfTable
                    .$(weatherCollection.getDayNumberCssSelector()).getText() + " " +
                    titleElementOfTable.$(weatherCollection.getDayOfMonthCssSelector()).getText() + " " +
                    titleElementOfTable.$(weatherCollection.getDayOfWeekCssSelector()).getText());

            System.out.println("{");

            for (SelenideElement firsColumnElement : titleElementOfTable
                    .$$(weatherCollection.getDayPartAndTempCssSelector())) {
                System.out.println(" " + firsColumnElement
                        .$(weatherCollection.getDayPartCssSelector()).getText() +
                        " " + firsColumnElement
                        .$(weatherCollection.getDayTempCssSelector()).getText());
            }

            System.out.println("}");

        }

    }
}
