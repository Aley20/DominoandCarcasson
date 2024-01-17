package Vue;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import Modele.GameDomino;

public class Dmd extends JFrame {
    int width = 1200;
    int heigth = 700;
    JPanel content = new JPanel();
    JButton onePLayer = new JButton("ONE PLAYER");
    JButton manyPLayer = new JButton("MANY PLAYERS");

    public Dmd() {

        setBounds(0, 0, 1200, 700);
        setVisible(true);
        setTitle("jeux");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(content);
        // JPanel pers=Personne("src/Image/personne1.jpg");
        // pers.setBounds(100, 100, 160, 250);
        // content.add(pers);
        content.add(onePLayer);
        content.add(manyPLayer);
        content.setLayout(null);
        content.setBackground(new Color(88, 41, 0));

        /* bouttons */
        onePLayer.setBounds(width / 2 - 150, heigth / 2 - 80, 300, 50);
        manyPLayer.setBounds(width / 2 - 150, heigth / 2, 300, 50);
        manyPLayer.setBackground(Color.WHITE);
        onePLayer.setBackground(Color.WHITE);
        manyPLayer.setForeground(new Color(88, 41, 0));
        onePLayer.setForeground(new Color(88, 41, 0));
        /* title */
        JLabel title = new JLabel(" DOMINO ");
        title.setFont(new Font("Serif", Font.ITALIC, 35));
        title.setBounds(30, 10, 1200, 40);
        title.setForeground(Color.white);

        content.add(title);
        action();

    }

    public static void main(String[] args) {
        new Dmd();
    }

    private void action() {
        var tmp = this;
        onePLayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new AfficheIG(1);
                tmp.dispose();

            }
        });
        manyPLayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                content.remove(onePLayer);
                content.remove(manyPLayer);
                content.repaint();
                JLabel seq1Label = new JLabel("nombre de joueur:  (2-4)");

                seq1Label.setBounds(100, 100, 200, 50);
                seq1Label.setForeground(Color.white);
                content.add(seq1Label);

                SpinnerModel model = new SpinnerNumberModel(2, 2, 4, 1);
                JSpinner nbJoueur = new JSpinner(model);
                nbJoueur.setBounds(300, 100, 80, 30);
                content.add(nbJoueur);

                JButton ok = new JButton("OK");
                ok.setBounds(500, 100, 80, 30);
                ok.setBackground(Color.WHITE);
                ok.setForeground(new Color(88, 41, 0));
                content.add(ok);
                ok.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        content.remove(seq1Label);
                        content.remove(nbJoueur);
                        content.remove(ok);
                        content.repaint();
                        int x = (int) nbJoueur.getValue();

                        JButton play = new JButton("PLAY");
                        play.setBounds(width / 2 - 150, 400, 300, 50);
                        play.setBackground(Color.WHITE);
                        play.setForeground(new Color(88, 41, 0));
                        content.add(play);
                        play.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                new AfficheIG(x);
                                tmp.dispose();

                            }
                        });

                    }
                });

            }
        });

    }

    public JPanel Personne(String path, int x, int y) {
        JPanel p = new JPanel();
        p.setBounds(x, y, 200, 300);
        p.setSize(200, 300);
        p.setLayout(null);
        p.setBackground(Color.MAGENTA);
        JLabel name = new JLabel("Alice");
        name.setBounds(20, 210, 50, 30);
        name.setFont(new Font("Serif", Font.BOLD, 22));
        name.setForeground(Color.white);
        p.add(name);
        BufferedImage img;
        try {
            img = ImageIO.read(new File(path));
            JButton pic = new JButton(new ImageIcon(img));
            pic.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            pic.setBounds(5, 5, 150, 200);
            p.add(pic);
        } catch (IOException e) {
            System.out.println("erreur");
        }
        return p;
    }

}
