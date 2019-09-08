package dao;

import JDBCapp1.JDBCapp1;
import entities.Course;
import entities.StudentsPerCourse;
import entities.Trainers;
import entities.TrainersPerCourse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eleni
 */
public class TrainersPerCourseDao {

    private final String URL = "jdbc:mysql://localhost:3306/private_school_structure?serverTimezone=UTC";
    private final String USERNAME = "root";
    private final String PASS = "1234";
    private Connection conn;
    private final String getTrainersPerCourse = "SELECT * FROM TrainersPerCourse";
    private final String getTrainersPerCourse2 = "select tFirstName,tLastName, ctitle as course, ctype as coursetype \n"
            + "from trainerspercourse as tc inner join trainers as t on tc.tid=t.tid \n"
            + "inner join course as c on tc.cid=c.cid ";
    private final String insertTrainersPerCourse = "INSERT INTO TrainersPerCourse (cid,tid) VALUES (?,?)";
    

    private Connection getConnection() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASS);

        } catch (SQLException ex) {
            Logger.getLogger(TrainersPerCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;

    }

    private void closeConnections(ResultSet rs, Statement st) {
        try {
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrainersPerCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<TrainersPerCourse> getTrainersPerCourse() {
        List<TrainersPerCourse> list = new ArrayList();

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(getTrainersPerCourse);
            while (rs.next()) {

                TrainersPerCourse tc = new TrainersPerCourse(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                list.add(tc);
            }
            closeConnections(rs, st);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCapp1.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public void getTrainersPerCourse2() {
        List<Trainers> list = new ArrayList();
        try {
            PreparedStatement pst = getConnection().prepareStatement(getTrainersPerCourse2);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
//                Trainers t = new Trainers();
//                TrainersPerCourse tc = new TrainersPerCourse();
//                
//                t.setTfirstname(rs.getString("tFirstName"));
//                t.setTlastname(rs.getString("tLastName"));
//                
//               list.add(t);

                String ctitle = rs.getString("course");
                String ctype = rs.getString("coursetype");
                String tFirstName = rs.getString("tFirstName");
                String tLastName = rs.getString("tLastName");
//              
                System.out.println(ctitle + " " + ctype + " " + tFirstName + " " + tLastName);
//                

            }
            closeConnections(rs, pst);
        } catch (SQLException ex) {
            Logger.getLogger(TrainersPerCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        //return list;
    }

    
    public boolean insertTrainersPerCourse(Scanner input) {
        System.out.println("Enter trainer's id:");
        int tid = input.nextInt();
        System.out.println("Enter course's id");
        int cid = input.nextInt();
        boolean inserted =false;
        try {
            PreparedStatement pst = getConnection().prepareStatement(insertTrainersPerCourse);
            //pst.setInt(1, tc.getTcid());
            pst.setInt(1, tid);
            pst.setInt(2, cid);
            int result = pst.executeUpdate();
            if (result > 0) {
                inserted = true;
                System.out.println("TrainersPerCourse inserted successfully");
            } 
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            inserted = false;
            System.out.println(ex.getLocalizedMessage());
            //Logger.getLogger(JDBCApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inserted;
    }
    
    
    
    
    
//    public boolean insertTrainersPerCourse(Trainers t, Course c) {
//        boolean inserted =false;
//        try {
//            PreparedStatement pst = getConnection().prepareStatement(insertTrainersPerCourse);
//            //pst.setInt(1, t.getTid());
//            pst.setString(1, t.getTfirstname());
//            pst.setString(2, t.getTlastname());
//            pst.setString(3, c.getCtitle());
//            pst.setString(4, c.getCtype());
//            
//            DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
//            String d1 = c.getCstartdate().format(dateFormatter);
//            String d2 = c.getCenddate().format(dateFormatter);
//           
//            
//            pst.setString(5, d1);
//            pst.setString(6, d2);
//            
//            pst.setInt(7, c.getStrid());
//            
//            
//            int result = pst.executeUpdate();
//            if (result > 0) {
//                inserted = true;
//                System.out.println("Trainer and course inserted successfully");
//            } 
//            pst.close();
//            conn.close();
//        } catch (SQLException ex) {
//            inserted = false;
//            System.out.println(ex.getLocalizedMessage());
//            //Logger.getLogger(JDBCApp.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return inserted;
//    }
//    
    
}
