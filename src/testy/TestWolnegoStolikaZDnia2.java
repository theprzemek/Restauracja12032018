package testy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Rezerwacja;
import narzedzia.Narzedzia;
import narzedzia.NarzedziaBazy;
import polaczenie.MySQLPolaczenie;

public class TestWolnegoStolikaZDnia2 {

	public static void main(String[] args) {
		
		String data = "01/01/2018";
		int godzina = 1000;

		try {
			Connection conn = MySQLPolaczenie.polaczZBaza();
			
			
			System.out.println("wolny stolik nr: "+Narzedzia.numerWolnegoStolika(conn, data, godzina));
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
