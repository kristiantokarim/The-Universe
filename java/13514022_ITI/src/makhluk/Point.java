package makhluk;
/**
* @author Kristianto K./13514075
* Kelas Point. Untuk merepresentasi koordinat suatu objek
*/
public class Point {
    /** Posisi absis. */
    private int x;
    /** Posisi ordinat. */
    private int y;

    /** Ctor point.
    */
    public Point() {
       this.x = 0; this.y = 0;
    }
    /** Ctor point yang berparameter. x = _x dan y = _y
    *
    * @param a absis
    * @param b ordinat
    *
    */
    public Point(final int a, final int b) {
        this.x = a; this.y = b;
    }
    /** Setter point. x = _x dan y = _y
    *
    * @param a absis
    * @param b ordinat
    *
    */
    public final void setPoint(final int a, final int b) {
        this.x = a;
        this.y = b;
    }
    /** Getter absis.
    * @return int absis
    */
    public final int getX() {
        return this.x;
    }
    /** Getter ordinat.
    * @return int ordinat
    */
    public final int getY() {
        return this.y;
    }
    /** Menggerakkan point sebesar _x dan _y. x = x + _x dan y = y +_y.
    * @param a delta X
    * @param b delta Y
    */
    public final void movePoint(final int a, final int b) {
        this.x = a + this.x;
        this.y = b + this.y;
    }
}
