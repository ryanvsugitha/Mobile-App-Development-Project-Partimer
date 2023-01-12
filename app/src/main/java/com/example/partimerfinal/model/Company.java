package com.example.partimerfinal.model;

public class Company {
    private String email;
    private String companyname;
    private String password;

    public Company(String email, String companyname, String password) {
        this.email = email;
        this.companyname = companyname;
        this.password = password;
    }

    public String Email() {
        return email;
    }

    public void setUsername(String username) {
        this.email = username;
    }

    public String getCompanyName() {
        return companyname;
    }

    public void setName(String companyname) {
        this.companyname = companyname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
