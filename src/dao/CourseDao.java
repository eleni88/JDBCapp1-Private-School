package dao;

import JDBCapp1.JDBCapp1;
import entities.Course;
import entities.Students;
import java.sql.Connection;
import java.sql.Date;
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
public class CourseDao {

    private final String URL = "jdbc:mysql://localhost:3306/private_school_structure?serverTimezone=UTC";
    private final String USERNAME = "root";
    private final String PASS = "1234";
    private Connection conn;
    private final String getCourse = "SELECT * FROM course";
    private final String getCourseById = "SELECT * FROM course WHERE cid = ?";
    private final String insertCourse = "INSERT INTO Course (ctitle,ctype,cStartDate,cEndDate,strid) VALUES (?,?,?,?,?)";

    private Connection getConnection() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASS);

        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    private void closeConnections(ResultSet rs, Statement st) {
        try {
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Course> getCourse() {
        List<Course> list = new ArrayList();
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
           
            ResultSet rs = st.executeQuery(getCourse);
            while (rs.next()) {
                LocalDate d1 = getDateByString(rs.getString(4));
                LocalDate d2 = getDateByString(rs.getString(5));
                Course c = new Course(rs.getInt(1), rs.getString(2), rs.getString(3), d1, d2, rs.getInt(6));
                list.add(c);
            }
            closeConnections(rs, st);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCapp1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Course getCourseById(int cid) {
        Course c = null;
        try {
            PreparedStatement pst = getConnection().prepareStatement(getCourseById);
            pst.setInt(1, cid);
            ResultSet rs = pst.executeQuery();
            rs.next();
            LocalDate d1 = getDateByString(rs.getString(4));
            LocalDate d2 = getDateByString(rs.getString(5));

            c = new Course(rs.getInt("cid"), rs.getString(2), rs.getString(3), d1, d2, rs.getInt(6));
            closeConnections(rs, pst);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCapp1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;

    }

    private LocalDate getDateByString(String date) {
        if (date == null) {
            return null;
        }
        LocalDate hmnia = LocalDate.parse(date);
        return hmnia;
    }
    
    
     public boolean insertCourse(Scanner input) {
         System.out.println("Enter course title:");
         String ctitle = input.next();
         System.out.println("Enter course type:");
         String ctype = input.next();
         System.out.println("Enter course's start date:");
         String cStartDate = input.next();
         System.out.println("Enter course's end date:");     
         String cEndDate = input.next();
         System.out.println("Enter course's stream(enter '1' for full-time or '2' for part-time:)");
         int strid = input.nextInt();
        boolean inserted = false;
        try {
            PreparedStatement pst = getConnection().prepareStatement(insertCourse);
            pst.setString(1, ctitle);
            pst.setString(2, ctype);
            pst.setInt(5, strid);
            LocalDate date1 = LocalDate.parse(cStartDate);
            Date d2 = Date.valueOf(date1);
            LocalDate date2 = LocalDate.parse(cEndDate);
            Date d3 = Date.valueOf(date2);
            pst.setDate(3, d2);
            pst.setDate(4, d3);

            int result = pst.executeUpdate();

            if (result > 0) {
                inserted = true;
                System.out.println("Student inserted successfully");
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
