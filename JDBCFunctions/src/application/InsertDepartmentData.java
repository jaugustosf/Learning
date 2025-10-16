package application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InsertDepartmentData {
    public static void main(String[] args) {
        PreparedStatement st = null;

        ResultSet rs = null;
        try (Connection conn = DB.getConnection()) {
            st = conn.prepareStatement(
                    "INSERT INTO department (Name) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "Department Test 2");

            st.executeUpdate();

            int rowsEffected = st.executeUpdate();
            rs = null;
            if (rowsEffected > 0) {
                rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            } else {
                System.out.println("No rows effected!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}