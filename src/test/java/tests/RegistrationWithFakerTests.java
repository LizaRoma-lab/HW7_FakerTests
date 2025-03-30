package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    FakeData fakeData = new FakeData();

    String firstName = fakeData.firstName,
            lastName = fakeData.lastName,
            userEmail = fakeData.userEmail,
            gender = fakeData.gender,
            userNumber = fakeData.userNumber,
            dayOfBirth = fakeData.dayOfBirth,
            monthOfBirth = fakeData.monthOfBirth,
            yearOfBirth = fakeData.yearOfBirth,
            subject = fakeData.subject,
            hobbies = fakeData.hobbies,
            picture = fakeData.picture,
            streetAddress = fakeData.streetAddress,
            state = fakeData.state,
            city = fakeData.city;

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setAddress(streetAddress)
                .setState(state)
                .setCity(city);

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", streetAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void successfulMinRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth);
    }

    @Test
    void unsuccessfulRegistrationWithoutGenderTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserNumber(userNumber)
                .setSubmit();

        registrationPage.visibleFirstName();
    }

}
