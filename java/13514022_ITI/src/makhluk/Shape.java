package makhluk;
import java.util.Random;
/**
* @author Malvin J/13514044
* {@inheritDoc}
*/
public class Shape extends Makhluk {
    /** Besar kekuatan makhluk.
     * Konstan sepangjang hidup namun nilai dirandom saat inisiasi.*/
    private int kekuatan; //Besar kekuatan makhluk
    /** Waktu kelahiran/waktu mulai makhluk. */
    private int starttime; //Waktu kelahiran objek
    /** Arah pergerakan makhluk, sesuai arah mata angin:
     *U (Utara), T (Timur), S (Selatan), B (Barat),
     * A (Timur Laut), C (Tenggara), D (Barat Daya), E (Barat Laut). */
    private char arahGerak; //Arah pergerakan makhluk
    /** ID makhluk. Nilai ID seluruh makhluk unik. */
    private int id; // ID makhluk (unik)
    /** Koordinat makhluk di dunia. Menggunakan tipe data Point. */
    private Point pos; //Koordinat posisi makhluk
    /** Delta waktu/ interval gerak makhluk (konstan namun dirandom). */
    private int dTime; //delts waktu pergerakan makhluk
    /** Karakter yang merepresentasikan bentuk makhluk. */
    private char gambar; //Gambar/bentuk makhluk
    /**
    * Fungsi untuk mendapatkan posisi absis makhluk.
    * @return int titikX
    */
    @Override
    public final int getX() {
        return pos.getX();
    }
    /**
    * Fungsi untuk mendapatkan posisi ordinat makhluk.
    * @return int titikY
    */
    @Override
    public final int getY() {
        return pos.getY();
    }
    /** Fungsi untuk mendapatkan kekuatan makhluk.
    * @return int kekuatan.
    */
    @Override
    public int getKekuatan() {
        return kekuatan;
    }
    /**
    * Fungsi untuk mendapatkan arah makhluk (pure virtual).
    * Kode arah : U (Utara), T (Timur), S (Selatan), B (Barat),
    * A (Timur Laut), C (Tenggara), D (Barat Daya), E (Barat Laut)
    * @return int titikX
    */
    @Override
    public final char getArah() {
        return arahGerak;
    }
    /**
    * Fungsi untuk mendapatkan ID makhluk.
    * ID setiap makhluk unik
    * @return int IDMakhluk
    *
    */
    @Override
    public final int getID() {
        return id;
    }
    /**
    * Fungsi untuk mendapatkan delta waktu makhluk.
    * @return int deltaTime
    */
    @Override
    public final int getDTime() {
        return dTime;
    }
    /** Fungsi untuk mendapatkan gambar atau bentuk makhluk.
    * @return char gambar
    */
    @Override
    public final char getGambar() {
        return gambar;
    }
    /** Fungsi untuk mendapatkan waktu mulai atau waktu kelahiran makhluk.
    * @return int waktuMulai
    */
    @Override
    public final int getStartTime() {
        return starttime;
    }
    /**
    * Setter kekuatan shape. Besar kekuatan dirandom (10~100).
    */
    public final void setKekuatan() {
    //Setter nilai kekuatan makhluk. Penentuan besar kekuatan dirandom (10~100)
    //I.S:-
    //F.S: Besar kekuatan makhluk terdefinisikan (random)
        final int min = 10, max = 100;
        kekuatan = min + (int) (Math.random() * ((max - min) + 1));
    }
    /**
    * Setter startTime.
    * @param startTimeObject waktu mulai objek
    */
    public final void setStartTime(final int startTimeObject) {
        starttime = startTimeObject;
    }
     /**
    * Setter position makhluk.
    * @param a absis
    * @param b ordinat
    */
    public final void setPos(final int a, final int b) {
        pos = new Point(a, b);
    }
    /**
    * Setter arah gerak shape pada saat penciptaan.
    * Arah dirandom (U,T,S,B,A,C,D,E).
    **/
    public final void setArah() {
    //Setter arah gerak makhluk. Penentuan arah dirandom
    //(sesuai arah mata angin)
    //I.S:-
    //F.S: Arah gerak makhluk terdefinisikan (random)
        final int min = 1, max = 8, arah;
        final int tiga = 3, empat = 4, lima = 5, enam = 6, tujuh = 7, eight = 8;
        arah = min + (int) (Math.random() * ((max - min) + 1));
        switch (arah) {
            case 1 : arahGerak = 'U'; break; //Utara, delta (0,1)
            case 2 : arahGerak = 'T'; break; //Timur, delta (1,0)
            case tiga : arahGerak = 'S'; break; //Selatan, delta (0,-1)
            case empat : arahGerak = 'B'; break; //Barat, delta (-1,0)
            case lima : arahGerak = 'A'; break; //Timur Laut, delta (1,1)
            case enam : arahGerak = 'C'; break; //Tenggara, delta (1,-1)
            case tujuh : arahGerak = 'D'; break; //Barat Daya, delta (-1,-1)
            case eight : arahGerak = 'E'; break; //Barat Laut, delta (-1,1)
            default : arahGerak = 'X'; break;
        }
    }
    /**
    * Setter arah gerak shape. Arah tidak dirandom.
    * @param a char arah yang diset.
    */
    public final void setArah(final char a) {
    //Setter arah gerak makhluk.
    //I.S: Nilai a terdefinisikan
    //F.S: Arah gerak makhluk terdefinisikan
        arahGerak = a;
    }
    /**
    * Setter ID shape.
    * @param v int ID
    *
    */
    public final void setID(final int v) {
    //Setter nilai ID makhluk.
    //I.S: Nilai pengisi ID, v, terdefinisikan
    //F.S: ID makhluk terdefinisikan
        id = v;
    }
    /**
    * Setter delta time shape (random).
    */
    public final void setDTime() {
    //Setter nilai delta waktu makhluk. Penentuan nilai dirandom (1~6)
    //I.S:-
    //F.S: Besar delta waktu makhluk terdefinisikan (random)
        Random rand = new Random(System.nanoTime());
        final int four = 6;
        dTime = Math.abs((rand.nextInt() % four)) + 1;
    }
    /**
    * Setter gambar shape.
    * @param d char gambar
    */
    public final void setGambar(final char d) {
    //Setter gambar makhluk.
    //I.S: Char pengisi gambar, d, terdefinisikan.
    //F.S: Gambar makhluk terdefinisikan
        gambar = d;
    }
    /**
    * Memindahkan posisi sebesar parameter.
    * @param a int delta X
    * @param b int delta Y
    */
    public final void movePos(final int a, final int b) {
    //Menggerakkan makhluk sebanyak _x,_y (tidak bergantung mata angin. (PURE)
    //I.S: Nilai penggerak terdefinisikan.
    //F.S: Koordinat posisi makhluk berubah menjadi (x+ _x), (y+ _y)
        pos.movePoint(a, b);
    }
    /**
    * Setter kekuatan.
    *
    * @param pow int kekuatan
    *
    */
    public final void setKekuatan(final int pow) {
        kekuatan = pow;
    }
    //Setter nilai kekuatan (tidak dirandom, untuk dari pembacaan file).
    //I.S: Nilai pengisi kekuatan pow terdefinisikan.
    //F.S: Besar kekuatan makhluk terdefinisikan menjadi sebesar pow.
    /**
    * Setter delta time shape.
    *
    * @param time int delta waktu
    *
    */
    public final void setDTime(final int time) {
        dTime = time;
    }
    //Setter nilai delta waktu (tidak dirandom, untuk dari pembacaan file).
    //I.S: Nilai pengisi kekuatan time terdefinisikan.
    //F.S: Besar delta waktu makhluk terdefinisikan menjadi sebesar time.

}
