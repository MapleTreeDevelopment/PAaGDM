package gdl.playerdata.entity;

/**
 * Diese Klasse repräsentiert ein Item in einem Inventar.
 *
 * Hinweis: Diese Klasse dient nur zu Testzwecken und sollte nicht in der finalen Produktion verwendet werden.
 * Einige Funktionen sind möglicherweise fehlerhaft oder unvollständig implementiert.
 */
public class Item {

    // Eindeutige ID des Items
    private final int id;

    // Anzahl der Items (bei stapelbaren Items die Stapelgröße)
    private final int amount;

    // Zustand des Items (z. B. Abnutzung)
    private double degrade;

    // Verbleibende Ladungen des Items (falls anwendbar)
    private double charges;

    // Gibt an, ob das Item stapelbar ist
    private boolean stackable;

    /**
     * Konstruktor für ein Item mit ID und Anzahl.
     *
     * @param id     Die eindeutige ID des Items.
     * @param amount Die Anzahl des Items.
     */
    public Item(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Konstruktor für ein Item mit ID, Anzahl und Stapelbarkeit.
     *
     * @param id        Die eindeutige ID des Items.
     * @param amount    Die Anzahl des Items.
     * @param stackable Ob das Item stapelbar ist.
     */
    public Item(int id, int amount, boolean stackable) {
        this.id = id;
        this.amount = amount;
        this.stackable = stackable;
    }

    /**
     * Konstruktor für ein Item mit ID, Anzahl und Abnutzungswert.
     *
     * @param id      Die eindeutige ID des Items.
     * @param amount  Die Anzahl des Items.
     * @param degrade Der Abnutzungswert des Items.
     */
    public Item(int id, int amount, double degrade) {
        this.id = id;
        this.amount = amount;
        this.degrade = degrade;
    }

    /**
     * Konstruktor für ein Item mit ID, Anzahl, Abnutzungswert und verbleibenden Ladungen.
     *
     * @param id      Die eindeutige ID des Items.
     * @param amount  Die Anzahl des Items.
     * @param degrade Der Abnutzungswert des Items.
     * @param charges Die verbleibenden Ladungen des Items.
     */
    public Item(int id, int amount, double degrade, double charges) {
        this.id = id;
        this.amount = amount;
        this.degrade = degrade;
        this.charges = charges;
    }

    /**
     * @return Die eindeutige ID des Items.
     */
    public int getId() {
        return id;
    }

    /**
     * @return Die Anzahl des Items.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @return Der Abnutzungswert des Items.
     */
    public double getDegrade() {
        return degrade;
    }

    /**
     * Setzt den Abnutzungswert des Items.
     *
     * @param degrade Der neue Abnutzungswert.
     */
    public void setDegrade(double degrade) {
        this.degrade = degrade;
    }

    /**
     * @return Die verbleibenden Ladungen des Items.
     */
    public double getCharges() {
        return charges;
    }

    /**
     * Setzt die verbleibenden Ladungen des Items.
     *
     * @param charges Die neuen verbleibenden Ladungen.
     */
    public void setCharges(double charges) {
        this.charges = charges;
    }

    /**
     * @return True, wenn das Item stapelbar ist, sonst False.
     */
    public boolean isStackable() {
        return stackable;
    }

    /**
     * Setzt, ob das Item stapelbar ist.
     *
     * @param stackable True, wenn das Item stapelbar sein soll, sonst False.
     */
    public void setStackable(boolean stackable) {
        this.stackable = stackable;
    }
}
