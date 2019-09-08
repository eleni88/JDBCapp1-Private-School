package dao;

import JDBCapp1.JDBCapp1;
import entities.Assignment;
import entities.Students;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
public class AssignmentDao {

    private final String URL = "jdbc:mysql://localhost:3306/private_school_structure?serverTimezone=UTC";
    private final String USERNAME = "root";
    private final String PASS = "1234";
    private Connection conn;
    private final String getAssignments = "SELECT * FROM Assignment";
    private final String getAssignmentById = "SELECT * FROM Assignment WHERE aid = ?";
    private final String insertAssignment = "INSERT INTO Assignment(atitle,adescription,aOralMark,aTotalMark,aSubDateTime) VALUES (?,?,?,?,?)";

    private Connection getConnection() {

        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    private void closeConnections(ResultSet rs, Statement st) {
        try {
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Assignment> getAssignments() {
        List<Assignment> list = new ArrayList();

        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(getAssignments);
            while (rs.next()) {

                LocalDateTime d = rs.getObject(6, LocalDateTime.class);

                Assignment a = new Assignment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), d);
                list.add(a);
            }
            closeConnections(rs, st);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCapp1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Assignment getAssignmentById(int aid) {
        Assignment a = null;
        try {
            PreparedStatement pst = getConnection().prepareStatement(getAssignmentById);
            pst.setInt(1, aid);
            ResultSet rs = pst.executeQuery();
            rs.next();

            LocalDateTime d2 = rs.getObject(6, LocalDateTime.class);

            a = new Assignment(rs.getInt(aid), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), d2);
            closeConnections(rs, pst);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCapp1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    
    
    public boolean insertAssignment(Scanner input) {
        System.out.println("Enter assignment's title:");
        String atitle = input.next();
        System.out.println("Enter assignment's description:");
        String atdescription = input.nextLine();
        System.out.println("Enter oral mark:");
        double aOralMark = input.nextDouble();
        System.out.println("Enter total mark:");
        double aTotalMark = input.nextDouble();
        System.out.println("Enter Submition date:");
        String aSubDateTime = input.next();
        
        
        
          
        boolean inserted = false;
        try {
            PreparedStatement pst = getConnection().prepareStatement(insertAssignment);
            pst.setString(1, atitle);
            pst.setString(2, atdescription);
           pst.setDouble(3, aOralMark);
          pst.setDouble(4, aTotalMark);
          
         
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

          LocalDateTime formatDateTime = LocalDateTime.parse(aSubDateTime, formatter);
          LocalDateTime.of(LocalDate.MAX, LocalTime.MAX);
          
    LocalDateTime d = formatDateTime;
    
     //String formatDateTime2 = d.format(formatter);
        
      //LocalDateTime d2 = LocalDateTime.parse(formatDateTime2);
          //LocalDateTime.of(LocalDate.of(2020, Month.MAY, 12), LocalTime.of(23, 59, 59))
          
        ZonedDateTime instant = d.atZone(ZoneId.systemDefault());
            java.util.Date output = Date.from(instant.toInstant());
      pst.setDate(6, (Date) output);

            int result = pst.executeUpdate();

            if (result > 0) {
                inserted = true;
                System.out.println("Assignment inserted successfully");
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
