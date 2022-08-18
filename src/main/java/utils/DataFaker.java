package utils;

import com.github.javafaker.Faker;

import java.io.StringReader;
import java.util.Locale;

public class DataFaker {

    private static final Faker faker = new Faker(new Locale("he"));
    private static final Faker fakerMail = new Faker();

    public static Faker faker() {
        return faker;
    }

    public static String fakePhoneNumber() {
        return faker.numerify("054#######");
    }

    public static String fakeEmail(String endingEmail) {
        if (endingEmail.equals("example")) {
            return fakerMail.letterify("???????????") + "@example.com";
        } else if (endingEmail.equals("gmail")) {
            return fakerMail.letterify("???????????") + "@gmail.com";
        }
        else return "the ending mail is suffix";
    }

    //todo: casting to int and then casting to string after the if
    public static String fakeNumBetweenAnd(int start, int end){
        return Integer.toString(faker.number().numberBetween(start, end));
    }

}