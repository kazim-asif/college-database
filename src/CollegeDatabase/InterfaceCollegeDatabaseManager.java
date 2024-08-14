// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2023-04-09

package CollegeDatabase;

import java.lang.String;
import java.util.Iterator;

// Public interface providing the specifications for the CollegeDatabaseManager class.
// Note: Assignment 1 of CS-102 (Spring 2023).
public interface InterfaceCollegeDatabaseManager {

   // Desc.: Loads data from input file following the format described in the specifications.
   // Input: The name of the input file.
   // Output: Could throw unchecked (non-critical) or checked (critical) exception...
   public void loadInputFile( String fileName ) throws Exception, RuntimeException;
   
   // Desc.: Returns (deep) copies of all users in the database arranged in the output array (sorted by id).
   // Output: Throws an unchecked (non-critical) exception if container is empty.
   public Iterator<CollegeUser> getAllUsers() throws RuntimeException;
   
   // Desc.: Returns (deep) copies of all courses in the database arranged in the output array (sorted by id).
   // Output: Throws an unchecked (non-critical) exception if container is empty.
   public Iterator<CollegeCourse> getAllCourses() throws RuntimeException;
   
   // Desc.: Insert an instructor/student/course/registration into the database.
   // Input: A new entry line (same as input file).
   // Output: Throws a checked (critical) exception if insertion fails.
   public void insertNewEntry( String entryLine ) throws Exception;
         
}


