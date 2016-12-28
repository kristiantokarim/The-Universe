package makhluk;
/** Kelas 'Planet'. Turunan (public) dari Shape.
 * @author Malvin J./13514044
 * {@inheritDoc}
 */

public class Planet extends Shape {
    /** Gravitasi yang dimiliki planet. Bernilai 50% dari kekuatan normal. */
    private int gravitasi;

    /** Ctor makhluk 'Planet'.
    * Selain atribut id, posisi, dan gambar, nilai atribut dirandom.
    * Gambar = "A"
    */
    public Planet() {
        setArah('U');
        setKekuatan(0);
        setID(0);
        setStartTime(0);
        setPos(0, 0);
        setDTime(0);
        setGambar('-');
        gravitasi = 0;
    }

    /** Ctor makhluk 'Planet'.
    * Selain atribut id, posisi, dan gambar, nilai atribut dirandom.
    *
    * @param id ID
    * @param x absis awal
    * @param y ordinat awal
    * @param time waktu lahir
    *
    */
    public Planet(final int id, final int x, final int y, final int time) {
        final double kali = 0.5;
        setArah();
        setStartTime(time);
        setKekuatan();
        setID(id);
        setPos(x, y);
        setDTime();
        setGambar('A');
        gravitasi = (int) kali * super.getKekuatan();
    }

    /** Getter kekuatan planet.
    * kekuatan planet = kekuatan + gravitasi (50% kekuatan).
    *
    * @return int kekuatan makhluk
    *
    */
    @Override
    public final int getKekuatan() {
         return super.getKekuatan() + gravitasi;
    }

    /** Setter kekuatan planet.
    * @param gravitasiBaru gravitasi yang akan di-set
    *
    */
    public final void setGravitasi(final int gravitasiBaru) {
         gravitasi = gravitasiBaru;
    }
}
