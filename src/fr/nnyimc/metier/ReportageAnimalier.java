package fr.nnyimc.metier;

public class ReportageAnimalier extends Reportage {
    private final String theme = "Animalier";

    public ReportageAnimalier() {
    }

    public ReportageAnimalier(String n, int d) {
        super(n, d);
    }

    public String getTheme() {
        return theme;
    }

}
