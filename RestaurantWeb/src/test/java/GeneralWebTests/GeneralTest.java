package GeneralWebTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by SeVlad on 15.01.2017.
 */
public class GeneralTest {
    private WebDriver browser;
    @Before
    public void setup() {
        browser = new ChromeDriver();
    }

    @Test
    public void startTest() {
        browser.get("https://www.google.com.ua");
        assertEquals("Україна", browser.findElement(By.className("logo-subtext")).getAttribute("value"));
    }

    @After
    public void tearDown() {
        browser.close();
    }
}
