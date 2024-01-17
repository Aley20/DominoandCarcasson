package Vue;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Modele.EventListener;
import Modele.GameCarcasonne;
import Modele.GameDomino;
import Modele.Position;
import Modele.TuileDomino;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;

public class AfficheIG extends Affiche {
  AfficheScore score;

  public AfficheIG(int nbJoueur) {
    super(nbJoueur);

    /* score */
    score = new AfficheScore(nbJoueur, this);
    score.setBounds(1000, 50, 250, 100);
    panel.add(score);

    panel.add(score);

  }

  @Override

  public void initBoard() {
    game = new GameDomino(nbJoueur);
    board = new BoardDomino(this, (GameDomino) game);
    c = new CaseDomino();

  }

  public void updateScore() {
    score.updateScore(game.players);
  }

}
