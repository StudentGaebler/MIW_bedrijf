package model;

/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 11/11/2021
 * Beschrijft een vrijwilliger.
 */

public class Vrijwilliger extends Persoon implements Oproepbaar {
    private static final int DEFAULT_UREN_GEWERKT = 0;
    private int urenGewerkt;

    public Vrijwilliger(String naam, String woonplaats, Afdeling afdeling) {
        super(naam, woonplaats, afdeling);
        urenGewerkt = DEFAULT_UREN_GEWERKT;
    }

    @Override
    public void huurIn(int uren) {
        urenGewerkt += uren;
    }

    @Override
    public double berekenJaarinkomen() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s en is een vrijwilliger", super.toString());
    }
}
