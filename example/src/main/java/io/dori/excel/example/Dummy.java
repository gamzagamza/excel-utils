package io.dori.excel.example;

import io.dori.excel.writer.Cell;

public class Dummy {
    @Cell(headerName = "Name")
    private String name;

    @Cell(headerName = "Email")
    private String email;

    @Cell(headerName = "Phone")
    private String phone;

    public Dummy(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
