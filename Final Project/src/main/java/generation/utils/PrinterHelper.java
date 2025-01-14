package generation.utils;

import generation.model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PrinterHelper {

    public static void showMainMenu() {
        System.out.println("|-------------------------------|");
        System.out.println("| Welcome to StudentGen         |");
        System.out.println("|-------------------------------|");
        System.out.println("| Select 1 option:              |");
        System.out.println("| . 1 Register Student          |");
        System.out.println("| . 2 Find Student              |");
        System.out.println("| . 3 Grade Student             |");
        System.out.println("| . 4 Enroll Student to Course  |");
        System.out.println("| . 5 Show Students Summary     |");
        System.out.println("| . 6 Show Courses Summary      |");
        System.out.println("| . 7 Exit                      |");
        System.out.println("|-------------------------------|");
    }

    public static Student createStudentMenu(Scanner scanner) throws ParseException {
        System.out.println("|-------------------------------------|");
        System.out.println("| . 1 Register Student                |");
        System.out.println("|-------------------------------------|");
        System.out.println("| Enter student name:                 |");
        String name = scanner.next();
        System.out.println("| Enter student ID:                   |");
        String id = scanner.next();
        System.out.println("| Enter student email:                |");
        String email = scanner.next();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate = null;
        while (birthDate == null) {
            System.out.println("| Enter student birth date(dd/mm/yyyy)|");
            String dateInput = scanner.next();
            try {
                birthDate = date.parse(dateInput);
            } catch (ParseException e) {
                System.out.println("The date is invalid, please try again. (dd/mm/yyyy)");
            }
        }
        System.out.println("|-------------------------------------|");
        Student student = new Student(id, name, email, birthDate);
        System.out.println("Student Successfully Registered! ");
        System.out.println(student);
        return student;
    }

}
