//package CollegeDatabase;
//
//import java.io.File;
//import java.util.*;
//
//// This class implements the InterfaceCollegeDatabaseManager interface
//public class CollegeDatabaseManager implements InterfaceCollegeDatabaseManager {
//
//    // The containers for storing users and courses
//    private ContainerUsers usersContainer;
//    private ContainerCourses coursesContainer;
//
//    // Constructor for initializing the containers
//    public CollegeDatabaseManager() {
//        usersContainer = new ContainerUsers();
//        coursesContainer = new ContainerCourses();
//    }
//
//    // This method loads data from a text file into the database
//    public void loadInputFile(String fileName) throws Exception, RuntimeException {
//        // Open the input file and create a Scanner to read from it
//        File inputFile = new File(fileName);
//        Scanner inputScanner = new Scanner(inputFile);
//
//        // Read each line of the input file
//        while (inputScanner.hasNextLine()) {
//            String line = inputScanner.nextLine();
//
//            // Split the line into an array of tokens
//            List<String> lineDataList = new ArrayList<>();
//            int start = 0;
//            for (int i = 0; i < line.length(); i++) {
//                if (line.charAt(i) == '|') {
//                    lineDataList.add(line.substring(start, i));
//                    start = i + 1;
//                }
//            }
//            lineDataList.add(line.substring(start));
//            String[] lineData = new String[lineDataList.size()];
//            for (int i = 0; i < lineDataList.size(); i++) {
//                lineData[i] = lineDataList.get(i);
//            }
//
//            // Process the line based on its first token
//            switch (lineData[0]) {
//                // If the token is "INS", create a new Instructor object and add it to the users container
//                case "INS":
//                    CollegeUser instructor = new Instructor(
//                            Integer.parseInt(lineData[1]), // ID
//                            lineData[2], // First name
//                            lineData[3]  // Last name
//                    );
//                    usersContainer.insertNewUser(instructor);
//                    break;
//                // If the token is "STU", create a new Student object and add it to the users container
//                case "STU":
//                    CollegeUser student = new Student(
//                            Integer.parseInt(lineData[1]), // ID
//                            lineData[2], // First name
//                            lineData[3]  // Last name
//                    );
//                    usersContainer.insertNewUser(student);
//                    break;
//                // If the token is "COU", create a new CollegeCourse object and add it to the courses container
//                case "COU":
//                    CollegeCourse course = new CollegeCourse(
//                            lineData[1],        // ID
//                            Integer.parseInt(lineData[2]),  // Year
//                            lineData[3],        // Term
//                            Integer.parseInt(lineData[4]),  // Max seats
//                            Integer.parseInt(lineData[5])   // Credits
//                    );
//                    coursesContainer.insertNewCourse(course);
//                    break;
//                // If the token is "REG", register a student for a course or assign a course to an instructor
//                case "REG":
//                    int userId = Integer.parseInt(lineData[1]);
//                    String courseId = lineData[2];
//                    String grade = lineData[3];
//
//                    // Find the course with the given ID
//                    CollegeCourse courseToRegister = null;
//                    for (CollegeCourse c : coursesContainer.getAllCoursesList()) {
//                        if (c.getId().equals(courseId)) {
//                            courseToRegister = c;
//                            break;
//                        }
//                    }
//
//                    // Find the user with the given ID and register them for the course or assign the course to them
//
//
//                    for (CollegeUser user : usersContainer.getAllUsersList()) {
//                        if (user.getId() == userId) {
//                            if (user instanceof Student && grade != null && !grade.equals("NA") && courseToRegister != null) {
//                                ((Student) user).enrollCourse(courseToRegister);
//                                ((Student) user).updateGPA(grade);
//                            } else if (user instanceof Instructor) {
//                                ((Instructor) user).assignCourse(courseToRegister);
//                            }
//                            break;
//                        }
//                    }
//                    break;
//                default:
//                    throw new RuntimeException("Invalid input file format.");
//            }
//        }
//
//        inputScanner.close();
//    }
//
//
//    // Returns (deep) copies of all users in the database arranged in the output array (sorted by id).
////    public CollegeUser[] getAllUsers() throws RuntimeException {
////        ArrayList<CollegeUser> users = usersContainer.getAllUsersList();
////        if (users.isEmpty()) {
////            throw new RuntimeException("Error: No users in the database.");
////        }
////        // Sort the list by user id using a custom comparator
////        Collections.sort(users, new Comparator<CollegeUser>() {
////            public int compare(CollegeUser user1, CollegeUser user2) {
////                return user1.getId() - user2.getId();
////            }
////        });
////        // Convert the list to an array and return it
////        CollegeUser[] usersArray = new CollegeUser[users.size()];
////        usersArray = users.toArray(usersArray);
////        return usersArray;
////    }
//
//    public Iterator<CollegeUser> getAllUsers() throws RuntimeException {
//        ArrayList<CollegeUser> users = usersContainer.getAllUsersList();
//        if (users.isEmpty()) {
//            throw new RuntimeException("Error: No users in the database.");
//        }
//        // Sort the list by user id using a custom comparator
//        Collections.sort(users, new Comparator<CollegeUser>() {
//            public int compare(CollegeUser user1, CollegeUser user2) {
//                return user1.getId() - user2.getId();
//            }
//        });
//        return users.iterator();
//    }    
//
//    
//    
//    // Returns (deep) copies of all courses in the database arranged in the output array (sorted by id).
////    public Iterator<CollegeCourse> getAllCourses() throws RuntimeException {
////        ArrayList<CollegeCourse> courses = coursesContainer.getAllCoursesList();
////        if (courses.isEmpty()) {
////            throw new RuntimeException("Error: No courses in the database.");
////        }
////        // Sort the list by course id using a custom comparator
////        Collections.sort(courses, new Comparator<CollegeCourse>() {
////            public int compare(CollegeCourse course1, CollegeCourse course2) {
////                return course1.getId().compareTo(course2.getId());
////            }
////        });
////        // Convert the list to an array and return it
////        CollegeCourse[] coursesArray = new CollegeCourse[courses.size()];
////        coursesArray = courses.toArray(coursesArray);
////        return coursesArray;
////    }
//    
//    public Iterator<CollegeCourse> getAllCourses() throws RuntimeException {
//        ArrayList<CollegeCourse> courses = coursesContainer.getAllCoursesList();
//        if (courses.isEmpty()) {
//            throw new RuntimeException("Error: No courses in the database.");
//        }
//        // Sort the list by course id using a custom comparator
//        Collections.sort(courses, new Comparator<CollegeCourse>() {
//            public int compare(CollegeCourse course1, CollegeCourse course2) {
//                return course1.getId().compareTo(course2.getId());
//            }
//        });
//        return courses.iterator();
//    }
//
//    
//    
//    
//
//    // Insert an instructor/student/course/registration into the database.
//    public void insertNewEntry(String entryLine) throws Exception {
//        String[] tokens = entryLine.split("\\|");
//        if (tokens.length < 2) {
//            throw new Exception("Error: Invalid entry format.");
//        }
//        String label = tokens[0];
//        if (label.equals("INS")) {
//            CollegeUser instructor = new Instructor(
//                    Integer.parseInt(tokens[1]), // ID
//                    tokens[2], // First name
//                    tokens[3]  // Last name
//            );
//            usersContainer.insertNewUser(instructor);
//        } else if (label.equals("STU")) {
//            CollegeUser student = new Student(
//                    Integer.parseInt(tokens[1]), // ID
//                    tokens[2], // First name
//                    tokens[3]  // Last name
//            );
//            usersContainer.insertNewUser(student);
//        } else if (label.equals("COU")) {
//            CollegeCourse course = new CollegeCourse(
//                    tokens[1],        // ID
//                    Integer.parseInt(tokens[2]),  // Year
//                    tokens[3],        // Term
//                    Integer.parseInt(tokens[4]),  // Max seats
//                    Integer.parseInt(tokens[5])   // Credits
//            );
//            coursesContainer.insertNewCourse(course);
//        } else if (label.equals("REG")) {
//            if (tokens.length < 4) {
//                throw new Exception("Error: Invalid registration format.");
//            }
//            int userId = Integer.parseInt(tokens[1]);
//            String courseId = tokens[2];
//            String grade = tokens[3];
//
//            // Find the user and course corresponding to the registration
//            CollegeUser user = null;
//            CollegeCourse course = null;
//            for (CollegeUser u : usersContainer.getAllUsersList()) {
//                if (u.getId() == userId) {
//                    user = u;
//                    break;
//                }
//            }
//            for (CollegeCourse c : coursesContainer.getAllCoursesList()) {
//                if (c.getId().equals(courseId)) {
//                    course = c;
//                    break;
//                }
//            }
//            if (user == null || course == null) {
//                throw new Exception("Error: Invalid registration user or course id.");
//            }
//
//            // Enroll the student and assign the grade
//            if (user instanceof Student) {
//                Student student = (Student) user;
//                if (grade != null && !grade.equals("NA")) {
//                    if (!student.hasRegisteredForCourse(course)) {
//                        student.enrollCourse(course);
//                        student.updateGPA(grade);
//                    }
//                }
//            }
//
//        } else {
//            throw new Exception("Error: Invalid entry label.");
//        }
//    }
//
//}





