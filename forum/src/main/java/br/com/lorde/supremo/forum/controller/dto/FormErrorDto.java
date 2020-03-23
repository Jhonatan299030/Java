package br.com.lorde.supremo.forum.controller.dto;

public class FormErrorDto {

    private String key;
    private String message;

    public FormErrorDto(String key, String message){
        this.key = key;
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
