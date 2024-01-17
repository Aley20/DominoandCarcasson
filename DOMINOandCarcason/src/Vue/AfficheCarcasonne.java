package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Modele.EventListener;
import Modele.Game;
import Modele.GameCarcasonne;
import Modele.GameDomino;
import Modele.Position;
import Modele.TuileCarcasonne;
import Modele.TuileDomino;

public class AfficheCarcasonne extends Affiche {

	public AfficheCarcasonne(int nbJoueur) {

		super(nbJoueur);

	}

	@Override

	public void initBoard() {
		game = new GameCarcasonne(nbJoueur);
		board = new BoardCarcasonn(this, (GameCarcasonne) game);
		c = new CaseCarc();
	}

}
