import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PeliTest {
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;
    Peli peli;
    Valinta p1valinta;
    Valinta p2valinta;

    @BeforeEach
    void setUp() {
        pelaaja1 = new Pelaaja();
        pelaaja2 = new Pelaaja();
        peli = new Peli(pelaaja1, pelaaja2);
    }

    @Test
    void tasapeli() {
        assertTrue(peli.tarkistaTasapeli(Valinta.kivi, Valinta.kivi));
    }

    @Test
    void p1Voitto() {
        p1valinta = Valinta.sakset;
        p2valinta = Valinta.paperi;
        assertEquals(pelaaja1, peli.tarkistaVoittaja(p1valinta, p2valinta), "Voittajan pitäisi olla Pelaaja 1");
    }

    @Test
    void p2Voitto() {
        p1valinta = Valinta.kivi;
        p2valinta = Valinta.paperi;
        assertEquals(pelaaja2, peli.tarkistaVoittaja(p1valinta, p2valinta), "Voittajan pitäisi olla Pelaaja 2");
    }

    @Test
    void voittolaskuri() {
        pelaaja1.voitto();
        assertEquals(1, pelaaja1.getVoitot(), "voittojen määrä ei noussut");
    }
}