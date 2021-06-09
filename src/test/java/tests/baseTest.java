package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class baseTest {
    public static final String URL = "https://demoqa.com";

    @BeforeAll
    public static void setup() {
        Configuration.startMaximized = true;
    }
}
