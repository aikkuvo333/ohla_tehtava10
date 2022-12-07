/**
 * Main luokka, jossa luodaan kaksi Pelaaja -objektia, sekä Peli -objekti johon luodut pelaajat
 * laitetaan. Pelin pelaaminen tapahtuu tässä luokassa.
 *
 * @author Aivan Vo
 */
public class Main {
    public static void main(String[] args) {
        Pelaaja max = new Pelaaja();
        Pelaaja miriam = new Pelaaja();
        Peli peli = new Peli(max, miriam);

        peli.pelaa();
    }
}
