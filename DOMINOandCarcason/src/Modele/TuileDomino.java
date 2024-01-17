package Modele;

import java.util.Random;

public class TuileDomino extends Tuile<int[]> {

  public TuileDomino() {
    super();

  }

  private void reset() {
  }

  public int[] valAlatoire() {
    Random rd = new Random();
    int r[] = new int[3];
    int x = 10;
    while (x > 6) {
      for (int index = 0; index < r.length; index++) {
        r[index] = rd.nextInt(4);
        // r[index]=2;
      }
      x = r[0] + r[1] + r[2];
    }

    return r;
  }

  @Override
  public void init() {
    up = valAlatoire();
    down = valAlatoire();
    rigth = valAlatoire();
    left = valAlatoire();

  }

  public void affiche() {
    System.out.print("  ");
    for (int i = 0; i < up.length; i++) {
      System.out.print(up[i] + " ");
    }
    System.out.println("  ");
    for (int i = 0; i < up.length; i++) {
      System.out.println(left[i] + "       " + rigth[i]);
    }
    System.out.print("  ");
    for (int i = 0; i < up.length; i++) {
      System.out.print(down[i] + " ");
    }
    System.out.println("  ");

  }

  @Override
  public void tourner() {
    int tmp[] = up;
    up = left;
    left = down;
    down = rigth;
    rigth = tmp;
    up = reverse(up);
    down = reverse(down);
  }

  public static int[] reverse(int a[]) {
    int[] b = new int[a.length];
    int j = a.length;
    for (int i = 0; i < a.length; i++) {
      b[j - 1] = a[i];
      j = j - 1;
    }

    return b;
  }

  @Override
  public boolean compatible(Tuile<int[]> top, Tuile<int[]> right, Tuile<int[]> down, Tuile<int[]> left) {
    if (top != null && !equalTab(this.up, top.down)) {

      return false;
    }

    if (right != null && !equalTab(this.rigth, right.left)) {

      return false;
    }

    if (down != null && !equalTab(this.down, down.up))
      return false;

    if (left != null && !equalTab(this.left, left.rigth))
      return false;

    return true;
  }

  public static boolean equalTab(int[] tab1, int[] tab2) {
    if (tab1.length != tab2.length)
      return false;
    for (int i = 0; i < tab2.length; i++) {
      if (tab1[i] != tab2[i]) {
        return false;
      }
    }
    return true;
  }

}
