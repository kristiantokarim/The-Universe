package makhluk;
/** Kelas 'Pesawat'. Turunan (public) dari Shape
 * @author Sashi Novita Sari/13514027
 * {@inheritDoc}
 */
public class Pesawat extends Shape {
    /** Ctor makhluk 'Pesawat'.
    */
    public Pesawat() {
        setArah('U');
        setKekuatan(0);
        setID(0);
        setStartTime(0);
        setPos(0, 0);
        setDTime(0);
        setGambar('-');
    }

    /** Ctor makhluk 'Pesawat'.
    * Selain atribut id, posisi, dan gambar, nilai atribut dirandom.
    * Gambar = 'P'
    *
    * @param id ID
    * @param x absis awal
    * @param y ordinat awal
    * @param time waktu lahir
    *
    */
    public Pesawat(final int id, final int x, final int y, final int time) {
        //final double kali = 0.3;
        setArah();
        setKekuatan();
        setStartTime(time);
        setID(id);
        setPos(x, y);
        setDTime();
        setGambar('P');
    }
}
