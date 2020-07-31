package fr.nnyimc.presentation;

import fr.nnyimc.metier.*;

public class Main {

    public static void main(String[] args) {
	    Divertissement d = new Divertissement("La Roue de la Fortune", "Philippe Risoli");
	    Fiction f = new Fiction("La Traversée de Paris", 2,1956, "Claude Autant-Lara", true);
        Fiction f1 = new Fiction("Super 8", 3 ,2011, "JJ Abrams", false);
	    ReportageAnimalier ra = new ReportageAnimalier("Le Tigre du Bengale", 1);
        ReportageCulturel rc = new ReportageCulturel("La Fête des Voisins", 1);
        ReportageInformation ri = new ReportageInformation("Tchernobyl, 20 ans après", 1);
        GrilleProgramme gp = new GrilleProgramme();
        gp.programmerEmission(d);
        gp.programmerEmission(f1);
        gp.programmerEmission(f);
        gp.programmerEmission(rc);
        gp.programmerEmission(ri);
        gp.programmerEmission(ra);
        System.out.println( "\r\n" + gp.toString() + "\r\n");
    }
}
