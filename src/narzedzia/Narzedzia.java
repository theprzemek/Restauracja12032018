package narzedzia;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Rezerwacja;

public class Narzedzia {

	public static int numerWolnegoStolika(Connection conn, String data, int godzina) throws SQLException {
		int numer = 1;
		int iloscStolikow = 5;
		List<Rezerwacja> rezList = new ArrayList<Rezerwacja>();

		rezList = NarzedziaBazy.dajListeRezerwacjiZDnia(conn, data, godzina);

		List<Integer> idStolikaList = new ArrayList<Integer>();
		for (int i = 0; i <= iloscStolikow; i++) {
			idStolikaList.add(0);
		}
		for (int i = 0; i < rezList.size(); i++) {

			idStolikaList.add(rezList.get(i).getIdStolika(), 1);
		}
		for (int i = 1; i <= idStolikaList.size(); i++) {
			if (idStolikaList.get(i) != 0) {
				numer++;
			} else {
				break;
			}
		}

		return numer;
	}

}
