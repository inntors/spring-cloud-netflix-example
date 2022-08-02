package net.devh.dto;


import net.devh.util.Message;

import static net.devh.dto.StatusResponseDto.ERROR;
import static net.devh.dto.StatusResponseDto.OK;

public class BuilderDto {

    public static <T> ResponseDto<T> error(String message, T value) {
        ResponseDto<T> response = new ResponseDto<>();
        response.setStatus(ERROR.getValue());
        response.setDescription(message);
        response.setValue(value);
        return response;
    }

    public static <T> ResponseDto<T> success(T value) {
        ResponseDto<T> response = new ResponseDto<>();
        response.setStatus(OK.getValue());
        response.setDescription(Message.isSuccess);
        response.setValue(value);
        return response;
    }
}
