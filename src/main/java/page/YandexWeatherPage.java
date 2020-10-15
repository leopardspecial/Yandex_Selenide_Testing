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
                    .$(weatherCollection.getDayNumber()).getText() + " " +
                    titleElementOfTable.$(weatherCollection.getDayOfMonth()).getText() + " " +
                    titleElementOfTable.$(weatherCollection.getDayOfWeek()).getText());

            System.out.println("{");

            for (SelenideElement firsColumnElement : titleElementOfTable
                    .$$(weatherCollection.getDayPartAndTemp())) {
                System.out.println(" " + firsColumnElement
                        .$(weatherCollection.getDayPart()).getText() +
                        " " + firsColumnElement
                        .$(weatherCollection.getDayTemp()).getText());
            }

            System.out.println("}");

        }

    }
}
