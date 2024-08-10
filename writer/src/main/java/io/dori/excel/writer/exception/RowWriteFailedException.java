package io.dori.excel.writer.exception;

public class RowWriteFailedException extends RuntimeException {
    public RowWriteFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
