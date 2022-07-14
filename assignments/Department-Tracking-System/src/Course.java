import java.util.ArrayList;

public class Course {
	String code;
	String title;
	String status;
	int min;
	int max;
	ArrayList<Instructor> instructors = new ArrayList<>();
	ArrayList<Student> registeredStudents = new ArrayList<>();

	public Course() {
		//Default constructor
	}
	
	public Course(String code, String title, int min, int max) {
		this.code = code;
		this.title = title;
		this.min = min;
		this.max = max;
	}

	void assignInstructor(Instructor i) {
		instructors.add(i);
	}

	int registerStudent(Student s) { 
		// If this maximum number of students is not reached, regiter the student
		if(registeredStudents.size() == this.max) {
			return 0;
		}
		registeredStudents.add(s);
		return 1;
	}

	void setStatus() {
		// Courses is cancelled if the min number of students to take the course is not reached for the semester
		if(registeredStudents.size() < this.min) { 
			this.status = "Cancelled";
		}
		else {
			this.status = "Not-Cancelled";
		}
	}
}
