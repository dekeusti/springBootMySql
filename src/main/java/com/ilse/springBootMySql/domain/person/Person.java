package com.ilse.springBootMySql.domain.person;

import com.ilse.springBootMySql.shared.EqualByStateObject;

import javax.persistence.*;

@Entity
public class Person extends EqualByStateObject {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer personId;
    private String name;
    private String firstName;
    @Embedded
    private Inss inss;

    private Person() {}

    public Person(String name, String firstName, Inss inss) {
        this.name = name;
        this.firstName = firstName;
        this.inss = inss;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setInss(Inss inss) {
        this.inss = inss;
    }

    public Integer getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public Inss getInss() {
        return inss;
    }
}
