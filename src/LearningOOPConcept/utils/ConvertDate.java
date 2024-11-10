package LearningOOPConcept.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConvertDate {

    public LocalDate parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        try {
            return LocalDate.parse(date, formatter);
        } catch (Exception e) {
            System.out.println("Invalid Date Format");
        }
        return null;
    }
}
