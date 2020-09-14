package fr.nnyimc.metier;

public class Fiction extends Emission implements IFiction{
    private int anneeRealisation;
    private String realisateur;
    private boolean rediffusion;

    public Fiction() {
        super();
    }

    public Fiction(String n, int d, int aR, String real, boolean redif) {
        super(n, d);
        anneeRealisation = aR;
        realisateur = real;
        rediffusion = redif;
    }

    public int getAnneeRealisation() {
        return anneeRealisation;
    }

    public void setAnneeRealisation(int anneeRealisation) {
        this.anneeRealisation = anneeRealisation;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public boolean isRediffusion() {
        return rediffusion;
    }

    public void setRediffusion(boolean rediffusion) {
        this.rediffusion = rediffusion;
    }

    public String toString(){
        return super.toString() + ", année de Réalisation: " + anneeRealisation + " \r\n"
                + " réalisateur: " + realisateur + ", rediffusion: " + rediffusion;
    }
}
