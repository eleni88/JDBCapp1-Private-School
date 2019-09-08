package JDBCapp1;

import dao.AssignmentDao;
import dao.CourseDao;
import dao.StudentsDao;
import dao.StudentsPerCourseDao;
import dao.TrainersDao;
import dao.TrainersPerCourseDao;
import entities.Assignment;
import entities.Course;
import entities.Students;
import entities.StudentsPerCourse;
import entities.Trainers;
import entities.TrainersPerCourse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Eleni
 */
public class JDBCapp1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AssignmentDao adao = new AssignmentDao();
        CourseDao cdao = new CourseDao();
        StudentsDao sdao = new StudentsDao();
        TrainersDao tdao = new TrainersDao();
        StudentsPerCourseDao scdao = new StudentsPerCourseDao();
        TrainersPerCourseDao tcdao = new TrainersPerCourseDao();

   
        //Print Students by id : 
        System.out.println("\n-->Printing Students by id...");
        Students st = sdao.getStudentById(3);
        System.out.println(st);
        
        //Print all the students per course :
        System.out.println("-->Printing list of Students Per Course...");
        scdao.getStudentsPerCourse2();
        
        //Print students per course (only the ids) :
        System.out.println("-->Printing list of Students Per Course...");
        List<StudentsPerCourse> list5 = scdao.getStudentsPerCourse();
        for (StudentsPerCourse sc : list5) {
            System.out.println(sc);
        }
        //Print trainers per course (only the ids) :
        System.out.println("-->Printing list of Students Per Course...");
        List<TrainersPerCourse> list6 = tcdao.getTrainersPerCourse();
        for (TrainersPerCourse tc : list6) {
            System.out.println(tc);
        }
        //Print a list of all trainers per course : 
        System.out.println("-->Printing list of Trainers Per Course...");
        tcdao.getTrainersPerCourse2();

        // INSERTS INPUT DATA TO THE FOLLOWING TABLES : 
        Scanner input = new Scanner(System.in);
        boolean valid = true;
        System.out.println("Welcome to our School's Platform!");
        System.out.println("Here's the basic menu.");
        System.out.println();
        System.out.println("For students' insertion enter 1.");
        System.out.println("For trainers' insertion press 2.");
        System.out.println("For assignments' insertion press 3.");
        System.out.println("For courses' insertion press 4");
        System.out.println("If you want to input trainers per course, press 5.");
        System.out.println("If you want to input students per course press 6");
        System.out.println("If you want to print a list of Students press 's'");
        System.out.println("If you want to print a list of Assignments press 'a'");
        System.out.println("If you want to print a list of Trainers press 't'");
        System.out.println("If you want to print a list of Courses press 'c'");
        
            String answer2;
        
        while (valid){
        answer2 = input.next();
        
        switch (answer2){
            
        case "s": 
            //Print list of all Students : 
            System.out.println("-->Printing list of Students...");
        List<Students> list4 = sdao.getStudents();
        for (Students s : list4) {
            System.out.println(s);
        }
        
        break;
        
        case "a": 
            //Print list of all Assignments:
         System.out.println("-->Printing list of assignments...");
        List<Assignment> list = adao.getAssignments();
        for (Assignment a : list) {
            System.out.println(a);
        }
        
        break;
        
        case "t":
            //Print list of all trainers :
            System.out.println("-->Printing list of trainers...");
        List<Trainers> list2 = tdao.getTrainers();
        for (Trainers t : list2) {
            System.out.println(t);
        }
        break;
        
        case "c":
            //Print list of all courses :
        System.out.println("-->Printing list of courses...");
        List<Course> list3 = cdao.getCourse();
        for (Course c : list3) {
            System.out.println(c);
        }
        
        break;    
            
        }
        
        }

        int answer;
        while (valid) {
            answer = input.nextInt();

            switch (answer) {
                case 1:

                    //insert new student :
                    System.out.println("Enter new Student:");

                    boolean saved = sdao.insertStudents(input);
                    if (saved == false) {
                        System.out.println("Try again...");
                    }
                    break;
                case 2:
                    // insert new trainer :

                    System.out.println("Enter new Trainer:");
                    boolean saved3 = tdao.insertTrainers(input);
                    if (saved3 == false) {
                        System.out.println("Try again...");
                    }
                    break;
                case 3:
                    //insert students per course :
                    System.out.println("Enter student's and course's ids:");
                    boolean saved6 = scdao.insertStudentsPerCourse(input);
                    if (saved6 == false) {
                        System.out.println("Try again...");
                    }
                    break;
                case 4:
                    //insert new course :
                    System.out.println("Enter new course:");
                    boolean saved2 = cdao.insertCourse(input);
                    if (saved2 == false) {
                        System.out.println("Try again...");
                    }
                    break;
                case 5:
                    //insert trainers per course :
                    System.out.println("Enter trainer's and course's ids");
                    boolean saved5 = tcdao.insertTrainersPerCourse(input);
                    if (saved5 == false) {
                        System.out.println("Try again...");
                    }
                    break;

                case 6:
                    //insert assignment :
                    System.out.println("Enter new assignment:");
                    boolean saved4 = adao.insertAssignment(input);
                    if (saved4 == false) {
                        System.out.println("Try again...");
                    }
                    break;

                default:
                    System.out.println("Please try again.");
            }
        }
        
       
        
    

    }
}
