package Vue;

import java.awt.Color;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Modele.*;

public class BoardDomino extends Board {

    public BoardDomino(AfficheIG gui, GameDomino game) {
        super(gui, game);
    }

    @Override
    public void affiche() {
        cases = new Case[this.tuiles.length][this.tuiles.length];
        for (int i = 0; i < tuiles.length; i++) {
            for (int j = 0; j < tuiles.length; j++) {
                Case newCase = new CaseDomino(this, (TuileDomino) tuiles[i][j], new Position(i, j));
                newCase.setBorder((Border) new LineBorder(Color.BLUE));

                this.add(newCase);
                cases[i][j] = newCase;
            }
        }

        this.setVisible(true);

    }
}
