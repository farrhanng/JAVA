package generation;

import generation.model.Course;
import generation.model.Student;
import generation.service.CourseService;
import generation.service.StudentService;
import generation.utils.PrinterHelper;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        // Instantiate
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();

        Scanner scanner = new Scanner(System.in);

        // Main Menu
        int option = 0;
        do {
            PrinterHelper.showMainMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    registerStudent(studentService, scanner);
                    break;
                case 2:
                    findStudent(studentService, scanner);
                    break;
                case 3:
                    gradeStudent(studentService, courseService, scanner);
                    break;
                case 4:
                    enrollStudentToCourse(studentService, courseService, scanner);
                    break;
                case 5:
                    showStudentsSummary(studentService, scanner);
                    break;
                case 6:
                    showCoursesSummary(courseService, scanner);
                    break;
            }
        } while (option != 7);
    }

    // case 1
    private static void registerStudent(StudentService studentService, Scanner scanner) throws ParseException {
        Student student = PrinterHelper.createStudentMenu(scanner);
        studentService.registerStudent(student);
    }

    // case 2
    private static void findStudent(StudentService studentService, Scanner scanner) {
        System.out.println("Enter student ID: ");
        String studentId = scanner.next();
        Student student = studentService.findStudent(studentId);
        if (student != null) {
            System.out.println("Student Found: ");
            System.out.println(student);
        } else {
            System.out.println("Student with Id = " + studentId + " not found");
        }
    }

    // case 3
    private static void gradeStudent(StudentService studentService, CourseService courseService, Scanner scanner) {
        System.out.println("Insert student ID");
        String studentId = scanner.next();
        Student student = studentService.findStudent(studentId);
        if (student == null) {
            System.out.println("Invalid student ID");
            return;
        }
        System.out.println(student);
        System.out.println("Insert course code");
        String courseId = scanner.next();
        Course course = courseService.getCourse(courseId);
        if (course == null) {
            System.out.println("Invalid course code");
            return;
        }
        System.out.println(course);

        System.out.println("Insert grade for the course:");
        while (!scanner.hasNextDouble()) { // Ensure that a double is entered for the grade
            System.out.println("Please enter a valid grade (numeric value):");
            scanner.next(); // Consume the invalid input
        }
        double grade = scanner.nextDouble();
        boolean success = studentService.gradeStudent(studentId, courseId, grade);
        if (success) {
            System.out.println("Student " + student.getName() + " in " + course.getName() + " is graded " + grade);
        } else {
            System.out.println("Failed to grade the student. Please check the student ID and course code.");
        }
    }

    // case 4
    private static void enrollStudentToCourse(StudentService studentService, CourseService courseService, Scanner scanner) {
        System.out.println("Insert student ID");
        String studentId = scanner.next();
        Student student = studentService.findStudent(studentId);
        if (student == null) {
            System.out.println("Invalid student ID");
            return;
        }
        System.out.println(student);
        System.out.println("Insert course code");
        String courseId = scanner.next();
        Course course = courseService.getCourse(courseId);
        if (course == null) {
            System.out.println("Invalid course Code");
            return;
        }
        System.out.println(course);
        courseService.enrollStudent(courseId, student);
        studentService.enrollToCourse(studentId, course);
        System.out.println("Student with ID: " + studentId + " enrolled successfully to " + courseId);
    }

    // case 5
    private static void showStudentsSummary(StudentService studentService, Scanner scanner) {
        studentService.showSummary();
    }

    // case 6
    private static void showCoursesSummary(CourseService courseService, Scanner scanner) {
        courseService.showSummary();
    }

}
