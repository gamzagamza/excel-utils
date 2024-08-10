package io.dori.excel.example;

import io.dori.excel.writer.annotation.Cell;

import java.time.ZonedDateTime;

public class Dummy {
    @Cell(headerName = "Name")
    private final String name;

    @Cell(headerName = "Email")
    private final String email;

    @Cell(headerName = "Phone")
    private final String phone;

    @Cell(headerName = "createdAt")
    private final ZonedDateTime createdAt;

    public Dummy(String name, String email, String phone, ZonedDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
