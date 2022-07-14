import org.junit.BeforeClass;
import org.junit.Test;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertEquals;


public class StudentTest {
	@BeforeClass
	public static void methodBeforeTests() {
		System.out.println("\t   Test of Student Class \n");
	}

	@Test
	public void testRegisterCourse() {
		System.out.println("   Test Course Registration \n Register a course and expect the list of registered courses to become 1");
		Course course = new Course("INF 101", "Intro to Computing", 4, 20);
		Student instance = new Student("Name", 20, "Num", "Addr");
		int expectedResult = 1;
		instance.registerCourse(course);
		int actualResult = instance.enrolledCourses.size();
		assertEquals(expectedResult, actualResult);
		System.out.println("End of Test\n");
		
	}

	@Test
	public void testSetGrade() {
		System.out.println("   Test Set Grade method \n  Set a grade of 80% for course Intro to Computing\n ");
		Course course = new Course("INF 101", "Intro to Computing", 4, 20);
		Student instance = new Student("Name", 20, "Num", "Addr");
		int expectedResult = 80;
		instance.registerCourse(course);
		instance.setGrade(course, "80");
		int actualResult = parseInt(instance.grades.get(instance.enrolledCourses.indexOf(course)));
		assertEquals(expectedResult, actualResult);
		System.out.println("End of Test\n");
	}

	@Test
	public void testSetProbationStatus() {
		System.out.println("   Test Set Probation Method \n Grades for the two courses are 90 and 20, student is supposed to be on probation \n");
		String[] code = { "INF 311", "INF 401" };
		String[] title = { "Mathematics 2", "Software Engineering 2" };
		int min = 5;
		int max = 20;
		Course[] courses;
		courses = new Course[2];
		String[] grades = { "90", "20" };
		Student instance = new Student("Name", 20, "Num", "Addr");
		for (int i = 0; i < title.length; i++) {
			// Create multiple objects of the course class
			courses[i] = new Course(code[i], title[i], min, max);
			instance.registerCourse(courses[i]);
			instance.setGrade(courses[i], grades[i]);
		}
		boolean expectedResult = true;
		instance.setProbationStatus();
		boolean actualResult = instance.onProbation;
		assertEquals(expectedResult, actualResult);
		System.out.println("End of Test\n");
	}

	@Test
	public void testSetStatusPT() {
		System.out.println("   Test the Status of a PartTime student \n Student has registered for only two courses, status must be PartTime \n ");
		String[] code = { "INF 311", "INF 401" };
		String[] title = { "Mathematics 2", "Software Engineering 2" };
		int min = 5;
		int max = 20;
		Course[] courses;
		courses = new Course[2];
		Student instance = new Student("Name", 20, "Num", "Addr");
		for (int i = 0; i < title.length; i++) {
			courses[i] = new Course(code[i], title[i], min, max);
			instance.registerCourse(courses[i]);
		}
		String expectedResult = "Part-Time";
		instance.setStatus();
		String actualResult = instance.status;
		assertEquals(expectedResult, actualResult);
		System.out.println("End of Test\n");
	}

	@Test
	public void testSetStatusFT() {
		System.out.println("   Test the Status of a FullTime student \n Student has registered for 6 courses, status must be FullTime \n ");
		String[] code = { "INF 311", "INF 401", "INF 112", "INF 214", "INF 110", "INF 404" };
		String[] title = { "Mathematics 2", "Software Engineering 2", "Intro to Computing", "Web Technology",
				"Management", "Data Structures" };
		int min = 5;
		int max = 20;
		Course[] courses;
		courses = new Course[6];
		Student instance = new Student("Name", 20, "Num", "Addr");
		for (int i = 0; i < title.length; i++) {
			courses[i] = new Course(code[i], title[i], min, max);
			instance.registerCourse(courses[i]);
		}
		String expectedResult = "Full-Time";
		instance.setStatus();
		String actualResult = instance.status;
		assertEquals(expectedResult, actualResult);
		System.out.println("End of Test\n");
	}

	@Test
	public void testFTStudentCourseLimit() {
		System.out.println("   Test the maximum number of courses of a student \n A full time student can register for a maximum of 6 courses \n ");
		Course[] courses;
		courses = new Course[6];
		Student instance = new Student("Name", 20, "Num", "Addr");
		for (int i = 0; i < courses.length; i++) {
			courses[i] = new Course("INF 101", "Intro to Computing", 5, 20);
			instance.registerCourse(courses[i]);
		}
		Course newCourse = new Course("INF 101", "Intro to Computing", 4, 20);
		int expectedResult = 0;
		int actualResult = instance.registerCourse(newCourse);
		assertEquals(expectedResult, actualResult);
		System.out.println("End of Test\n");
	}
}
