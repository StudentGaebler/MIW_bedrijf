package model;

/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 09/11/2021
 * Beschrijft een werknemer
 */

public class Werknemer extends Persoon {
    private static final double GRENSWAARDE_BONUS = 4500;
    private static final double DEFAULT_MAANDSALARIS = 0.0;
    private static final int MAANDEN_IN_EEN_JAAR = 12;

    private double maandsalaris;

    public Werknemer(String naam, String woonplaats, Afdeling afdeling, double maandsalaris) {
        super(naam, woonplaats, afdeling);
        this.maandsalaris = maandsalaris;
    }

    public Werknemer(String naam) {
        this(naam, DEFAULT_WOONPLAATS, new Afdeling(), DEFAULT_MAANDSALARIS);
    }

    public Werknemer() {
        this(DEFAULT_NAAM);
    }

    public boolean heeftRechtOpBonus() {
        return maandsalaris >= GRENSWAARDE_BONUS;
    }

    @Override
    public double berekenJaarinkomen() {
        return MAANDEN_IN_EEN_JAAR * maandsalaris + (heeftRechtOpBonus() ? maandsalaris : 0);
    }

    @Override
    public String toString() {
        return String.format("%s en is een werknemer %s recht op een bonus.\n",
                super.toString(), heeftRechtOpBonus() ? "met" : "zonder");
    }
    public void setMaandsalaris(double maandsalaris) {
        if (maandsalaris < 0) {
            System.out.printf("Het maandsalaris mag niet negatief zijn, het wordt nu op %.2f gezet.\n",
                    DEFAULT_MAANDSALARIS);
            this.maandsalaris = DEFAULT_MAANDSALARIS;
        } else {
            this.maandsalaris = maandsalaris;
        }
    }
}
