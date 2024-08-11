# excel-utils
Support for bulk excel processing

---

## Example

```java
import java.util.List;

public void write(OutputStream outputStream) {
    var excelFile = new DefaultExcelFile<>(Example.class);

    excelFile.addRows(new Example("A", 1));
    excelFile.addRows(new Example("B", 2));
    excelFile.addRows(new Example("C", 3));

    excelFile.addRows(List.of(new Example("D", 4), new Example("E", 5)));

    excelFile.write(outputStream);
}
```
