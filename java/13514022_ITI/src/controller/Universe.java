package controller;
import board.Board;
import board.JPanelWithBackground;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import javax.swing.JFrame;
import makhluk.Bintang;
import makhluk.Matahari;
import makhluk.Planet;
import makhluk.Satelit;
import makhluk.Shape;
import makhluk.Pesawat;
import spacelist.SpaceList;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/** Kelas Main 'Penciptaan Semesta'.
 * @author Sashi Novita S./13514027
 */
public class Universe extends Thread {
    /**
     * method.
     */
    /**Image untuk giveup**/
    private final ImageIcon giveup = new ImageIcon(
            ClassLoader.getSystemResource("resources/yougiveup.png"));
    /**Image untuk win**/
    private final ImageIcon youwin = new ImageIcon(
            ClassLoader.getSystemResource("resources/youwin.png"));
    /**Image untuk win**/
    private final ImageIcon gameover = new ImageIcon(
            ClassLoader.getSystemResource("resources/gameover.png"));
    /**List container makhluk.*/
    private static SpaceList lis = new SpaceList();
    /**Board semesta.*/
    private static Board x = new Board();
    /**Windows interface.*/
    private static JFrame f = new JFrame("THE UNIVERSE");
    /**Windows interface.*/
    private static JFrame main = new JFrame("THE UNIVERSE");
    /**Ukuran pixel gambar.*/
    private static int pix = 40;
    /**Ukuran JUlabel.*/
    private static JLabel[][] cetMat = new JLabel[x.getWidth()][x.getLength()];
    /**Boolean tombol atas ditekan.*/
    private static boolean up;
    /**Boolean tombol bawah ditekan.*/
    private static boolean down;
    /**Boolean tombol delete ditekan.*/
    private static boolean del;
    /**Boolean tombol spasi ditekan.*/
    private static boolean spasi;
    /**Boolean tombol kanan ditekan.*/
    private static boolean right;
    /**Boolean tombol home ditekan.*/
    private static boolean home;
    /**Boolean tombol kiri ditekan.*/
    private static boolean left;
    /**Boolean jika button start di-klik.*/
    private static boolean startButtonClicked;
    /**Ukuran dari list.*/
    private static int idxList;
    /**Posisi x player.*/
    private static int dX;
    /**Posisi y player.*/
    private static int dY;
    /**id makhluk.*/
    private static int id = 0;
    /**nObjeck menampung banyaknya makhluk yang masih hidup.*/
    private static int nObject;
    /**Level dari permainan.*/
    private static int level;
    /**Magic number 3.*/
    //private final int tiga = 3;
    /**Magic number 4.*/
    private final int empat = 4;
    /**Magic number 5.*/
    private final int lima = 5;
    /**Magic number 6.*/
    private final int enam = 6;
    /**Magic number 8.*/
   // private final int delapan = 8;
    /**Magic number 10.*/
    private final int sepuluh = 10;
    /**Magic number 1000.*/
    private final int seribu = 1000;
    /**Magic number 100.*/
    private final int seratus = 100;
    /**Method untuk mengacak kemunculan makhluk.
    */
    public final void randomizeList() {
        int timex = 0;
         for (int i = 1; i <= nObject; i++) {
            final int minLength = 1;
            final int maxLength = x.getLength() - 1;
            final int minWidth = 1;
            final int maxWidth = x.getWidth() - 1;
            Random rand = new Random(System.nanoTime());
            int xpos, ypos;
            do {
                xpos = Math.abs(rand.nextInt(
                            maxWidth - minWidth + 1) + minWidth);
                ypos = Math.abs(
                                    rand.nextInt(maxLength - minLength + 1)
                                            + minLength);
            }
            while((xpos == lis.getObject(0).getX()) && (ypos == 
                    lis.getObject(0).getY()));
            Shape newobj;
            int object = Math.abs(rand.nextInt() % empat);
            id++;
            if (object == 0) {
                // OBJEK BINTANG DI HASILKAN
                newobj = new Bintang(id, xpos, ypos, timex);
            } else if (object == 1) {
                // OBJEK MATAHARI DI HASILKAN
                newobj = new Matahari(id, xpos, ypos, timex);
            } else if (object == 2) {
                // OBJEK PLANET DI HASILKAN
                newobj = new Planet(id, xpos, ypos, timex);
            } else {
                // OBJEK SATELIT DI HASILKAN
                newobj = new Satelit(id, xpos, ypos, timex);
            }
            // MEMASUKAN OBJEK YANG DI HASILKAN KE DALAM LIST OF OBJECT
            lis.setObject(newobj);
            timex++;
            id++;
            if (timex == enam) {
                timex = 0;
            }
        }
    }
    /**Method untuk menggerakkan posisi objek yang tidak dikendalikan player.
     * @param index merepresentasikan objek ke berapa yang digerakkan
    */
    public final void moveobject(final int index) {
        LifeControl ruler = new LifeControl();
        Shape s = new Shape();
        s = lis.getObject(index);
        ruler.moveObj(s, x);
        lis.setList(index, s);
    }
    /**Method untuk menggerakkan posisi objek yang dikendalikan player.
    */
    public final void moveplayer() {
        Shape s = new Shape();
        s = lis.getObject(0);
        int tempX = dX + s.getX();
        int tempY = dY + s.getY();
        boolean cekX = tempX < x.getWidth() && tempX >= 0;
        boolean cekY = tempY < x.getLength() && tempY >= 0;
        if (cekX && cekY) {
            s.movePos(dX, dY);
        }
        lis.setList(0, s);
    }
    /**Method untuk mencetak keadaan makhluk di alam semesta.
    */
    public final void print() {
        //LifeControl ruler = new LifeControl();
        x.makeSpace(lis); // MEMPOSISIKAN LIST OBJEK KE POSISI PADA MATRIKS
        //ruler.lifeSelection(x, lis, 2); // LIFE SELECTION JIKA DUA OBJEK
        //DALAM 1 SEL
        //String s = x.printBoard(lis);
        //label1.setText(s); // CETAK ISI MATRIKS
        x.printBoard(lis, cetMat);
    }
    /**
     * Method untuk mencetak dummy ke layar console dan berfungsi sebagai dummy
     * untuk mengatasi masalah tidak digunakan (unused variable).
     */
    public final void printDummy() {
        System.out.println("dummy");
    }
    /**
     * Mejalankan perpindahan objek.
    */
    public class MyThread extends Thread {
        @Override
        /**
         * IdxList 0 untuk menggerakkan objek player.
         * IdxList lainnya untuk menggerakkan objek lainnya.
         */
        public final void run() {
            if (idxList == 0) {
                moveplayer();
            } else {
                moveobject(idxList);
            }
        }
    }
    /**
     * Method untuk meletakkan JFrame ke tengah.
     * @param frame Jframe
     */
    public static void centreWindow(final Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int eks = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(eks, y);
    }
    /**Method untuk mencetak keadaan makhluk dalam semesta.
    * @throws IOException  penanganan file eksternal
    * @throws InterruptedException interupsi key
    */
    public Universe() throws InterruptedException, IOException {
        //KAMUS
        int timex = 0;
        int i, j;
        boolean pause = false;
        boolean finish = false;
        //String s = "";
        int maxMakh = level * sepuluh;
        nObject = maxMakh;
        //ALGORITMA
        main.getContentPane().removeAll();
        JPanelWithBackground jwb = new JPanelWithBackground(
                ClassLoader.getSystemResource("resources/back.png"),
                pix * x.getLength(), pix * x.getWidth());
        main.getContentPane().add(jwb);
        jwb.addKeyListener(new MyKeyListener());
        jwb.setLayout(new GridLayout(x.getWidth(), x.getLength()));
        for (i = 0; i < x.getWidth(); i++) {
            for (j = 0; j < x.getLength(); j++) {
                cetMat[i][j] = new JLabel();
                cetMat[i][j].setPreferredSize(new Dimension(pix, pix));
                //cetMat[i][j].setIcon(new ImageIcon("D:\\z.jpg"));
                jwb.add(cetMat[i][j]);
            }
        }
        main.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //f.setPreferredSize(new Dimension(15*x.getWidth(),15*x.getLength()));
        jwb.setPreferredSize(new Dimension(pix * x.getLength(), pix
                * x.getWidth()));
        main.pack();
        main.setVisible(true);
        centreWindow(main);
        id = 1;
        Shape newobj = new Pesawat(id, 0, 0, lima);
        lis.setObject(newobj);
        randomizeList();
        while (!finish && !lis.isEmpty()
                && lis.getObject(0).getID() == 1) {
            jwb.requestFocus();
            nObject = maxMakh - lis.getLength();
            if (nObject > 0) {
                randomizeList();
            }
            dX = 0;
            dY = 0;
            if (up) { //MELAKUKAN PENCIPTAAN
               dY = 0;
               dX = -1;
            } else if (down) { //MEM-PAUSE PROGRAM
                dY = 0;
                dX = 1;
            } else if (right) { //MENGHAPUS SELURUH MAKHLUK PADA BOARD
                dY = 1;
                dX = 0;
            } else if (left) { //KELUAR DARI PROGRAM
                dY = -1;
                dX = 0;
            } else if (spasi) {
                pause = true;
            }
            final int limabelas = 15;
            if (timex == limabelas) {
                timex = 0;
            }
            timex++;
            ArrayList<MyThread> threads = new ArrayList<MyThread>();
            if (lis.getLength() != 0) {
                // PERULANGAN UNTUK MEMINDAHKAN OBJEK SESUAI DELTA TIME MASING
                // MASING
                for (i = 0; i <= lis.getLength() - 1; i++) {
                    idxList = i;
                    MyThread temx = new MyThread();
                    threads.add(temx);
                    temx.start();
                    temx.join();
                }
                threads.clear();
            }
        if (lis.getObject(0).getY() == x.getLength() - 1
                && lis.getObject(0).getX() == x.getWidth() - 1) {
            finish = true;
        }
        x.makeSpace(lis); // POSISIKAN OBJEK - OBJEK DALAM MATRIKS
        x.printBoard(lis, cetMat);
        MILLISECONDS.sleep(seratus);
        if (home) {
            MILLISECONDS.sleep(seribu);
            MILLISECONDS.sleep(seribu);
            x.printX(lis, main.getContentPane());
        }
        MILLISECONDS.sleep(2 * sepuluh);
        // KONDISI JIKA SEDANG PAUSE
        while (pause) {
            // JIKA TOMBOL SPACE DITEKAN LAGI MAKA PROGRAM AKAN PLAY SEPERTI
            // SEMULA
            if (spasi) {
                pause = false;
            }
            MILLISECONDS.sleep(seratus);
        }
        if (del) {
            lis.bigBang();
        }
    }
    jwb.setLayout(null);
    JLabel stats = new JLabel();
    jwb.setBackgroundx(
            ClassLoader.getSystemResource("resources/back1.png"),
                pix * x.getLength(), pix * x.getWidth());
    jwb.removeAll();
    jwb.repaint();
    jwb.setBounds(0, 0, seribu, seratus * enam);
    jwb.add(stats);
    if (!lis.isEmpty()) {
        if (lis.getObject(0).getID() != 1) {
            stats.setIcon(gameover);
            stats.setBounds(seratus * empat, seratus, 2 * seratus, seratus);
        } else {
            stats.setIcon(youwin);
            stats.setBounds(seratus * empat, seratus, 2 * seratus, seratus);
        }
   } else {
            stats.setIcon(giveup);
            stats.setBounds(seratus * empat, seratus, 2 * seratus, seratus);
    }
 }
    /**
     * running main.
     * @param argv untuk menjalankan main
     * @throws InterruptedException penangganan kasus interupsi key
     * @throws IOException penangganan kasus jika ada file yang tidak terbaca
     * @throws Exception penangganan kasus kesalahan
     */
    public static void main(final String[] argv) throws InterruptedException,
            IOException, Exception {
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setPreferredSize(new Dimension(pix * x.getLength(), pix
                * x.getWidth()));
        f.setLayout(null); startButtonClicked = false;
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(ClassLoader.getSystemResource(
                "resources/sBck.png")));
        background.setBounds(0, 0, pix * x.getLength(), pix * x.getWidth());
        JLabel startButton = new JLabel(); JLabel helpButton = new JLabel();
        f.getContentPane().add(startButton); f.getContentPane().add(helpButton);
        startButton.setIcon(new ImageIcon(ClassLoader.getSystemResource(
                "resources/start.png")));
        helpButton.setIcon(new ImageIcon(ClassLoader.getSystemResource(
                "resources/help.png")));
        helpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(final java.awt
                    .event.MouseEvent evt) {
                helpButton.setIcon(new ImageIcon(ClassLoader.getSystemResource(
                        "resources/helpenter.png")));
            }
            public void mouseExited(final java.awt
                    .event.MouseEvent evt) {
                helpButton.setIcon(new ImageIcon(ClassLoader.getSystemResource(
                        "resources/help.png")));
            }
            public void mouseClicked(final java.awt
                    .event.MouseEvent evt) {
                JFrame help = new JFrame(); help.setLayout(null);
                help.setPreferredSize(new Dimension(pix * x.getLength(),
                        pix * x.getWidth()));
                help.setDefaultCloseOperation(EXIT_ON_CLOSE);
                JLabel backButton = new JLabel();
                help.getContentPane().add(backButton);
                backButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseEntered(final java.awt
                            .event.MouseEvent evt) {
                        backButton.setIcon(new ImageIcon(ClassLoader
                                .getSystemResource(
                                        "resources/backButtonenter.png")));
                    }
                    @Override
                    public void mouseExited(final java.awt
                            .event.MouseEvent evt) {
                        backButton.setIcon(new ImageIcon(ClassLoader
                                .getSystemResource("resources/backButton.png")));
                    }
                    @Override
                    public void mouseClicked(final java.awt
                            .event.MouseEvent evt) {
                        f.setVisible(true);
                        help.setVisible(false);
                    }
                });
                backButton.setIcon(new ImageIcon(ClassLoader.getSystemResource(
                        "resources/backButton.png")));
                final int delapanratus = 800;
                final int empatratustujuhpuluh = 470;
                final int seratus = 100; final int limapuluh = 50;
                backButton.setBounds(delapanratus, empatratustujuhpuluh,
                        seratus, limapuluh);
                help.pack(); JLabel helpText = new JLabel();
                helpText.setIcon(new ImageIcon(ClassLoader.getSystemResource(
                        "resources/helpText.png")));
                help.getContentPane().add(helpText);
                final int seribu = 1000; final int enamratus = 600;
                helpText.setBounds(0, 0, seribu, enamratus);
                centreWindow(help); f.setResizable(false); f.setVisible(false);
                help.setVisible(true);
            }
        });
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(final java.awt
                    .event.MouseEvent evt) {
                startButton.setIcon(new ImageIcon(ClassLoader.getSystemResource(
                        "resources/startenter.png")));
            }
            @Override
            public void mouseExited(final java.awt
                    .event.MouseEvent evt) {
                startButton.setIcon(new ImageIcon(ClassLoader.getSystemResource(
                        "resources/start.png")));
            }
            @Override
            public void mouseClicked(final java.awt
                    .event.MouseEvent evt) {
                f.getContentPane().removeAll(); JLabel lev1 = new JLabel();
                lev1.setIcon(new ImageIcon(ClassLoader.getSystemResource(
                        "resources/level1.png")));
                lev1.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseEntered(final java.awt
                            .event.MouseEvent evt) {
                        lev1.setIcon(new ImageIcon(ClassLoader
                                .getSystemResource("resources/"
                                        + "level1enter.png")));
                    }
                    @Override
                    public void mouseExited(final java.awt
                            .event.MouseEvent evt) {
                        lev1.setIcon(new ImageIcon(ClassLoader
                                .getSystemResource("resources/level1.png")));
                    }
                    @Override
                    public void mouseClicked(final java.awt
                            .event.MouseEvent evt) {
                        level = 1; startButtonClicked = true; f.dispose();
                    }
                });
                JLabel lev2 = new JLabel();
                lev2.setIcon(new ImageIcon(ClassLoader.getSystemResource(
                        "resources/level2.png")));
                lev2.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseEntered(final java.awt
                            .event.MouseEvent evt) {
                        lev2.setIcon(new ImageIcon(ClassLoader
                                .getSystemResource("resources/"
                                        + "level2enter.png")));
                    }
                    @Override
                    public void mouseExited(final java.awt
                            .event.MouseEvent evt) {
                        lev2.setIcon(new ImageIcon(ClassLoader
                                .getSystemResource("resources/level2.png")));
                    }
                    @Override
                    public void mouseClicked(final java.awt
                            .event.MouseEvent evt) {
                        level = 2; startButtonClicked = true; f.dispose();
                    }
                });
                JLabel lev3 = new JLabel();
                lev3.setIcon(new ImageIcon(ClassLoader.getSystemResource(
                        "resources/level3.png")));
                lev3.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseEntered(final java.awt
                            .event.MouseEvent evt) {
                        lev3.setIcon(new ImageIcon(ClassLoader
                                .getSystemResource("resources/"
                                        + "level3enter.png")));
                    }
                    @Override
                    public void mouseExited(final java.awt
                            .event.MouseEvent evt) {
                        lev3.setIcon(new ImageIcon(ClassLoader
                                .getSystemResource("resources/level3.png")));
                    }
                    @Override
                    public void mouseClicked(final java.awt
                            .event.MouseEvent evt) {
                        final int tiga = 3; level = tiga;
                        startButtonClicked = true; f.dispose();
                    }
                });
                JLabel lev4 = new JLabel();
                lev4.setIcon(new ImageIcon(ClassLoader.getSystemResource(
                        "resources/level4.png")));
                lev4.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseEntered(final java.awt
                            .event.MouseEvent evt) {
                        lev4.setIcon(new ImageIcon(ClassLoader
                                .getSystemResource("resources/"
                                        + "level4enter.png")));
                    }
                    @Override
                    public void mouseExited(final java.awt
                            .event.MouseEvent evt) {
                        lev4.setIcon(new ImageIcon(ClassLoader
                                .getSystemResource("resources/level4.png")));
                    }
                    @Override
                    public void mouseClicked(final java.awt
                            .event.MouseEvent evt) {
                        final int empat = 4; level = empat;
                        startButtonClicked = true; f.dispose();
                    }
                });
                JLabel lev5 = new JLabel();
                lev5.setIcon(new ImageIcon(ClassLoader.getSystemResource(
                        "resources/level5.png")));
                lev5.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseEntered(final java.awt
                            .event.MouseEvent evt) {
                        lev5.setIcon(new ImageIcon(ClassLoader
                                .getSystemResource("resources/"
                                        + "level5enter.png")));
                    }
                    @Override
                    public void mouseExited(final java.awt
                            .event.MouseEvent evt) {
                        lev5.setIcon(new ImageIcon(ClassLoader
                                .getSystemResource("resources/level5.png")));
                    }
                    @Override
                    public void mouseClicked(final java.awt
                            .event.MouseEvent evt) {
                        final int lima = 5; level = lima;
                        startButtonClicked = true; f.dispose();
                    }
                });
                f.getContentPane().add(lev1); f.getContentPane().add(lev2);
                f.getContentPane().add(lev3); f.getContentPane().add(lev4);
                f.getContentPane().add(lev5);
                final int empatratuslimapuluh = 450, empatratustujuhpuluh = 470;
                final int limapuluh = 50, seratuslimapuluh = 150;
                final int seratus = limapuluh * 2, duaratustigapuluh = 230;
                final int tigaratussepuluh = 310, tigaratussembilanpuluh = 390;
                lev1.setBounds(empatratuslimapuluh, seratuslimapuluh,
                        seratus, limapuluh);
                lev2.setBounds(empatratuslimapuluh, duaratustigapuluh,
                        seratus, limapuluh);
                lev3.setBounds(empatratuslimapuluh, tigaratussepuluh,
                        seratus, limapuluh);
                lev4.setBounds(empatratuslimapuluh, tigaratussembilanpuluh,
                        seratus, limapuluh);
                lev5.setBounds(empatratuslimapuluh, empatratustujuhpuluh,
                        seratus, limapuluh);
                f.getContentPane().add(background);
                background.setIcon(new ImageIcon(ClassLoader.getSystemResource(
                        "resources/selectLevel.png")));
                f.repaint();
            }
        });
        final int limapuluh = 50, seratus = limapuluh * 2;
        final int empatratustujuhpuluh = 470, enamenampuluh = 660;
        final int delapanratus = 800;
        startButton.setBounds(enamenampuluh, empatratustujuhpuluh,
                seratus, limapuluh);
        helpButton.setBounds(delapanratus, empatratustujuhpuluh,
                seratus, limapuluh);
        f.getContentPane().add(background); f.pack(); f.setResizable(false);
        centreWindow(f); f.setVisible(true);
        while (!startButtonClicked) {
            MILLISECONDS.sleep(limapuluh);
        }
        Universe u = new Universe();
        u.printDummy();
    }

