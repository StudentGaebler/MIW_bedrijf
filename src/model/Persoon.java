package model;


/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 05/11/2021
 *
 * Beschrijft de eigenschappen van een persoon binnen het bedrijf
 */

public class Persoon {
    private static final String DEFAULT_NAAM = "Onbekend";
    private static final int DEFAULT_MAANDSALARIS = 0;
    private static final String DEFAULT_WOONPLAATS = "Onbekend";
    private static final double GRENSWAARDE_BONUS = 4500;

    public static int aantalPersonen = 0;

    private int personeelsNummer;
    private String naam;
    private String woonplaats;
    private double maandsalaris;

    public Persoon(String naam, String woonplaats, double maandsalaris){
        this.setNaam(naam);
        this.setWoonplaats(woonplaats);
        this.setMaandsalaris(maandsalaris);
        this.personeelsNummer = ++aantalPersonen;
    }

    public Persoon(String naam) {
        this(naam, DEFAULT_WOONPLAATS, DEFAULT_MAANDSALARIS);
    }

    public Persoon(){
        this(DEFAULT_NAAM);
    }

    public double berekenJaarinkomen() {
        return maandsalaris * 12;
    }

    public boolean heeftRechtOpBonus() {
        return maandsalaris >= GRENSWAARDE_BONUS;
    }

    public int getPersoneelsNummer() {
        return personeelsNummer;
    }

    public void setPersoneelsNummer(int personeelsNummer) {
        this.personeelsNummer = personeelsNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public double getMaandsalaris() {
        return maandsalaris;
    }

    public void setMaandsalaris(double maandsalaris) {
        if (maandsalaris < 0) {
            System.out.println("Het maandsalaris kan niet negatief zijn. Het maandsalaris wordt 0.");
            this.maandsalaris = 0;
        } else {
            this.maandsalaris = maandsalaris;
        }
    }
}
