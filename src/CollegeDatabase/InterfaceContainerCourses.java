


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2023-04-09

package CollegeDatabase;

import java.lang.String;

// Public interface providing the specifications for the ContainerCourses class.
// Note: Assignment 1 of CS-102 (Spring 2023).
public interface InterfaceContainerCourses {

   // Desc.: Returns (deep) copies of all courses in the database arranged in the output array (sorted by id).
   // Output: Throws an unchecked (non-critical) exception if container is empty.
   public CollegeCourse[] getAllCourses() throws RuntimeException;
   
   // Desc.: Insert a new course into the database.
   // Input: A new course object.
   // Output: Throws a checked (critical) exception if insertion fails.
   public void insertNewCourse( CollegeCourse newCourse ) throws Exception;
         
}


