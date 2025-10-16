package application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InsertData {
    public static void main(String[] args) {
        PreparedStatement st = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        ResultSet rs = null;
        try (Connection conn = DB.getConnection()) {
            st = conn.prepareStatement("""
                    INSERT INTO seller
                        (Name, Email, BirthDate, BaseSalary, DepartmentId)
                    VALUES
                        (?, ?, ?, ?, ?)
                    """, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "Toma Karen");
            st.setString(2, "karen@toma.com");
            st.setDate(3, new java.sql.Date(sdf.parse("24/05/2000").getTime()));
            st.setDouble(4, 3000.00);
            st.setInt(5, 4);

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

            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}