import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;

public class InstructorTest {
	@BeforeClass
	public static void beforeTests() {
		System.out.println("\t   Test of Instructor Class\n");
	}

	@Test
	public void testAssignCourse() {
		System.out.println("\t Assign Course Test");
		Course cInstance = new Course("INF 311", "Programming", 5, 20);
		Instructor instance = new Instructor("Name", 35, "Num", "Addr", "Full-Time");
		int expectedResult = 1;
		instance.assignCourse(cInstance);
		int actualResult = instance.assignedCourses.size();
		assertEquals(expectedResult, actualResult);
		System.out.println("  End of Test\n");
	}

	@Test
	public void testSalaryForProfWBonus() {
		System.out.println("Test for Full Time Lecturer's salary with bonus");
		System.out.println("No. of assigned Courses: " + 4 + " Expected Salary: " + 5500);
		String[] code = { "INF 311", "INF 401", "INF 112", "INF 214"};
		String[] title = { "Intro to Computing", "Web Technology", "Management", "Data Structures" };
		int min = 5;
		int max = 20;
		Course[] courses;
		courses = new Course[4];
		Instructor instance = new Instructor("Name", 35, "Num", "Addr", "Professor");
		for (int i = 0; i < title.length; i++) {
			courses[i] = new Course(code[i], title[i], min, max);
			instance.assignCourse(courses[i]);
		}
		instance.setBonus();
		instance.calculateSalary();
		int expectedResult = 5500;
		int actualResult = instance.salary;
		assertEquals(expectedResult, actualResult);
		System.out.println("End of Test\n");
	}

	@Test
	public void testSalaryForProfWOBonus() {
		System.out.println("Test for Professors Salary without bonus");
		System.out.println("No. of assigned Courses: " + 2 + " Expected Salary: " + 2500);
		String[] code = { "INF 311", "INF 401" };
		String[] title = { "Mathematics 2", "Software Engineering 2" };
		int min = 5;
		int max = 20;
		Course[] courses;
		courses = new Course[2];
		Instructor instance = new Instructor("Name", 35, "Num", "Addr", "Professor");
		for (int i = 0; i < title.length; i++) {
			// Create multiple objects of the course class
			courses[i] = new Course(code[i], title[i], min, max);
			instance.assignCourse(courses[i]);
		}
		instance.setBonus();
		instance.calculateSalary();
		int expectedResult = 2500;
		int actualResult = instance.salary;
		assertEquals(expectedResult, actualResult);
		System.out.println("End of Test\n");
	}

	@Test
	public void testFTLSalaryWithBonus() {
		System.out.println("Test for Full Time Lecturer's salary with bonus");
		System.out.println("No. of assigned Courses: " + 6 + " Expected Salary: " + 7500);
		String[] code = { "INF 311", "INF 401", "INF 112", "INF 214", "INF 110", "INF 404" };
		String[] title = { "Mathematics 2", "Software Engineering 2", "Intro to Computing", "Web Technology",
				"Management", "Data Structures" };
		int min = 5;
		int max = 20;
		Course[] courses;
		courses = new Course[6];
		Instructor instance = new Instructor("Name", 35, "Num", "Addr", "Full-Time");
		for (int i = 0; i < title.length; i++) {
			courses[i] = new Course(code[i], title[i], min, max);
			instance.assignCourse(courses[i]);
		}
		instance.setBonus();
		instance.calculateSalary();
		int expectedResult = 7500;
		int actualResult = instance.salary;
		assertEquals(expectedResult, actualResult);
		System.out.println("End of Test\n");
	}

	@Test
	public void testFTLSalaryWOBonus() {
		System.out.println("Test for Full Time Lecturer's salary with bonus");
		System.out.println("No. of assigned Courses: " + 4 + " Expected Salary: " + 2500);
		String[] code = { "INF 311", "INF 401", "INF 112", "INF 214"};
		String[] title = { "Intro to Computing", "Web Technology", "Management", "Data Structures" };
		int min = 5;
		int max = 20;
		Course[] courses;
		courses = new Course[6];
		Instructor instance = new Instructor("Name", 35, "Num", "Addr", "Full-Time");
		for (int i = 0; i < title.length; i++) {
			courses[i] = new Course(code[i], title[i], min, max);
			instance.assignCourse(courses[i]);
		}
		instance.setBonus();
		instance.calculateSalary();
		int expectedResult = 2500;
		int actualResult = instance.salary;
		assertEquals(expectedResult, actualResult);
		System.out.println("End of Test\n");
	}

	@Test
	public void testPTLSalary() {
		System.out.println("Test for Part Time Lecturer's salary \n");
		System.out.println("No. of assigned Courses: " + 1 + " Expected Salary: " + 2500);
		Instructor instance = new Instructor("Name", 35, "Num", "Addr", "Part-Time");
		Course cInstance = new Course("INF 311", "Programming", 5, 20);
		instance.assignCourse(cInstance);
		instance.setBonus();
		instance.calculateSalary();
		int expectedResult = 2500;
		int actualResult = instance.salary;
		assertEquals(expectedResult, actualResult);
		System.out.println("End of Test\n");
	}
}
