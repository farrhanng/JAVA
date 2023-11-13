package generation.service;

import generation.model.Course;
import generation.model.Module;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {
    private CourseService courseService;
    private Course existingCourse;

    @BeforeEach
    void setUp() {
        courseService = new CourseService();
        Module module = new Module("0", "Test Module", "Test Module Description");
        existingCourse = new Course("CS101", "Test Course", 5, module);
        courseService.registerCourse(existingCourse);
    }

    @Test
    void whenCourseCodeExists_thenCourseIsReturned() {
        Course course = courseService.getCourse("CS101");
        assertEquals(existingCourse, course, "The course code matches.");
    }

    @Test
    void whenCourseCodeDoesNotExist_thenNullIsReturned() {
        Course course = courseService.getCourse("nonexistent");
        assertNull(course, "The course is nonexistent.");
    }
}