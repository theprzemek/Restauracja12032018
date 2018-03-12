package narzedzia;

import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Rezerwacja;

public class NarzedziaBazy {

	public static List<Rezerwacja> dajListeRezerwacji(Connection conn) throws SQLException {

		List<Rezerwacja> rezList = new ArrayList<Rezerwacja>();

		String sql = "Select * from rezerwacja";

		PreparedStatement stm = null;
		ResultSet rs = null;

		try {

			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				Rezerwacja rez = new Rezerwacja();
				rez.setIdRezerwacja(Integer.parseInt(rs.getString(1)));
				rez.setData(rs.getString(2));
				rez.setGodzina(Integer.parseInt(rs.getString(3)));
				rez.setImie(rs.getString(4));
				rez.setNazwisko(rs.getString(5));
				rez.setEmail(rs.getString(6));
				rez.setIdStolika(Integer.parseInt(rs.getString(7)));

				rezList.add(rez);
			}

		} catch (SQLException e) {
			System.out.println("B³¹d podczas wykonywania zapytania");

		} finally {
			rs.close();
			stm.close();
		}
		return rezList;
	}

	public static List<Rezerwacja> dajListeRezerwacjiZDnia(Connection conn, String data, int godzina)
			throws SQLException {

		List<Rezerwacja> rezList = new ArrayList<Rezerwacja>();

		String sql = "Select idRezerwacja, data, godzina, imie, nazwisko, email,idStolika from rezerwacja "
				+ "where data = ? and godzina = ? ";

		PreparedStatement stm = null;
		ResultSet rs = null;

		try {

			stm = conn.prepareStatement(sql);
			stm.setString(1, data);
			stm.setInt(2, godzina);

			rs = stm.executeQuery();

			while (rs.next()) {
				Rezerwacja rez = new Rezerwacja();
				rez.setIdRezerwacja(Integer.parseInt(rs.getString(1)));
				rez.setData(rs.getString(2));
				rez.setGodzina(Integer.parseInt(rs.getString(3)));
				rez.setImie(rs.getString(4));
				rez.setNazwisko(rs.getString(5));
				rez.setEmail(rs.getString(6));
				rez.setIdStolika(Integer.parseInt(rs.getString(7)));

				rezList.add(rez);
			}

		} catch (SQLException e) {
			System.out.println("B³¹d podczas wykonywania zapytania");
		} finally {
			rs.close();
			stm.close();
		}
		return rezList;
	}

	public static void dodajRezerwacje(Connection conn, Rezerwacja rez) throws SQLException {
		if (rez.getData().equals(null)) {
			throw new InvalidParameterException("brak daty");
		}
		if (rez.getNazwisko().equals(null)) {
			throw new InvalidParameterException("brak Nazwiska");
		}

		if (rez.getGodzina() == 0) {
			throw new InvalidParameterException("brak godziny");
		}

		String sql = "INSERT INTO rezerwacja " + "(idRezerwacja, data, godzina, imie, nazwisko, email, idStolika) "
				+ "VALUES (?,?,?,?,?,?,?)";

		PreparedStatement stm = null;

		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, rez.getIdRezerwacja());
			stm.setString(2, rez.getData());
			stm.setInt(3, rez.getGodzina());
			stm.setString(4, rez.getImie());
			stm.setString(5, rez.getNazwisko());
			stm.setString(6, rez.getEmail());
			stm.setInt(7, rez.getIdStolika());

			stm.execute();

		} catch (SQLException e) {
			System.out.println("b³¹d podczas wykonywania zapytania");
		} finally {
			stm.close();
		}
	}

	public static int wypiszLiczbeRezerwacji(Connection conn) throws SQLException {

		String sql = "Select Count(idRezerwacja) From rezerwacja ";

		PreparedStatement stm = null;
		ResultSet rs = null;
		int ileRezerwacji = 0;
		try {

			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			if (rs.next()) {
				ileRezerwacji = rs.getInt(1);
			} else {
				System.out.println("Nie ma ¿adnych rezerwacji");
				ileRezerwacji = 0;
			}

		} catch (SQLException e) {
			System.out.println("b³¹d podczas wykonywania zapytania");
		} finally {
			rs.close();
			stm.close();
		}
		return ileRezerwacji;
	}

	public static int czyJestWolnyStolik(Connection conn, String data, String godzina) throws SQLException {

		int zajete = 0;
		String sql = "Select Count(idStolika) from rezerwacja " + "where data = ? and godzina = ? ";

		PreparedStatement stm = null;
		ResultSet rs = null;

		try {

			stm = conn.prepareStatement(sql);
			stm.setString(1, data);
			stm.setInt(2, Integer.parseInt(godzina.substring(0, 2)));

			rs = stm.executeQuery();

			if (rs.next()) {
				zajete = Integer.parseInt(rs.getString(1));
			}

		} catch (SQLException e) {
			System.out.println("b³¹d podczas wykonywania zapytania");
		} finally {
			rs.close();
			stm.close();
		}
		return zajete;
	}

	public static void inicjalizacjaTabeli(Connection conn) throws SQLException {

		String sql = "CREATE TABLE rezerwacja (idRezerwacja INTEGER, data VARCHAR(10), godzina INTEGER, imie VARCHAR(20), nazwisko VARCHAR(20), email VARCHAR(45), idStolika INTEGER, PRIMARY KEY (idRezerwacja))";

		PreparedStatement stm = null;

		try {

			stm = conn.prepareStatement(sql);
			stm.execute();

		} catch (SQLException e) {
			System.out.println("b³¹d podczas wykonywania zapytania");
		} finally {
			stm.close();
		}
	}

}
