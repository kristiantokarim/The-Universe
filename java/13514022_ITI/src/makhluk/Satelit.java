package makhluk;
/** Kelas 'Satelit'. Turunan (public) dari Planet
 * @author Malvin J./13514044
 * {@inheritDoc}
 */
public class Satelit extends Planet {
    /** Ctor makhluk 'Satelit'.
    * Selain atribut id, posisi, dan gambar, nilai atribut dirandom.
    * Gambar = 'C'.
    *
    * @param id ID
    * @param x absis awal
    * @param y ordinat awal
    * @param time waktu lahir
    *
    */
    public Satelit(final int id, final int x, final int y, final int time) {
        final double kali = 0.2;
        setArah();
        setKekuatan();
        setID(id);
        setStartTime(time);
        setPos(x, y);
        setDTime();
        setGambar('C');
        setGravitasi((int) kali * getKekuatan());
    }
}
