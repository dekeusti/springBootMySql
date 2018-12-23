package com.ilse.springBootMySql.testConstants;

import com.ilse.springBootMySql.controller.person.PersonTO;
import com.ilse.springBootMySql.domain.person.Inss;
import com.ilse.springBootMySql.domain.person.Person;

public class PersonTestConstants {

    private PersonTestConstants() {
    }

    public static final String PERSON_NAME = "Fristi";
    public static final String PERSON_FIRST_NAME = "Micky";
    public static final String INSS_VALUE = "02050900129";
    public static final Inss INSS = new Inss(INSS_VALUE);

    public static PersonTO personTO() {
        return new PersonTO(PERSON_NAME, PERSON_FIRST_NAME, INSS_VALUE);

    }

    public static final Person person() {
        return new Person(PERSON_NAME, PERSON_FIRST_NAME, INSS);
    }
}
