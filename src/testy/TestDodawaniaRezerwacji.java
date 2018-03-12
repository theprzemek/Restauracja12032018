package testy;

import java.sql.Connection;
import java.sql.SQLException;

import model.Rezerwacja;
import narzedzia.NarzedziaBazy;
import polaczenie.MySQLPolaczenie;

public class TestDodawaniaRezerwacji {

	public static void main(String[] args) {
	
		try {
			Connection conn = MySQLPolaczenie.polaczZBaza();
			Rezerwacja rez = new Rezerwacja();
			rez.setIdRezerwacja(6);
			rez.setData("01/01/2018");
			rez.setGodzina(1000);
			rez.setImie("tomek");
			rez.setNazwisko("janusz");
			rez.setEmail("aaa@aaa.pl");
			rez.setIdStolika(4);
			
			NarzedziaBazy.dodajRezerwacje(conn, rez);
				
			
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
