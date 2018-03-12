package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Rezerwacja;
import narzedzia.Narzedzia;
import narzedzia.NarzedziaBazy;
import polaczenie.MySQLPolaczenie;

@WebServlet("/Check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Check() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String data = request.getParameter("data");
		String godz = request.getParameter("godz");
		int ileStolikow = 5;

		try {
			Connection conn = MySQLPolaczenie.polaczZBaza();
			if (NarzedziaBazy.czyJestWolnyStolik(conn, data, godz) < ileStolikow) {
				Rezerwacja rez = new Rezerwacja();
				rez.setIdRezerwacja(NarzedziaBazy.wypiszLiczbeRezerwacji(conn) + 1);
				rez.setData(data);
				rez.setGodzina(Integer.parseInt(godz.substring(0, 2)));
				rez.setImie(firstName);
				rez.setNazwisko(lastName);
				rez.setEmail(email);
				rez.setIdStolika(Narzedzia.numerWolnegoStolika(conn, data, Integer.parseInt(godz.substring(0, 2))));
				NarzedziaBazy.dodajRezerwacje(conn, rez);
				MySQLPolaczenie.zamknijPolaczenie(conn);
				RequestDispatcher rd = request.getRequestDispatcher("odpPoz.jsp");
				rd.forward(request, response);

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("odpNeg.jsp");
				rd.forward(request, response);

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
