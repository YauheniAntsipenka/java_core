package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionTask {
    public static void start(){
        Connection conn = null;
        PreparedStatement prep1 = null;
        PreparedStatement prep2 = null;
        PreparedStatement prep3 = null;

        try{
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "test", "test");
            prep1 = conn.prepareStatement("SELECT * FROM Sellers WHERE sex = ?");
            prep1.setString(1, "male");
            ResultSet rs = prep1.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getString(2) +
                    " " + rs.getString(3) + " " + rs.getString(4));
            }


            conn.setAutoCommit(false); //BEGIN TRANSACTION

            prep2 = conn.prepareStatement("UPDATE sellers SET sex = 'male' WHERE id = ?" );
            prep2.setInt(1, 3);

            prep3 = conn.prepareStatement("UPDATE sellers SET sex = 'female' WHERE id = ?" );
            prep3.setInt(1, 4);

            prep2.executeUpdate();
            prep3.executeUpdate();

            conn.commit();  //END TRANSACTION

            ResultSet rs2 = prep1.executeQuery();
            while (rs2.next()){
                System.out.println(rs2.getString(1) + " " + rs2.getString(2) +
                    " " + rs2.getString(3) + " " + rs2.getString(4));
            }

        } catch (SQLException e){
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                if (prep1 != null) {
                    prep1.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (prep2 != null) {
                    prep2.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (prep3 != null) {
                    prep3.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
