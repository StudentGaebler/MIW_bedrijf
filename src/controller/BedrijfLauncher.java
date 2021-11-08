package controller;

import model.Persoon;

/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 05/11/2021
 *
 * Laat de werking van mijn bedrijf zien
 */

public class BedrijfLauncher {

    public static void main(String[] args) {
        System.out.println(Persoon.aantalPersonen);

        Persoon baas = new Persoon("Mark", "Den Haag", 10000);
        System.out.println(Persoon.aantalPersonen);
        System.out.println(baas.getPersoneelsNummer());

        Persoon medewerker = new Persoon("Caroline", "Delft", 4000);
        System.out.println(Persoon.aantalPersonen);
        System.out.println(medewerker.getPersoneelsNummer());

        Persoon assistent = new Persoon ("Klaas");

        Persoon manager = new Persoon();
        System.out.println(Persoon.aantalPersonen);

        System.out.printf("%s verdient %.2f per jaar en heeft %s recht op een bonus.\n", baas.getNaam(),
                baas.berekenJaarinkomen(), baas.heeftRechtOpBonus() ? "wel" : "geen");
        System.out.printf("%s verdient %.2f per jaar en heeft %s recht op een bonus.\n", medewerker.getNaam(),
                medewerker.berekenJaarinkomen(), medewerker.heeftRechtOpBonus() ? "wel" : "geen");
    }
}
