package lolapp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Toolkit;

public class VPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton[] champbuttons = new JButton[120];
	private String campeones[] = { "aatrox", "ahri", "akali", "alistar",
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

	private int numc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPrincipal frame = new VPrincipal(0);
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
	public VPrincipal(int numc) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VPrincipal.class.getResource("/img/iconloley3.png")));

		this.numc = numc;
		String nombrec = "";
		setBounds(100, 100, 1024, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Loley3 | Campeones");
		JButton button = new JButton("");

		int nummax = numc + 20;
		if (nummax == 120) {
			nummax = numc + 19;

		}
		final int numpag = numc;
		for (int f = numc; f < nummax; f++) {

			champbuttons[f] = new JButton();
			champbuttons[f].setIcon(new ImageIcon(VPrincipal.class
					.getResource("/img/cuadrado" + campeones[f] + ".png")));
			getContentPane().add(champbuttons[f]);
			champbuttons[f].addActionListener(this);

		}
		int x = 55;
		int y = 15;
		for (int f = numc; f < nummax; f++) {
			if (nummax == numc + 19) {
				if (f == nummax - 14) {
					x = 55;
					y = 135;
				} else if (f == nummax - 9) {
					x = 55;
					y = 255;
				} else if (f == nummax - 4) {
					x = 55;
					y = 375;
				}
			} else {

				if (f == nummax - 15) {
					x = 55;
					y = 135;
				} else if (f == nummax - 10) {
					x = 55;
					y = 255;
				} else if (f == nummax - 5) {
					x = 55;
					y = 375;
				}
			}
			champbuttons[f].setBounds(x, y, 100, 100);
			x += 180;
		}

		JButton sigpag = new JButton("");
		sigpag.setIcon(new ImageIcon(VPrincipal.class
				.getResource("/img/arrow_right.png")));
		sigpag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VPrincipal vp2 = new VPrincipal(numpag + 20);
				dispose();
				vp2.setVisible(true);

			}
		});
		if (nummax == 119) {
			sigpag.setVisible(false);
		}
		sigpag.setBounds(976, 252, 48, 43);
		getContentPane().add(sigpag);

		JButton anteriorpag = new JButton("");
		anteriorpag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPrincipal vp2 = new VPrincipal(numpag - 20);
				dispose();
				vp2.setVisible(true);

			}
		});

		JButton buscar = new JButton("");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VBusqueda vb = new VBusqueda();
				dispose();
				vb.setVisible(true);
			}
		});
		buscar.setIcon(new ImageIcon(VPrincipal.class
				.getResource("/img/magnifier.png")));
		buscar.setBounds(976, 295, 48, 43);
		getContentPane().add(buscar);
		anteriorpag.setIcon(new ImageIcon(VPrincipal.class
				.getResource("/img/arrow_left.png")));
		anteriorpag.setBounds(976, 210, 48, 43);
		getContentPane().add(anteriorpag);

		if (nummax == 20) {
			anteriorpag.setVisible(false);
		}

		JButton actualizar = new JButton("");
		actualizar.addActionListener(new ActionListener() {
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
					VPrincipal vp = new VPrincipal(0);
					dispose();
					vp.setVisible(true);

				} catch (Exception e2) {

				}

			}
		});
		actualizar.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/database_refresh.png")));
		actualizar.setBounds(976, 169, 48, 43);
		getContentPane().add(actualizar);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon(VPrincipal.class
				.getResource("/img/Home 2.png")));
		btnNewButton.setBounds(976, 92, 48, 41);
		getContentPane().add(btnNewButton);
		JButton btcompara = new JButton("");
		btcompara.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/Up-Down.png")));
		btcompara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VistaCompara vc = new VistaCompara();
				dispose();
				vc.setVisible(true);
			}
		});

		btcompara.setBounds(976, 130, 48, 41);
		getContentPane().add(btcompara);
		
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

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon(
						VPrincipal.class
								.getResource("/img/league-of-legends-game-hd-wallpaper-1920x1080-1903 copia.jpg")));
		lblNewLabel.setBounds(0, 0, 1055, 746);
		getContentPane().add(lblNewLabel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int f = 0; f < 120; f++) {
			if (e.getSource() == champbuttons[f]) {
				VCampeo vc = new VCampeo(campeones[f], numc);
				dispose();
				vc.setVisible(true);
			}
		}

	}
}
