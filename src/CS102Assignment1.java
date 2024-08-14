import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

import CollegeDatabase.CollegeCourse;
import CollegeDatabase.CollegeDatabaseManager;
import CollegeDatabase.CollegeUser;

public class CS102Assignment1 {

    public static void main(String[] args) throws Exception {
        Scanner consoleInput = new Scanner(System.in);

        // Check if there is an argument for the file name
        if (args.length != 1) {
            System.err.println("Error: Please provide an input file name as an argument.");
            System.exit(1);
        }

        String filename = args[0];
        CollegeDatabaseManager db = new CollegeDatabaseManager();
        
        try {
            // Load the input file
            db.loadInputFile(filename);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found. Please provide a valid input file name.");
            System.exit(1);
        }

        while (true) {
            System.out.println("--- CS-102 - ASSIGNMENT 1 – COLLEGE DATABASE MANAGER ---");
            System.out.println("1 --> Print All Users (Instructors and Students with GPA)");
            System.out.println("2 --> Print All Courses");
            System.out.println("3 --> Insert New Entry");
            System.out.println("4 --> Exit");
            System.out.print("Your Choice? ");

            try {
                int choice = Integer.parseInt(consoleInput.nextLine());

                // Perform the chosen command
                switch (choice) {
                    case 1:
                        // Print all users
                        Iterator<CollegeUser> userIterator = db.getAllUsers();
                        while (userIterator.hasNext()) {
                            CollegeUser user = userIterator.next();
                            System.out.println(user.toString());
                        }
                        break;
                    case 2:
                        // Print all courses
                        Iterator<CollegeCourse> courseIterator = db.getAllCourses();
                        while (courseIterator.hasNext()) {
                            CollegeCourse course = courseIterator.next();
                            System.out.println(course.toString());
                        }
                        break;
                    case 3:
                        // Insert a new entry
                        System.out.print("Enter new entry: ");
                        String entryLine = consoleInput.nextLine();
                        db.insertNewEntry(entryLine);
                        break;
                    case 4:
                        // Exit the program
                        System.exit(0);
                    default:
                        System.err.println("Error: Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid choice. Please enter a valid integer.");
            }
        }
    }
}
