package controller;

import model.Afdeling;
import model.Persoon;

/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 05/11/2021
 *
 * Laat de werking van mijn bedrijf zien
 */

public class BedrijfLauncher {

    public static void main(String[] args) {
        Afdeling[] afdelingen = new Afdeling[4];

        afdelingen[0] = new Afdeling("Uitvoering", "Hilversum");
        afdelingen[1] = new Afdeling("Support", "Amsterdam");
        afdelingen[2] = new Afdeling("Management", "Almere");
        afdelingen[3] = new Afdeling("Documentatie", "Gouda");

        Persoon baas = new Persoon("Mark", "Den Haag", 10000, afdelingen[2]);
        Persoon medewerker = new Persoon("Caroline", "Delft", 4000, afdelingen[1]);
        Persoon assistent = new Persoon("Klaas");

        System.out.printf("Het aantal personen in het bedrijf is %d.\n", Persoon.aantalPersonen);
        System.out.printf("%s werkt in %s en woont in %s.\n",
                baas.getNaam(), baas.getAfdeling().getAfdelingsPlaats(), baas.getWoonplaats());
        System.out.printf("%s werkt op de afdeling %s en verdient %.2f.\n",
                medewerker.getNaam(), medewerker.getAfdeling().getAfdelingsNaam(), medewerker.getMaandsalaris());
        System.out.printf("%s werkt op de afdeling %s en woont in %s.\n",
                assistent.getNaam(), assistent.getAfdeling().getAfdelingsNaam(), assistent.getWoonplaats());
    }

}
