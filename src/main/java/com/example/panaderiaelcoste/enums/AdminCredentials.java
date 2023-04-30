package com.example.panaderiaelcoste.enums;

public enum AdminCredentials {

    USERNAME ("ADMIN"),
    PASSWORD("admin123");
    private final String value;
    private AdminCredentials(String value){
        this.value=value;

    }
    public String getValue(){
        return value;
    }

}
