package fr.nnyimc.metier;

public class ReportageInformation extends Reportage {
    private final String theme = "Information";

    public ReportageInformation() {
    }

    public ReportageInformation(String n, int d) {
        super(n, d);
    }

    public String getTheme() {
        return theme;
    }
}
