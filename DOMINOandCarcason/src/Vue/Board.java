package Vue;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;

import Modele.Game;
import Modele.Position;
import Modele.Tuile;

public class Board extends JPanel { //plateau
    public Tuile tuiles[][];
    public Case cases[][];
    Game game;
    Affiche gui;

    public Board(Affiche gui, Game game) {
        this.gui = gui;
        this.game = game;
        this.tuiles = (Tuile[][]) game.tuiles;
        this.setLayout(new GridLayout(tuiles.length, tuiles.length));
        this.affiche();
    }

    public void affiche() {

    }

    public Case getCase(Position pos) {
        return cases[pos.x][pos.y];
    }

    /* met les postions possibles en royge */
    public void updateStatus(LinkedList<Position> positionPossibles) {
        for (int i = 0; i < tuiles.length; i++) {
            for (int j = 0; j < tuiles.length; j++) {
                Position pos = new Position(i, j);
                Case caseTmp = getCase(pos);
                if (positionPossibles.contains(pos)) {
                    caseTmp.setBorder((Border) new LineBorder(Color.RED));
                } else {
                    caseTmp.setBorder((Border) new LineBorder(Color.GRAY));
                }
            }
        }
    }

}
