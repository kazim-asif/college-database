package CollegeDatabase;

public class CollegeCourse implements InterfaceCollegeCourse {
    private final String id;
    private final int year;
    private final String term;
    private final int maxSeats;
    private final int credits;

    public CollegeCourse(String id, int year, String term, int maxSeats, int credits) {
        this.id = id;
        this.year = year;
        this.term = term;
        this.maxSeats = maxSeats;
        this.credits = credits;
    }

    public String getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getTerm() {
        return term;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public int getCredits() {
        return credits;
    }

    // Overriding the compareTo method defined by Comparable
    // We assume that the course id is unique for each course
    public int compareTo(CollegeCourse other) {
        return this.id.compareTo(other.getId());
    }

    @Override
    public String toString() {
        return "CollegeCourse{" +
                "id='" + id + '\'' +
                ", year=" + year +
                ", term='" + term + '\'' +
                ", maxSeats=" + maxSeats +
                ", credits=" + credits +
                '}';
    }
}
