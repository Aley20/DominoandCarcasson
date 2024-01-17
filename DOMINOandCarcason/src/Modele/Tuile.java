package Modele;

public class Tuile<T> {
    public T up;
    public T down;
    public T rigth;
    public T left;

    public Tuile() {
        init();
    }

    public void init() {

    }

    public void tourner() {

    }

    public boolean compatible(Tuile<T> top, Tuile<T> right, Tuile<T> down, Tuile<T> left) {
        return false;
    }

}
