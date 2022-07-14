public class Application {
	Course[] courses;
	Student[] students;
	Instructor[] instructors;

	public void createCourses() {
		this.courses = new Course[6];
		String[] codes = { "INF 311", "INF 315", "INF 309", "INF 305", "INF 307", "INF 313" };
		String[] titles = { "Data Structures", "Discrete Maths", "Info Sys", "Networking", "ObjectOP...",
				"Web Tech" };

		for (int i = 0; i < 6; i++) {
			this.courses[i] = new Course(codes[i], titles[i], 5, 20);
		}
	}

	public void createInstructors() {
		this.instructors = new Instructor[5];
		String[] names = { "Samuel Sarpong", "Paul Obeng", "Frederick Akoto", "Joshua Ackah", "Betty Oppong" };
		int[] ages = { 34, 37, 40, 28, 50 };
		String[] nos = { "0000000000", "0000000000", "0000000000", "0000000000", "0000000000" };
		String[] addrs = { "P.O.Box 161", "P.O.Box 161", "P.O.Box 161", "P.O.Box 161", "P.O.Box 161" };
		String[] types = { "Full-Time", "Full-Time", "Part-Time", "Professor", "Part-Time" };

		for (int i = 0; i < 5; i++) {
			this.instructors[i] = new Instructor(names[i], ages[i], nos[i], addrs[i], types[i]);
		}
	}

	public void createStudents() {
		this.students = new Student[20];
		String[] names = { "Anna Fiakeye", "Godwin Alorbu", "Andrews Agbesi", "Kingsford Ku...", "Wisdom Amuzu",
				"Adelaide Ama", "Ivy Sosu", "Ruben Odoi", "Stanley Ofori", "Samuel Gyasi", "Frederick D...",
				"Inusaah Ali", "Kojo Mensah", "Felicia Annan", "Nora Opoku", "Shine Sosu", "Elijah Edekor",
				"Emmanuel Tetteh", "Yaw Adjei", "Julius Agbyai" };
		int[] ages = { 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 23, 23, 23, 23, 23 };
		String[] nos = { "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000",
				"0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000",
				"0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000", "0000000000" };
		String[] addrs = { "P.O.Box 161", "P.O.Box 161", "P.O.Box 161", "P.O.Box 161", "P.O.Box 161", "P.O.Box 161",
				"P.O.Box 161", "P.O.Box 161", "P.O.Box 161", "P.O.Box 161", "P.O.Box 161", "P.O.Box 161", "P.O.Box 161",
				"P.O.Box 161", "P.O.Box 161", "P.O.Box 161", "P.O.Box 161", "P.O.Box 161", "P.O.Box 161",
				"P.O.Box 161" };

		for (int i = 0; i < 20; i++) {
			this.students[i] = new Student(names[i], ages[i], nos[i], addrs[i]);
		}
	}

	public void regFTStudentsAndCourses() {
		for (int i = 0; i < 4; i++) {
			Course currCourse = this.courses[i];
			for (int j = 0; j < 15; j++) {
				Student currStud = this.students[j];
				currCourse.registerStudent(currStud);
				this.students[j].registerCourse(currCourse);
			}
		}
	}

	public void regPTStudentsAndCourses() {
		for (int i = 4; i < 6; i++) {
			Course currCourse = this.courses[i];
			for (int j = 15; j < 20; j++) {
				Student currStud = this.students[j];
				currCourse.registerStudent(currStud);
				this.students[j].registerCourse(currCourse);
			}
		}
	}

	public void setStudentGrades() {
		String[] grades = { "80", "50", "40", "100", "55", "95", "40", "40", "40",
				"40", "40", "40", "40", "40", "40", "40", "40", "40", "40", "40", "40", "40",
				"40", "40", "40", "40", "40" };
		for (Course currCourse : this.courses) {
			for (int j = 0; j < currCourse.registeredStudents.size(); j++) {
				Student currStudent = currCourse.registeredStudents.get(j);
				currStudent.setGrade(currCourse, grades[j]);
			}
		}
	}

	public void assignInstructors() {
		for (Course currCourse : this.courses) {
			for (Instructor instructor : this.instructors) {
				currCourse.assignInstructor(instructor);
				instructor.assignCourse(currCourse);
			}
		}
	}

	public void setBonusAndSalaries() {
		for (Instructor instructor : this.instructors) {
			instructor.setBonus();
			instructor.calculateSalary();
		}
	}

	public void setStudentStatus() {
		for (Student student : this.students) {
			student.setStatus();
		}
	}

	public void setCourseStatus() {
		for (Course cours : this.courses) {
			cours.setStatus();
		}
	}

	// Functional Req 1
	public void listCoursesWithStudentsCount() {
		System.out.println("\t1.\t\t   Courses and the Number of students enrolled".toUpperCase());
		for (Course currCourse : this.courses) {
			System.out.println("\t" + currCourse.title + ":" + currCourse.code + "\t\t\t\tNo. of Students: "
					+ currCourse.registeredStudents.size());
		}
	}

	// Functional Req 2
	public void listCoursesWithInstructors() {
		System.out.println("\t2.\t\t    Courses and their Instructors".toUpperCase());
		for (Course currCourse : this.courses) {
			System.out.println("\t Course Code: " + currCourse.code + "\t\t Course Title: " + currCourse.title);
			for (int j = 0; j < currCourse.instructors.size(); j++) {
				Instructor cInstructor = currCourse.instructors.get(j);
				System.out.println("\t\t\t\t" + cInstructor.name);
			}
		}
	}

	// Functional Req 3
	public void listInstructorsWithTypes() {
		System.out.println("\t3.\t\t   Instructors and their types".toUpperCase());
		for (Instructor cInstructor : this.instructors) {
			System.out.println("\t\t" + cInstructor.name + "\t\t\t\t" + cInstructor.type);
		}
	}

	// Functional Req 4
	public void listStudentsWithStatus() {
		System.out.println("\t4.\t\t   Students and their status".toUpperCase());
		for (Student currStudent : this.students) {
			System.out.println("\t\t" + currStudent.name + "\t\t\t" + currStudent.status);
		}
	}

	// Functional Req 5
	public void listCancelledCourses() {
		System.out.println("\t5.   Cancelled Courses".toUpperCase());
		int count = 0;
		for (Course currCourse : this.courses) {
			if (currCourse.status.equals("Cancelled")) {
				System.out.println("\t" + currCourse.title + ":" + currCourse.code);
				continue;
			}
			count += 1;
		}
		if (count == this.courses.length) {
			System.out.println("  No courses cancelled for the semester \n");
		}

	}

	// Functional Req 6
	public void listInstructorsAndSalaries() {
		System.out.println("\t6.\t\t   Instructors and their Salaries".toUpperCase());
		System.out.println(" Base Salary \t Bonus \t\t Total Salary");
		for (Instructor cInstructor : this.instructors) {
			System.out.println(" " + cInstructor.basePay + "\t\t " + cInstructor.bonus + " \t\t " + cInstructor.salary);
		}
	}

	// Functional Req 7
	public void listCAGOfStudents() {
		System.out.println("\t7.\t\t    Courses and enrolled students grades".toUpperCase());
		for (Course currCourse : this.courses) {
			System.out.println(" Course Code: " + currCourse.code + " Course Title: " + currCourse.title);
			for (int j = 0; j < currCourse.registeredStudents.size(); j++) {
				Student currStud = currCourse.registeredStudents.get(j);
				String grade = currStud.grades.get(currStud.enrolledCourses.indexOf(currCourse));
				System.out.println("\t" + currStud.name + " : " + grade);
			}
		}
	}

	// Functional Req 8
	public void listStudOnProbation() {
		System.out.println("\t8.   Students on Academic Probation".toUpperCase());
		int count = 0;
		for (Student currStudent : this.students) {
			if (currStudent.onProbation) {
				System.out.println("\t " + currStudent.name);
				continue;
			}
			count += 1;
		}
		if (count == this.students.length) {
			System.out.println("  No Students on Probation");
		}
	}
}
