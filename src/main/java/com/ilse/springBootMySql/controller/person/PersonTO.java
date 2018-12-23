package com.ilse.springBootMySql.controller.person;

import com.ilse.springBootMySql.shared.TransferObject;

import javax.validation.constraints.NotNull;

public class PersonTO extends TransferObject {

    @NotNull
    private String name;
    private String firstName;
    private String inss;

    private PersonTO() {}

    public PersonTO(String name, String firstName, String inss) {
        this.name = name;
        this.firstName = firstName;
        this.inss = inss;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getInss() {
        return inss;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setInss(String inss) {
        this.inss = inss;
    }
}
