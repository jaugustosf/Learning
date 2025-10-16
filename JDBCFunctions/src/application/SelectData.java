package application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectData {
    public static void main(String[] args) {
        ResultSet rs = null;
        Statement st = null;
        //Aqui estamos apenas dando seletcs no banco
        try (Connection conn = DB.getConnection()) {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM department");

            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
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