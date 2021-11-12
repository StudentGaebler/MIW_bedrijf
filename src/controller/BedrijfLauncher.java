package controller;

import model.*;

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
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Geef de naam: ");
        String naam = keyboard.next();
        System.out.print("Geef de woonplaats: ");
        String woonplaats = keyboard.next();
        System.out.print("Geef de naam van de afdeling: ");
        String naamAfdeling = keyboard.next();
        System.out.print("Geef de plaats van de afdeling: ");
        String plaatsAfdeling = keyboard.next();

        boolean onjuisteInvoer = true;
        while (onjuisteInvoer) {
            System.out.print("Geef het maandsalaris: ");
            try {
                double maandsalaris = keyboard.nextDouble();
                Werknemer nieuweWerknemer = new Werknemer(naam, woonplaats, new Afdeling(naamAfdeling, plaatsAfdeling), maandsalaris);
                System.out.println(nieuweWerknemer);
                onjuisteInvoer = false;
            } catch (InputMismatchException invoerFout) {
                System.out.println("Verkeerde invoer probeer het opnieuw.");
            } catch (IllegalArgumentException maandsalarisFout) {
                System.out.println(maandsalarisFout.getMessage());
            } finally {
                System.out.println("Je invoer is op de juiste wijze afgehandeld.");
                keyboard.nextLine();
            }
        }
    }
}
