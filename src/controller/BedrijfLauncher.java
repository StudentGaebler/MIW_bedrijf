package controller;

import model.Afdeling;
import model.Persoon;
import model.Werknemer;
import model.Zzper;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 05/11/2021
 *
 * Laat de werking van mijn bedrijf zien
 */

public class BedrijfLauncher {

    public static void main(String[] args) {
        // 2) Behoud de array met vier afdelingen, zoals ze al in de main methode staan.
        Afdeling[] afdelingen = new Afdeling[4];

        afdelingen[0] = new Afdeling("Uitvoering", "Hilversum");
        afdelingen[1] = new Afdeling("Support", "Amsterdam");
        afdelingen[2] = new Afdeling("Management", "Almere");
        afdelingen[3] = new Afdeling("Documentatie", "Gouda");

        // 3) Maak een arraylist met objecten van de klasse Persoon met de naam personen.
        ArrayList<Persoon> personen = new ArrayList<>();

        // 4) Vul de arraylist als volgt:
        personen.add(new Werknemer("Mark", "Den Haag", afdelingen[2], 10000));
        personen.add(new Werknemer("Angelique", "Rotterdam", afdelingen[2], 5000));
        personen.add(new Werknemer("Caroline", "Delft", afdelingen[1], 4000));
        personen.add(new Zzper("Klaas", "Diemen", afdelingen[3], 50.00));
        personen.add(new Zzper("Ronald", "Zaandam", afdelingen[0], 80));
        personen.add(new Zzper("Jannie", "Utrecht", afdelingen[0], 60.00));
        personen.add(new Zzper("Anne", "Zwolle", afdelingen[0], 40.00));

        // 5) Gebruik een for-loop met instanceof en typecasting om alle zzp-ers in de arraylist
        // voor 320 uur in te huren.
        for (Persoon persoon : personen) {
            if (persoon instanceof Zzper) {
                ((Zzper) persoon).huurIn(320);
            }
        }

        // sorteer op naam
        Collections.sort(personen);

        // 6) Gebruik een for-loop en de al bestaande methode toonJaarInkomen() om de volgende uitvoer te krijgen:
        for (Persoon persoon : personen) {
            toonJaarinkomen(persoon);
        }
    }

    public static void toonJaarinkomen(Persoon persoon) {
        System.out.printf("%s verdient %.2f per jaar.\n", persoon.getNaam(), persoon.berekenJaarinkomen());
    }

}
