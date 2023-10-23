package util;

import com.github.javafaker.Faker;

public class Randomizer {
    private static Faker faker = new Faker();

    public static String randomEmail() {
        return faker.internet().emailAddress();
}

    public static String randomPhone(){
        String phone =  faker.number().digits(10);
        System.out.println(phone);
        return phone;
    }

    public static String randomName(){
        return faker.name().fullName();
    }

}
