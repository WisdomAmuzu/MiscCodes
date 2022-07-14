public class AppBootstrap {

    public static void main(String[] args) {
        Application app = new Application();
        app.createCourses();
        app.createInstructors();
        app.createStudents();

        app.regFTStudentsAndCourses();
        app.regPTStudentsAndCourses();
        app.assignInstructors();

        app.setStudentGrades();
        app.setStudentStatus();
        app.setCourseStatus();
        app.setBonusAndSalaries();
        
        app.listCoursesWithStudentsCount();
        app.listCoursesWithInstructors();
        app.listInstructorsWithTypes();
        app.listStudentsWithStatus();
        app.listCancelledCourses();
        app.listInstructorsAndSalaries();
        app.listCAGOfStudents();
        app.listStudOnProbation();

    }
}
