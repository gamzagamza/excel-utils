package io.dori.excel.example;

import io.dori.excel.writer.DefaultExcelFile;

import java.io.FileOutputStream;
import java.util.List;

public class DummyWrite {

    public static void main(String[] args) {
        var dummies = List.of(
                new Dummy("USER_01", "USER_01@gmail.com", "010-0000-0001"),
                new Dummy("USER_02", "USER_02@gmail.com", "010-0000-0002"),
                new Dummy("USER_03", "USER_03@gmail.com", "010-0000-0003"),
                new Dummy("USER_04", "USER_04@gmail.com", "010-0000-0004"),
                new Dummy("USER_05", "USER_05@gmail.com", "010-0000-0005")
        );

        var excelFile = new DefaultExcelFile<>(Dummy.class);
        excelFile.addRows(dummies);

        try (var outputStream = new FileOutputStream("dummy.xlsx")) {
            excelFile.write(outputStream);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to write excel file", e);
        }
    }
}
