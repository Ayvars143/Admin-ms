package com.example.Customerms.Pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseEntity<T> {

    private Integer responseCode;
    private String message;
    private Boolean success;
    private T data;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(Boolean success){
        this.success=success;
    }
    public Boolean getSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
