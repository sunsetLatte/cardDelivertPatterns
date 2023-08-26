package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    private static Faker faker = new Faker(new Locale("ru"));
    private static LocalDate today = LocalDate.now();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    DataGenerator() {
    }

    public static String generateCity() {
        var cities = new String[]{"Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Владикавказ",
                "Горно-Алтайск", "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Краснодар", "Магас", "Махачкала",
                "Нарьян-Мар", "Салехард", "Самара", "Саранск", "Саратов", "Хабаровск", "Ханты-Мансийск",
                "Южно-Сахалинск", "Великий Новгород", "Владивосток", "Владимир", "Вологда", "Рязань", "Биробиджан",
                "Чебоксары", "Москва", "Санкт-Петербург", "Ульяновск", "Симферополь", "Ростов-на-Дону"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateDate(int plusDays) {
        LocalDate newDate = today.plusDays(plusDays);
        return formatter.format(newDate);
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale("ru"));
        return faker.name().fullName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale("ru"));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }


        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }

}

