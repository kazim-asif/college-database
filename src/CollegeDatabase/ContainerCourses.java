package CollegeDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Container for storing and managing college courses
class ContainerCourses implements InterfaceContainerCourses {
    private TreeNode root;

    public ContainerCourses() {
        root = null;
    }

    // Insert a new course into the container
    public void insertNewCourse(CollegeCourse newCourse) throws Exception {
        if (newCourse == null) {
            throw new Exception("Invalid input data.");
        }
        if (containsCourse(newCourse.getId())) {
            throw new Exception("Duplicate course code.");
        }
        root = insertNode(root, newCourse);
    }

    // Helper method to insert a course node into the container
    private TreeNode insertNode(TreeNode node, CollegeCourse course) {
        if (node == null) {
            return new TreeNode(course);
        }
        if (course.getId().compareTo(node.course.getId()) < 0) {
            node.left = insertNode(node.left, course);
        } else {
            node.right = insertNode(node.right, course);
        }
        return node;
    }

    // Get an array of all courses in the container (in-order traversal)
    public CollegeCourse[] getAllCourses() throws RuntimeException {
        if (root == null) {
            throw new RuntimeException("Container is empty.");
        }
        List<CollegeCourse> coursesList = new ArrayList<>();
        inOrderTraversal(root, coursesList);
        return coursesList.toArray(new CollegeCourse[0]);
    }

    // Perform an in-order traversal of the tree and collect courses in a list
    private void inOrderTraversal(TreeNode node, List<CollegeCourse> coursesList) {
        if (node != null) {
            inOrderTraversal(node.left, coursesList);
            coursesList.add(node.course);
            inOrderTraversal(node.right, coursesList);
        }
    }

    // Get a list of all courses in the container
    public ArrayList<CollegeCourse> getAllCoursesList() {
        return new ArrayList<>(Arrays.asList(getAllCourses()));
    }

    // Get an iterator for a pre-order traversal of the tree
    public Iterator<CollegeCourse> getPreOrderIterator() {
        List<CollegeCourse> coursesList = new ArrayList<>();
        preOrderTraversal(root, coursesList);
        return coursesList.iterator();
    }

    // Perform a pre-order traversal of the tree and collect courses in a list
    private void preOrderTraversal(TreeNode node, List<CollegeCourse> coursesList) {
        if (node != null) {
            coursesList.add(node.course);
            preOrderTraversal(node.left, coursesList);
            preOrderTraversal(node.right, coursesList);
        }
    }

    // Get an iterator for an in-order traversal of the tree
    public Iterator<CollegeCourse> getInOrderIterator() {
        List<CollegeCourse> coursesList = new ArrayList<>();
        inOrderTraversal(root, coursesList);
        return coursesList.iterator();
    }

    // Get an iterator for a post-order traversal of the tree
    public Iterator<CollegeCourse> getPostOrderIterator() {
        List<CollegeCourse> coursesList = new ArrayList<>();
        postOrderTraversal(root, coursesList);
        return coursesList.iterator();
    }

    // Perform a post-order traversal of the tree and collect courses in a list
    private void postOrderTraversal(TreeNode node, List<CollegeCourse> coursesList) {
        if (node != null) {
            postOrderTraversal(node.left, coursesList);
            postOrderTraversal(node.right, coursesList);
            coursesList.add(node.course);
        }
    }

    // Check if a course with the given course ID exists in the container
    private boolean containsCourse(String courseId) {
        return findNode(root, courseId) != null;
    }

    // Find the node with the given course ID in the tree
    private TreeNode findNode(TreeNode node, String courseId) {
        if (node == null || node.course.getId().equals(courseId)) {
            return node;
        }
        if (courseId.compareTo(node.course.getId()) < 0) {
            return findNode(node.left, courseId);
        } else {
            return findNode(node.right, courseId);
        }
    }

    // TreeNode class for representing a node in the tree
    private static class TreeNode {
        private CollegeCourse course;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(CollegeCourse course) {
            this.course = course;
            this.left = null;
            this.right = null;
        }
    }
}
