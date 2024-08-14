// CS-102: "Computing and Algorithms II"
// Prof. Giuseppe Turini
// Kettering University
// 2022-04-09

package CollegeDatabase;

import java.lang.Comparable;
import java.lang.String;

// Public interface providing the specifications for the CollegeCourse class.
// Note: Assignment 1 of CS-102 (Spring 2023).
public interface InterfaceCollegeCourse extends Comparable<CollegeCourse> {
   
   // Accessors (getters).
   public String getId();
   public int getYear();
   public String getTerm();
   public int getMaxSeats();
   public int getCredits();
   
}


