package controller;

import model.Afdeling;
import model.Persoon;
import model.Werknemer;
import model.Zzper;

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

        Werknemer baas = new Werknemer("Mark", "Den Haag", afdelingen[2], 10000);
        Werknemer medewerker = new Werknemer("Caroline", "Delft", afdelingen[1], 4000);
        Zzper assistent = new Zzper("Klaas", "Diemen", afdelingen[3], 50.00);

        assistent.huurIn(160);

        System.out.printf("Het aantal personen in het bedrijf is %d.\n", Persoon.aantalPersonen);
        System.out.printf(baas.toString());
        System.out.printf(medewerker.toString());
        System.out.printf(assistent.toString());

        System.out.printf("%s verdient %.2f per jaar\n", baas.getNaam(), baas.berekenJaarinkomen());
        System.out.printf("%s verdient %.2f per jaar\n", medewerker.getNaam(), medewerker.berekenJaarinkomen());
        System.out.printf("%s verdient %.2f per jaar\n", assistent.getNaam(), assistent.berekenJaarinkomen());
    }

}
