package org.arbin.assignmnet4c0932096.service;

import org.arbin.assignmnet4c0932096.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    public void setUp() {
        studentService = new StudentService();
        // Clear any existing students
        Student.resetIdCounter();
    }

    @Test
    public void testAddingStudentIncreasesListSize() {
        // Setup
        int initialSize = studentService.getAllStudents().size();
        Student newStudent = new Student("Test Student", "test@example.com", 20);

        // Execute
        studentService.addStudent(newStudent);

        // Assert
        int newSize = studentService.getAllStudents().size();
        assertEquals(initialSize + 1, newSize, "Adding a student should increase the list size by 1");
        assertTrue(studentService.getAllStudents().contains(newStudent),
                "The list should contain the newly added student");
    }
}