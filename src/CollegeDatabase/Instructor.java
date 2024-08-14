package CollegeDatabase;

import java.util.ArrayList;
import java.util.List;

// Instructor class representing an instructor in the college database
public class Instructor extends CollegeUser implements InterfaceInstructor {
    private List<CollegeCourse> courses;

    public Instructor(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.courses = new ArrayList<>();
    }

    // Assign a course to the instructor
    public void assignCourse(CollegeCourse course) {
        this.courses.add(course);
    }

    // Get an array of all courses assigned to the instructor
    @Override
    public CollegeCourse[] getAllCourses() {
        return courses.toArray(new CollegeCourse[0]);
    }
}
