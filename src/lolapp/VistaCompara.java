package lolapp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.awt.Toolkit;

public class VistaCompara extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String namechampions[] = { "aatrox", "ahri", "akali", "alistar",
			"amumu", "anivia", "annie", "ashe", "blitzcrank", "brand", "braum",
			"caitlyn", "cassiopeia", "chogath", "corki", "darius", "diana",
			"drmundo", "draven", "elise", "evelynn", "ezreal", "fiddlesticks",
			"fiora", "fizz", "galio", "gangplank", "garen", "gragas", "graves",
			"hecarim", "heimerdinger", "irelia", "janna", "jarvaniv", "jax",
			"jayce", "jinx", "karma", "karthus", "kassadin", "katarina",
			"kayle", "kennen", "khazix", "kogmaw", "leblanc", "leesin",
			"leona", "lissandra", "lucian", "lulu", "lux", "masteryi",
			"malphite", "malzahar", "maokai", "missfortune", "mordekaiser",
			"morgana", "nami", "nasus", "nautilus", "nidalee", "nocturne",
			"nunu", "olaf", "orianna", "pantheon", "poppy", "quinn", "rammus",
			"renekton", "rengar", "riven", "rumble", "ryze", "sejuani",
			"shaco", "shen", "shyvana", "singed", "sion", "sivir", "skarner",
			"sona", "soraka", "swain", "syndra", "talon", "taric", "teemo",
			"thresh", "tristana", "trundle", "tryndamere", "twistedfate",
			"twitch", "udyr", "urgot", "varus", "vayne", "veigar", "velkoz",
			"vi", "viktor", "vladimir", "volibear", "warwick", "monkeyking",
			"xerath", "xinzhao", "yasuo", "yorick", "zac", "zed", "ziggs",
			"zilean", "zyra" };
	private String namechampionsM[] = { "Aatrox", "Ahri", "Akali", "Alistar",
			"Amumu", "Anivia", "Annie", "Ashe", "Blitzcrank", "Brand", "Braum",
			"Caitlyn", "Cassiopeia", "Chogath", "Corki", "Darius", "Diana",
			"Drmundo", "Draven", "Elise", "Evelynn", "Ezreal", "Fiddlesticks",
			"Fiora", "Fizz", "Galio", "Gangplank", "Garen", "Gragas", "Graves",
			"Hecarim", "Heimerdinger", "Irelia", "Janna", "Jarvaniv", "Jax",
			"Jayce", "Jinx", "Karma", "Karthus", "Kassadin", "Katarina",
			"Kayle", "Kennen", "Khazix", "Kogmaw", "Leblanc", "Leesin",
			"Leona", "Lissandra", "Lucian", "Lulu", "Lux", "Masteryi",
			"Malphite", "Malzahar", "Maokai", "Missfortune", "Mordekaiser",
			"Morgana", "Nami", "Nasus", "Nautilus", "Nidalee", "Nocturne",
			"Nunu", "Olaf", "Orianna", "Pantheon", "Poppy", "Quinn", "Rammus",
			"Renekton", "Rengar", "Riven", "Rumble", "Ryze", "Sejuani",
			"Shaco", "Shen", "Shyvana", "Singed", "Sion", "Sivir", "Skarner",
			"Sona", "Soraka", "Swain", "Syndra", "Talon", "Taric", "Teemo",
			"Thresh", "Tristana", "Trundle", "Tryndamere", "TwistedFate",
			"Twitch", "Udyr", "Urgot", "Varus", "Vayne", "Veigar", "Velkoz",
			"Vi", "Viktor", "Vladimir", "Volibear", "Warwick", "MonkeyKing",
			"Xerath", "XinZhao", "Yasuo", "Yorick", "Zac", "Zed", "Ziggs",
			"Zilean", "Zyra" };

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCompara frame = new VistaCompara();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaCompara() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaCompara.class.getResource("/img/iconloley3.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Loley3 | Comparador de Campeones");
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					URL urlxml = new URL(
							"http://s450659001.mialojamiento.es/xmlcampeon.xml");
					URLConnection urlCon = urlxml.openConnection();
					InputStream is = urlCon.getInputStream();
					FileOutputStream fos = new FileOutputStream(
							"xml/xmlcampeon.xml");
					int leido = is.read();
					while (leido != -1) {
						fos.write(leido);
						leido = is.read();
					}
					is.close();
					fos.close();
					VistaCompara vc = new VistaCompara();
					dispose();
					vc.setVisible(true);

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		btnNewButton.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/database_refresh.png")));
		btnNewButton.setBounds(976, 169, 48, 43);
		contentPane.add(btnNewButton);
		final JComboBox<String> comboBoxizq = new JComboBox<String>();

		comboBoxizq.setModel(new DefaultComboBoxModel<String>(new String[] {
				"-Selecciona Campeón-", "Aatrox", "Ahri", "Akali", "Alistar",
				"Amumu", "Anivia", "Annie", "Ashe", "Blitzcrank", "Brand",
				"Braum", "Caitlyn", "Cassiopeia", "Chogath", "Corki", "Darius",
				"Diana", "Drmundo", "Draven", "Elise", "Evelynn", "Ezreal",
				"Fiddlesticks", "Fiora", "Fizz", "Galio", "Gangplank", "Garen",
				"Gragas", "Graves", "Hecarim", "Heimerdinger", "Irelia",
				"Janna", "Jarvaniv", "Jax", "Jayce", "Jinx", "Karma",
				"Karthus", "Kassadin", "Katarina", "Kayle", "Kennen", "Khazix",
				"Kogmaw", "Leblanc", "Leesin", "Leona", "Lissandra", "Lucian",
				"Lulu", "Lux", "Masteryi", "Malphite", "Malzahar", "Maokai",
				"Missfortune", "Mordekaiser", "Morgana", "Nami", "Nasus",
				"Nautilus", "Nidalee", "Nocturne", "Nunu", "Olaf", "Orianna",
				"Pantheon", "Poppy", "Quinn", "Rammus", "Renekton", "Rengar",
				"Riven", "Rumble", "Ryze", "Sejuani", "Shaco", "Shen",
				"Shyvana", "Singed", "Sion", "Sivir", "Skarner", "Sona",
				"Soraka", "Swain", "Syndra", "Talon", "Taric", "Teemo",
				"Thresh", "Tristana", "Trundle", "Tryndamere", "TwistedFate",
				"Twitch", "Udyr", "Urgot", "Varus", "Vayne", "Veigar",
				"Velkoz", "Vi", "Viktor", "Vladimir", "Volibear", "Warwick",
				"MonkeyKing", "Xerath", "XinZhao", "Yasuo", "Yorick", "Zac",
				"Zed", "Ziggs", "Zilean", "Zyra" }));
		comboBoxizq.setBounds(30, 37, 195, 27);
		getContentPane().add(comboBoxizq);

		final JComboBox<String> comboboxder = new JComboBox<String>();
		comboboxder.setModel(new DefaultComboBoxModel<String>(new String[] {
				"-Selecciona Campeón-", "Aatrox", "Ahri", "Akali", "Alistar",
				"Amumu", "Anivia", "Annie", "Ashe", "Blitzcrank", "Brand",
				"Braum", "Caitlyn", "Cassiopeia", "Chogath", "Corki", "Darius",
				"Diana", "Drmundo", "Draven", "Elise", "Evelynn", "Ezreal",
				"Fiddlesticks", "Fiora", "Fizz", "Galio", "Gangplank", "Garen",
				"Gragas", "Graves", "Hecarim", "Heimerdinger", "Irelia",
				"Janna", "Jarvaniv", "Jax", "Jayce", "Jinx", "Karma",
				"Karthus", "Kassadin", "Katarina", "Kayle", "Kennen", "Khazix",
				"Kogmaw", "Leblanc", "Leesin", "Leona", "Lissandra", "Lucian",
				"Lulu", "Lux", "Masteryi", "Malphite", "Malzahar", "Maokai",
				"Missfortune", "Mordekaiser", "Morgana", "Nami", "Nasus",
				"Nautilus", "Nidalee", "Nocturne", "Nunu", "Olaf", "Orianna",
				"Pantheon", "Poppy", "Quinn", "Rammus", "Renekton", "Rengar",
				"Riven", "Rumble", "Ryze", "Sejuani", "Shaco", "Shen",
				"Shyvana", "Singed", "Sion", "Sivir", "Skarner", "Sona",
				"Soraka", "Swain", "Syndra", "Talon", "Taric", "Teemo",
				"Thresh", "Tristana", "Trundle", "Tryndamere", "TwistedFate",
				"Twitch", "Udyr", "Urgot", "Varus", "Vayne", "Veigar",
				"Velkoz", "Vi", "Viktor", "Vladimir", "Volibear", "Warwick",
				"MonkeyKing", "Xerath", "XinZhao", "Yasuo", "Yorick", "Zac",
				"Zed", "Ziggs", "Zilean", "Zyra" }));
		comboboxder.setBounds(763, 37, 195, 27);
		getContentPane().add(comboboxder);

		JButton Home = new JButton("");

		Home.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/Home 2.png")));
		Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPrincipal v1 = new VPrincipal(0);
				dispose();
				v1.setVisible(true);

			}
		});
		Home.setBounds(976, 92, 48, 41);
		contentPane.add(Home);
		
		JButton buscar = new JButton("");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VBusqueda vb = new VBusqueda();
				dispose();
				vb.setVisible(true);
			}
		});
		buscar.setIcon(new ImageIcon(VPrincipal.class.getResource("/img/magnifier.png")));
		buscar.setBounds(976, 295, 48, 43);
		getContentPane().add(buscar);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VCampeonStats vcs = new VCampeonStats();
				dispose();
				vcs.setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon(VPrincipal.class.getResource("/img/table_multiple.png")));
		button_1.setBounds(976, 337, 48, 43);
		getContentPane().add(button_1);
		
		JButton btcompara = new JButton("");
		btcompara.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/Up-Down.png")));
		btcompara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btcompara.setBounds(976, 130, 48, 41);
		contentPane.add(btcompara);
		// Imagenes campeones izquierda

		final JLabel[] imgcampizq = new JLabel[namechampions.length];

		for (int f = 0; f < imgcampizq.length; f++) {

			imgcampizq[f] = new JLabel("");
			imgcampizq[f].setIcon(new ImageIcon(VistaCompara.class
					.getResource("/img/imgcampbuena" + namechampions[f]
							+ ".jpg")));
			imgcampizq[f].setHorizontalAlignment(SwingConstants.LEFT);
			imgcampizq[f].setBounds(30, 109, 185, 240);
			contentPane.add(imgcampizq[f]);
			imgcampizq[f].setVisible(false);

		}

		// FIN IMAGENES CAMPEONES IZQUIERDA---------------

		// Imagenes campeones derecha

		final JLabel[] imgcamp = new JLabel[namechampions.length];

		for (int f = 0; f < imgcamp.length; f++) {

			imgcamp[f] = new JLabel("");
			imgcamp[f].setIcon(new ImageIcon(VistaCompara.class
					.getResource("/img/imgcampbuena" + namechampions[f]
							+ ".jpg")));
			imgcamp[f].setHorizontalAlignment(SwingConstants.LEFT);
			imgcamp[f].setBounds(763, 109, 185, 240);
			contentPane.add(imgcamp[f]);
			imgcamp[f].setVisible(false);

		}

		// FIN IMAGENES CAMPEONES DERECHA------------

		JLabel Damageizq = new JLabel("");
		Damageizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/daño.png")));
		Damageizq.setToolTipText("Daño físico");
		Damageizq.setBounds(30, 365, 32, 32);
		contentPane.add(Damageizq);
		

		JLabel Vidaizq = new JLabel("");
		Vidaizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/vida.png")));
		Vidaizq.setBounds(30, 405, 33, 33);
		contentPane.add(Vidaizq);

		JLabel manaizq = new JLabel("");
		manaizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/mana.png")));
		manaizq.setBounds(30, 445, 33, 32);
		contentPane.add(manaizq);

		JLabel velocidadizq = new JLabel("");
		velocidadizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/velocidad.png")));
		velocidadizq.setBounds(30, 485, 33, 34);
		contentPane.add(velocidadizq);

		JLabel armaduraizq = new JLabel("");
		armaduraizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/armor.png")));
		armaduraizq.setBounds(30, 525, 32, 31);
		contentPane.add(armaduraizq);

		JLabel resmagicizq = new JLabel("");
		resmagicizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/armormagic.png")));
		resmagicizq.setBounds(220, 365, 33, 33);
		contentPane.add(resmagicizq);

		JLabel regvidaizq = new JLabel("");
		regvidaizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/regevida.png")));
		regvidaizq.setBounds(220, 405, 31, 32);
		contentPane.add(regvidaizq);

		JLabel regmanaizq = new JLabel("");
		regmanaizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/regmana.png")));
		regmanaizq.setBounds(220, 445, 33, 33);
		contentPane.add(regmanaizq);

		JLabel velocidadataqizq = new JLabel("");
		velocidadataqizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/velocidadatak.png")));
		velocidadataqizq.setBounds(220, 485, 33, 35);
		contentPane.add(velocidadataqizq);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/daño.png")));
		label.setBounds(725, 365, 32, 32);
		contentPane.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/vida.png")));
		label_1.setBounds(725, 405, 33, 33);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/mana.png")));
		label_2.setBounds(725, 445, 33, 32);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/velocidad.png")));
		label_3.setBounds(725, 485, 33, 34);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/armor.png")));
		label_4.setBounds(725, 525, 32, 31);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/armormagic.png")));
		label_5.setBounds(915, 365, 33, 33);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/regevida.png")));
		label_6.setBounds(915, 405, 31, 32);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/regmana.png")));
		label_7.setBounds(915, 445, 33, 33);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/velocidadatak.png")));
		label_8.setBounds(915, 485, 33, 35);
		contentPane.add(label_8);

		final JLabel dañoestizq = new JLabel("");
		dañoestizq.setBounds(70, 375, 138, 16);
		contentPane.add(dañoestizq);

		final JLabel vidaestizq = new JLabel("");
		vidaestizq.setBounds(70, 415, 138, 16);
		contentPane.add(vidaestizq);

		final JLabel manaestizq = new JLabel("");
		manaestizq.setBounds(70, 455, 138, 16);
		contentPane.add(manaestizq);

		final JLabel velocestizq = new JLabel("");
		velocestizq.setBounds(70, 495, 138, 16);
		contentPane.add(velocestizq);

		final JLabel armorestizq = new JLabel("");
		armorestizq.setBounds(70, 535, 138, 16);
		contentPane.add(armorestizq);

		final JLabel armormagestizq = new JLabel("");
		armormagestizq.setBounds(265, 375, 138, 16);
		contentPane.add(armormagestizq);

		final JLabel regvidaestizq = new JLabel("");
		regvidaestizq.setBounds(265, 415, 138, 16);
		contentPane.add(regvidaestizq);

		final JLabel regmanaestizq = new JLabel("");
		regmanaestizq.setBounds(265, 455, 138, 16);
		contentPane.add(regmanaestizq);

		final JLabel velocataqestizq = new JLabel("");
		velocataqestizq.setBounds(265, 495, 138, 16);
		contentPane.add(velocataqestizq);

		final JLabel dañoestder = new JLabel("");
		dañoestder.setBounds(575, 375, 138, 16);
		contentPane.add(dañoestder);

		final JLabel vidaestder = new JLabel("");
		vidaestder.setBounds(575, 415, 138, 16);
		contentPane.add(vidaestder);

		final JLabel manaestder = new JLabel("");
		manaestder.setBounds(575, 455, 138, 16);
		contentPane.add(manaestder);

		final JLabel velocestder = new JLabel("");
		velocestder.setBounds(575, 495, 138, 16);
		contentPane.add(velocestder);

		final JLabel armorestder = new JLabel("");
		armorestder.setBounds(575, 535, 138, 16);
		contentPane.add(armorestder);

		final JLabel armormagestder = new JLabel("");
		armormagestder.setBounds(765, 375, 138, 16);
		contentPane.add(armormagestder);

		final JLabel regvidaestder = new JLabel("");
		regvidaestder.setBounds(765, 415, 138, 16);
		contentPane.add(regvidaestder);

		final JLabel regmanaestder = new JLabel("");
		regmanaestder.setBounds(765, 455, 138, 16);
		contentPane.add(regmanaestder);

		final JLabel velocataqestder = new JLabel("");
		velocataqestder.setBounds(763, 495, 138, 16);
		contentPane.add(velocataqestder);

		// Eventos combobox izquierdo
		try {
			File xmlfile = new File("xml/xmlcampeon.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			final Document doc = dBuilder.parse(xmlfile);
			doc.getDocumentElement().normalize();

			comboBoxizq.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (comboBoxizq.getSelectedItem().equals(
							"-Selecciona Campeón-")) {
						dañoestizq.setText("");
						vidaestizq.setText("");
						manaestizq.setText("");
						velocestizq.setText("");
						armorestizq.setText("");
						armormagestizq.setText("");
						regvidaestizq.setText("");
						regmanaestizq.setText("");
						velocataqestizq.setText("");

					}
					for (int f = 0; f < imgcamp.length; f++) {
						if (comboBoxizq.getSelectedItem().equals(
								namechampionsM[f])) {

							imgcampizq[f].setVisible(true);

							NodeList nList = doc
									.getElementsByTagName(namechampions[f]);
							for (int temp = 0; temp < nList.getLength(); temp++) {

								Node nNode = nList.item(temp);

								if (nNode.getNodeType() == Node.ELEMENT_NODE) {

									Element eElement = (Element) nNode;

									dañoestizq.setText(eElement
											.getElementsByTagName("daño")
											.item(0).getTextContent());
									vidaestizq.setText(eElement
											.getElementsByTagName("vida")
											.item(0).getTextContent());
									manaestizq.setText(eElement
											.getElementsByTagName("mana")
											.item(0).getTextContent());
									velocestizq.setText(eElement
											.getElementsByTagName("velocidad")
											.item(0).getTextContent());
									armorestizq.setText(eElement
											.getElementsByTagName("armadura")
											.item(0).getTextContent());
									armormagestizq.setText(eElement
											.getElementsByTagName("armamagica")
											.item(0).getTextContent());
									regvidaestizq.setText(eElement
											.getElementsByTagName("regvida")
											.item(0).getTextContent());
									regmanaestizq.setText(eElement
											.getElementsByTagName("regmana")
											.item(0).getTextContent());
									velocataqestizq
											.setText(eElement
													.getElementsByTagName(
															"velocataque")
													.item(0).getTextContent());
								}
							}

						} else {
							imgcampizq[f].setVisible(false);
						}
					}

				}
			});

			// Eventos combobox derecho
			comboboxder.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if (comboboxder.getSelectedItem().equals(
							"-Selecciona Campeón-")) {
						dañoestder.setText("");
						vidaestder.setText("");
						manaestder.setText("");
						velocestder.setText("");
						armorestder.setText("");
						armormagestder.setText("");
						regvidaestder.setText("");
						regmanaestder.setText("");
						velocataqestder.setText("");

					}

					for (int i = 0; i < imgcamp.length; i++) {

						if (comboboxder.getSelectedItem().equals(
								namechampionsM[i])) {
							imgcamp[i].setVisible(true);
							NodeList nList = doc
									.getElementsByTagName(namechampions[i]);
							for (int temp = 0; temp < nList.getLength(); temp++) {

								Node nNode = nList.item(temp);

								if (nNode.getNodeType() == Node.ELEMENT_NODE) {

									Element eElement = (Element) nNode;

									dañoestder.setText(eElement
											.getElementsByTagName("daño")
											.item(0).getTextContent());
									vidaestder.setText(eElement
											.getElementsByTagName("vida")
											.item(0).getTextContent());
									manaestder.setText(eElement
											.getElementsByTagName("mana")
											.item(0).getTextContent());
									velocestder.setText(eElement
											.getElementsByTagName("velocidad")
											.item(0).getTextContent());
									armorestder.setText(eElement
											.getElementsByTagName("armadura")
											.item(0).getTextContent());
									armormagestder.setText(eElement
											.getElementsByTagName("armamagica")
											.item(0).getTextContent());
									regvidaestder.setText(eElement
											.getElementsByTagName("regvida")
											.item(0).getTextContent());
									regmanaestder.setText(eElement
											.getElementsByTagName("regmana")
											.item(0).getTextContent());
									velocataqestder
											.setText(eElement
													.getElementsByTagName(
															"velocataque")
													.item(0).getTextContent());
								}
							}
						} else {
							imgcamp[i].setVisible(false);
						}

					}

				}
			});
		} catch (Exception E) {

		}

	}
}
