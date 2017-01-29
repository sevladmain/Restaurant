package GeneralWebTests;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


/**
 * Created by SeVlad on 15.01.2017.
 */
public class RestaurantMainPageTest {

    @BeforeClass
    public static void setup() {
        baseUrl = "http://localhost:8080/";
        browser = "chrome";
    }

    @Test
    public void mainPageHasAddress() {
        open("/");
        $(By.id("address")).shouldHave(text("Ресторан у загубленого альпініста"));
    }

    @AfterClass
    public static void tearDown() {
        closeWebDriver();
    }
}
