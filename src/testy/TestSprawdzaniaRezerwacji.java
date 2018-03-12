package testy;

import java.sql.Connection;
import java.sql.SQLException;

import narzedzia.NarzedziaBazy;
import polaczenie.MySQLPolaczenie;

public class TestSprawdzaniaRezerwacji {

	public static void main(String[] args) {

		String data = "01/01/2018";
		String godzina = "1000";

		try {
			Connection conn = MySQLPolaczenie.polaczZBaza();

			int liczba = NarzedziaBazy.czyJestWolnyStolik(conn, data, godzina);

			System.out.println("wynik: " + liczba);

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
