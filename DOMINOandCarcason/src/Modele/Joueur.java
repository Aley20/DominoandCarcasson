package Modele;

public class Joueur {
	public String name;
	public int point;
	public boolean bot;

	public Joueur(boolean bot, String name) {
		this.bot = bot;
		this.name = name;
	}

	public void incremente(int n) {
		this.point += n;
	}

}
