/**
 * Luokka <code>Valinta</code> sisältää kolme vaihtoehtoa käsimerkille, kivi, paperi ja sakset.
 *
 * @author Aivan Vo
 */
enum Valinta {
    kivi,
    paperi,
    sakset
}

/**
 * Luokka <code>Pelaaja</code> mahdollistaa Pelaaja -objektin luomisen,
 * jonka avulla voidaan generoida pelaajalle Valinta, joka vastaa pelaajan käsimerkkiä.
 *
 * @author Ira Dook, Aivan Vo
 */
public class Pelaaja {
    /**
     * Muuttuja <code>valinta</code> vastaa pelaajan käsimerkkivalintaa.
     */
    Valinta valinta;
    /**
     * Muuttuja <code>voitot</code> vastaa pelaajan voittojen lukumäärää.
     */
    int voitot;

    /**
     * Generoi randomilla yhden käsimerkkivalinnan.
     *
     * @return Valinta -objekti, joka kertoo saadun käsimerkkivalinnan.
     */
    public Valinta pelaajanValinta() {
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0:
                valinta = Valinta.kivi;
                break;
            case 1:
                valinta = Valinta.paperi;
                break;
            case 2:
                valinta = Valinta.sakset;
                break;
        }
        return valinta;
    }

    /**
     * Korottaa pelaajan voiton lukumäärän yhdellä.
     * @return voittojen lukumäärä korotuksen jälkeen.
     */
    public int voitto() {
        return this.voitot++;
    }

    /**
     * Getteri, jolla saa haettua sen hetkisten voittojen lukumäärä.
     * @return voittojen lukumäärä.
     */
    public int getVoitot() {
        return this.voitot;
    }
}
