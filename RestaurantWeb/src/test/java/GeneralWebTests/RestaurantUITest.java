package GeneralWebTests;


import org.junit.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


/**
 * Created by SeVlad on 15.01.2017.
 */
@Ignore
public class RestaurantUITest {

    @BeforeClass
    public static void setup() {
        baseUrl = "http://localhost:8080/";
        browser = "chrome";
    }

    @Test
    public void mainPageHasRestaurantName() {
        open("/");
        $(By.id("restaurant_name")).shouldBe(exist);
    }

    @Test
    public void mainPageHasAddress() {
        open("/");
        $(By.id("address")).shouldBe(exist);
    }

    @Test
    public void mainPageHasPhone() {
        open("/");
        $(By.id("phone")).shouldBe(exist);
    }

    @AfterClass
    public static void tearDown() {
        closeWebDriver();
    }
}
