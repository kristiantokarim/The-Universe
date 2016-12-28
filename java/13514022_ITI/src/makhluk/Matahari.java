package makhluk;
/**Kelas 'Matahari'. Turunan (public) dari Bintang
 * @author Malvin J./13514044
 * {@inheritDoc}
 */
public class Matahari extends Bintang {
    /** Ctor makhluk 'Matahari'.
    * Selain atribut id, posisi, dan gambar, nilai atribut dirandom.
    * Gambar = '*'
    *
    * @param id ID
    * @param x absis awal
    * @param y ordinat awal
    * @param time waktu lahir
    *
    */
    public Matahari(final int id, final int x, final int y, final int time) {
        final double kali = 0.8;
        setArah();
        setKekuatan();
        setID(id);
        setPos(x, y);
        setDTime();
        setGambar('@');
        setStartTime(time);
        setCahaya((int) kali * super.getKekuatan());
    }
}
