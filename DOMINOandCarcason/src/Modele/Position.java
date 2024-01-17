package Modele;

public class Position {
    public int x, y;

    public Position() {
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x=" + x + " et y= " + y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Position))
            return false;

        Position p = (Position) o;

        return this.x == p.x && this.y == p.y;
    }

    public Position top() {
        return new Position(x - 1, y);
    }

    public Position left() {
        return new Position(x, y - 1);
    }

    public Position rigth() {
        return new Position(x, y + 1);
    }

    public Position down() {
        return new Position(x + 1, y);
    }

}
