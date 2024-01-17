package Vue;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Modele.Position;
import Modele.Tuile;

public class Case extends JPanel {
    Tuile t;
    Position pos;
    Board board;
    int count = 0;

    public Case() {

    }

    public Case(Board board, Tuile tuile, Position position) {
        this();
        t = tuile;
        this.pos = pos;
        this.board = board;
        affiche();

    }

    public void setTuile(Tuile tuile) {
        this.setVisible(false);
        t = tuile;
        affiche();

    }

    public void affiche() {
    }

}
