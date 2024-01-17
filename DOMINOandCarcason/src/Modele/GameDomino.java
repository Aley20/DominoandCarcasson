package Modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameDomino extends Game {

    public GameDomino(int nbJoueur) {
        super(nbJoueur);
        reset();

    }

    @Override
    public void reset() { // commence une nouvelle partie 
        initSacTuile();
        currentTuile = new TuileDomino();
        tuiles = new TuileDomino[LENGTH][LENGTH];
        positionPossibles.clear();
        positionPossibles.add(pInitial);
        jouer(currentTuile, pInitial);
        currentTuile = null;
        currentPlayerIndex = 0;

    }

    public void initSacTuile() {
        for (int i = 0; i < 30; i++) {
            sacDeTuile.add(new TuileDomino());
        }
    }

    public int calculateScore(Position pos) {
        int score = 0;

        TuileDomino top = (TuileDomino) getTuileAtPos(pos.top()), left = (TuileDomino) getTuileAtPos(pos.left()),
                down = (TuileDomino) getTuileAtPos(pos.down()), right = (TuileDomino) getTuileAtPos(pos.rigth());

        if (top != null)
            score += sumArray(top.down);

        if (left != null)
            score += sumArray(left.rigth);

        if (down != null)
            score += sumArray(down.up);

        if (right != null)
            score += sumArray(right.left);

        return score;
    }

    private int sumArray(int[] tab) {
        int sum = 0;
        for (int i : tab)
            sum += i;
        return sum;
    }

    public void ajoutScore(Joueur j, int[] t, int[] tab) {
        int score = 0;
        if (tab != null && t != null) {
            for (int i = 0; i < t.length; i++) {
                score = score + t[i] + tab[i];
            }
        } else if (tab == null) {
            for (int i = 0; i < t.length; i++) {
                score = score + t[i];
            }
        } else {
            for (int i = 0; i < tab.length; i++) {
                score = score + tab[i];
            }
        }

        j.incremente(score);
    }

    @Override
    public TuileDomino generatTuile(int x) {

        x = Math.abs(new Random().nextInt()) % sacDeTuile.size();
        return (TuileDomino) super.generatTuile(x);
    }

    public int getHighScore() {

        int highScore = 0;
        for (Joueur j : players) {
            if (j.point > highScore)
                highScore = j.point;
        }
        return highScore;
    }

    public Joueur getWinner() {
        int highScore = 0;
        Joueur highScorePlayer = players[0];
        for (Joueur j : players) {
            if (j.point > highScore) {
                highScore = j.point;
                highScorePlayer = j;
            }
        }
        return highScorePlayer;
    }

}
