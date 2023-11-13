package generation.service;

import generation.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    private StudentService studentService;
    private Student existingStudent;

    @BeforeEach
    void setUp() {
        studentService = new StudentService();
        existingStudent = new Student("1", "John Doe", "john.doe@test.com", new Date());
        studentService.registerStudent(existingStudent);
    }

    @Test
    void whenStudentIdExists_thenStudentIsFound() {
        Student foundStudent = studentService.findStudent("1");
        assertNotNull(foundStudent, "Student should be found with ID '1'");
        assertEquals(existingStudent, foundStudent, "The found student should be the one we registered");
    }

    @Test
    void whenStudentIdDoesNotExist_thenNullIsReturned() {
        Student foundStudent = studentService.findStudent("nonexistent");
        assertNull(foundStudent, "No student should be found with a non-existent ID");
    }
}
