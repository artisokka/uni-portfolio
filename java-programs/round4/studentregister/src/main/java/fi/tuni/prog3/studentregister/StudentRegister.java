package fi.tuni.prog3.studentregister;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author janik
 *
 *
 */
public class StudentRegister {

    public class Pair<String, Attainment> {

        public String name;
        public Attainment att;

        public Pair(String x, Attainment y) {
            this.name = x;
            this.att = y;
        }

        public String getName() {
            return this.name;
        }

        public Attainment getAtt() {
            return this.att;
        }
    }

    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<Attainment> attainments = new ArrayList<>();

    public StudentRegister() {

    }

    public ArrayList<Student> getStudents() {
        students.sort(Comparator.comparing(student -> student.getName()));
        return students;
    }

    public ArrayList<Course> getCourses() {
        courses.sort(Comparator.comparing(course -> course.getName()));
        return courses;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addAttainment(Attainment att) {
        attainments.add(att);
    }

    public void printStudentAttainments(String studentNumber, String order) {
        ArrayList<Pair<String, Attainment>> result = new ArrayList<>();
        boolean exist = false;
        Student student = new Student("", "");

        for (int i = 0; i < this.attainments.size(); i++) {
            if (this.attainments.get(i).getStudentNumber().compareTo(studentNumber) == 0) {
                for (int k = 0; k < students.size(); k++) {
                    if (students.get(k).getStudentNumber().compareTo(studentNumber) == 0) {
                        student = students.get(k);
                        break;
                    }
                }

                for (int j = 0; j < this.courses.size(); j++) {

                    if (courses.get(j).getCode().compareTo(attainments.get(i).getCourseCode()) == 0) {
                        String courseName = courses.get(j).getName();
                        var temp = attainments.get(i);
                        result.add(new Pair(courseName, temp));
                    }
                }

                exist = true;
            }
        }

        if (exist) {
            if (order.compareTo("by name") == 0) {
                result.sort(Comparator.comparing(Pair -> Pair.name));
            } else if (order.compareTo("by code") == 0) {
                result.sort(Comparator.comparing(Pair -> Pair.att.getCourseCode()));
            }

            System.out.println(student.getName() + " (" + studentNumber + "):");
            for (int i = 0; i < result.size(); i++) {
                System.out.println("  " + result.get(i).att.getCourseCode() + " " + result.get(i).name + ": " + result.get(i).att.getGrade());
            }

        } else {
            System.out.println("Unknown student number: " + studentNumber);
        }
    }

    public void printStudentAttainments(String studentNumber) {
        printStudentAttainments(studentNumber, "");
    }

}
