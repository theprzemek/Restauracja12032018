package model;

public class Rezerwacja {
	private int idRezerwacja;
	private String data;
	private int godzina;
	private String imie;
	private String nazwisko;
	private String email;
	private int idStolika;

	public Rezerwacja() {
	}

	public Rezerwacja(int idRezerwacja, String data, int godzina, String imie, String nazwisko, String email,
			int idStolika) {
		super();
		this.idRezerwacja = idRezerwacja;
		this.data = data;
		this.godzina = godzina;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.email = email;
		this.idStolika = idStolika;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdStolika() {
		return idStolika;
	}

	public void setIdStolika(int idStolika) {
		this.idStolika = idStolika;
	}

	public int getIdRezerwacja() {
		return idRezerwacja;
	}

	public void setIdRezerwacja(int idRezerwacja) {
		this.idRezerwacja = idRezerwacja;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getGodzina() {
		return godzina;
	}

	public void setGodzina(int godzina) {
		this.godzina = godzina;
	}

}
