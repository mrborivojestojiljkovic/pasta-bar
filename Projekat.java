import java.util.Scanner;

public class Projekat {

	public static void main(String[] args) {

		Scanner unesi = new Scanner(System.in);
		String[] sastojci = { "Makarone", "Spagete", "Bolognese", "Curetina", "Govedja prsuta", "Slanina", "Piletina",
				"4 sira", "Dimljeni sir", "Parmezan", "Pavlaka", "Pesto sos", "Napolitana", "Povrce mix", "Pecurke",
				"Kutija" };
		int[] cene = { 50, 60, 120, 120, 140, 100, 100, 100, 80, 50, 80, 80, 80, 50, 50, 20 };
		String[] stalneMusterije = { "0631111111", "063222222", "063333333", "064444444", "065555555", "066666666" };

		System.out.println(
				"Dobar dan, drago nam je sto koristite nase usluge. Izvolite, zapocnite Vasu online porudzbinu.");
		String a = "";
		String b = "Poruci";
		double cenaPaste = 0;

		while (!a.equals(b)) {
			System.out.println("Izaberite sastojak za pastu: ");
			a = unesi.nextLine();
			int pozicija = pronadjiSastojak(sastojci, a);
			if (pozicija >= 0) {
				cenaPaste = cenaPaste + cene[pozicija];
			}
		}

		String c = "";

		System.out.println("Unesite Vas kontakt telefon: ");
		c = unesi.next();
		boolean stalnaMusterija = stalniKupac(stalneMusterije, c);
		String notifikacija = "Ovaj korisnik nema popust.";
		if (stalnaMusterija) {
			cenaPaste = cenaPaste * 0.9;
			notifikacija = "Ovaj korisnik ima popust od 10 posto.";
		}

		System.out.println("Vasa cena je: " + cenaPaste + "rsd. (NOTIFIKACIJA: " + notifikacija + ")");
		System.out.println("Prijatno!!");

		unesi.close();
	}

	public static int pronadjiSastojak(String[] sastojak, String nazivSastojka) {
		int n = -1;
		for (int i = 0; i < sastojak.length; i++) {
			if (sastojak[i].equals(nazivSastojka)) {
				n = i;
				break;
			}
		}
		return n;
	}

	public static boolean stalniKupac(String[] brojeviTelefona, String broj) {
		boolean stalni = false;

		for (int i = 0; i < brojeviTelefona.length; i++) {
			if (brojeviTelefona[i].equals(broj)) {
				stalni = true;
				break;
			}
		}
		return stalni;
	}
}
