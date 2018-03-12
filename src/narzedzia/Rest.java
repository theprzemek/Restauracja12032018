package narzedzia;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import model.Rezerwacja;
import polaczenie.MySQLPolaczenie;
@Path("/rest")
public class Rest {
	
	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_HTML)
	public static String wykazRezerwacji() throws SQLException, ClassNotFoundException {
		String odpowiedz = "<!DOCTYPE html>\r\n"
				+ "<html>\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" + 
				"<title>Wszystkie rezerwacje z bazy</title>\r\n" + 
				"</head>\r\n" + 
				"<body>";
		Connection conn = MySQLPolaczenie.polaczZBaza();
		List <Rezerwacja> odp = new ArrayList<Rezerwacja>();
		odp = NarzedziaBazy.dajListeRezerwacji(conn);
		MySQLPolaczenie.zamknijPolaczenie(conn);
		for(Rezerwacja r: odp) {
			odpowiedz=odpowiedz+"<p>id rezerwacji: "+r.getIdRezerwacja();
			odpowiedz=odpowiedz+", Imiê: "+r.getImie();
			odpowiedz=odpowiedz+", Nazwisko: "+r.getNazwisko();
			odpowiedz=odpowiedz+", Email: "+r.getEmail();
			odpowiedz=odpowiedz+", data: "+r.getData();
			odpowiedz=odpowiedz+", godzina: "+r.getGodzina();
			odpowiedz=odpowiedz+", nr stolika: "+r.getIdStolika()+"</p>";	
		}
		odpowiedz = odpowiedz + "</body>\r\n" + 
				"</html>";
		return odpowiedz;
	}
	@POST
	@Path("/inicjalizacja")
	public static void inicjalizacjaSQL() throws SQLException, ClassNotFoundException {
		Connection conn = MySQLPolaczenie.polaczZBaza();
		NarzedziaBazy.inicjalizacjaTabeli(conn);
		MySQLPolaczenie.zamknijPolaczenie(conn);
	}
}