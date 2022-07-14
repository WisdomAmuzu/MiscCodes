import java.util.ArrayList;

public class Instructor extends Individual {
    int bonus;
    int salary;
    int basePay = 2500;
    String type;
    ArrayList<Course> assignedCourses = new ArrayList<>();

    public Instructor() {
        //Default constructor
    }
    
    public Instructor(String name, int age, String phoneNumber, String address, String type) {
            this.name = name;
            this.age = age;
            this.phoneNumber = phoneNumber;
			this.address = address;
            this.type = type;
    }

    public Instructor(String string, int i, String string2, String string3) {
    }

    void setBonus() {
        switch (type) {
            case "Full-Time":
            // if he's a ful time lecturer and takes more than 4 courses, add a bonus of 5000
                if(!assignedCourses.isEmpty() && assignedCourses.size() > 4 ) { 
                    this.bonus = 5000;
                }
                break;
            case "Part-Time":
            // No bonus for a part time lecturer
                this.bonus = 0;
                break;
            case "Professor":
            // add a bonus of 1500 for each extra course after 2 courses for a professor
                if(!assignedCourses.isEmpty() && assignedCourses.size() > 2) { 
                    int diff = assignedCourses.size() - 2;
                    this.bonus = diff * 1500;
                }
				break;
        }
    }

    void calculateSalary() {
        this.salary = this.basePay + this.bonus;
    }

    int assignCourse(Course c) {
        switch (type) {
            case "Full-Time":
                this.assignedCourses.add(c);
                break;
            case "Part-Time":
            // Constraint for part time lecturers to take not more than 2 courses
                if(this.assignedCourses.size() == 2) {
                    return 0;
                }
                else {
                    this.assignedCourses.add(c);
                }
                break;
            case "Professor":
                this.assignedCourses.add(c);
                break;
			default:
				return 0;
        }
        return 1;
    }
}