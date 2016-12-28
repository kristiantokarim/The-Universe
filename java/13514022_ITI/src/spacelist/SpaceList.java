package spacelist;
import java.util.ArrayList;
import makhluk.Shape;

/** Kelas SpaceList. Kelas objek yang menampung makhluk yang sedang hidup./
 * @author Kristianto K./13514075
 */
public class SpaceList  {
    /** vector yang merepresentasikan list dari objek yang sedang hidup. */
    private ArrayList<Shape> listOfObject;

    /** Ctor spacelist.
    */
    public SpaceList() {
        this.listOfObject = new ArrayList<>();
    }
    /** Function untuk menghapus objek x dari spacelist.
    *
    * @param x objek yang dihapus dari list
    * @return Spacelist
    *
    */
    public final SpaceList deleteList(final Shape x) {
        boolean found = false;
        int i = 0;
        while ((!found) && (i < listOfObject.size())) {
            if (x.getID() == listOfObject.get(i).getID()) {

                found = true;
                listOfObject.remove(i);
            } else {
                i++;
            }
        }
        return this;
    }
    /** Function yang mengembalikan objek ber-ID id dari list.
    *
    * @param id ID dari objek yang ingin diambil
    * @return Shape
    *
    */
    public final Shape getShape(final int id) {
        boolean found = false;
        int i = 0;
        while ((!found) && (i < listOfObject.size())) {
            if (listOfObject.get(i).getID() == id) {
                found = true;
            } else {
                i++;
            }
        }
        return listOfObject.get(i);
    }
    /** Method untuk menambahkan objek baru di spacelist.
    * Penambahan dilakukan setelah objek terakhir pada list.
    *
    * @param s shape yang di tambahkan pada list
    *
    */
    public final void setObject(final Shape s) {
        listOfObject.add(s);
    }
    /** Function untuk mengembalikan panjang list.
    *
    * @return int panjangList
    *
    */
    public final int getLength() {
        return listOfObject.size();
    }
    /** Method untuk mendapatkan objek dari list sesuai indeks.
    *
    * @param i indeks objek pada list
    * @return Shape makhluk pada indeks ke-i
    *
    */
    public final Shape getObject(final int i) {
        Shape x;
        x = listOfObject.get(i);
        return x;
    }
    /** Setter objek dengan indeks i, menjadi bernilai X.
    *
    * @param i indeks
    * @param s shape yang melakukan assign
    *
    */
    public final void setList(final int i, final Shape s) {
        listOfObject.set(i, s);
    }
    /** Menghapus seluruh makhluk dari list.
    *
    * @return Spacelist yang sudah dihapus
    *
    */
    public final SpaceList bigBang() {
        listOfObject.clear();
        return this;
    }
    /** Mengecek apakah spacelist isEmpty.
    *
    * @return true jika kosong dan false jika ada
    *
    */
    public final boolean isEmpty() {
        return listOfObject.isEmpty();
    }
}
