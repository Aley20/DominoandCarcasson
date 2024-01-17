package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Modele.EventListener;
import Modele.EventManager;
import Modele.Game;
import Modele.GameDomino;
import Modele.Position;
import Modele.Tuile;

public class Affiche implements EventListener {
    JFrame j;
    JPanel panel;
    Game game;
    Board board;

    AffichLog log;
    Case c;
    int nbJoueur;
    JButton generet;
    JButton tourner;
    JButton passerLeTour;

    public Affiche(int nbJoueur) {
        this.nbJoueur = nbJoueur;
        initBoard();
        game.subscribe(this);

        j = new JFrame();
        j.setBounds(0, 0, 1500, 800);
        j.setVisible(true);
        j.setTitle("domino");
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initialisation du panel
        panel = new JPanel();
        panel.setBackground(new Color(88, 41, 0));
        panel.setLayout(null);
        j.add(panel);
        /* log */
        log = new AffichLog();
        log.setBounds(1000, 500, 250, 100);
        panel.add(log);

        // case

        c.setBounds(900, 200, 100, 100);
        panel.add(c);
        c.setVisible(false);

        // generet
        generet = new JButton("Generer");
        generet.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                log.updateLog((game).getCurrentPlayer(), " a generer une tuile");
                c.setTuile((game).generatTuile(0));
                c.setVisible(true);
                game.getPositionPossibles(game.currentTuile);

                board.updateStatus((game).positionPossibles);

            }
        });
        panel.add(generet);
        generet.setBounds(1000, 400, 80, 30);

        tourner = new JButton("tourner");
        panel.add(tourner);
        tourner.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                log.updateLog(game.getCurrentPlayer(), " a tourner sa tuile");
                if ((game).currentTuile == null) {

                    return;
                }

                game.tourne();
                c.setTuile(game.currentTuile);
                game.getPositionPossibles(game.currentTuile);
                board.updateStatus(game.positionPossibles);

            }
        });
        tourner.setBounds(1100, 400, 80, 30);

        passerLeTour = new JButton("passer");
        panel.add(passerLeTour);
        passerLeTour.setBounds(1200, 400, 80, 30);
        passerLeTour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                log.updateLog(((Game) game).getCurrentPlayer(), " a passe son tour"); // "IA a joue "
                c.setVisible(false);

                ((Game) game).currentTuile = null;
                ((Game) game).getPositionPossibles((Tuile) ((Game) game).currentTuile);
                board.updateStatus(((Game) game).positionPossibles);
                ((Game) game).nextPlayer();
                if (((Game) game).getCurrentPlayer().bot) {
                    Position pos = board.game.jouerBot();

                    if (pos != null) {
                        board.cases[pos.x][pos.y].setTuile(board.game.currentTuile);
                        ((Game) game).getPositionPossibles(null);
                        board.updateStatus(board.game.positionPossibles);
                        // updateScore();
                        board.cases[pos.x][pos.y].setBorder((Border) new LineBorder(Color.YELLOW));
                    }
                    ((Game) game).currentTuile = null;
                    ((Game) game).nextPlayer();
                }
            }
        });
        JButton exit = new JButton("exit");
        exit.setBackground(Color.WHITE);
        panel.add(exit);
        exit.setBounds(1050, 10, 80, 30);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                j.dispose();
                new Acceuil();
            }
        });
        panel.add(board);
        board.setBounds(80, 10, 700, 700);

    }

    @Override
    public void update(Object data) {
        boolean gameOver = "finParti".equals((String) data);

        if (gameOver) {
            board.setVisible(false);
            log.setVisible(false);
            passerLeTour.setVisible(false);
            tourner.setVisible(false);
            generet.setVisible(false);

            JLabel sc = new JLabel("Fin de parti");
            sc.setFont(new Font("Serif", Font.ITALIC, 35));
            sc.setBounds(300, 50, 800, 40);
            sc.setForeground(Color.white);
            panel.add(sc);

            JButton replay = new JButton("Replay");
            replay.setBounds(400, 400, 100, 40);
            replay.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    j.dispose();
                    new Acceuil();
                }
            });
            panel.add(replay);
            this.panel.repaint();
            return;
        }
        Boolean generet = "generatTuile".equals((String) data);
        if (generet) {
            log.updateLog(((Game) game).getCurrentPlayer(), " a generer une tuile");

        }
        Boolean tourner = "tourne".equals((String) data);
        if (tourner) {
            log.updateLog(((Game) game).getCurrentPlayer(), " a tourner sa tuile");
        }

    }

    public void initBoard() {

    }

    public void coloreCaseAcotee(Tuile t) {
        LinkedList<Position> l = ((Game) game).getPositionPossibles(t);
        for (int index = 0; index < l.size(); index++) {
            ((BoardDomino) board).getCase(l.get(index)).setBackground(Color.BLUE);
        }

    }

}
