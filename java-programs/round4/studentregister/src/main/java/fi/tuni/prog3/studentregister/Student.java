package fi.tuni.prog3.studentregister;

/**
 *
 * @author janik
 */
public class Student {

    private String name;
    private String number;

    public Student(String name, String studentNumber) {
        this.name = name;
        this.number = studentNumber;
    }

    public String getName() {
        return name;
    }

    public String getStudentNumber() {
        return number;
    }
}
