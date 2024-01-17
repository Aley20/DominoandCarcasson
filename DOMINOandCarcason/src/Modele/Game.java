package Modele;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game extends EventManager {
    public Joueur[] players; //tableau de joeur
    public int currentPlayerIndex = 0;//joueur courant qui joue
    public ArrayList<Tuile> sacDeTuile = new ArrayList<>();//on va tirer dns ce sac
    final int LENGTH = 7; //taille du plateau
    public LinkedList<Position> positionPossibles = new LinkedList<>();//liste des position possible
    public final Position pInitial = new Position((LENGTH - 1) / 2, (LENGTH - 1) / 2);//position de la premier tuile posée au centre
    public Tuile currentTuile;
    public Tuile tuiles[][];

    public Game(int nbJoueur) {
        initJoueur(nbJoueur);

    }

    public void reset() {

    }

    public void initSacTuile() {

    }

    private void initJoueur(int n) {
        if (n == 1) {
            players = new Joueur[2];
            players[0] = new Joueur(false, "Alice");
            players[1] = new Joueur(true, "IA");
            return;
        } else {
            players = new Joueur[n];
            for (int i = 0; i < players.length; i++) {
                players[i] = new Joueur(false, "Joueur " + (i + 1));
            }
        }
    }

    public boolean gameOver() { //verifie juste le nombre de tuile sac detuile
        if (sacDeTuile.size() == 0) {
            this.notify("finParti");
            return true;
        }
        return false;
    }

    public void nextPlayer() { // on regarde d'abord si on a des tuile , si on en a on passe au joueur suivnt
        gameOver();
        currentPlayerIndex = currentPlayerIndex == players.length - 1 ? 0 : currentPlayerIndex + 1;
    }

    public Joueur getCurrentPlayer() {

        return players[currentPlayerIndex];
    }

    public boolean jouer(Tuile tuile, Position pos) {
        if (positionJouable(tuile, pos)) { //verifie si on peut jouuer dans cette case

            tuiles[pos.x][pos.y] = tuile;

            if (!pos.equals(pInitial)) { // si c la posi initial pas de score 
                players[currentPlayerIndex].incremente(3);
            }

            return true;
        }

        return false;
        // TODO Auto-generated method stub

    }

    private boolean positionJouable(Tuile tuile, Position pos) {


        if (getTuileAtPos(pos) != null) 
            return false;

        if (pos.equals(pInitial) && getTuileAtPos(pInitial) == null) //si pos initial et 
            return true;

        Tuile top = getTuileAtPos(pos.top()), left = getTuileAtPos(pos.left()), // on regarde tuile haut ...
                down = getTuileAtPos(pos.down()), right = getTuileAtPos(pos.rigth());
        // au moin un tuile a cot�
        if (top == null && down == null && left == null && right == null)
            return false;

        return tuile.compatible(top, right, down, left);
    }

    public Tuile getTuileAtPos(Position pos) {
        if (positionValide(pos)) {
            return tuiles[pos.x][pos.y];
        }
        return null;
    }

    public boolean positionValide(Position pos) {
        return pos.x >= 0 && pos.x < LENGTH && pos.y >= 0 && pos.y < LENGTH;
    }

    public Tuile generatTuile(int x) {
        gameOver();

        if (sacDeTuile.size() > 0) {
            this.notify("generatTuile");
            currentTuile = sacDeTuile.remove(x);

            return currentTuile;
        }

        return null;
    }

    public Position jouerBot() { //Ia genere une tuile et va jouer 
        Tuile tuile = generatTuile(0);

        for (int i = 1; i <= 4; i++) {
            List<Position> positions = getPositionPossibles(tuile);

            if (positions.size() > 0) {
                Position pos = positions.get(Math.abs(new Random().nextInt()) % positions.size());
                jouer(tuile, pos);
                return pos;
            }

            // tourne(tuile);
        }

        return null;

    }

    public LinkedList<Position> getPositionPossibles(Tuile tuile) {
        if (positionPossibles.size() > 0)
            positionPossibles.clear();

        if (tuile != null)
            for (int i = 0; i < LENGTH; i++) {
                for (int j = 0; j < LENGTH; j++) {
                    Position pos = new Position(i, j);
                    if (positionJouable(tuile, pos)) {
                        positionPossibles.add(pos);
                    }
                }
            }

        return positionPossibles;
    }

    public void tourne() {
        notify("tourne");
        currentTuile.tourner();
    }

}
