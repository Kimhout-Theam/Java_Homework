package LearningOOPConcept.model;

import java.time.LocalDate;

public class UpdateUserDTO {

    public String name;
    public String gender;
    public int age;
    public LocalDate birthDate;

    public UpdateUserDTO(){}
    public UpdateUserDTO(String name, String gender, int age, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthDate = birthDate;
    }
}
