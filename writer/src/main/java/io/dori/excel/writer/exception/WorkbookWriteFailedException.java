package io.dori.excel.writer.exception;

public class WorkbookWriteFailedException extends RuntimeException {
    public WorkbookWriteFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