/** KELAS UNTUK INPUT TOMBOL.
* @author Sashi Novita S./13514027
*/
static class MyKeyListener extends KeyAdapter {
    /** Method untuk mendapatkan input keyboard dan mengubah variabel
     * boolean key.
    *
    * @param evt input karakter keyboard
    *
    */
    @Override
    public void keyPressed(final KeyEvent evt) {
        final int tigaDelapan = 38, empatPuluh = 40, tigaTujuh = 37;
        final int tigaSembilan = 39;
        final int tigaEnam = 36, tigaDua = 32, satuDuaTujuh = 127;
        if (evt.getKeyCode() == tigaDelapan) {
            up = true;
        } else if (evt.getKeyCode() == empatPuluh) {
            down = true;
        } else if (evt.getKeyCode() == tigaTujuh) {
            left = true;
        } else if (evt.getKeyCode() == tigaSembilan) {
            right = true;
        } else if (evt.getKeyCode() == tigaEnam) {
            home = true;
        } else if (evt.getKeyCode() == tigaDua) {
            spasi = true;
        } else if (evt.getKeyCode() == satuDuaTujuh) {
            del = true;
        }
    }


/** Method untuk mendapatkan input keyboard dan mengubah variabel boolean key.
*
* @param evt input karakter keyboard
*
*/
    @Override
    public void keyTyped(final KeyEvent evt) {
        final int tigaDelapan = 38, empatPuluh = 40, tigaTujuh = 37;
        final int tigaSembilan = 39;
        final int tigaEnam = 36, tigaDua = 32, satuDuaTujuh = 127;
        if (evt.getKeyCode() == tigaDelapan) {
            up = true;
        } else if (evt.getKeyCode() == empatPuluh) {
            down = true;
        } else if (evt.getKeyCode() == tigaTujuh) {
            left = true;
        } else if (evt.getKeyCode() == tigaSembilan) {
            right = true;
        } else if (evt.getKeyCode() == tigaEnam) {
            home = true;
        } else if (evt.getKeyCode() == tigaDua) {
            spasi = true;
        } else if (evt.getKeyCode() == satuDuaTujuh) {
            del = true;
        }
    }

/** Method untuk mengubah variabel boolean key ketika key di-released.
*
* @param evt input karakter keyboard
*
*/
    @Override
    public void keyReleased(final KeyEvent evt) {
        up = false; down = false; left = false; right = false;
        home = false; spasi = false; del = false;
    }
}
}

