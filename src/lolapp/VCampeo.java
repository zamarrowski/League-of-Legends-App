package lolapp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.awt.Font;
import java.awt.Toolkit;

public class VCampeo extends JFrame {

	private JPanel contentPane;
	private static String ncampeon;
	private static int numc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VCampeo frame = new VCampeo(ncampeon, numc);
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
	public VCampeo(String nombre, final int numc) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VCampeo.class.getResource("/img/iconloley3.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		ncampeon = nombre;
		setResizable(false);
		setTitle("Loley3 | Campeon");
		String nombredellabelcampeon = ncampeon.charAt(0) + "";
		nombredellabelcampeon = nombredellabelcampeon.toUpperCase();
		for (int f = 1; f < ncampeon.length(); f++) {
			nombredellabelcampeon += ncampeon.charAt(f);

		}
		JLabel imagencampeon = new JLabel("");
		this.numc = numc;

		imagencampeon.setIcon(new ImageIcon(VCampeo.class
				.getResource("/img/imgcampbuena" + ncampeon + ".jpg")));
		imagencampeon.setBackground(Color.WHITE);
		imagencampeon.setBounds(70, 40, 185, 240);
		contentPane.add(imagencampeon);
		
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

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNombre.setBounds(284, 18, 288, 38);
		contentPane.add(lblNombre);
		lblNombre.setText(nombredellabelcampeon);

		JLabel damage = new JLabel("New label");
		damage.setBounds(329, 84, 163, 16);
		contentPane.add(damage);

		JLabel health = new JLabel("New label");
		health.setBounds(329, 125, 163, 16);
		contentPane.add(health);

		JLabel Damageizq = new JLabel("");
		Damageizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/daño.png")));
		Damageizq.setBounds(284, 68, 32, 32);
		contentPane.add(Damageizq);

		JLabel Vidaizq = new JLabel("");
		Vidaizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/vida.png")));
		Vidaizq.setBounds(284, 108, 33, 33);
		contentPane.add(Vidaizq);

		JLabel manaizq = new JLabel("");
		manaizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/mana.png")));
		manaizq.setBounds(284, 148, 33, 32);
		contentPane.add(manaizq);

		JLabel velocidadizq = new JLabel("");
		velocidadizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/velocidad.png")));
		velocidadizq.setBounds(284, 188, 33, 34);
		contentPane.add(velocidadizq);

		JLabel armaduraizq = new JLabel("");
		armaduraizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/armor.png")));
		armaduraizq.setBounds(284, 228, 32, 31);
		contentPane.add(armaduraizq);

		JLabel resmagicizq = new JLabel("");
		resmagicizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/armormagic.png")));
		resmagicizq.setBounds(539, 68, 33, 33);
		contentPane.add(resmagicizq);

		JLabel regvidaizq = new JLabel("");
		regvidaizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/regevida.png")));
		regvidaizq.setBounds(541, 107, 31, 32);
		contentPane.add(regvidaizq);

		JLabel regmanaizq = new JLabel("");
		regmanaizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/regmana.png")));
		regmanaizq.setBounds(541, 147, 33, 33);
		contentPane.add(regmanaizq);

		JLabel velocidadataqizq = new JLabel("");
		velocidadataqizq.setIcon(new ImageIcon(VistaCompara.class
				.getResource("/img/velocidadatak.png")));
		velocidadataqizq.setBounds(541, 187, 33, 35);
		contentPane.add(velocidadataqizq);

		JLabel mana = new JLabel("");
		mana.setBounds(329, 164, 163, 16);
		contentPane.add(mana);

		JLabel speed = new JLabel("New label");
		speed.setBounds(329, 207, 163, 16);
		contentPane.add(speed);

		JLabel armor = new JLabel("New label");
		armor.setBounds(329, 243, 163, 16);
		contentPane.add(armor);

		JLabel magicresis = new JLabel("");
		magicresis.setBounds(586, 84, 163, 16);
		contentPane.add(magicresis);

		JLabel reghealth = new JLabel("New label");
		reghealth.setBounds(586, 123, 163, 16);
		contentPane.add(reghealth);

		JLabel regmana = new JLabel("New label");
		regmana.setBounds(586, 164, 163, 16);
		contentPane.add(regmana);

		JLabel atackspeed = new JLabel("New label");
		atackspeed.setBounds(586, 206, 163, 16);
		contentPane.add(atackspeed);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VPrincipal v = new VPrincipal(numc);
				dispose();
				v.setVisible(true);
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

		try {
			File xmlfile = new File("xml/xmlcampeon.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlfile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName(ncampeon);
			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					damage.setText(eElement.getElementsByTagName("daño")
							.item(0).getTextContent());
					health.setText(eElement.getElementsByTagName("vida")
							.item(0).getTextContent());
					atackspeed.setText(eElement
							.getElementsByTagName("velocataque").item(0)
							.getTextContent());
					mana.setText(eElement.getElementsByTagName("mana").item(0)
							.getTextContent());
					speed.setText(eElement.getElementsByTagName("velocidad")
							.item(0).getTextContent());
					reghealth.setText(eElement.getElementsByTagName("regvida")
							.item(0).getTextContent());
					regmana.setText(eElement.getElementsByTagName("regmana")
							.item(0).getTextContent());
					armor.setText(eElement.getElementsByTagName("armadura")
							.item(0).getTextContent());
					magicresis.setText(eElement
							.getElementsByTagName("armamagica").item(0)
							.getTextContent());

				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
