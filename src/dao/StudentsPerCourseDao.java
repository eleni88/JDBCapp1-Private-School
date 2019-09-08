package dao;

import JDBCapp1.JDBCapp1;
import entities.Course;
import entities.Students;
import entities.StudentsPerCourse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eleni
 */
public class StudentsPerCourseDao {

    private final String URL = "jdbc:mysql://localhost:3306/private_school_structure?serverTimezone=UTC";
    private final String USERNAME = "root";
    private final String PASS = "1234";
    private Connection conn;
    private final String getStudentsPerCourse = "SELECT * FROM StudentsPerCourse";
    private final String getStudentsPerCourse2 = "SELECT sFirstName, sLastName, ctitle as course, ctype as coursetype FROM StudentsPerCourse as sc inner join Students as s on sc.sid=s.sid inner join Course as c on sc.cid=c.cid";
    private final String insertStudentsPerCourse = "INSERT INTO StudentsPerCourse (sid,cid) VALUES (?,?)";

    private Connection getConnection() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASS);

        } catch (SQLException ex) {
            Logger.getLogger(StudentsPerCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    private void closeConnections(ResultSet rs, Statement st) {
        try {
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsPerCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<StudentsPerCourse> getStudentsPerCourse() {
        List<StudentsPerCourse> list = new ArrayList();

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(getStudentsPerCourse);
            while (rs.next()) {

                StudentsPerCourse sc = new StudentsPerCourse(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                list.add(sc);
            }
            closeConnections(rs, st);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCapp1.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public void getStudentsPerCourse2() {
        

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(getStudentsPerCourse2);
            while (rs.next()) {
                String sFirstName = rs.getString("sFirstName");
                String sLastName = rs.getString("sLastName");
                String ctitle = rs.getString("course");
                String ctype = rs.getString("coursetype");
                
                System.out.println("sFirstName"+" "+"sLastName"+" "+"ctitle"+" "+"ctype");
                System.out.println(sFirstName + " " + sLastName + " " + ctitle + " " + ctype);

            }
            closeConnections(rs, st);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCapp1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println();
    }

    public boolean insertStudentsPerCourse(Scanner input) {
        System.out.println("Enter Student's id:");
        int sid = input.nextInt();
        System.out.println("Enter course's id");
        int cid = input.nextInt();
        boolean inserted =false;
        try {
            PreparedStatement pst = getConnection().prepareStatement(insertStudentsPerCourse);
            
            pst.setInt(1, sid);
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
    
    


}
