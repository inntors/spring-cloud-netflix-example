package net.devh.exception;

import java.util.UUID;

import net.devh.util.Message;
import org.springframework.beans.factory.annotation.Autowired;

public class CompareException extends RuntimeException {

    private final UUID guid;

    @Autowired
    public CompareException(UUID guid) {
        this.guid = guid;
    }

    @Override
    public String getMessage() {
        return Message.isError;
    }

    public UUID getGuid() {
        return guid;
    }
}
