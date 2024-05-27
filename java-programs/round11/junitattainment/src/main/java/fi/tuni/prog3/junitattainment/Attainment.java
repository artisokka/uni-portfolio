package fi.tuni.prog3.junitattainment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Collections;

/**
 *
 * @author janik
 */
public class Attainment implements Comparable<Attainment> {

    private String courseCode;
    private String studentNumber;
    private int grade;

    public Attainment(String courseCode, String studentNumber, int grade) throws
            IllegalArgumentException {
        if (courseCode == null || courseCode.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (studentNumber == null || studentNumber.isEmpty()) {
            throw new IllegalArgumentException(
                    "Student number cannot be null or empty");
        }
        if (grade > 5 || grade < 0) {
            throw new IllegalArgumentException("Grade must be 0-5");
        }
        this.courseCode = courseCode;
        this.studentNumber = studentNumber;
        this.grade = grade;
    }


    public static final Comparator<Attainment> CODE_STUDENT_CMP =
            new Comparator<Attainment>() {
                @Override
                public int compare(Attainment a, Attainment b) {
                    int cmp = a.getCourseCode().compareTo(b.getCourseCode());
                    if (cmp == 0) {
                        cmp = a.getStudentNumber().compareTo(b.
                                getStudentNumber());
            }
            return cmp;
        }
    };
    public static final Comparator<Attainment> CODE_GRADE_CMP =
            new Comparator<Attainment>() {
        @Override
        public int compare(Attainment a, Attainment b) {
            int cmp = a.getCourseCode().compareTo(b.getCourseCode());
            if (cmp == 0) {
                cmp = Double.compare(a.getGrade(), b.getGrade());
                return -cmp;
            }
            return cmp;
        }
    };
    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", courseCode, studentNumber, grade);
    }

    @Override
    public int compareTo(Attainment other) {
        int cmp = studentNumber.compareTo(other.getStudentNumber());
        if (cmp == 0) {
            cmp = courseCode.compareTo(other.getCourseCode());
        }
        return cmp;
    }

}
