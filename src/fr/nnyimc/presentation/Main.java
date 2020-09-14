package fr.nnyimc.presentation;

import fr.nnyimc.metier.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springIOC-config.xml");
        IGrilleProgramme grille = (IGrilleProgramme) context.getBean("grille");

        // Setting d
        IDivertissement d = (IDivertissement) context.getBean("divertissement");
        ((Emission)d).setNom("La Roue de la Fortune");
        ((Divertissement)d).setAnimateur("Philippe Risoli");

        // Setting f
        IFiction f = (IFiction) context.getBean("fiction");
        ((Emission)f).setNom("La Traversée de Paris");
        ((Emission)f).setDuree(2);
        ((Fiction)f).setRealisateur("Claude Autant-Lara");
        ((Fiction)f).setAnneeRealisation(1956);
        ((Fiction)f).setRediffusion(true);

        // Setting f1
        IFiction f1 = (IFiction) context.getBean("fiction");
        ((Emission)f1).setNom("Super 8");
        ((Emission)f1).setDuree(3);
        ((Fiction)f1).setRealisateur("JJ Abrams");
        ((Fiction)f1).setAnneeRealisation(2011);
        ((Fiction)f1).setRediffusion(true);

        // Setting ra
        IReportageAnimalier ra = (IReportageAnimalier) context.getBean("repAnim");
        ((Emission)ra).setNom("Le Tigre du Bengale");
        ((Emission)ra).setDuree(1);

        // Setting rc
        IReportageInformation ri = (IReportageInformation) context.getBean("repInfo");
        ((Emission)ri).setNom("Tchernobyl, 20 ans après");
        ((Emission)ri).setDuree(1);

        // Setting rc
        IReportageCulturel rc = (IReportageCulturel) context.getBean("repCult");
        ((Emission)rc).setNom("La Fête des Voisins");
        ((Emission)rc).setDuree(1);

        grille.programmerEmission((Emission) d);
        grille.programmerEmission((Emission) f1);
        grille.programmerEmission((Emission) f);
        grille.programmerEmission((Emission) rc);
        grille.programmerEmission((Emission) ri);
        grille.programmerEmission((Emission) ra);
        System.out.println( "\r\n" + grille.toString() + "\r\n");
    }
}
