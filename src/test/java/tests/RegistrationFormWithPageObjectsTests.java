package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Alex";
    String lastName = "Egorov";
    String email = "alex@egorov.com";
    String gender = "Other";
    String number = "1231231230";
    String day = "30";
    String month = "July";
    String year = "2008";
    String subject = "Math";
    String hobbies = "Sports";
    String picture = "1.png";
    String address = "Some address 1";
    String state = "NCR";
    String city = "Noida";

    String formName = "Student Name",
            formEmail = "Student Email",
            formGender = "Gender";


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
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(number)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setAddress(address)
                .setStateAndCity(state, city)
                .clickSubmit();

        registrationPage
                .checkForm(formName, firstName + " " + lastName)
                .checkForm(formEmail, email)
                .checkForm(formGender, gender);
    }
}
