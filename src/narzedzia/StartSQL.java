package narzedzia;

import java.sql.Connection;
import java.sql.SQLException;

import polaczenie.MySQLPolaczenie;

public class StartSQL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = MySQLPolaczenie.polaczZBaza();
		NarzedziaBazy.inicjalizacjaTabeli(conn);
		MySQLPolaczenie.zamknijPolaczenie(conn);

	}

}
