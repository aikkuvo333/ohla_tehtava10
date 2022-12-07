/**
 * Luokka <code>Peli</code> mahdollistaa Kivi-sakset-paperi -pelin luomisen.
 *
 * @author Ira Dook, Aivan Vo
 */
public class Peli {
    /**
     * Muuttuja <code>p1</code> vastaa ensimmäistä Pelaajaa, joka osallistuu peliin.
     */
    Pelaaja p1;
    /**
     * Muuttuja <code>p2</code> vastaa toista Pelaajaa, joka osallistuu peliin.
     */
    Pelaaja p2;
    /**
     * Boolean muuttuja <code>peliKaynnissa</code> kertoo onko peli vielä käynnissä vai päättynyt.
     */
    boolean peliKaynnissa = true;
    /**
     * Muuttuja <code>pelatutPelit</code> vastaa pelattujen pelien lukumäärää.
     */
    int pelatutPelit = 0;
    /**
     * Muuttuja <code>tasapelit</code> vastaa tasapelien lukumäärää.
     */
    int tasapelit = 0;
    /**
     * Muuttuja <code>p1Voitot</code> vastaa Pelaaja 1:n voittojen lukumäärää.
     */
    int p1Voitot;
    /**
     * Muuttuja <code>p2Voitot</code> vastaa Pelaaja 2:n voittojen lukumäärää.
     */
    int p2Voitot;
    /**
     * Muuttuja <code>p1Valinta</code> vastaa Pelaaja 1:n Valintaa.
     */
    Valinta p1Valinta;
    /**
     * Muuttuja <code>p2Valinta</code> vastaa Pelaaja 2:n Valintaa.
     */
    Valinta p2Valinta;

    /**
     * konstruktori, luo Kivisaksetpaperi -pelin, joka sisältää kaksi pelaajaa.
     *
     * @param p1 ensimmäinen Pelaaja -objekti
     * @param p2 toinen Pelaaja -objekti
     */
    public Peli(Pelaaja p1, Pelaaja p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Tarkista kierroksen voittaja ja printtaa tulos.
     * Toista tätä, kunnes jomman kumman pelaajan
     * voittojen määrä on 3.
     */
    public void pelaa() {
        do {
            this.kerroPelitilanne();

            if (tarkistaVoittaja(p1Valinta, p2Valinta) == p2) {
                System.out.println("Voittaja on Pelaaja 2");
            } else if (tarkistaVoittaja(p1Valinta,p2Valinta) == p1) {
                System.out.println("Voittaja on Pelaaja 1");
            } else if (tarkistaTasapeli(p1Valinta, p2Valinta)){
                System.out.println("Tasapeli");
            }
            this.pelatutPelit++;

            if ((p1.getVoitot() >= 3) || (p2.getVoitot() >= 3)) {
                peliKaynnissa = false;
                System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
            }
        } while (peliKaynnissa);
    }

    /**
     * Vertaa Pelaajien Valinnat ja korota voiton määrä sille pelaajalle,
     * joka voittaa.
     *
     * @param p1Valinta Pelaaja 1:n valinta
     * @param p2Valinta Pelaaja 2:n valinta
     * @return Pelaaja -objekti, joka on voittanut
     */
    public Pelaaja tarkistaVoittaja (Valinta p1Valinta, Valinta p2Valinta) {
        if ((p1Valinta == Valinta.sakset & p2Valinta == Valinta.kivi) || (p1Valinta == Valinta.paperi & p2Valinta == Valinta.sakset) || (p1Valinta == Valinta.kivi & p2Valinta == Valinta.paperi)) {
            p2.voitto();
            return p2;
        } else if ((p1Valinta == Valinta.sakset & p2Valinta == Valinta.paperi) || (p1Valinta == Valinta.kivi & p2Valinta == Valinta.sakset) || (p1Valinta == Valinta.paperi & p2Valinta == Valinta.kivi)) {
            p1.voitto();
        }
        return p1;
    }

    /**
     * Tarkistaa, onko tulos tasapeli ja korottaa tasapelimuuttujan arvon yhdellä,
     * mikäli pelaajilla on samat valinnat.
     *
     * @param p1Valinta Pelaaja 1:n valinta
     * @param p2Valinta Pelaaja 2:n valinta
     * @return boolean arvo, true mikäli kyseessä tasapeli
     */
    public boolean tarkistaTasapeli (Valinta p1Valinta, Valinta p2Valinta) {
        if(p1Valinta == p2Valinta) {
            tasapelit++;
            return true;
        }
        return false;
    }

    /**
     * Hakee tasapelien ja molempien pelaajien voittojen määrät ja tulostaa pelitilanteen konsoliin
     */
    public void kerroPelitilanne() {
        System.out.println("Erä: "
                + pelatutPelit + " =====================\n");
        System.out.println("Tasapelien lukumäärä: "
                + tasapelit + "\n");

        p1Valinta = p1.pelaajanValinta();
        p1Voitot = p1.getVoitot();
        System.out.println("Pelaaja 1: " + p1Valinta
                + "\n\t Pelaaja 1:llä koossa " + p1Voitot + " voittoa.");
        p2Valinta = p2.pelaajanValinta();
        p2Voitot = p2.getVoitot();
        System.out.println("Pelaaja 2: " + p2Valinta
                + "\n\t Pelaaja 2:lla koossa " + p2Voitot + " voittoa.");
    }

}