package CollegeDatabase;

import java.io.File;
import java.util.*;

// This class implements the InterfaceCollegeDatabaseManager interface
public class CollegeDatabaseManager implements InterfaceCollegeDatabaseManager {

    // The containers for storing users and courses
    private ContainerUsers usersContainer;
    private ContainerCourses coursesContainer;

    // Constructor for initializing the containers
    public CollegeDatabaseManager() {
        usersContainer = new ContainerUsers();
        coursesContainer = new ContainerCourses();
    }

    // This method loads data from a text file into the database
    public void loadInputFile(String fileName) throws Exception, RuntimeException {
        // Open the input file and create a Scanner to read from it
        File inputFile = new File(fileName);
        Scanner inputScanner = new Scanner(inputFile);

        // Read each line of the input file
        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();

            // Split the line into an array of tokens
            List<String> lineDataList = new ArrayList<>();
            int start = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '|') {
                    lineDataList.add(line.substring(start, i));
                    start = i + 1;
                }
            }
            lineDataList.add(line.substring(start));
            String[] lineData = new String[lineDataList.size()];
            for (int i = 0; i < lineDataList.size(); i++) {
                lineData[i] = lineDataList.get(i);
            }

            // Process the line based on its first token
            switch (lineData[0]) {
                // If the token is "INS", create a new Instructor object and add it to the users container
                case "INS":
                    CollegeUser instructor = new Instructor(
                            Integer.parseInt(lineData[1]), // ID
                            lineData[2], // First name
                            lineData[3]  // Last name
                    );
                    usersContainer.insertNewUser(instructor);
                    break;
                // If the token is "STU", create a new Student object and add it to the users container
                case "STU":
                    CollegeUser student = new Student(
                            Integer.parseInt(lineData[1]), // ID
                            lineData[2], // First name
                            lineData[3]  // Last name
                    );
                    usersContainer.insertNewUser(student);
                    break;
                // If the token is "COU", create a new CollegeCourse object and add it to the courses container
                case "COU":
                    CollegeCourse course = new CollegeCourse(
                            lineData[1],        // ID
                            Integer.parseInt(lineData[2]),  // Year
                            lineData[3],        // Term
                            Integer.parseInt(lineData[4]),  // Max seats
                            Integer.parseInt(lineData[5])   // Credits
                    );
                    coursesContainer.insertNewCourse(course);
                    break;
                // If the token is "REG", register a student for a course or assign a course to an instructor
                case "REG":
                    int userId = Integer.parseInt(lineData[1]);
                    String courseId = lineData[2];
                    String grade = lineData[3];

                    // Find the course with the given ID
                    CollegeCourse courseToRegister = null;
                    for (CollegeCourse c : coursesContainer.getAllCoursesList()) {
                        if (c.getId().equals(courseId)) {
                            courseToRegister = c;
                            break;
                        }
                    }

                    // Find the user with the given ID and register them for the course or assign the course to them
                    for (CollegeUser user : usersContainer.getAllUsersList()) {
                        if (user.getId() == userId) {
                            if (user instanceof Student && grade != null && !grade.equals("NA") && courseToRegister != null) {
                                ((Student) user).enrollCourse(courseToRegister);
                                ((Student) user).updateGPA(grade);
                            } else if (user instanceof Instructor) {
                                ((Instructor) user).assignCourse(courseToRegister);
                            }
                            break;
                        }
                    }
                    break;
                default:
                    throw new RuntimeException("Invalid input file format.");
            }
        }

        inputScanner.close();
    }


    // Returns (deep) copies of all users in the database arranged in the output array (sorted by id).
