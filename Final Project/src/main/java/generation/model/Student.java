package generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends Person implements Evaluation {

    private final List<Course> enrolledCourses = new ArrayList<>();
    private final List<Course> approvedCourses = new ArrayList<>();

    // Constructor
    public Student(String id, String name, String email, Date birthDate) {
        // Superclass Person Constructor
        super(id, name, email, birthDate);
    }

    // Getters & Setters
    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Method case 3
    public boolean setGradeForCourse(String courseCode, double grade) {
        for (Course course : enrolledCourses) {
            if (course.getCode().equals(courseCode)) {
                course.setGrade(grade);
                return true;
            }
        }
        return false;
    }

    // Method case 4
    public void enrollToCourse(Course course) {
        enrolledCourses.add(course);
    }

    public boolean isCourseApproved(String courseCode) {
        for (Course course : approvedCourses) {
            if (course.getCode().equals(courseCode)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAttendingCourse(String courseCode) {
        for (Course course : enrolledCourses) {
            if (course.getCode().equals(courseCode)) {
                return true;
            }
        }
        return false;
    }

    // Evaluation Interface
    @Override
    public double getAverage() {
        return 0;
    }

    @Override
    public List<Course> getApprovedCourses() {
        return new ArrayList<>(approvedCourses);
    }

    @Override
    public String toString() {
        return "Student {" + super.toString() + "}";
    }
}
