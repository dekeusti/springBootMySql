package com.ilse.springBootMySql.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilse.springBootMySql.controller.person.PersonTO;
import com.ilse.springBootMySql.domain.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.ilse.springBootMySql.testConstants.PersonTestConstants.personTO;
import static com.ilse.springBootMySql.testConstants.UserTestConstants.user;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getAllUsersTest() throws Exception {
        this.mockMvc.perform(get("/demo/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[]"))
                .andExpect(content().json("[]"));
    }

    @Test
    public void getAllPersonsTest() throws Exception {
        this.mockMvc.perform(get("/person/all"))
                .andDo(print())
                .andExpect(content().string("[]"))
                .andExpect(content().json("[]"))
                .andExpect(status().isOk());
    }

    @Test
    public void addPersonTest() throws Exception {
        PersonTO personTO = personTO();

        this.mockMvc.perform(post("/person/add")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJsonString(personTO)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test  // Flacky test
    public void findUserByNameTest() throws Exception {
        userRepository.save(user());


        this.mockMvc.perform(get("/demo/findByName")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("name", "naam"))
                .andDo(print())
//                .andExpect(content().string(asJsonString(userWithId())))
                .andExpect(content().string(containsString("\"name\":\"naam\",\"email\":\"email\"}")))
                .andExpect(status().isOk());

        userRepository.delete(user());
    }

    /*
     * converts a Java object into JSON representation
     */
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}