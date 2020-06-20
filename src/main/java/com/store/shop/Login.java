package com.store.shop;

public class Login {
    private String email;
    private String pwdhash;

    public Login(String email, String pwdhash) {
        this.email = email;
        this.pwdhash = pwdhash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwdhash() {
        return pwdhash;
    }

    public void setPwdhash(String pwdhash) {
        this.pwdhash = pwdhash;
    }
}
