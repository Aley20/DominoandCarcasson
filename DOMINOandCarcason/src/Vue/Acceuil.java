package Vue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.GameCarcasonne;

public class Acceuil extends JFrame {

	final String dir = System.getProperty("user.dir");
	JPanel accueil = new JPanel();
	int width = 1200;
	int heigth = 700;

	public Acceuil() {

		setBounds(0, 0, 1200, 700);
		setVisible(true);
		setTitle("jeux");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(accueil);

		/* PAnel */
		accueil.setLayout(null);
		accueil.setBackground(new Color(88, 41, 0));

		/* Titre */
		JLabel title = new JLabel(" ACCEUIL DES JEUX ");
		title.setFont(new Font("Serif", Font.ITALIC, 35));
		title.setBounds(30, 10, 1200, 40);
		title.setForeground(Color.white);

		accueil.add(title);

		/* les deux button img */
		BufferedImage img = null;
		BufferedImage img2 = null;
		try {
			img = ImageIO.read(new File(dir + "\\..\\Image\\image1.jpg"));
			img2 = ImageIO.read(new File(dir + "\\..\\Image\\image4.jpg"));

		} catch (IOException e) {

			try {
				img = ImageIO.read(new File(dir + "/../Image/image1.jpg"));
				img2 = ImageIO.read(new File(dir + "/../Image/image4.jpg"));
			} catch (IOException ex) {
				System.out.println("erreur");
			}
		}

		JButton pic = new JButton(new ImageIcon(img));
		pic.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		pic.setBounds(width / 8, heigth / 3, 312, 176);
		//var tmp = this;
		pic.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new AfficheCarcasonne(1);

				//tmp.dispose();

			}
		});
		accueil.add(pic);

		JButton pic1 = new JButton(new ImageIcon(img2));
		pic1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		pic1.setBounds(width / 2, heigth / 3, 312, 176);
		accueil.add(pic1);
		pic1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Dmd();
			//	tmp.dispose();
			}
		});
	}

}
