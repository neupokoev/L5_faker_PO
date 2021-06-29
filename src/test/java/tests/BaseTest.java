package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true; // comment for pull request
    }
}
