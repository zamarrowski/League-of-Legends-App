package lolapp;

import java.io.BufferedWriter;
import java.io.FileWriter;

import com.jaunt.Elements;
import com.jaunt.UserAgent;

public class actualizarCampeones {

	public static void main(String[] args) {
		String vida = "";
		String mana = "";
		String dmg = "";
		String vataq = "";
		String vmov = "";
		String regvida = "";
		String regmana = "";
		String arm = "";
		String resmag = "";
		String campeones[] = { "aatrox", "ahri", "akali", "alistar", "amumu",
				"anivia", "annie", "ashe", "blitzcrank", "brand", "braum",
				"caitlyn", "cassiopeia", "chogath", "corki", "darius", "diana",
				"drmundo", "draven", "elise", "evelynn", "ezreal",
				"fiddlesticks", "fiora", "fizz", "galio", "gangplank", "garen",
				"gragas", "graves", "hecarim", "heimerdinger", "irelia",
				"janna", "jarvaniv", "jax", "jayce", "jinx", "karma",
				"karthus", "kassadin", "katarina", "kayle", "kennen", "khazix",
				"kogmaw", "leblanc", "leesin", "leona", "lissandra", "lucian",
				"lulu", "lux", "masteryi", "malphite", "malzahar", "maokai",
				"missfortune", "mordekaiser", "morgana", "nami", "nasus",
				"nautilus", "nidalee", "nocturne", "nunu", "olaf", "orianna",
				"pantheon", "poppy", "quinn", "rammus", "renekton", "rengar",
				"riven", "rumble", "ryze", "sejuani", "shaco", "shen",
				"shyvana", "singed", "sion", "sivir", "skarner", "sona",
				"soraka", "swain", "syndra", "talon", "taric", "teemo",
				"thresh", "tristana", "trundle", "tryndamere", "twistedfate",
				"twitch", "udyr", "urgot", "varus", "vayne", "veigar",
				"velkoz", "vi", "viktor", "vladimir", "volibear", "warwick",
				"monkeyking", "xerath", "xinzhao", "yasuo", "yorick", "zac",
				"zed", "ziggs", "zilean", "zyra" };

		try {

			FileWriter fw = new FileWriter("xml/xmlcampeon.xml");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("<campeones>");
			for (int i = 0; i < campeones.length; i++) {

				UserAgent ua = new UserAgent();
				ua.visit("http://gameinfo.euw.leagueoflegends.com/es/game-info/champions/"
						+ campeones[i]);

				Elements atributos = ua.doc
						.findEach("<span class=\"stat-value\">");
				String res = atributos.outerHTML();

				String atrib[] = new String[atributos.size()];
				String lng = "<span class=\"stat-value\">";
				String lng2 = "</span>";

				for (int f = 0; f < atrib.length; f++) {

					atrib[f] = res.substring(
							res.indexOf("<span class=\"stat-value\">")
									+ lng.length(), res.indexOf("</span>"));
					res = res.substring(res.indexOf("</span>") + lng2.length());

				}

				if (atrib.length == 9) {

					vida = atrib[0];
					mana = atrib[1];
					dmg = atrib[2];
					vataq = atrib[3];
					vmov = atrib[4];
					regvida = atrib[5];
					regmana = atrib[6];
					arm = atrib[7];
					resmag = atrib[8];

				} else if (atrib.length == 7) {
					vida = atrib[0];
					dmg = atrib[1];
					vataq = atrib[2];
					vmov = atrib[3];
					regvida = atrib[4];
					arm = atrib[5];
					resmag = atrib[6];
				}

				bw.write("<" + campeones[i] + ">");
				bw.write("<vida>" + vida + "</vida>");
				bw.write("<mana>" + mana + "</mana>");
				bw.write("<daño>" + dmg + "</daño>");
				bw.write("<velocataque>" + vataq + "</velocataque>");
				bw.write("<velocidad>" + vmov + "</velocidad>");
				bw.write("<regvida>" + regvida + "</regvida>");
				bw.write("<regmana>" + regmana + "</regmana>");
				bw.write("<armadura>" + arm + "</armadura>");
				bw.write("<armamagica>" + resmag + "</armamagica>");

				bw.write("</" + campeones[i] + ">");

			}
			bw.write("</campeones>");
			bw.close();

		} catch (Exception e) {
			System.out.println(e.toString());

		}

	}
}
