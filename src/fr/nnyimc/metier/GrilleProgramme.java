package fr.nnyimc.metier;

import java.util.ArrayList;
import java.util.Collections;

public class GrilleProgramme {
    private ArrayList<Emission> grille = new ArrayList<>(Collections.nCopies(24, null));;
    private int debDivert = 18;
    private int debFictionPremiereDiffusion = 21;
    private int debFictionRedif = 0;
    private int[] debReportage = {0, 14};
    private int flag = 0;

    public GrilleProgramme() {

    }

    public GrilleProgramme(ArrayList<Emission>g) {
        grille = g;
    }

    public ArrayList<Emission> getGrille() {
        return grille;
    }

    public void setGrille(ArrayList<Emission> grille) {
        this.grille = grille;
    }


    /**
     * Cette fonction permet de positionner des types de programme selon leur type
     * dans une grille horaire
     * @param e
     */
    public void programmerEmission(Emission e) {

        int duree = e.getDuree();

          // Emissions de divertissement
          if (e instanceof Divertissement) {
              verifierPlage(e, duree, debDivert);

              if (debDivert <= 22)
                  debDivert += duree+1;
          }

          // Emission de type première diffusion de fiction
          if (e instanceof Fiction && !((Fiction) e).isRediffusion()) {
              verifierPlage(e, duree, debFictionPremiereDiffusion);

              if (debFictionPremiereDiffusion <= 23 - duree)
                  debFictionPremiereDiffusion += duree;
          }

          // Emission de type redifussion de fiction
          if (e instanceof Fiction && ((Fiction) e).isRediffusion()) {

              verifierPlage(e, duree, debFictionRedif);

              if (debFictionRedif <= 24 - duree)
                  debFictionRedif += duree;
          }

          // Emission de type reportage
          if (e instanceof Reportage) {
              /*
              * Si l'indicateur est à 1 la fonction d'ajout a accompli sa tache
              * il faut alors le réinitialiser pour pouvoir inspecter les
              * autres valeurs du tableau d'horaire des reportages
              */

              flag = 0;
              for(int i = 0; i < debReportage.length; i++) {
                  for (int j = debReportage[i]; j < 18 ; j++) {
                      if ((j< 6 || j > 13) && flag < 1) {
                          verifierPlage(e, duree, debReportage[i]);
                          debReportage[i]++;
                      }
                  }
              }
          }

    }

    /**
     * Cette fonction permet de s'assurer que
     * le créneau demandé est effectivement disponible
     * @param e
     * @param duree
     * @param debutEmission
     */
    private void verifierPlage(Emission e, int duree, int debutEmission) {

        int finEmission = debutEmission + duree;
        if (finEmission >= 24)
            finEmission = 23;

        if(null==grille.get(debutEmission) && null==grille.get(finEmission)) {

            for (int i = debutEmission; i <= finEmission; i++) {

                    grille.set(i, e);
                    System.out.println("Ajout confirmé: " +
                            i + " heures - " + grille.get(i));

            }
            // Capteur provoquant l'arrêt de la boucle lors de l'ajout d'un reportage
            flag = 1;


        }
        else {
                if (null != grille.get(debutEmission)) {
                    System.out.println("Ajout impossible, plage horaire occupée: " +
                            debutEmission + " heures - " + grille.get(debutEmission));
                } else {
                    System.out.println("Ajout impossible, disponibilité insuffisante.");
                }
        }
    }

    @Override
    public String toString() {
         String descriptif = "";
         for(Emission e: grille) {
             if(null!=e)
                descriptif += e.toString()+"\r\n";
         }
         return descriptif;
    }
}
