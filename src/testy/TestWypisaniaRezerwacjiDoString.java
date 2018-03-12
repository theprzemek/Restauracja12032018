package testy;

import java.sql.SQLException;
import narzedzia.Rest;

public class TestWypisaniaRezerwacjiDoString {

	public static void main(String[] args) {

		try {

			String odp = Rest.wykazRezerwacji();

			System.out.println(odp);

		} catch (ClassNotFoundException e) {
			System.out.println("b³¹d sterownika");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("b³¹d sterownika");
			e.printStackTrace();
		}

	}

}
