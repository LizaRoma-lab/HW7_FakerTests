package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakeData {
    Faker faker = new Faker(new Locale("en-GB"));

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2020)),
            monthOfBirth = faker.options().option("January", "August", "May", "February", "March"),
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 29)),
            subject = faker.options().option("Computer Science", "Chemistry", "Maths", "English", "Biology"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            picture = "cat.jfif",
            streetAddress = faker.address().streetAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = findCityByState(state);

    public String findCityByState(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "";
        };
    }
}
