package fr.nnyimc.metier;

public abstract class Emission {

    private String nom;
    private int duree;
    private int debut;
    private int fin;

    public Emission() {

    }

    public Emission(String nom) {
        this.nom = nom;
    }

    public Emission(String nom, int duree) {
        this.nom = nom;
        this.duree = duree;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getDebut() {
        return debut;
    }

    public void setDebut(int debut) {
        if(debut >= 0 && debut <24)
        this.debut = debut;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        fin = debut + duree;

        if(fin > 24)
            fin -= 24;

        this.fin = fin;
    }

    public String toString() {
        return "Nom: " + nom + ", duree: " + getDuree() + " heures";
    }
}
