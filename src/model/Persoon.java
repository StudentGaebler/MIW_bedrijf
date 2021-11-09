package model;


/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 05/11/2021
 *
 * Beschrijft de eigenschappen van een persoon binnen het bedrijf
 */

public class Persoon {
    public static int aantalPersonen = 0;

    protected static final String DEFAULT_NAAM = "Onbekend";
    protected static final String DEFAULT_WOONPLAATS = "Onbekend";

    protected int personeelsNummer;
    protected String naam;
    protected String woonplaats;
    protected Afdeling afdeling;

    public Persoon(String naam, String woonplaats, Afdeling afdeling){
        this.setNaam(naam);
        this.setWoonplaats(woonplaats);
        this.afdeling = afdeling;
        this.personeelsNummer = ++aantalPersonen;
    }

    public Persoon(String naam) {
        this(naam, DEFAULT_WOONPLAATS, new Afdeling());
    }

    public Persoon(){
        this(DEFAULT_NAAM);
    }

    public double berekenJaarinkomen() {
        return 0.0;
    }

    @Override
    public String toString() {
        return String.format("%s woont in %s en werkt op %s", naam, woonplaats, afdeling);
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

    public Afdeling getAfdeling() {
        return afdeling;
    }
}
