package CollegeDatabase;

import java.util.ArrayList;
import java.util.List;

// Student class representing a student in the college database
public class Student extends CollegeUser implements InterfaceStudent {
    private List<CollegeCourse> courses;
    private float gpa;

    public Student(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.courses = new ArrayList<>();
        gpa = 0.0f;
    }

    // Enroll in a course
    public void enrollCourse(CollegeCourse course) {
        this.courses.add(course);
    }

    // Get an array of all enrolled courses
    @Override
    public CollegeCourse[] getAllCourses() {
        return courses.toArray(new CollegeCourse[0]);
    }

    // Get the GPA of the student
    @Override
    public float getGPA() {
        return this.gpa;
    }

    // Set the GPA of the student
    public void setGPA(float gpa) {
        this.gpa = gpa;
    }

    // Check if the student has registered for a specific course
    public boolean hasRegisteredForCourse(CollegeCourse course) {
        for (CollegeCourse c : courses) {
            if (c.getId().equals(course.getId())) {
                return true;
            }
        }
        return false;
    }

    // Update the GPA based on the grade received for a course
    public void updateGPA(String grade) {
        if (this.gpa == 0.0f) {
            this.gpa = recalculateGPA(grade);
            return;
        }
        float total = this.gpa + recalculateGPA(grade);
        this.gpa = total / 2;
    }

    // Recalculate the GPA based on the grade received
    private float recalculateGPA(String grade) {
        switch (grade) {
            case "A":
                return 4.0f;
            case "A-":
                return 3.7f;
            case "B+":
                return 3.3f;
            case "B":
                return 3.0f;
            case "B-":
                return 2.7f;
            case "C+":
                return 2.3f;
            case "C":
                return 2.0f;
            case "C-":
                return 1.7f;
            case "D+":
                return 1.3f;
            case "D":
                return 1.0f;
            case "F":
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    // Override the toString method to include the GPA information
    @Override
    public String toString() {
        if (this.gpa == 0.0f) {
            return super.toString() + " GPA: N/A";
        }
        return super.toString() + " GPA: " + this.gpa;
    }
}
