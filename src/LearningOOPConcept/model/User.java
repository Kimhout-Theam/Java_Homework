package LearningOOPConcept.model;

import java.time.LocalDate;
import java.util.UUID;

public class User {
    public UUID uuid;
    public String name;
    public String gender;
    public int age;
    public LocalDate birthDate;

    public User() {}
    public User(String name, String gender, int age, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "\nUser UUID: "+ uuid +
                "\nName: " + name +
                "\nGender: " + gender +
                "\nAge: " + age +
                "\nBirth Date: " + birthDate;
    }
}

