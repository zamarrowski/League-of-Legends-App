package lolapp;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.jaunt.Elements;
import com.jaunt.UserAgent;

import javax.swing.JScrollBar;
import java.awt.FlowLayout;
import java.awt.Toolkit;

public class VCampeonStats extends JFrame {

	public static String[][] getTableStatsRows() {

		return null;

	}

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VCampeonStats frame = new VCampeonStats();
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
	public VCampeonStats() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VCampeonStats.class.getResource("/img/iconloley3.png")));
		setTitle("LoLey3 | Estadísticas Campeones");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelrightbuttons = new JPanel();
		panelrightbuttons.setBounds(976, 92, 48, 291);
		contentPane.add(panelrightbuttons);
		panelrightbuttons.setLayout(null);
		final JPanel panelimpact = new JPanel();
		panelimpact.setBounds(155, 95, 637, 423);
		contentPane.add(panelimpact);
		final JPanel damage = new JPanel();
		damage.setBounds(155, 95, 637, 423);
		contentPane.add(damage);
		
		final JPanel panelmostplayed = new JPanel();
		panelmostplayed.setBounds(155, 95, 637, 423);
		contentPane.add(panelmostplayed);
		panelmostplayed.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelmostplayed.setVisible(false);
		panelimpact.setVisible(false);
		damage.setVisible(false);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(0, 6, 48, 41);
		panelrightbuttons.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPrincipal vp = new VPrincipal(0);
				dispose();
				vp.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(VPrincipal.class
				.getResource("/img/Home 2.png")));
		JButton btcompara = new JButton("");
		btcompara.setBounds(0, 46, 48, 41);
		panelrightbuttons.add(btcompara);
		btcompara.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/Up-Down.png")));
		JButton actualizar = new JButton("");
		actualizar.setBounds(0, 85, 48, 43);
		panelrightbuttons.add(actualizar);
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

		JButton buscar = new JButton("");
		buscar.setBounds(0, 208, 48, 43);
		panelrightbuttons.add(buscar);
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VBusqueda vb = new VBusqueda();
				dispose();
				vb.setVisible(true);
			}
		});
		buscar.setIcon(new ImageIcon(VPrincipal.class
				.getResource("/img/magnifier.png")));

		JButton button = new JButton("");
		button.setBounds(0, 248, 48, 43);
		panelrightbuttons.add(button);
		button.setIcon(new ImageIcon(VCampeonStats.class
				.getResource("/img/table_multiple.png")));
		btcompara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VistaCompara vc = new VistaCompara();
				dispose();
				vc.setVisible(true);
			}
		});

		final JPanel paneltopbuttons = new JPanel();
		paneltopbuttons.setBounds(155, 6, 637, 65);

		contentPane.add(paneltopbuttons);

		try {

			paneltopbuttons.setLayout(null);

			JButton btnMsJugados = new JButton("Más jugados");
			final InternetConnection c = new InternetConnection();
			btnMsJugados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (c.getConnection() == true) {
						String[] columnas = { "#", "Campeon",
								"Partidas Jugadas", "Porcentaje de Victoria" };
						ChampionStats cs = new ChampionStats();

						table = new JTable(cs.getMostPlayedStats(), columnas);
						table.getColumnModel().getColumn(0)
								.setPreferredWidth(40);
						table.getColumnModel().getColumn(1)
								.setPreferredWidth(220);
						table.getColumnModel().getColumn(2)
								.setPreferredWidth(220);
						table.getColumnModel().getColumn(3)
								.setPreferredWidth(220);
						JScrollPane scroll = new JScrollPane(table);
						panelmostplayed.add(scroll);
						scroll.setBounds(247, 66, 500, 470);
						panelimpact.setVisible(false);
						damage.setVisible(false);
						panelmostplayed.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null,
								"Necesitas conexión a Internet", "LoLey3",
								JOptionPane.PLAIN_MESSAGE);

					}
				}

			});
			btnMsJugados.setBounds(60, 25, 130, 29);
			paneltopbuttons.add(btnMsJugados);

			JButton btnImpactoEnEl = new JButton("Impacto en el juego");
			btnImpactoEnEl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (c.getConnection() == true) {

						String[] columnsimpact = { "#", "Campeon", "KDA Ratio",
								"Asesinatos", "Muertes", "Asistencias" };
						ChampionStats cs = new ChampionStats();
						table = new JTable(cs.getGameImpact(), columnsimpact);

						JScrollPane scroll = new JScrollPane(table);
						panelimpact.add(scroll);
						scroll.setBounds(247, 66, 500, 470);
						panelmostplayed.setVisible(false);
						damage.setVisible(false);
						panelimpact.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,
								"Necesitas conexion a Internet", "LoLey3",
								JOptionPane.PLAIN_MESSAGE);
					}
				}
			});
			btnImpactoEnEl.setBounds(253, 25, 186, 29);
			paneltopbuttons.add(btnImpactoEnEl);

			JButton btnDaoRealizado = new JButton("Daño realizado");
			btnDaoRealizado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (c.getConnection() == true) {

						String[] columnsimpact = { "#", "Campeon",
								"Daño total", "Daño físico", "Daño mágico" };
						ChampionStats cs = new ChampionStats();
						table = new JTable(cs.getDamageDealt(), columnsimpact);

						JScrollPane scroll = new JScrollPane(table);
						damage.add(scroll);
						scroll.setBounds(247, 66, 500, 470);
						panelimpact.setVisible(false);
						panelmostplayed.setVisible(false);
						damage.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,
								"Necesitas conexión a Internet", "LoLey3",
								JOptionPane.PLAIN_MESSAGE);
					}
				}
			});
			btnDaoRealizado.setBounds(488, 25, 130, 29);
			paneltopbuttons.add(btnDaoRealizado);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
