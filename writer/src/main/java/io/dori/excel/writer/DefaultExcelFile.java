package io.dori.excel.writer;

import io.dori.excel.writer.exception.RowWriteFailedException;
import io.dori.excel.writer.exception.WorkbookWriteFailedException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;

public class DefaultExcelFile<T> implements ExcelFile<T> {
    private final SXSSFWorkbook workbook;
    private final Sheet sheet;

    private final Class<T> clazz;

    public DefaultExcelFile(Class<T> clazz) {
        this.workbook = new SXSSFWorkbook();
        this.sheet = this.workbook.createSheet("Sheet");
        this.clazz = clazz;

        this.renderHeader();
    }

    @Override
    public void write(OutputStream outputStream) {
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            throw new WorkbookWriteFailedException(e.getMessage(), e);
        }
    }

    @Override
    public void addRow(T object) {
        var row = sheet.createRow(sheet.getLastRowNum() + 1);

        int col = 0;
        for (Field field : this.clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Cell.class)) {
                field.setAccessible(true);

                try {
                    var cell = row.createCell(col++);
                    cell.setCellValue(field.get(object).toString());
                } catch (IllegalAccessException e) {
                    throw new RowWriteFailedException(e.getMessage(), e);
                }
            }
        }
    }

    @Override
    public void addRows(List<T> objects) {
        objects.forEach(this::addRow);
    }

    private void renderHeader() {
        var row = sheet.createRow(0);
        var col = 0;

        for (Field field : this.clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Cell.class)) {
                var annotation = field.getAnnotation(Cell.class);
                var cell = row.createCell(col++);
                cell.setCellValue(annotation.headerName());
            }
        }
    }
}
