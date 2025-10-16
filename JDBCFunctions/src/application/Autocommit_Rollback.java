package application;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Autocommit_Rollback {
    public static void main(String[] args) {
        Statement st = null;
        Connection conn = null;

        try {
            conn = DB.getConnection();
            st = conn.createStatement();

            conn.setAutoCommit(false);

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

//            int x = 1;
//            if(x < 2){
//                throw new SQLException("Fake error");
//            }

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 3");

            conn.commit();

            System.out.println("Rows Affected: " + rows1 + rows2);

        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Cause: " + e.getMessage());
            } catch(SQLException e1) {
                e1.printStackTrace();
            }

        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}