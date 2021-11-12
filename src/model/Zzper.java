package model;

/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 09/11/2021
 * Beschrijft een zzper
 */

public class Zzper extends Persoon implements Oproepbaar {
    private static final double DEFAULT_UURTARIEF = 0.0;
    private static final int DEFAULT_UREN_GEWERKT = 0;
    private double uurtarief;
    private int urenGewerkt;

    public Zzper(String naam, String woonplaats, Afdeling afdeling, double uurtarief) {
        super(naam, woonplaats, afdeling);
        this.uurtarief = uurtarief;
        this.urenGewerkt = DEFAULT_UREN_GEWERKT;
    }

    @Override
    public void huurIn(int uren) {
        urenGewerkt += uren;
    }

    @Override
    public double berekenJaarinkomen() {
        return urenGewerkt * uurtarief;
    }

    @Override
    public String toString() {
        return String.format("%s en is een zzp-er met een uurtarief van %.2f", super.toString(), uurtarief);
    }
}
