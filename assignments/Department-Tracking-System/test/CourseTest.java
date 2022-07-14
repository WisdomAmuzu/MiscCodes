import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourseTest {
	@BeforeClass
	public static void methodBeforeTests() {
		System.out.println("\t   Test of Course Class \n");
	}

	@Test
	public void testAssignInstructor() {
		System.out.println("Test for assignInstrcutor method for course \n assign one lecturer to the course and expect the number of assigned course to become 1 \n ");
		Course instance = new Course();
		Instructor insInstance = new Instructor();
		int expectedResult = 1;
		instance.assignInstructor(insInstance);
		int actualResult = instance.instructors.size();
		assertEquals(expectedResult, actualResult);
		System.out.println("End of Test\n");
	}

	@Test
	public void testRegisterStudent() {
		System.out.println("Test for registerStudent method for course \n register a student and expect the number of enrolled students to change \n ");
		Course instance = new Course("code", "title", 5, 20);
		Student stuInstance = new Student();
		instance.registerStudent(stuInstance);
		int expectedResult = 1;
		int actualResult = instance.registeredStudents.size();
		assertEquals(expectedResult, actualResult);
		System.out.println("End of Test\n");
	}

	@Test
	public void testSetStatus() {
		System.out.println("Test for setStatus methof of course class \n Registered students is less than the max so the course must be cancelled \n ");
		String[] names = { "Name", "Name", "Name" };
		int[] ages = { 20, 20, 20 };
		String[] nos = { "0000000000", "0000000000", "0000000000" };
		String[] addrs = { "Addr", "Addr", "Addr" };
		Student[] students;
		students = new Student[3];
		Course instance = new Course("INF 311", "Programming", 5, 20);
		for (int i = 0; i < 3; i++) {
			students[i] = new Student(names[i], ages[i], nos[i], addrs[i]);
			instance.registerStudent(students[i]);
		}
		String expectedResult = "Cancelled";
		instance.setStatus();
		String actualResult = instance.status;
		assertEquals(expectedResult, actualResult);
		System.out.println("End of Test\n");
	}

	@Test
	public void testMaxStuForCourse() {
		System.out.println("Test for the maximum number of students that can take a particular course, in this case, 20 \n An additional student can't be registered after the max is reached \n");
		Student[] students;
		students = new Student[20];
		Course instance = new Course("INF 311", "Programming", 5, 20);
		for (int i = 0; i < 20; i++) {
			students[i] = new Student("Name", 20, "000000000", "0000");
			instance.registerStudent(students[i]);
		}
		Student newStudent = new Student("Name", 25, "0000000000", "0000");
		int expectedResult = 0;
		int actualResult = instance.registerStudent(newStudent);
		assertEquals(expectedResult, actualResult);
		System.out.println("End of Test\n");
	}
}
