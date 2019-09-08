package dao;

import JDBCapp1.JDBCapp1;
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
public class StudentsDao {

    private final String URL = "jdbc:mysql://localhost:3306/private_school_structure?serverTimezone=UTC";
    private final String USERNAME = "root";
    private final String PASS = "1234";
    private Connection conn;
    private final String getStudents = "SELECT * FROM students";
    private final String getStudentById = "SELECT * FROM students WHERE sid = ?";
    private final String insertStudents = "INSERT INTO Students(sFirstName,sLastName,sDateOfBirth,sTuitionfees) VALUES (?,?,?,?)";

    private Connection getConnection() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASS);

        } catch (SQLException ex) {
            Logger.getLogger(StudentsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    private void closeConnections(ResultSet rs, Statement st) {
        try {
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Students> getStudents() {
        List<Students> list = new ArrayList();
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            //Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(getStudents);
            while (rs.next()) {
                LocalDate d = getDateByString(rs.getString(4));
                Students s = new Students(rs.getInt(1), rs.getString(2), rs.getString(3), d, rs.getInt(5));
                list.add(s);
            }
            closeConnections(rs, st);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCapp1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Students getStudentById(int sid) {
        Students s = null;
        try {
            PreparedStatement pst = getConnection().prepareStatement(getStudentById);
            pst.setInt(1, sid);
            ResultSet rs = pst.executeQuery();
            rs.next();
            LocalDate d = getDateByString(rs.getString(4));
            s = new Students(rs.getInt(1), rs.getString(2), rs.getString(3), d, rs.getInt(5));
            closeConnections(rs, pst);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCapp1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    private LocalDate getDateByString(String date) {
        if (date == null) {
            return null;
        }
        LocalDate hmnia = LocalDate.parse(date);
        return hmnia;
    }

    public boolean insertStudents(Scanner input) {
     
      System.out.println("Enter Student's firstname:");
        String Sfirstname = input.next();
        System.out.println("Enter Student's lastname:");
        String Slastname = input.nextLine();
        System.out.println("Enter Student's tuition fees:");
        int Stuitionfees = input.nextInt();
        System.out.println("Enter Student's Date of Birth:");
        String d1 = input.next();
        boolean inserted = false;
        try {
            PreparedStatement pst = getConnection().prepareStatement(insertStudents);
            pst.setString(1, Sfirstname);
            pst.setString(2, Slastname);
            pst.setInt(4, Stuitionfees);
            //DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
            //String d = s.getSdateofbirth().format(dateFormatter);
            LocalDate date1 = LocalDate.parse(d1);
            Date d2 = Date.valueOf(date1);
            pst.setDate(3, d2);
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
