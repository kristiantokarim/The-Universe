package makhluk;
/**
* @author Malvin J/13514044
* Abstract Class Makhluk
*/
public abstract class Makhluk {
    /**
    * Fungsi untuk mendapatkan posisi absis makhluk.
    * @return int titikX
    */
    public abstract int getX();
    /**
    * Fungsi untuk mendapatkan posisi ordinat makhluk.
    * @return int titikY
    */
    public abstract int getY();
    /** Fungsi untuk mendapatkan kekuatan makhluk.
    * @return int kekuatan
    */
    public abstract int getKekuatan();
    /**
    * Fungsi untuk mendapatkan arah makhluk (pure virtual).
    * Kode arah : U (Utara), T (Timur), S (Selatan), B (Barat),
    * A (Timur Laut), C (Tenggara), D (Barat Daya), E (Barat Laut)
    * @return int titikX
    */
    public abstract char getArah();
    /**
    * Fungsi untuk mendapatkan ID makhluk.
    * ID setiap makhluk unik
    * @return int IDMakhluk
    *
    */
    public abstract int getID();
    /**
    * Fungsi untuk mendapatkan delta waktu makhluk.
    * @return int deltaTime
    */
    public abstract int getDTime();
    /** Fungsi untuk mendapatkan gambar atau bentuk makhluk.
    * @return char gambar
    */
    public abstract char getGambar();
    /** Fungsi untuk mendapatkan waktu mulai atau waktu kelahiran makhluk.
    * @return int waktuMulai
    */
    public abstract int getStartTime();
}
