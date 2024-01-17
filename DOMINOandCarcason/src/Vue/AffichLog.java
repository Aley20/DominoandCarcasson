package Vue;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.Joueur;

public class AffichLog extends JPanel {
     // va afficher le bas "debut de parti , alice joue "

    public AffichLog() {

        this.setSize(200, 100);
        this.setLayout(null);
        JLabel log = new JLabel("Debut de la partie");
        log.setBounds(80, 11, 150, 60);
        this.add(log);

    }

    public void updateLog(Joueur player, String s) {
        this.removeAll();
        this.removeAll();

        JLabel players = new JLabel(player.name + "a " + s);
        players.setBounds(10, 5, 200, 60);
        this.add(players);

        this.revalidate();
        this.repaint();

    }
}
