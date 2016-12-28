package controller;
import board.Board;
import makhluk.Shape;
/**
 * @author Taufic L.S./13514022
 * Kelas LifeControl, untuk mengatur seleksi kehidupan dan pergerakan makhluk.
 */
public class LifeControl {
    /** Fungsi untuk menggerakkan suatu objek sesuai dengan arah gerak dan
     *  kondisi dunia.
        Bila objek berapa di ujung dunia, makan objek akan mengubah arah gerak.
    *
    * @param makhluk objek yang digerakkan
    * @param boardID kondisi dunia
    *
    */
    public final void moveObj(final Shape makhluk, final Board boardID) {
    //Menggerakkan objek sesuai dengan arah pergerakan dan kondisi board
    //I.S : makhluk yang akan digerakkan serta board terdefinisi
    //F.S : menggerakkan makhluk sesuai dengan arah gerak (dapat terjadi
    //      perubahan arah bila posisi
    //      makhluk berada di tepi board
        boolean movValid = false; //boolean pengizinan gerak
        //Shape temp;
        int dX = 0, dY = 0;
        //d* = besar pergerakan, t* = posisi akhir (sementara)
        while (!movValid) {
            switch (makhluk.getArah()) {
                case 'U': dX = 0; dY = 1; break; //Arar gerak utara
                case 'T': dX = 1; dY = 0; break; //Arar gerak timur
                case 'S': dX = 0; dY = -1; break; //Arar gerak selatan
                case 'B': dX = -1; dY = 0; break; //Arar gerak barat
                case 'A': dX = 1; dY = 1; break; //Arar gerak timur laut
                case 'C': dX = 1; dY = -1; break; //Arar gerak tenggara
                case 'D': dX = -1; dY = -1; break; //Arar gerak barat daya
                case 'E': dX = -1; dY = 1; break; //Arar gerak barat laut
                default : dX = 2; dY = 2; break;
            }
            int tX = makhluk.getX() + dX;
            int tY = makhluk.getY() + dY;
            //Pengecekan apakah makhluk berada di tepian
            boolean cektX = tX > boardID.getWidth() - 1;
            boolean cektY = tY > boardID.getLength() - 1;
            if ((cektX) || (cektY) || (tX < 0) || (tY < 0)) {
                movValid = false;
            } else {
                movValid = true;
            }
            // Bila makhluk berada ditepian, maka arah gerak diubah
            if (!movValid) {
                switch (makhluk.getArah()) {
                    case 'U': makhluk.setArah('T'); break;
                    case 'T': makhluk.setArah('S'); break;
                    case 'S': makhluk.setArah('B'); break;
                    case 'B': makhluk.setArah('A'); break;
                    case 'A': makhluk.setArah('C'); break;
                    case 'C': makhluk.setArah('D'); break;
                    case 'D': makhluk.setArah('E'); break;
                    case 'E': makhluk.setArah('U'); break;
                    default : makhluk.setArah('X'); break;
                }
            }
        }
    makhluk.movePos(dX, dY); //Menggerakkan makhluk sebanyak d*
    }
}
