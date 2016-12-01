package pl.codeme.examples;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class JDBCExample {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String zespol = "Programowanie";
		
		String SQL = ""
				+ "SELECT"
				+ "		l.imie, SUM(c_zz.zaangazowanie) AS zaangazowanie "
				+ "FROM"
				+ "		zespoly z "
				+ "JOIN"
				+ "		czlonkowie_zespolow c_z ON (c_z.id_zespoly = z.id) "
				+ "LEFT JOIN"
				+ "		czlonkowie_zespolow c_zz ON (c_z.id_ludzie = c_zz.id_ludzie) "
				+ "LEFT JOIN"
				+ "		ludzie l ON (l.id = c_zz.id_ludzie) "
				+ "WHERE"
				+ "		nazwa = ? "
				+ "GROUP BY"
				+ "		l.id";
		
		try {
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/codeme", "root", "root");
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(SQL);
//			stmt.setString(1, zespol);//ustawianie wartosci, ustrzezenie sie przed atakami sql injection
			ResultSet rs = stmt.executeQuery();
//			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				System.out.println(rs.getString("imie") + " " + rs.getInt("zaangazowanie"));
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
