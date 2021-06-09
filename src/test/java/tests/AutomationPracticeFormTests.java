package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests {

    @BeforeAll
    static void setStartConfig() {
        Configuration.startMaximized = true;
    }

    @BeforeEach
    void executeBeforeTest() {
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void fillAllFormFieldsTest() {
        // Test data
        String firstName = "Ivan",
                lastName = "Ivanov",
                email = "test@gmail.com",
                gender = "Male",
                filename = "testFile.JPG",
                country = "Russia",
                userNumber = "9111111111";

        // Fill the form
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1991");
        $("[aria-label='Choose Monday, March 18th, 1991']").click();
        $("#subjectsInput").setValue("Co").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFile(new File("src/resources/" + filename));
        $("#currentAddress").setValue(country);
        $("#react-select-3-input").setValue("Raja").pressEnter();
        $("#react-select-4-input").setValue("Jais").pressEnter();
        $("#submit").click();

        // Check data
        $(".table-responsive").
                shouldHave(text(firstName + " " + lastName),
                        text(email),
                        text(gender),
                        text(userNumber),
                        text("18 March,1991"),
                        text("Computer Science"),
                        text("Sports, Reading"),
                        text(filename),
                        text(country),
                        text("Rajasthan Jaiselmer")
                );
    }

    @Test
    void fillMinimumFieldsToSubmitTest() {
        // Test data
        String firstName = "Ivan",
                lastName = "Ivanov",
                userNumber = "9111111111";

        // Fill the form
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#gender-radio-3").parent().click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        // Check data
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text("Other"),
                text(userNumber)
        );
        $("button#closeLargeModal").click();
        //$("#example-modal-sizes-title-lg").shouldNotBe(visible);
        $("#example-modal-sizes-title-lg").should(exist); //it works only without previous line
        $("#example-modal-sizes-title-lg").should(disappear); //it works always
    }
}