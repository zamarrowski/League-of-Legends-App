package lolapp;

import com.jaunt.Elements;
import com.jaunt.UserAgent;

public class ChampionStats {

	public String[][] getMostPlayedStats() {
		try {

			UserAgent ua = new UserAgent();
			ua.visit("http://www.elophant.com/league-of-legends/champions/most-played");
			Elements res = ua.doc.findEach("<td>");
			int cont = 0;
			int contfilas = 0;
			int contcolumn = 0;
			String[][] datosfilas = new String[114][4];

			for (int f = 0; f < res.size(); f++) {

				if (res.getElement(f).innerText().length() > 0) {

					if (f == cont) {
						datosfilas[contfilas][contcolumn] = res.getElement(f)
								.innerText();
						contcolumn++;
						datosfilas[contfilas][contcolumn] = res.getElement(
								f + 2).innerText();
						contcolumn++;
						datosfilas[contfilas][contcolumn] = res.getElement(
								f + 3).innerText();
						contcolumn++;
						datosfilas[contfilas][contcolumn] = res.getElement(
								f + 5).innerText();
						contfilas++;
						contcolumn = 0;
						cont += 7;
					}

				}

			}
			return datosfilas;
		} catch (Exception e) {
			return null;
		}

	}

	public String[][] getGameImpact() {
		try {
			UserAgent ua = new UserAgent();
			ua.visit("http://www.elophant.com/league-of-legends/champions/game-impact");
			Elements res = ua.doc.findEach("<td>");
			int cont = 0;
			int contfilas = 0;
			int contcolumn = 0;
			String[][] datosfilas = new String[114][6];

			for (int f = 0; f < res.size(); f++) {

				if (res.getElement(f).innerText().length() > 0) {

					if (f == cont) {

						datosfilas[contfilas][contcolumn] = res.getElement(f)
								.innerText();
						contcolumn++;
						datosfilas[contfilas][contcolumn] = res.getElement(
								f + 2).innerText();
						contcolumn++;
						datosfilas[contfilas][contcolumn] = res.getElement(
								f + 3).innerText();
						contcolumn++;
						datosfilas[contfilas][contcolumn] = res.getElement(
								f + 5).innerText();
						contcolumn++;
						datosfilas[contfilas][contcolumn] = res.getElement(
								f + 7).innerText();
						contcolumn++;
						datosfilas[contfilas][contcolumn] = res.getElement(
								f + 9).innerText();
						contfilas++;
						contcolumn = 0;
						cont += 11;
					}

				}

			}

			return datosfilas;
		} catch (Exception e) {
			return null;
		}
	}

	public String[][] getDamageDealt() {
		try {

			UserAgent ua = new UserAgent();
			ua.visit("http://www.elophant.com/league-of-legends/champions/damage-dealt");
			Elements res = ua.doc.findEach("<td>");
			int cont = 0;
			int contfilas = 0;
			int contcolumn = 0;
			String[][] datosfilas = new String[114][5];

			for (int f = 0; f < res.size(); f++) {

				if (res.getElement(f).innerText().length() > 0) {

					if (f == cont) {

						datosfilas[contfilas][contcolumn] = res.getElement(f)
								.innerText();
						contcolumn++;
						datosfilas[contfilas][contcolumn] = res.getElement(
								f + 2).innerText();
						contcolumn++;
						datosfilas[contfilas][contcolumn] = res.getElement(
								f + 3).innerText();
						contcolumn++;
						datosfilas[contfilas][contcolumn] = res.getElement(
								f + 5).innerText();
						contcolumn++;
						datosfilas[contfilas][contcolumn] = res.getElement(
								f + 7).innerText();
						contfilas++;
						contcolumn = 0;
						cont += 9;
					}

				}

			}

			return datosfilas;
		} catch (Exception e) {
			return null;
		}
	}

}
