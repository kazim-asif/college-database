package CollegeDatabase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class ContainerUsers implements InterfaceContainerUsers {
    private List<CollegeUser> users;

    public ContainerUsers() {
        users = new ArrayList<>();
    }

    public void insertNewUser(CollegeUser newUser) throws Exception {
        int index = binarySearch(newUser.getId());
        if (index >= 0) {
            throw new Exception("User with ID " + newUser.getId() + " already exists.");
        }
        index = -(index + 1); // Convert to insertion point
        users.add(index, newUser);
    }
    
    // binary search

    private int binarySearch(int userId) {
        int left = 0;
        int right = users.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            CollegeUser user = users.get(mid);
            if (user.getId() == userId) {
                return mid;
            } else if (user.getId() < userId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -(left + 1); // User not found, return insertion point
    }

    public CollegeUser[] getAllUsers() throws RuntimeException {
        if (users.isEmpty()) {
            throw new RuntimeException("No users in the database.");
        }
        return users.toArray(new CollegeUser[0]);
    }

    public ArrayList<CollegeUser> getAllUsersList() {
        return new ArrayList<>(users);
    }

    public Iterator<CollegeUser> getIterator() {
        return users.iterator();
    }

    public ListIterator<CollegeUser> getListIterator() {
        return users.listIterator();
    }
}
