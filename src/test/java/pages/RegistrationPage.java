package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    // components
    private CalendarComponent calendarComponent = new CalendarComponent();

    // locators
    private SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            resultsTable = $(".table-responsive");


    // actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }


    public void setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }

    public void clickSubmit() {
        $("#submit").click();
    }

    public void setStateAndCity(String state,String city) {
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
    }

    public void setAddress(String address) {
        $("#currentAddress").setValue(address);
    }

    public void setPicture(String picture) {
        $("#uploadPicture").uploadFromClasspath("img/" + picture);
    }

    public void setHobbies(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
    }

    public void setSubjects(String subjects) {
        $("#subjectsInput").setValue(subjects).pressEnter();
    }

    public void setNumber(String number) {
        $("#userNumber").setValue(number);
    }

    public void setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
    }

    public void setEmail(String email) {
        $("#userEmail").setValue(email);
    }
}
