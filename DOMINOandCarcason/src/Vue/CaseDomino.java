package Vue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Modele.Position;
import Modele.Tuile;
import Modele.TuileDomino;

import javax.swing.*;
import java.awt.*;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CaseDomino extends Case {
    TuileDomino t;

    public CaseDomino() {

    }

    public CaseDomino(BoardDomino board, TuileDomino tuile, Position pos) {

        this.pos = pos;
        this.pos = pos;
        this.board = board;
        t = tuile;
        affiche();
        addEvents();

    }

    public void addEvents() {
        Case caseTmp = this;

        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                clicked("mouseReleased");

            }

            public void clicked(String action) {
                if (t != null || board.game.currentTuile == null && board.game.getCurrentPlayer().bot)
                    return;

                if (board.game.jouer(board.game.currentTuile, pos)) {
                    // board.gui.log.updateLog(board.game.getCurrentPlayer(), " a jou� la tuile " );
                    caseTmp.setTuile(board.game.currentTuile);
                    board.game.currentTuile = null;
                    board.game.getPositionPossibles(null);
                    board.updateStatus(board.game.positionPossibles);
                    board.gui.c.setTuile(null);
                    ((AfficheIG) board.gui).updateScore();
                    board.game.nextPlayer();
                    caseTmp.setBorder((Border) new LineBorder(Color.YELLOW));

                    if (board.game.getCurrentPlayer().bot) {
                        Position pos = board.game.jouerBot();

                        if (pos != null) {
                            // board.gui.log.updateLog(board.game.getCurrentPlayer(), " a jou� la tuile " );
                            board.cases[pos.x][pos.y].setTuile(board.game.currentTuile);
                            board.game.getPositionPossibles(null);
                            board.updateStatus(board.game.positionPossibles);
                            // board.gui.updateScore();
                            board.cases[pos.x][pos.y].setBorder((Border) new LineBorder(Color.YELLOW));
                        } else {
                            // board.gui.log.updateLog(board.game.getCurrentPlayer(), " a pass� son tour");
                        }
                        board.game.currentTuile = null;
                        board.game.nextPlayer();
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
    }

    @Override
    public void setTuile(Tuile tuile) {
        // TODO Auto-generated method stub
        this.setVisible(false);
        t = (TuileDomino) tuile;
        affiche();

    }

    public void coloreCase() {
        this.setBackground(Color.ORANGE);
    }

    @Override
    public void affiche() {
        this.removeAll();

        if (t == null) {
            return;
        }
        t = (TuileDomino) t;

        this.setVisible(true);

        JPanel up = new JPanel();
        this.add(up);

        up.setLayout(new GridLayout(5, 5));
        // result.setSize(200, 200);
        for (int i = 0; i < 25; i++) {
            JLabel tmp = new JLabel("");
            if (i >= 1 && i <= 3) {
                tmp.setText(" " + t.up[i - 1] + " ");
                up.add(tmp);
            } else if (i == 5 || i == 10 || i == 15) {
                if (i == 5) {
                    tmp.setText(" " + t.left[0] + " ");
                } else if (i == 10) {
                    tmp.setText(" " + t.left[1] + " ");
                } else {
                    tmp.setText(" " + t.left[2] + " ");
                }

                up.add(tmp);
            } else if (i == 9 || i == 14 || i == 19) {
                if (i == 9) {
                    tmp.setText(" " + t.rigth[0] + " ");
                } else if (i == 14) {
                    tmp.setText(" " + t.rigth[1] + " ");
                } else {
                    tmp.setText(" " + t.rigth[2] + " ");
                }
                up.add(tmp);
            } else if (i >= 21 && i <= 23) {
                if (i == 21) {
                    tmp.setText(" " + t.down[0] + " ");
                } else if (i == 22) {
                    tmp.setText(" " + t.down[1] + " ");
                } else {
                    tmp.setText(" " + t.down[2] + " ");
                }
                up.add(tmp);
            } else {

                tmp.setText(" ");
                up.add(tmp);
            }

            up.setVisible(true);
            this.setVisible(true);

        }

    }

}
