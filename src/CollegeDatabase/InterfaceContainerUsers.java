


// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2023-04-09

package CollegeDatabase;

import java.lang.String;

// Public interface providing the specifications for the ContainerUsers class.
// Note: Assignment 1 of CS-102 (Spring 2023).
public interface InterfaceContainerUsers {

   // Desc.: Returns (deep) copies of all users in the database arranged in the output array (sorted by id).
   // Output: Throws an unchecked (non-critical) exception if container is empty.
   public CollegeUser[] getAllUsers() throws RuntimeException;
   
   // Desc.: Insert a new user (instructor/student) into the database.
   // Input: A new user (instructor/student) object.
   // Output: Throws a checked (critical) exception if insertion fails.
   public void insertNewUser( CollegeUser newUser ) throws Exception;
         
}


