package fr.nnyimc.metier;

public class ReportageCulturel extends Reportage implements IReportageCulturel {
    private final String theme = "Culturel";

    public ReportageCulturel() {
    }

    public ReportageCulturel(String n, int d) {
        super(n, d);
    }

    public String getTheme() {
        return theme;
    }
}
