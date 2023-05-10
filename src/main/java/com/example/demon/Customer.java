package com.example.demon;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Customer {
    private String customerName;
    private String customerPhoneNumber;

    public Customer(String customerName, String customerPhoneNumber) {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;

    }
}
