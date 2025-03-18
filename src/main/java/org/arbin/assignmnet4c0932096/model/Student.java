package org.arbin.assignmnet4c0932096.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private static int idCounter = 1;

    private Integer id;

    @NotNull
    @Size(min = 2, max = 40)
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Min(18)
    private Integer age;

    // Constructor without id generation
    public Student(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public void ensureId() {
        if (this.id == null) {
            this.id = idCounter++;
        }
    }

    // Static method to get next available ID
    public static void resetIdCounter() {
        idCounter = 1;
    }
}