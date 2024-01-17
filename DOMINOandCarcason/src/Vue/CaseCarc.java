package Vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Modele.Direction;
import Modele.Position;
import Modele.Tuile;
import Modele.TuileCarcasonne;
import Modele.TuileDomino;
import Modele.Type;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;

public class CaseCarc extends Case {
	final String dir = System.getProperty("user.dir");
	TuileCarcasonne t;

	public CaseCarc() {

	}

	public CaseCarc(BoardCarcasonn board, TuileCarcasonne tuile, Position pos) {
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
				System.out.println("clicked");

				if (board.game.jouer(board.game.currentTuile, pos)) {
					// board.gui.log.updateLog(board.game.getCurrentPlayer(), " a jou� la tuile " );
					caseTmp.setTuile(board.game.currentTuile);
					board.game.currentTuile = null;
					board.game.getPositionPossibles(null);
					board.updateStatus(board.game.positionPossibles);
					board.gui.c.setTuile(null);
					// board.gui.updateScore();
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

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
	}

	@Override
	public void setTuile(Tuile tuile) {
		this.setVisible(false);
		t = (TuileCarcasonne) tuile;
		affiche();

	}

	@Override
	public void affiche() {
		this.removeAll();

		if (t == null)
			return;

		JPanel up = new JPanel();
		this.add(up);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(dir + "\\..\\Image\\img\\imageCarcasonne\\" + t.Myid + ".png"));

		} catch (IOException e) {
			try {
				img = ImageIO.read(new File(dir + "/../Image/img/imageCarcasonne/" + t.Myid + ".png"));
			} catch (Exception e1) {
				System.out.println("erreur");
			}

		}

		if (t.direction == Direction.RIGHT)
			img = rotate(img, Math.PI / 2);
		else if (t.direction == Direction.LEFT)
			img = rotate(img, -Math.PI / 2);
		else if (t.direction == Direction.DOWN)
			img = rotate(img, Math.PI);

		JLabel pic = new JLabel(new ImageIcon(img));
		pic.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		up.add(pic);
		this.setVisible(true);

	}

	public static BufferedImage rotate(BufferedImage image, double angle) {
		double sin = Math.abs(Math.sin(angle)), cos = Math.abs(Math.cos(angle));
		int w = image.getWidth(), h = image.getHeight();
		int neww = (int) Math.floor(w * cos + h * sin), newh = (int) Math.floor(h * cos + w * sin);
		GraphicsConfiguration gc = getDefaultConfiguration();
		BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
		Graphics2D g = result.createGraphics();
		g.translate((neww - w) / 2, (newh - h) / 2);
		g.rotate(angle, w / 2, h / 2);
		g.drawRenderedImage(image, null);
		g.dispose();
		return result;
	}

	private static GraphicsConfiguration getDefaultConfiguration() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		return gd.getDefaultConfiguration();
	}

}
