package gdl.playerdata.runescape;

/**
 * Do not use this class in final production.
 * Functions are only for testing and do not function properly!
 */
public class Item {

    private final int id;
    private final int amount;
    private double degrade;
    private double charges;
    private boolean stackable;

    public Item(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public Item(int id, int amount, boolean stackable) {
        this.id = id;
        this.amount = amount;
        this.stackable = stackable;
    }

    public Item(int id, int amount, double degrade) {
        this.id = id;
        this.amount = amount;
        this.degrade = degrade;
    }

    public Item(int id, int amount, double degrade, double charges) {
        this.id = id;
        this.amount = amount;
        this.degrade = degrade;
        this.charges = charges;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public double getDegrade() {
        return degrade;
    }

    public void setDegrade(double degrade) {
        this.degrade = degrade;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public boolean isStackable() {
        return stackable;
    }

    public void setStackable(boolean stackable) {
        this.stackable = stackable;
    }
}
