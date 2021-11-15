package controller;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 05/11/2021
 *
 * Laat de werking van mijn bedrijf zien
 */

public class BedrijfLauncher {

    public static void main(String[] args) {
        // 4) Lees de afdelingen uit het tekstbestand Afdelingen.txt en voeg ze toe aan de arraylist met
        //de naam afdelingen. Let op: de naam en plaats van de afdeling staan op twee verschillende
        //regels in het tekstbestand.
        ArrayList<Afdeling> afdelingen = new ArrayList<>();
        File afdelingenBestand = new File("resources/Afdelingen.txt");
        try {
            Scanner afdelingenBestandScanner = new Scanner(afdelingenBestand);
            while (afdelingenBestandScanner.hasNextLine()) {
                String afdelingsNaam = afdelingenBestandScanner.nextLine();
                String afdelingsPlaats = afdelingenBestandScanner.nextLine();
                afdelingen.add(new Afdeling(afdelingsNaam, afdelingsPlaats));
            }
        } catch (FileNotFoundException nietGevonden) {
            System.out.println("Het bestand is niet gevonden. Bestandsnaam: " + afdelingenBestand.getAbsolutePath());
        }
        System.out.println(afdelingen);

        //5) Lees vervolgens de diverse personen uit het bestand Personen.csv en voeg ze toe aan een
        //arraylist met de naam personen. Een regel bestaat uit het volgende: type persoon, naam,
        //woonplaats, index van de arraylist afdelingen, maandsalaris/uurtarief/0.
        ArrayList<Persoon> personen = new ArrayList<>();
        File personenBestand = new File("resources/Personen.csv");
        try {
            Scanner personenBestandScanner = new Scanner(personenBestand);
            while (personenBestandScanner.hasNextLine()) {
                String[] regel = personenBestandScanner.nextLine().split(",");
                String typePersoon = regel[0];
                String naam = regel[1];
                String woonplaats = regel[2];
                int indexAfdeling = Integer.parseInt(regel[3]);
                Afdeling afdeling = afdelingen.get(indexAfdeling);
                double ietsMetGeld = Double.parseDouble(regel[4]);

                switch (typePersoon) {
                    case "Werknemer" -> personen.add(new Werknemer(naam, woonplaats, afdeling, ietsMetGeld));
                    case "Zzper" -> personen.add(new Zzper(naam, woonplaats, afdeling, ietsMetGeld));
                    case "Vrijwilliger" -> personen.add(new Vrijwilliger(naam, woonplaats, afdeling));
                }
            }
        } catch (FileNotFoundException nietGevonden) {
            System.out.println("Het bestand is niet gevonden. Bestandsnaam: " + personenBestand);
        }

        // 6) Sorteer de arraylist met personen en druk deze af.
        Collections.sort(personen);

        // 7) Voeg code toe om een uitvoerbestand PersonenPerAfdeling.txt te maken dat er zo
        //uitziet:
        File uitvoerBestand = new File("resources/PersonenPerAfdeling.txt");
        try {
            PrintWriter printWriter = new PrintWriter(uitvoerBestand);
            for (Afdeling afdeling : afdelingen) {
                printWriter.println("Afdeling: " + afdeling.getAfdelingsnaam());
                for (Persoon persoon : personen) {
                    if (afdeling.getAfdelingsnaam().equals(persoon.getAfdeling().getAfdelingsnaam())) {
                        printWriter.println("-- " + persoon);
                    }
                }
                printWriter.println();
            }

            printWriter.close();
        } catch (IOException nietGemaakt) {
            System.out.println("Het bestand kan niet gemaakt worden.");
        }
    }
}
