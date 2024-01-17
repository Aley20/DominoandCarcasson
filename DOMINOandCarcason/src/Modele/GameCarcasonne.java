package Modele;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Vue.AfficheCarcasonne;

public class GameCarcasonne extends Game {

	public final int nbTuile = 30;

	public GameCarcasonne(int nbJoueur) {
		super(nbJoueur);
		reset();

	}

	@Override
	public void reset() { // reinitialise une partie 
		TuileCarcasonne.iniTializeTuiles();
		initSacTuile();
		generatTuile(0);
		tuiles = new TuileCarcasonne[LENGTH][LENGTH];
		positionPossibles.clear();
		positionPossibles.add(pInitial);

		jouer((TuileCarcasonne) currentTuile, pInitial);

		currentTuile = null;
		currentPlayerIndex = 0;

	}

	@Override
	public void initSacTuile() {
		for (int i = 0; i < 30; i++) {
			sacDeTuile.add(new TuileCarcasonne());
		}
	}

	@Override
	public TuileCarcasonne generatTuile(int x) {
		gameOver();

		if (sacDeTuile.size() > 0) {
			this.notify("generatTuile");

			currentTuile = sacDeTuile.remove(x);

			return (TuileCarcasonne) currentTuile;
		}

		return null;
	}

}
