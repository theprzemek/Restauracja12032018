package testy;

import java.sql.Connection;
import java.sql.SQLException;

import narzedzia.NarzedziaBazy;
import polaczenie.MySQLPolaczenie;

public class TestSprawdzaniaIlosciRezerwacji {

	public static void main(String[] args) {


		try {
			Connection conn = MySQLPolaczenie.polaczZBaza();

			System.out.println("Jest "+NarzedziaBazy.wypiszLiczbeRezerwacji(conn)+" rezerwacji");

			MySQLPolaczenie.zamknijPolaczenie(conn);

		} catch (ClassNotFoundException e) {
			System.out.println("b³¹d sterownika");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("b³¹d sterownika");
			e.printStackTrace();
		}

	}

}
