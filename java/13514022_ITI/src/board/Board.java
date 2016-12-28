/**
* suatu kelas yang menampilkan tata surya.
* @see board
*/
package board;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import makhluk.Shape;
import spacelist.SpaceList;
/**
 * @author Taufic L.S./13514022
 * Header kelas Board.
 */
public class Board {
    /**
     * method.
     */
    private int[][] matrixBoard; /** matriks semesta.*/
    private static final int DEFAULTLENGTH = 25; /**panjangAwal Semesta.*/
    private static final int DEFAULTWIDTH = 15; /**lebarAwal Semeesta.*/
    private int width; /**lebarSemesta.*/
    private int length; /**panjangSemesta.*/
    /**bintang**/
    private final ImageIcon bintang = new ImageIcon(ClassLoader
                                    .getSystemResource(
                                            "resource/bintang.png"));
    /**plane**/
    private final ImageIcon plane = new ImageIcon(ClassLoader
                                    .getSystemResource(
                                            "resource/plane.png"));
    /**satelit**/
    private final ImageIcon satelit = new ImageIcon(ClassLoader
                                    .getSystemResource(
                                            "resource/satelit.png"));
    /**matahari**/
    private final ImageIcon matahari = new ImageIcon(ClassLoader
                                    .getSystemResource(
                                            "resource/matahari.png"));
    /**ledakan**/
    private final ImageIcon explode = new ImageIcon(ClassLoader
                                    .getSystemResource(
                                            "resource/explode.png"));
    /**planet**/
    private final ImageIcon planet = new ImageIcon(ClassLoader
                                    .getSystemResource(
                                            "resource/planet.png"));
    /** Ctor Board.
    */
    public Board() {
        int i, j;
        length = DEFAULTLENGTH;
        width = DEFAULTWIDTH;
        matrixBoard = new int[width][length];
        for (i = 0; i < width; i++) {
            for (j = 0; j < length; j++) {
                matrixBoard[i][j] = 0;
            }
        }
    }

    /** Function yang mengembalikan panjang dari board.
    * @return int panjangBoard
    */
    public final int getLength() {
        return length;
    }

    /** Function yang mengembalikan lebar dari board.
    * @return int lebarBoard
    */
    public final int getWidth() {
        return width;
    }
    /** Function yang mengembalikan Matriks dari suatu list of makhluk.
     * @param lx list of makhluk
     * @return int[][] matrixBoard
     */
    public final int[][] getMatriks(final SpaceList lx) {
        makeSpace(lx);
        return matrixBoard;
    }
    /** Function yang mengembalikan ID makhluk di Board.
    * @param i indeks baris
    * @param j indeks kolom
    * @return int IDMakhluk
    */
    public final int getBoardID(final int i, final int j) {
        return matrixBoard[i][j];
    }
    /** Method untuk menciptakan semesta.
    * Objek dari semesta dimasukkan ke dalam matriks.
    * @param listOfSpace list makhluk
    */
    public final void makeSpace(final SpaceList listOfSpace) {
        Shape object;
        int i, j;
        for (i = 0; i < width; i++) {
            for (j = 0; j < length; j++) {
                matrixBoard[i][j] = 0;
            }
        }
        int n = -1;
        for (i = 0; i < listOfSpace.getLength(); i++) {
            object = listOfSpace.getObject(i);
            if (matrixBoard[object.getX()][object.getY()] == 0) {
                matrixBoard[object.getX()][object.getY()] = object.getID();
            } else { //collision
                int idVictim = matrixBoard[object.getX()][object.getY()];
                matrixBoard[object.getX()][object.getY()] = n;
                if (idVictim != -1) {
                    Shape victim;
                    victim = listOfSpace.getShape(idVictim);
                    //Inisiasi matriks dengan val_undef (N)
                    //Menghapus objek dari list ketika objek bertabrakkan
                    listOfSpace.deleteList(victim);
                    listOfSpace.deleteList(object);
                } else {
                    listOfSpace.deleteList(object);
                }
            }
        }
    }

    /** Method mengubah id makhluk pada indeks [i,j].
    * @param i indeks baris
    * @param j indeks kolom
    * @param x ID Makhluk baru
    */
    public final void setBoardID(final int i, final int j, final int x) {
        matrixBoard[i][j] = x;
    }

    /** Function untuk mendapatkan isi dari matriks yang akan dicetak.
    * @param listOfSpace list Makhluk
    * @param cetMat matriks label
    */
    public final void printBoard(final SpaceList listOfSpace,
            final JLabel[][] cetMat) {
        int i;
        for (i = 0; i < getWidth(); i++) {
            int j;
            for (j = 0; j < getLength(); j++) {
                if (getBoardID(i, j) == 0) {
                    cetMat[i][j].setIcon(new ImageIcon(""));
                } else {
                    if (getBoardID(i, j) != -1) {
                        if (listOfSpace.getShape(getBoardID(i, j))
                                .getGambar() == 'C') {
                            cetMat[i][j].setIcon(satelit);
                        } else if (listOfSpace.getShape(getBoardID(i, j))
                                .getGambar() == '*') {
                            cetMat[i][j].setIcon(bintang);
                        } else if (listOfSpace.getShape(getBoardID(i, j))
                                .getGambar() == '@') {
                            cetMat[i][j].setIcon(matahari);
                        } else if (listOfSpace.getShape(getBoardID(i, j))
                                .getGambar() == '-') {
                            cetMat[i][j].setIcon(planet);
                        } else if (listOfSpace.getShape(getBoardID(i, j))
                                .getGambar() == 'P') {
                            cetMat[i][j].setIcon(plane);
                        }
                    } else {
                        cetMat[i][j].setIcon(explode);
                    }
                }
            }
        }
    }

    /**
     * Kelas untuk mendapatkan screenshot dari Board.
     * @param component komponen screnshot
     * @return hasil screenshot
     */
    public static BufferedImage getScreenShot(
    final Component component) {

    BufferedImage image = new BufferedImage(
      component.getWidth(),
      component.getHeight(),
      BufferedImage.TYPE_INT_RGB
      );
    // call the Component's paint method, using
    // the Graphics object of the image.
    component.paint(image.getGraphics()); // alternately use .printAll(..)
    return image;
  }
    /** Function untuk mendapatkan isi dari matriks yang akan dicetak ke file
    * eksternal.
    * @param listOfSpace list Makhluk
    * @param x sebuah komponen
    * @throws IOException  jika gagal membentuk file
    */
    public final void printX(final SpaceList listOfSpace,
            final Component x)throws IOException {
        //int i, j;
        //String s = "";
        //int n = -1;
        Date date = new Date();
        SimpleDateFormat strtime = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        File filename = new File("Capture-" + strtime.format(date) + ".png");
        BufferedImage img = getScreenShot(x);
        ImageIO.write(img, "png", filename);
    }
}
