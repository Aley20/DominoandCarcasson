package Modele;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class TuileCarcasonne extends Tuile<Type> {

	public static LinkedList<Integer> idTuile = new LinkedList<>();

	public int Myid;
	// Type up,down,rigth,left;
	public Direction direction = Direction.UP;
	public static int nbTuile = 30;

	public static void iniTializeTuiles() {

		if (idTuile.size() != 0)
			idTuile.clear();

		for (int i = 0; i < 30; i++) {
			idTuile.add(i);
		}
		System.out.println("hello");

		Collections.shuffle(idTuile);
	}

	public TuileCarcasonne() {
		super();

	}

	@Override
	public void init() {
		this.Myid = idTuile.get(0);

		setInfosTuile();
		idTuile.removeFirst();
	}

	public void remove(int t) {
		for (int i = 0; i < idTuile.size(); i++) {
			if (idTuile.get(i) == t) {
				idTuile.remove(i);
			}
		}
	}

	public void setInfosTuile() {
		if (Myid == 0) {
			this.up = Type.VILLE;
			this.down = Type.FORET;
			this.left = Type.RUE;
			this.rigth = Type.FORET;
			return;
		}
		if (Myid == 1) {
			this.up = Type.RUE;
			this.down = Type.RUE;
			this.left = Type.RUE;
			this.rigth = Type.FORET;
			return;
		}
		if (Myid == 2) {
			this.up = Type.FORET;
			this.down = Type.FORET;
			this.left = Type.FORET;
			this.rigth = Type.FORET;
			return;
		}
		if (Myid == 3) {
			this.up = Type.RUE;
			this.down = Type.RUE;
			this.left = Type.RUE;
			this.rigth = Type.RUE;
			return;
		}
		if (Myid == 4) {
			this.up = Type.FORET;
			this.down = Type.FORET;
			this.left = Type.FORET;
			this.rigth = Type.VILLE;
			return;
		}
		if (Myid == 5) {
			this.up = Type.RUE;
			this.down = Type.VILLE;
			this.left = Type.FORET;
			this.rigth = Type.RUE;
			return;
		}
		if (Myid == 6) {
			this.up = Type.FORET;
			this.down = Type.VILLE;
			this.left = Type.FORET;
			this.rigth = Type.FORET;
			return;
		}
		if (Myid == 7) {
			this.up = Type.FORET;
			this.down = Type.FORET;
			this.left = Type.RUE;
			this.rigth = Type.FORET;
			return;
		}
		if (Myid == 8) {
			this.up = Type.FORET;
			this.down = Type.RUE;
			this.left = Type.RUE;
			this.rigth = Type.FORET;
			return;
		}

		if (Myid == 9) {
			this.up = Type.RUE;
			this.down = Type.VILLE;
			this.left = Type.RUE;
			this.rigth = Type.RUE;
			return;
		}
		if (Myid == 10) {
			this.up = Type.FORET;
			this.down = Type.VILLE;
			this.left = Type.RUE;
			this.rigth = Type.RUE;
			return;
		}
		if (Myid == 11) {
			this.up = Type.VILLE;
			this.down = Type.VILLE;
			this.left = Type.RUE;
			this.rigth = Type.VILLE;
			return;
		}
		if (Myid == 12) {
			this.up = Type.FORET;
			this.down = Type.RUE;
			this.left = Type.RUE;
			this.rigth = Type.VILLE;
			return;
		}
		if (Myid == 13) {
			this.up = Type.RUE;
			this.down = Type.FORET;
			this.left = Type.RUE;
			this.rigth = Type.FORET;
			return;
		}
		if (Myid == 14) {
			this.up = Type.FORET;
			this.down = Type.VILLE;
			this.left = Type.VILLE;
			this.rigth = Type.FORET;
			return;
		}
		if (Myid == 15) {
			this.up = Type.VILLE;
			this.down = Type.FORET;
			this.left = Type.FORET;
			this.rigth = Type.VILLE;
			return;
		}
		if (Myid == 16) {
			this.up = Type.VILLE;
			this.down = Type.RUE;
			this.left = Type.RUE;
			this.rigth = Type.VILLE;
			return;
		}
		if (Myid == 17) {
			this.up = Type.FORET;
			this.down = Type.RUE;
			this.left = Type.RUE;
			this.rigth = Type.FORET;
			return;
		}
		if (Myid == 18) {
			this.up = Type.VILLE;
			this.down = Type.RUE;
			this.left = Type.RUE;
			this.rigth = Type.VILLE;
			return;
		}
		if (Myid == 19) {
			this.up = Type.VILLE;
			this.down = Type.VILLE;
			this.left = Type.FORET;
			this.rigth = Type.VILLE;
			return;
		}
		if (Myid == 20) {
			this.up = Type.FORET;
			this.down = Type.VILLE;
			this.left = Type.RUE;
			this.rigth = Type.RUE;
			return;
		}
		if (Myid == 21) {
			this.up = Type.RUE;
			this.down = Type.VILLE;
			this.left = Type.RUE;
			this.rigth = Type.RUE;
			return;
		}
		if (Myid == 22) {
			this.up = Type.VILLE;
			this.down = Type.VILLE;
			this.left = Type.FORET;
			this.rigth = Type.FORET;
			return;
		}
		if (Myid == 23) {
			this.up = Type.FORET;
			this.down = Type.FORET;
			this.left = Type.RUE;
			this.rigth = Type.RUE;
			return;
		}
		if (Myid == 24) {
			this.up = Type.FORET;
			this.down = Type.RUE;
			this.left = Type.FORET;
			this.rigth = Type.FORET;
			return;
		}

		if (Myid == 25) {
			this.up = Type.FORET;
			this.down = Type.FORET;
			this.left = Type.VILLE;
			this.rigth = Type.VILLE;
			return;
		}
		if (Myid == 26) {
			this.up = Type.VILLE;
			this.down = Type.RUE;
			this.left = Type.VILLE;
			this.rigth = Type.VILLE;
			return;
		}
		if (Myid == 27) {
			this.up = Type.VILLE;
			this.down = Type.RUE;
			this.left = Type.VILLE;
			this.rigth = Type.RUE;
			return;
		}
		if (Myid == 28) {
			this.up = Type.FORET;
			this.down = Type.RUE;
			this.left = Type.RUE;
			this.rigth = Type.FORET;
			return;
		}
		if (Myid == 29) {
			this.up = Type.VILLE;
			this.down = Type.RUE;
			this.left = Type.FORET;
			this.rigth = Type.RUE;
			return;
		}
		if (Myid == 30) {
			this.up = Type.VILLE;
			this.down = Type.VILLE;
			this.left = Type.VILLE;
			this.rigth = Type.VILLE;
			return;
		}

	}

	@Override
	public void tourner() {
		if (direction.equals(Direction.UP)) {
			direction = Direction.RIGHT;
		} else if (direction.equals(Direction.RIGHT)) {
			direction = Direction.DOWN;
		} else if (direction.equals(Direction.DOWN)) {
			direction = Direction.LEFT;
		} else if (direction.equals(Direction.LEFT)) {
			direction = Direction.UP;
		}

		var tmp = up;
		up = left;
		left = down;
		down = rigth;
		rigth = tmp;
	}

	public int valAlatoire() {
		Random rd = new Random();
		int x = rd.nextInt(idTuile.size());

		return idTuile.get(x);
	}

	@Override
	public boolean compatible(Tuile<Type> top, Tuile<Type> right, Tuile<Type> down, Tuile<Type> left) {
		if (top != null && top.down != this.up)
			return false;
		if (right != null && right.left != this.rigth)
			return false;
		if (down != null && down.up != this.down)
			return false;
		if (left != null && left.rigth != this.left)
			return false;

		return true;
	}

	public int getId() {
		return Myid;
	}

}
