package tests;

import com.github.javafaker.Faker;
import model.Gender;
import model.Hobby;
import model.Month;
import model.Subject;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import java.time.Year;

import static utils.RandomUtils.getMaxDaysInMonth;

public class AutomationPracticeFormTests extends baseTest {
    // Test data
    Faker faker = new Faker();
    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = Gender.values()[faker.random().nextInt(0, 2)].toString(),
            filename = "testFile.JPG",
            mobile = faker.phoneNumber().subscriberNumber(10),
            monthOfBirth = Month.values()[faker.random().nextInt(0, 11)].toString(),
            yearOfBirth = faker.random().nextInt(1900, Year.now().getValue()).toString(),
            dayOfBirth = String.valueOf(getMaxDaysInMonth(Month.valueOf(monthOfBirth).ordinal(),
                    Integer.parseInt(yearOfBirth))),
            subject = Subject.values()[faker.random().nextInt(0, 4)].toString(),
            hobby = Hobby.values()[faker.random().nextInt(0, 2)].toString(),
            currentAddress = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Merrut";

    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    @Test
    void checkAutomationPracticeForm() {
        // Open test page
        studentRegistrationFormPage.openPage();

        // Fill the form
        studentRegistrationFormPage.typeFirstName(firstName);
        studentRegistrationFormPage.typeSecondName(lastName);
        studentRegistrationFormPage.typeEmail(email);
        studentRegistrationFormPage.chooseGender(gender);
        studentRegistrationFormPage.typePhoneNumber(mobile);
        studentRegistrationFormPage.chooseDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
        studentRegistrationFormPage.typeSubject(subject);
        studentRegistrationFormPage.chooseHobby(hobby);
        studentRegistrationFormPage.uploadImage(filename);
        studentRegistrationFormPage.typeAddress(currentAddress);
        studentRegistrationFormPage.chooseStateAndCity(state, city);
        studentRegistrationFormPage.pressSubmit();

        // Check result data
        studentRegistrationFormPage.checkResults(
                firstName,
                lastName,
                email,
                gender,
                mobile,
                dayOfBirth,
                monthOfBirth,
                yearOfBirth,
                subject,
                hobby,
                filename,
                currentAddress,
                state,
                city);
    }
}