package makhluk;
/** Kelas 'Bintang'. Turunan (public) dari Shape
 * @author Malvin J./13514044
 * {@inheritDoc}
 */
public class Bintang extends Shape {
    /** Nilai cahaya yang dimiliki bintang.
    * Bernilai 30% dari kekuatan normal. */
    //Kekuatan tambahan untuk Planet (0.3*kekuatan)
    private int cahaya;
    //Ctor
    /** ctor 'Bintang'.
    */
    public Bintang() {
        setArah('U');
        setKekuatan(0);
        setID(0);
        setStartTime(0);
        setPos(0, 0);
        setDTime(0);
        setGambar('-');
        cahaya = 0;
    }

    /** Ctor makhluk 'Bintang'.
    * Selain atribut id, posisi, dan gambar, nilai atribut dirandom.
    * Gambar = '*'
    *
    * @param id ID
    * @param x absis awal
    * @param y ordinat awal
    * @param time waktu lahir
    *
    */
    public Bintang(final int id, final int x, final int y, final int time) {
        final double kali = 0.3;
        setArah();
        setKekuatan();
        setStartTime(time);
        setID(id);
        setPos(x, y);
        setDTime();
        setGambar('*');
        cahaya = (int) kali * super.getKekuatan();
    }
    //Getter kekuatan
    /** Getter kekuatan bintang.
    * kekuatan bintang = kekuatan + cahaya (30% kekuatan).
    *
    * @return int kekuatanBintang
    *
    */
    @Override
    public int getKekuatan() {
        return super.getKekuatan() + cahaya;
    }

    /** Setter cahaya bintang.
    * @param cahayaBaru cahaya yang akan di-set
    *
    */
    public final void setCahaya(final int cahayaBaru) {
         cahaya = cahayaBaru;
    }
}
