package com.example.demon;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Setter
@Getter
public class Customer2 {
    private String name;
    private String phoneNumber;
    private String email;
    private LocalDate date;

    public Customer2(String name, String phoneNumber, String email, LocalDate date) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.date = date;

    }
}
