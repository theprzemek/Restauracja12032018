package testy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Rezerwacja;
import narzedzia.NarzedziaBazy;
import polaczenie.MySQLPolaczenie;

public class TestWypisaniaRezerwacjiZDnia {

	public static void main(String[] args) {
		
		String data = "01/01/2018";
		int godzina = 1000;

		try {
			Connection conn = MySQLPolaczenie.polaczZBaza();
			List<Rezerwacja> rezList = new ArrayList<Rezerwacja>();
			rezList = NarzedziaBazy.dajListeRezerwacjiZDnia(conn, data, godzina);

			MySQLPolaczenie.zamknijPolaczenie(conn);
			
          for(int i =0; i<rezList.size();i++) {
        	  Rezerwacja rez = new Rezerwacja();
        	  rez = rezList.get(i);
			System.out.println("id rezerwacji: " + rez.getIdRezerwacja() + " data: " + rez.getData() + " godzina: "
					+ rez.getGodzina() + " imie: " + rez.getImie() + " nazwisko: " + rez.getNazwisko() + " email: "
					+ rez.getEmail() + " id stolika: " + rez.getIdStolika());}

		} catch (ClassNotFoundException e) {
			System.out.println("b³¹d sterownika");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("b³¹d sterownika");
			e.printStackTrace();
		}

	}

}
