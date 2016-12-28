package board;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Kelas 'JPanelWithBackground' untuk mengatur background dari JPanel.
 * @author Kristianto Karim/13514075
 */
public class JPanelWithBackground extends JPanel {

  /**Menampung variabel image background.*/
  private Image backgroundImage;

  // Some code to initialize the background image.
  // Here, we use the constructor to load the image. This
  // can vary depending on the use case of the panel.
  /**
   * Kelas untuk mengatur variabel backgroundImage.
   * @param fileName nama file background
   * @param x kuran panjang layar
   * @param y ukuran lebar layar
   * @throws IOException penanganan file background tidak ditemukan
   */
  public JPanelWithBackground(final String fileName, final int x,
          final int y) throws IOException {
    Image ori = ImageIO.read(new File(fileName));
    backgroundImage = ori.getScaledInstance(x, y, Image.SCALE_SMOOTH);
  }
  /**
   * Kelas untuk mengatur variabel backgroundImage.
   * @param fileName nama file background
   * @param x absis
   * @param y ordinat
   * @throws IOException penanganan file background tidak ditemukan
   */
  public final void setBackgroundx(final String fileName, final int x,
          final int y) throws IOException {
      Image ori = ImageIO.read(new File(fileName));
    backgroundImage = ori.getScaledInstance(x, y, Image.SCALE_SMOOTH);
  }
  /**
   * Kelas untuk memberikan background pada layar.
   * @param fileName sebuah filename
   * @throws IOException penanganan file jika tidak ditemukan
   */
  public JPanelWithBackground(final String fileName) throws IOException {
    backgroundImage = ImageIO.read(new File(fileName));
  }
  /**
   * Mengatur background dari panel sesuai file gambar yang dimasukkan.
   * @param g JPanel
   * {@inheritDoc}
   */
  @Override
  public final void paintComponent(final Graphics g) {
    super.paintComponent(g);

    // Draw the background image.
    g.drawImage(backgroundImage, 0, 0, this);
  }
}
