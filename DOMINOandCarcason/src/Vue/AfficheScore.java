package Vue;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.*;

public class AfficheScore extends JPanel {
    AfficheIG a;

    public AfficheScore(int n, AfficheIG a) {
        this.a = a;

        if (n == 1) {
            this.setSize(200, 100);
            JLabel player1 = new JLabel(" player 1 score : 0");
            JLabel player2 = new JLabel(" IA score : 0");
            this.add(player1);
            this.add(player2);
        } else if (n == 2) {
            this.setSize(100, 50);
            JLabel player1 = new JLabel(a.game.players[0].name + " score : 0");
            JLabel player2 = new JLabel(a.game.players[1].name + " score : 0");
            this.add(player1);
            this.add(player2);
        } else if (n == 3) {
            this.setSize(100, 50);
            JLabel player1 = new JLabel(a.game.players[0].name + " score : 0");
            JLabel player2 = new JLabel(a.game.players[1].name + " score : 0");
            JLabel player3 = new JLabel(a.game.players[2].name + " score : 0");
            this.add(player1);
            this.add(player2);
            this.add(player3);
        }

        else if (n == 4) {
            this.setSize(100, 50);
            JLabel player1 = new JLabel(a.game.players[0].name + " score : 0");
            JLabel player2 = new JLabel(a.game.players[1].name + " score : 0");

            JLabel player3 = new JLabel(a.game.players[2].name + " score : 0");
            JLabel player4 = new JLabel(a.game.players[3].name + " score : 0");
            this.add(player1);
            this.add(player2);
            this.add(player3);
            this.add(player4);
        }

        this.setBackground(Color.WHITE);

    }

    public void updateScore(Joueur[] players) {
        this.removeAll();
        for (int i = 0; i < players.length; i++) {
            JLabel player = new JLabel(players[i].name + " score : " + players[i].point);
            this.add(player);
        }
        this.revalidate();
        this.repaint();
    }
}
