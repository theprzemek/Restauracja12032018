package testy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import polaczenie.MySQLPolaczenie;

public class TestPolaczeniaZBaza {
	static String daneZBazy = "";

	public static void main(String[] args) {
		String sql = "Select * FROM user";
		try {
			Connection conn = MySQLPolaczenie.polaczZBaza();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				wyswietlDaneZBazy(rs);
			}
			MySQLPolaczenie.zamknijPolaczenie(conn);
		} catch (ClassNotFoundException e) {
			System.out.println("b³¹d sterownika");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("b³¹d sterownika");
			e.printStackTrace();
		}

	}

	static void wyswietlDaneZBazy(ResultSet rs) {
		try {
			/**daneZBazy = rs.getString(1);
			System.out.println("\n" + daneZBazy + " ");
			daneZBazy = rs.getString(2);
			System.out.println(daneZBazy + " ");*/
			daneZBazy = rs.getString(1);
			System.out.println(daneZBazy);
			daneZBazy = rs.getString(2);
			System.out.println(daneZBazy);
			daneZBazy = rs.getString(3);
			System.out.println(daneZBazy);
			daneZBazy = rs.getString(4);
			System.out.println(daneZBazy);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
/**
 * public class JDBC {
 * 
 * static String daneZBazy;
 * 
 * public static void main(String[] args) {
 * 
 * String polaczenieURL =
 * "jdbc:mysql://192.168.1.4/test?user=test&password=test"; //Tworzymy proste
 * zapytanie doa bazy danych String query = "Select * FROM pracownicy";
 * 
 * Connection conn = null;
 * 
 * try {
 * 
 * //Ustawiamy dane dotycz¹ce pod³¹czenia conn =
 * DriverManager.getConnection(polaczenieURL);
 * 
 * //Ustawiamy sterownik MySQL Class.forName("com.mysql.jdbc.Driver");
 * 
 * //Uruchamiamy zapytanie do bazy danych Statement stmt =
 * conn.createStatement(); ResultSet rs = stmt.executeQuery(query);
 * 
 * while (rs.next()) { wyswietlDaneZBazy(rs); }
 * 
 * conn.close(); } //Wyrzuæ wyj¹tki jê¿eli nast¹pi¹ b³êdy z pod³¹czeniem do bazy
 * danych lub blêdy zapytania o dane catch(ClassNotFoundException wyjatek) {
 * System.out.println("Problem ze sterownikiem"); }
 * 
 * catch(SQLException wyjatek) { //e.printStackTrace();
 * //System.out.println("Problem z logowaniem\nProsze sprawdzic:\n nazwê
 * u¿ytkownika, has³o, nazwê bazy danych lub adres IP serwera");
 * System.out.println("SQLException: " + wyjatek.getMessage());
 * System.out.println("SQLState: " + wyjatek.getSQLState());
 * System.out.println("VendorError: " + wyjatek.getErrorCode()); }
 * 
 * } static void wyswietlDaneZBazy(ResultSet rs){ try{ daneZBazy =
 * rs.getString(1); System.out.println("\n" + daneZBazy + " "); daneZBazy =
 * rs.getString(2); System.out.println(daneZBazy + " "); daneZBazy =
 * rs.getString(3); System.out.println(daneZBazy); }catch(SQLException e) {
 * e.printStackTrace(); } }
 * 
 * }
 */