//    public CollegeUser[] getAllUsers() throws RuntimeException {
//        ArrayList<CollegeUser> users = usersContainer.getAllUsersList();
//        if (users.isEmpty()) {
//            throw new RuntimeException("Error: No users in the database.");
//        }
//        // Sort the list by user id using a custom comparator
//        Collections.sort(users, new Comparator<CollegeUser>() {
//            public int compare(CollegeUser user1, CollegeUser user2) {
//                return user1.getId() - user2.getId();
//            }
//        });
//        // Convert the list to an array and return it
//        CollegeUser[] usersArray = new CollegeUser[users.size()];
//        usersArray = users.toArray(usersArray);
//        return usersArray;
//    }

    public Iterator<CollegeUser> getAllUsers() throws RuntimeException {
        ArrayList<CollegeUser> users = usersContainer.getAllUsersList();
        if (users.isEmpty()) {
            throw new RuntimeException("Error: No users in the database.");
        }
        // Sort the list by user id using a custom comparator
        Collections.sort(users, new Comparator<CollegeUser>() {
            public int compare(CollegeUser user1, CollegeUser user2) {
                return user1.getId() - user2.getId();
            }
        });
        return users.iterator();
    }    

    
    
    // Returns (deep) copies of all courses in the database arranged in the output array (sorted by id).
