package net.devh.exception;

import net.devh.util.Message;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class ServiceException extends RuntimeException{

    private final UUID guid;

    @Autowired
    public ServiceException(UUID guid) {
        this.guid = guid;
    }

    @Override
    public String getMessage() {
        return Message.serviceError;
    }

    public UUID getGuid() {
        return guid;
    }
}
