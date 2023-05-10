package com.example.demon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.function.*;

import static com.example.demon.CustomerRegistrationValidator.isAnAdult;
import static com.example.demon.CustomerRegistrationValidator.isPhoneNumberValid;
import static com.example.demon.CustomerRegistrationValidator.ValidationResult;

@SpringBootApplication
@Slf4j
public class DemonApplication {

    static int[] arr = {1, 3, 5, 7, 8, 10, 20, 35, 99, 100};

    public static void main(String[] args) throws IOException {
        //SpringApplication.run(DemonApplication.class, args);
        //System.out.println(binarySearch(3, 0, arr.length - 1));
//        test.accept(new Customer("이름", "2412124"));
//        test2.accept(new Customer("조남주", "01051719052"), false);
//        System.out.println(isPhoneNumberValidPredicate.test("07111111111"));
//        System.out.println(isPhoneNumberValidPredicate.and(containsNumber).test("07111111111"));
//        System.out.println(getDbConnectionUrl.get());
//        System.out.println(listSupplier.get());

//        Customer2 customer2 = new Customer2(
//                "john",
//                "08201051719052",
//                "qwer9052@gmail.com",
//                LocalDate.of(2000, 1,1)
//        );
//
//        ValidationResult result = CustomerRegistrationValidator
//                .isEmailValid()
//                .and(isPhoneNumberValid())
//                .and(isAnAdult())
//                .apply(customer2);
//
//        System.out.println(result);
//        if(result != ValidationResult.SUCCESS){
//            throw new IllegalStateException(result.name());
//        }


        hello("John", null, value -> {
            System.out.println("no lastName Provided for " + value);
        });

        hello2("John", null, () -> {
            System.out.println("no lastName Provided for ");
        });

        Function<String, String> printName = name -> name.toUpperCase();

        BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
            if (name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toUpperCase();
        };

        System.out.println(upperCaseName.apply("Alex", 20));
    }


    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }

    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }


    static Supplier<List<String>> listSupplier = () ->
            List.of("jdbc://localhost:3362/users",
                    "jdbc://localhost:3362/users",
                    "jdbc://localhost:3362/users");

    static Supplier<String> getDbConnectionUrl = () -> "jdbc://localhost:3362/users";

    //static BiPredicate<String, String> test2 = (phonenumber, truefalsetest) ->

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber = phoneNumber -> phoneNumber.contains("3");

    static Consumer<Customer> test = customer ->
            System.out.println("hello " + customer.getCustomerName() + ", thanks for resgetering phone number " + customer.getCustomerPhoneNumber());

    static BiConsumer<Customer, Boolean> test2 = (customer, showPhoneNumber) ->
            System.out.println("hello " + customer.getCustomerName() + ", thanks for resgetering phone number " + (showPhoneNumber ? customer.getCustomerPhoneNumber() : "********"));

    static int binarySearch(int key, int low, int high) {

        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;

    }


}
