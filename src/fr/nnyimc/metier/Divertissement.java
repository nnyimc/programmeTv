package fr.nnyimc.metier;

public class Divertissement extends Emission {
    private String animateur;
    private final int duree = 2;

    public Divertissement () {

    }

    public Divertissement (String n, String a) {
        super(n);
        animateur = a;
    }

    public String getAnimateur() {
        return animateur;
    }

    public void setAnimateur(String animateur) {
        this.animateur = animateur;
    }

    @Override
    public int getDuree() {
        return duree;
    }

    @Override
    public String toString() {
        return super.toString() + ", animateur: " + animateur;
    }
}
