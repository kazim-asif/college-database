package CollegeDatabase;

public class CollegeUser implements InterfaceCollegeUser {
    private int id;
    private String firstName;
    private String lastName;

    public CollegeUser(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(CollegeUser o) {
        return 0;
    }

    @Override
    public String toString() {
        return "CollegeUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
