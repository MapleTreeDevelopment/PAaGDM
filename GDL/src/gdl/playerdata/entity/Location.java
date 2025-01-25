package gdl.playerdata.entity;

/**
 * Diese Klasse repräsentiert eine Position im Spiel mit den Koordinaten X, Y und Z.
 *
 * Hinweis: Diese Klasse dient nur zu Testzwecken und sollte nicht in der finalen Produktion verwendet werden.
 */
public class Location {

    // X-Koordinate
    private int x;

    // Y-Koordinate
    private int y;

    // Z-Koordinate (z. B. Höhe oder Ebene)
    private int z;

    /**
     * Konstruktor zur Initialisierung der X-, Y- und Z-Koordinaten.
     *
     * @param x Die X-Koordinate.
     * @param y Die Y-Koordinate.
     * @param z Die Z-Koordinate.
     */
    public Location(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Konstruktor zur Initialisierung der X- und Y-Koordinaten.
     * Die Z-Koordinate wird standardmäßig auf 0 gesetzt.
     *
     * @param x Die X-Koordinate.
     * @param y Die Y-Koordinate.
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    /**
     * Setzt die Position basierend auf einem anderen Location-Objekt.
     *
     * @param location Ein anderes Location-Objekt, das die neuen Koordinaten enthält.
     */
    public void setLocation(Location location) {
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
    }

    /**
     * @return Die X-Koordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Setzt die X-Koordinate.
     *
     * @param x Die neue X-Koordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return Die Y-Koordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Setzt die Y-Koordinate.
     *
     * @param y Die neue Y-Koordinate.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return Die Z-Koordinate.
     */
    public int getZ() {
        return z;
    }

    /**
     * Setzt die Z-Koordinate.
     *
     * @param z Die neue Z-Koordinate.
     */
    public void setZ(int z) {
        this.z = z;
    }
}
