package fr.nnyimc.metier;

public abstract class Reportage extends Emission {
    private final String theme = "";
    public Reportage() {
    }

    public Reportage(String n, int d) {
        super(n, d);
    }

    public String getTheme() {
        return theme;
    }

    public String toString() {
        return super.toString() + ", thème: " + getTheme();
    }

}


