package application;

import db.DB;
import db.DbIntegrityException;

import java.sql.*;

public class DeleteData {
    public static void main(String[] args) {
        PreparedStatement st = null;

        ResultSet rs = null;
        try (Connection conn = DB.getConnection()) {
            st = conn.prepareStatement(
                    "DELETE FROM department WHERE Id = ?",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, 2);

            int rowsEffected = st.executeUpdate();

            System.out.println("Done! Rows Affected: " + rowsEffected);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}