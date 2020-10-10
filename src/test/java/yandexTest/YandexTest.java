package yandexTest;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class YandexTest {
    private ElementsCollection dayNumber;
    private ElementsCollection dayOfWeek;
    private ElementsCollection firstTableColumn;
    private int elementWrapperCounty;
    private List<String> dayNumbersCollection;


    @Before
    public void openYandexPage() {
        open("https://yandex.ru/pogoda/izhevsk");
    }

    @Before
    public void getElementCollectionCounty() {
        elementWrapperCounty = $$(By.xpath("//div[@class='card']/*/table")).size();

        System.out.println(elementWrapperCounty);
    }

    @Before
    public void setElementsCollections() {
        dayNumber = $$("div[class=card] strong");
        dayOfWeek = $$("div[class=card] small");
        firstTableColumn = $$(By.xpath("//tbody/*/td[1]"));
    }

    @Test
    public void printElementCollection() {
        int tdElements = 4;

        for (int i = 0; i < elementWrapperCounty; i++) {

            System.out.print("{" + dayNumber.get(i).text()
                    + " " + dayOfWeek.get(i).getText() + "}\n");

            if (i == 0) {
                for (int k = 0; k < tdElements; k++) {
                    System.out.println(firstTableColumn.get(k).text());
                }
                continue;
            }

            for (int k = tdElements; k < tdElements + 4; k++) {
                System.out.println(firstTableColumn.get(k).text());
            }
            tdElements = tdElements + 4;
        }


    }
}

