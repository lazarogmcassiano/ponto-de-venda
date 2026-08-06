package com.cassiano.pos.dto.response;

public class LoginResponse {

    private String name;
    private String barcode;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginResponse(String name, String barcode, String password) {
        this.name = name;
        this.barcode = barcode;
        this.password = password;
    }

}
