package generation.service;

import generation.model.Course;
import generation.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService {
    private final Map<String, Student> students = new HashMap<>();

    // Method case 1
    public void registerStudent(Student student) {
        students.put(student.getId(), student);
    }

    // Method case 2
    public Student findStudent(String studentId) {
        return students.get(studentId);
    }

    // Method case 3
    public boolean gradeStudent(String studentId, String courseCode, double grade) {
        Student student = students.get(studentId);
        if (student != null) {
            return student.setGradeForCourse(courseCode, grade);
        }
        return false;
    }

    // Method case 4
    public void enrollToCourse(String studentId, Course course) {
        students.get(studentId).enrollToCourse(course);
    }

    // Method case 5 and 6
    public void showSummary() {
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            Student student = entry.getValue();

            System.out.println("Student ID: " + entry.getKey() + ", Name: " + student.getName());
            System.out.println("Enrolled Courses: ");

            for (Course course : student.getEnrolledCourses()) {
                System.out.println(course);
            }
            System.out.println("Approved Courses: ");
            for (Course course : student.getApprovedCourses()) {
                System.out.println(course);
            }
            System.out.println();
        }
    }

    // Question 2
    public boolean isSubscribed(String studentId) {
        return students.containsKey(studentId);
    }

}
