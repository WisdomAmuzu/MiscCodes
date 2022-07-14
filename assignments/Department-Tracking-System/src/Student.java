import static java.lang.Integer.parseInt;
import java.util.ArrayList;

public class Student extends Individual {
	String status;
	int maxCourse = 6;
	boolean onProbation;
	ArrayList<Course> enrolledCourses = new ArrayList<>();
	ArrayList<String> grades = new ArrayList<>();

	public Student() {
		//Default constructor
	}
	
	public Student(String name, int age, String phoneNumber, String address) {
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	int registerCourse(Course c) {
		// If the student has registered up to 6 courses, he can't take anymore courses
		if (this.enrolledCourses.size() < 6) {
			this.enrolledCourses.add(c);
			this.grades.add(this.enrolledCourses.indexOf(c), ""); // Add an entry for the course in grades and set to an empty strng
			return 1;
		}
		return 0;

	}

	void setStatus() {
		// Set status to part time if courses enrolled is not zero and less than 2 else status is full time ( Couses not less than 3)
		if (!enrolledCourses.isEmpty()) {
			if (enrolledCourses.size() < 3) {
				this.status = "Part-Time";
			} else {
				this.status = "Full-Time";
			}
		}
	}

	void setProbationStatus() {
		int average;
		int sum = 0;
		for (int i = 0; i < this.grades.size(); i++) {
			sum += parseInt(this.grades.get(i));
		}
		average = sum / this.enrolledCourses.size(); // Sum of grades divided by number of courses
		if (average < 60) {
			this.onProbation = true;
		} else {
			this.onProbation = false;
		}
	}

	int setGrade(Course c, String grade) {
		if (grades.get(this.enrolledCourses.indexOf(c)).isEmpty()) {
			this.grades.set(this.enrolledCourses.indexOf(c), grade); // set the grade using the index of the course in student's enrolled courses
			return 1;
		} else {
			return 0;
		}

	}
}
