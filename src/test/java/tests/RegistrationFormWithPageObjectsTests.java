package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Alex";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1081";
        Configuration.headless = true;
    }

    @Test
    void successFillTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName("Egorov")
                .setEmail("alex@egorov.com")
                .setGender("Other")
                .setNumber("1231231230")
                .setBirthDate("30", "July", "2008")
                .setSubjects("Math")
                .setHobbies("Sports")
                .setPicture("1.png")
                .setAddress("Some address 1")
                .setStateAndCity("NCR", "Noida")
                .clickSubmit();

        registrationPage
                .checkForm("Student Name", firstName + " Egorov")
                .checkForm("Student Email", "alex1@egorov.com")
                .checkForm("Gender", "Other");
    }


}