//    public Iterator<CollegeCourse> getAllCourses() throws RuntimeException {
//        ArrayList<CollegeCourse> courses = coursesContainer.getAllCoursesList();
//        if (courses.isEmpty()) {
//            throw new RuntimeException("Error: No courses in the database.");
//        }
//        // Sort the list by course id using a custom comparator
//        Collections.sort(courses, new Comparator<CollegeCourse>() {
//            public int compare(CollegeCourse course1, CollegeCourse course2) {
//                return course1.getId().compareTo(course2.getId());
//            }
//        });
//        // Convert the list to an array and return it
//        CollegeCourse[] coursesArray = new CollegeCourse[courses.size()];
//        coursesArray = courses.toArray(coursesArray);
//        return coursesArray;
//    }
    
    public Iterator<CollegeCourse> getAllCourses() throws RuntimeException {
        ArrayList<CollegeCourse> courses = coursesContainer.getAllCoursesList();
        if (courses.isEmpty()) {
            throw new RuntimeException("Error: No courses in the database.");
        }
        // Sort the list by course id using a custom comparator
        Collections.sort(courses, new Comparator<CollegeCourse>() {
            public int compare(CollegeCourse course1, CollegeCourse course2) {
                return course1.getId().compareTo(course2.getId());
            }
        });
        return courses.iterator();
    }

    
    
    

    // Insert an instructor/student/course/registration into the database.
    public void insertNewEntry(String entryLine) throws Exception {
        String[] tokens = entryLine.split("\\|");
        if (tokens.length < 2) {
            throw new Exception("Error: Invalid entry format.");
        }
        String label = tokens[0];
        if (label.equals("INS")) {
            CollegeUser instructor = new Instructor(
                    Integer.parseInt(tokens[1]), // ID
                    tokens[2], // First name
                    tokens[3]  // Last name
            );
            usersContainer.insertNewUser(instructor);
        } else if (label.equals("STU")) {
            CollegeUser student = new Student(
                    Integer.parseInt(tokens[1]), // ID
                    tokens[2], // First name
                    tokens[3]  // Last name
            );
            usersContainer.insertNewUser(student);
        } else if (label.equals("COU")) {
            CollegeCourse course = new CollegeCourse(
                    tokens[1],        // ID
                    Integer.parseInt(tokens[2]),  // Year
                    tokens[3],        // Term
                    Integer.parseInt(tokens[4]),  // Max seats
                    Integer.parseInt(tokens[5])   // Credits
            );
            coursesContainer.insertNewCourse(course);
        } else if (label.equals("REG")) {
            if (tokens.length < 4) {
                throw new Exception("Error: Invalid registration format.");
            }
            int userId = Integer.parseInt(tokens[1]);
            String courseId = tokens[2];
            String grade = tokens[3];

            // Find the user and course corresponding to the registration
            CollegeUser user = null;
            CollegeCourse course = null;
            for (CollegeUser u : usersContainer.getAllUsersList()) {
                if (u.getId() == userId) {
                    user = u;
                    break;
                }
            }
            for (CollegeCourse c : coursesContainer.getAllCoursesList()) {
                if (c.getId().equals(courseId)) {
                    course = c;
                    break;
                }
            }
            if (user == null || course == null) {
                throw new Exception("Error: Invalid registration user or course id.");
            }

            // Enroll the student and assign the grade
            if (user instanceof Student) {
                Student student = (Student) user;
                if (grade != null && !grade.equals("NA")) {
                    if (!student.hasRegisteredForCourse(course)) {
                        student.enrollCourse(course);
                        student.updateGPA(grade);
                    }
                }
            }

        } else {
            throw new Exception("Error: Invalid entry label.");
        }
    }
}
