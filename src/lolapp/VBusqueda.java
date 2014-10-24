package lolapp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jaunt.UserAgent;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;

public class VBusqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreDeInvocador;
	private JLabel etiquetas[] = new JLabel[10];
	private JLabel etiquetasis[] = new JLabel[10];
	private JLabel etiquetasmuert[] = new JLabel[10];
	private JLabel resetiquetas[] = new JLabel[10];
	private JLabel resetiquetasis[] = new JLabel[10];
	private JLabel resetiquetasmuert[] = new JLabel[10];
	private JLabel etiquetasminions[] = new JLabel[10];
	private JLabel resetiquetaminions[] = new JLabel[10];
	private JLabel resetiquetatipo[] = new JLabel[10];
	private JLabel imgcamp[] = new JLabel[11];
	private JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VBusqueda frame = new VBusqueda();
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
	public VBusqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				VBusqueda.class.getResource("/img/iconloley3.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Loley3 | Busqueda de Invocadores");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JLabel lblPromedioltimas = new JLabel(
				"Promedio últimas 20 partidas:");
		lblPromedioltimas.setBounds(720, 305, 203, 16);
		contentPane.add(lblPromedioltimas);
		lblPromedioltimas.setVisible(false);

		final JLabel lblAsesinatos = new JLabel("Asesinatos:");
		lblAsesinatos.setBounds(720, 330, 79, 16);
		contentPane.add(lblAsesinatos);
		lblAsesinatos.setVisible(false);

		final JLabel lblAsistencias = new JLabel("Asistencias:");
		lblAsistencias.setBounds(720, 355, 79, 16);
		contentPane.add(lblAsistencias);
		lblAsistencias.setVisible(false);

		final JLabel lblAsistencias_1 = new JLabel("Muertes:");
		lblAsistencias_1.setBounds(720, 380, 79, 16);
		contentPane.add(lblAsistencias_1);
		lblAsistencias_1.setVisible(false);

		final JLabel lblNewLabel = new JLabel("0");
		lblNewLabel.setBounds(862, 333, 61, 16);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);

		final JLabel label = new JLabel("0");
		label.setBounds(862, 355, 61, 16);
		contentPane.add(label);
		label.setVisible(false);

		final JLabel label_1 = new JLabel("0");
		label_1.setBounds(862, 380, 61, 16);
		contentPane.add(label_1);
		label_1.setVisible(false);

		final JLabel lvlsumm = new JLabel("");
		lvlsumm.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lvlsumm.setBounds(464, 37, 125, 19);
		contentPane.add(lvlsumm);

		final JLabel namesumm = new JLabel("");
		namesumm.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		namesumm.setBounds(464, 16, 125, 19);
		contentPane.add(namesumm);

		txtNombreDeInvocador = new JTextField();
		txtNombreDeInvocador.setText("Nombre de Invocador...");
		txtNombreDeInvocador.setBounds(60, 33, 224, 28);
		contentPane.add(txtNombreDeInvocador);
		txtNombreDeInvocador.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VPrincipal vp = new VPrincipal(0);
				dispose();
				vp.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(VPrincipal.class
				.getResource("/img/Home 2.png")));
		btnNewButton.setBounds(976, 92, 48, 41);
		getContentPane().add(btnNewButton);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VCampeonStats vcs = new VCampeonStats();
				dispose();
				vcs.setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon(VPrincipal.class.getResource("/img/table_multiple.png")));
		button_1.setBounds(976, 210, 48, 43);
		getContentPane().add(button_1);
		
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

		int y = 80;
		int x = 60;

		for (int f = 1; f < 11; f++) {

			if (f == 5) {
				y = 80;
				x = 400;
			}
			if (f == 9) {
				y = 80;
				x = 720;
			}

			imgcamp[f] = new JLabel();
			imgcamp[f].setBounds(x, y, 100, 100);
			contentPane.add(imgcamp[f]);
			imgcamp[f].setIcon(new ImageIcon(VBusqueda.class
					.getResource("/img/cuadradocorki.png")));
			imgcamp[f].setVisible(false);
			y += 112;

		}

		y = 35;
		x = 190;

		for (int f = 0; f < 10; f++) {

			if (f == 4) {
				y = 35;
				x = 530;
			}
			if (f == 8) {
				y = 35;
				x = 850;
			}

			etiquetas[f] = new JLabel();
			etiquetas[f].setBounds(x, y, 100, 100);
			contentPane.add(etiquetas[f]);
			etiquetas[f].setText("Asesinatos");

			y += 112;

		}

		y = 35;
		x = 290;

		for (int f = 0; f < 10; f++) {

			if (f == 4) {
				y = 35;
				x = 630;
			}
			if (f == 8) {
				y = 35;
				x = 950;
			}

			resetiquetas[f] = new JLabel();
			resetiquetas[f].setBounds(x, y, 100, 100);
			contentPane.add(resetiquetas[f]);
			resetiquetas[f].setText("Resases");

			y += 112;

		}

		y = 55;
		x = 190;

		for (int f = 0; f < 10; f++) {

			if (f == 4) {
				y = 55;
				x = 530;
			}
			if (f == 8) {
				y = 55;
				x = 850;
			}

			etiquetasis[f] = new JLabel();
			etiquetasis[f].setBounds(x, y, 100, 100);
			contentPane.add(etiquetasis[f]);
			etiquetasis[f].setText("Asistencias");

			y += 112;

		}

		y = 55;
		x = 290;

		for (int f = 0; f < 10; f++) {

			if (f == 4) {
				y = 55;
				x = 630;
			}
			if (f == 8) {
				y = 55;
				x = 950;
			}
			resetiquetasis[f] = new JLabel();
			resetiquetasis[f].setBounds(x, y, 100, 100);
			contentPane.add(resetiquetasis[f]);
			resetiquetasis[f].setText("resasis");

			y += 112;

		}

		y = 75;
		x = 190;

		for (int f = 0; f < 10; f++) {

			if (f == 4) {
				y = 75;
				x = 530;
			}
			if (f == 8) {
				y = 75;
				x = 850;
			}

			etiquetasmuert[f] = new JLabel();
			etiquetasmuert[f].setBounds(x, y, 100, 100);
			contentPane.add(etiquetasmuert[f]);
			etiquetasmuert[f].setText("Muertes");

			y += 112;

		}

		// - - - -

		y = 95;
		x = 190;

		for (int f = 0; f < 10; f++) {

			if (f == 4) {
				y = 95;
				x = 530;
			}
			if (f == 8) {
				y = 95;
				x = 850;
			}

			etiquetasminions[f] = new JLabel();
			etiquetasminions[f].setBounds(x, y, 100, 100);
			contentPane.add(etiquetasminions[f]);
			etiquetasminions[f].setText("Minions");

			y += 112;

		}

		// ----tipo partida

		y = 115;
		x = 190;

		for (int f = 0; f < 10; f++) {

			if (f == 4) {
				y = 115;
				x = 530;
			}
			if (f == 8) {
				y = 115;
				x = 850;
			}

			resetiquetatipo[f] = new JLabel();
			resetiquetatipo[f].setBounds(x, y, 100, 100);
			contentPane.add(resetiquetatipo[f]);
			resetiquetatipo[f].setText("tipo");

			y += 112;

		}

		// ----fin tipo partida

		// - - - -

		y = 75;
		x = 290;

		for (int f = 0; f < 10; f++) {

			if (f == 4) {
				y = 75;
				x = 630;
			}
			if (f == 8) {
				y = 75;
				x = 950;
			}

			resetiquetasmuert[f] = new JLabel();
			resetiquetasmuert[f].setBounds(x, y, 100, 100);
			contentPane.add(resetiquetasmuert[f]);
			resetiquetasmuert[f].setText("resmuer");

			y += 112;

		}

		// - - - -

		y = 95;
		x = 290;

		for (int f = 0; f < 10; f++) {

			if (f == 4) {
				y = 95;
				x = 630;
			}
			if (f == 8) {
				y = 95;
				x = 950;
			}

			resetiquetaminions[f] = new JLabel();
			resetiquetaminions[f].setBounds(x, y, 100, 100);
			contentPane.add(resetiquetaminions[f]);
			resetiquetaminions[f].setText("resminion");

			y += 112;

		}

		// - - - -

		for (int f = 0; f < etiquetas.length; f++) {

			etiquetas[f].setVisible(false);
			etiquetasis[f].setVisible(false);
			etiquetasmuert[f].setVisible(false);
			resetiquetas[f].setVisible(false);
			resetiquetasis[f].setVisible(false);
			resetiquetasmuert[f].setVisible(false);
			etiquetasminions[f].setVisible(false);
			resetiquetaminions[f].setVisible(false);
			resetiquetatipo[f].setVisible(false);

		}

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombreDeInvocador.getText();
				String resultado[];
				String id;
				String name;
				String nivel;
				String campeonjugadoid[] = new String[11];
				String campeonjugadoname[] = new String[11];
				String asesinatos[] = new String[11];
				String muertes[] = new String[11];
				String asistencias[] = new String[11];
				String minions[] = new String[11];
				String tipo[] = new String[11];
				String victoria[] = new String[11];
				int cont = 0;
				String partida[];

				try {

					for (int f = 0; f < muertes.length; f++) {
						muertes[f] = "0";
						campeonjugadoid[f] = "0";
						campeonjugadoname[f] = "0";
						asesinatos[f] = "0";
						asistencias[f] = "0";
					}

					URL web = new URL(
							"https://euw.api.pvp.net/api/lol/euw/v1.4/summoner/by-name/"
									+ nombre
									+ "?api_key=7261b23e-6bba-44c4-ab1e-39a3f715553f");
					URLConnection urlc = web.openConnection();
					urlc.connect();
					InputStreamReader isr = new InputStreamReader(urlc
							.getInputStream());
					BufferedReader br = new BufferedReader(isr);
					resultado = br.readLine().split("\"");

					id = resultado[4].substring(1, resultado[4].indexOf(','));
					name = resultado[1];
					nivel = resultado[12].substring(1, 3);

					URL partidasrecientesurl = new URL(
							"https://euw.api.pvp.net/api/lol/euw/v1.3/game/by-summoner/"
									+ id
									+ "/recent?api_key=7261b23e-6bba-44c4-ab1e-39a3f715553f");
					URLConnection urlc2 = partidasrecientesurl.openConnection();
					urlc2.connect();
					InputStreamReader isr2 = new InputStreamReader(urlc2
							.getInputStream());
					BufferedReader br2 = new BufferedReader(isr2);
					resultado = br2.readLine().split("gameId");

					for (int f = 0; f < resultado.length; f++) {

						partida = resultado[f].split("\"");

						for (int f1 = 0; f1 < partida.length; f1++) {

							if (f > 0) {
								campeonjugadoid[f] = partida[21].substring(1,
										partida[21].indexOf(','));

								tipo[f] = partida[14];

								if (partida[f1].contains("championsKilled")) {
									asesinatos[f] = partida[f1 + 1].substring(
											1, partida[f1 + 1].indexOf(','));

								}

								if (partida[f1].contains("numDeaths")) {
									muertes[f] = partida[f1 + 1].substring(1,
											partida[f1 + 1].indexOf(','));
								}

								if (partida[f1].contains("assists")) {
									asistencias[f] = partida[f1 + 1].substring(
											1, partida[f1 + 1].indexOf(','));
								}

								if (partida[f1].contains("minionsKilled")) {
									minions[f] = partida[f1 + 1].substring(1,
											partida[f1 + 1].indexOf(','));

								}
								if (partida[f1].contains("win")) {
									victoria[f] = partida[f1 + 1].substring(1,
											partida[f1 + 1].indexOf(','));
								}

							}

						}

					}

					for (int f = 1; f < campeonjugadoid.length; f++) {
						URL url3 = new URL(
								"https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/"
										+ campeonjugadoid[f]
										+ "?api_key=7261b23e-6bba-44c4-ab1e-39a3f715553f");

						URLConnection urlc3 = url3.openConnection();
						urlc3.connect();
						InputStreamReader isr3 = new InputStreamReader(urlc3
								.getInputStream());
						BufferedReader br3 = new BufferedReader(isr3);
						resultado = br3.readLine().split("\"");
						campeonjugadoname[f] = resultado[5];

					}

					for (int f = 1; f < asesinatos.length; f++) {
						etiquetas[f - 1].setVisible(true);
						resetiquetas[f - 1].setText(asesinatos[f]);
						resetiquetas[f - 1].setVisible(true);
						etiquetasis[f - 1].setVisible(true);
						resetiquetasis[f - 1].setText(asistencias[f]);
						resetiquetasis[f - 1].setVisible(true);
						etiquetasmuert[f - 1].setVisible(true);
						resetiquetasmuert[f - 1].setText(muertes[f]);
						resetiquetasmuert[f - 1].setVisible(true);
						etiquetasminions[f - 1].setVisible(true);
						resetiquetaminions[f - 1].setVisible(true);
						resetiquetaminions[f - 1].setText(minions[f]);
						resetiquetatipo[f - 1].setVisible(true);
						resetiquetatipo[f - 1].setText(tipo[f]);

						if (victoria[f].equalsIgnoreCase("true")) {
							resetiquetatipo[f - 1].setForeground(Color.green);
						} else {
							resetiquetatipo[f - 1].setForeground(Color.red);
						}

					}

					for (int i = 1; i < campeonjugadoname.length; i++) {
						imgcamp[i].setVisible(true);
						String nminuscula = campeonjugadoname[i].charAt(0) + "";
						nminuscula = nminuscula.toLowerCase();
						nminuscula += campeonjugadoname[i].substring(1);

						imgcamp[i].setIcon(new ImageIcon(VBusqueda.class
								.getResource("/img/alter/cuadrado" + nminuscula
										+ ".png")));

					}
					namesumm.setText(nombre);
					lvlsumm.setText(nivel);

					UserAgent ua = new UserAgent();
					ua.visit("http://euw.op.gg/summoner/userName=" + nombre);
					String promasesin = ua.doc.findFirst(
							"<span class=\"kill\">").innerText();
					String prommuertes = ua.doc.findFirst(
							"<span class=\"death\">").innerText();
					String promasis = ua.doc.findFirst(
							"<span class=\"assist\">").innerText();
					lblNewLabel.setText(promasesin);
					label.setText(prommuertes);
					label_1.setText(promasis);
					lblNewLabel.setVisible(true);
					label.setVisible(true);
					label_1.setVisible(true);
					lblPromedioltimas.setVisible(true);
					lblAsesinatos.setVisible(true);
					lblAsistencias.setVisible(true);
					lblAsistencias_1.setVisible(true);
					

				} catch (Exception ex) {
					System.out.println(ex.toString());
				}

			}

		});
		btnBuscar.setBounds(296, 34, 117, 29);
		contentPane.add(btnBuscar);

	}
}
