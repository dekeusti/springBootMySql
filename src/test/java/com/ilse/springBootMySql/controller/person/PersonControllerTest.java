package com.ilse.springBootMySql.controller.person;

import com.ilse.springBootMySql.domain.person.Person;
import com.ilse.springBootMySql.domain.person.PersonRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static com.ilse.springBootMySql.testConstants.PersonTestConstants.person;
import static com.ilse.springBootMySql.testConstants.PersonTestConstants.personTO;
import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PersonControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonController personController;

    @Test
    public void getAllPersons() {

        when(personRepository.findAll()).thenReturn((Iterable<Person>) newArrayList(person()));

        personController.getAllPersons();
        verify(personRepository).findAll();
    }

    @Test
    public void addPerson() {
        PersonTO personTO = personTO();
        personController.addPerson(personTO);
        verify(personRepository).save(person());
    }

}