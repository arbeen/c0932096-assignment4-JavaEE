package org.arbin.assignmnet4c0932096.controller;

import org.arbin.assignmnet4c0932096.model.Student;
import org.arbin.assignmnet4c0932096.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testGetStudentsReturnsOk() throws Exception {
        // Setup
        when(studentService.getAllStudents()).thenReturn(
                Arrays.asList(
                        new Student("John Doe", "john@example.com", 20),
                        new Student("Jane Smith", "jane@example.com", 22)
                )
        );

        // Execute and Assert
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(view().name("students"))
                .andExpect(model().attributeExists("students"));
    }

    @Test
    public void testSaveStudentWithInvalidDataReturnsFormWithErrors() throws Exception {
        // Execute and Assert - testing with invalid age (under 18)
        mockMvc.perform(post("/students/save")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "John Doe")
                        .param("email", "john@example.com")
                        .param("age", "17")) // Age below 18 should trigger validation error
                .andExpect(status().isOk())
                .andExpect(view().name("new-student"))
                .andExpect(model().attributeHasFieldErrors("student", "age"));
    }
}