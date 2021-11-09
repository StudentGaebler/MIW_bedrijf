package model;

/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 08/11/2021
 *
 * Beschrijft een afdeling.
 */

public class Afdeling {
    private static final String DEFAULT_AFDELINGS_NAAM = "Onbekend";
    private static final String DEFAULT_AFDELINGS_PLAATS = "Onbekend";

    private String afdelingsnaam;
    private String afdelingsplaats;

    public Afdeling(String afdelingsNaam, String afdelingsPlaats) {
        this.afdelingsnaam = afdelingsNaam;
        this.afdelingsplaats = afdelingsPlaats;
    }

    public Afdeling() {
        this(DEFAULT_AFDELINGS_NAAM, DEFAULT_AFDELINGS_PLAATS);
    }

    @Override
    public String toString() {
        return String.format("afdeling %s te %s", afdelingsnaam, afdelingsplaats);
    }

    public String getAfdelingsnaam() {
        return afdelingsnaam;
    }

    public String getAfdelingsplaats() {
        return afdelingsplaats;
    }
}
