
package dao;

import JDBCapp1.JDBCapp1;
import entities.Course;
import entities.Trainers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class TrainersDao {
    
    private final String URL = "jdbc:mysql://localhost:3306/private_school_structure?serverTimezone=UTC";
    private final String USERNAME = "root";
    private final String PASS = "1234";
    private Connection conn;
    private final String getTrainers = "SELECT * FROM Trainers";
    private final String getTrainerById = "SELECT * FROM Trainers WHERE tid = ?";
     private final String insertTrainers = "INSERT INTO Trainers (tFirstName,tLastName) VALUES (?,?)";
    
    private Connection getConnection(){
    
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASS);
           
        } catch (SQLException ex) {
            Logger.getLogger(TrainersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
     return conn;
    }
    
    private void closeConnections(ResultSet rs, Statement st) {
        try {
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrainersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public List<Trainers> getTrainers() {
        List<Trainers>list = new ArrayList();
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            //Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(getTrainers);
            while (rs.next()) {
                
                Trainers t = new Trainers(rs.getInt(1), rs.getString(2),rs.getString(3));
             list.add(t);
            }
            closeConnections(rs, st);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCapp1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
     public Trainers getTrainerById(int tid) {
        Trainers t = null;
        try {
            PreparedStatement pst = getConnection().prepareStatement(getTrainerById);
            pst.setInt(1, tid);
            ResultSet rs = pst.executeQuery();
            rs.next();
            
            t = new Trainers(rs.getInt("tid"),rs.getString(2),rs.getString(3));
            closeConnections(rs, pst);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCapp1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
     
     
     public boolean insertTrainers(Scanner input) {
         System.out.println("Enter Trainer's firstname:");
        String tfirstname = input.next();
        System.out.println("Enter Trainer's lastname:");
        String tlastname = input.next();
        boolean inserted = false;
        try {
            PreparedStatement pst = getConnection().prepareStatement(insertTrainers);
          
            pst.setString(1, tfirstname);
            pst.setString(2, tlastname);
         

            int result = pst.executeUpdate();

            if (result > 0) {
                inserted = true;
                System.out.println("Trainer inserted successfully");
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
