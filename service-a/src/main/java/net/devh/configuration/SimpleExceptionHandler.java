package net.devh.configuration;

import net.devh.dto.BuilderDto;
import net.devh.dto.ResponseDto;
import net.devh.exception.CompareException;
import net.devh.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class SimpleExceptionHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CompareException.class)
    public ResponseDto<?> handle(CompareException e) {
        return BuilderDto.error(e.getMessage(), e.getGuid());
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServiceException.class)
    public ResponseDto<?> handle(ServiceException e) {
        return BuilderDto.error(e.getMessage(), e.getGuid());
    }
}
