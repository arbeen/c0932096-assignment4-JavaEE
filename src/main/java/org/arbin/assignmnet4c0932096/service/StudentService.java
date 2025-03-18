package org.arbin.assignmnet4c0932096.service;

import org.arbin.assignmnet4c0932096.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    //    In memory list students

    private final List<Student> students = new ArrayList<>();

    public List<Student> getAllStudents() {
        return students;
    }

    public void addStudent(Student student) {
        student.ensureId();
        students.add(student);
    }

    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }

}