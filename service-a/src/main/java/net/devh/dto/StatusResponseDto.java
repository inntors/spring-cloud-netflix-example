package net.devh.dto;

public enum StatusResponseDto {
    OK("OK"),
    ERROR("ERROR");
    private final String value;
    StatusResponseDto(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
