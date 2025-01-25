package gdl.playerdata.runescape;

import java.util.ArrayList;

/**
 * Do not use this class in final production.
 * Functions are only for testing and do not function properly!
 */
public class Inventory {

    private ArrayList<Item> inventory = new ArrayList<>();
    private final int maxcap = 28;

    public Inventory() {

    }

    public boolean addItem(Item item) {
        if(hasRoomFor(item)) {
            inventory.add(item);
            return true;
        }
        return false;
    }

    public boolean containsItem(Item item) {
        return inventory.contains(item);
    }

    public boolean removeItem(Item item) {
        if(containsItem(item)) {
            inventory.remove(item);
            return true;
        }
        return false;
    }

    public boolean hasRoomFor(Item item) {
        return inventory.size() + (item.isStackable() ? 1 : item.getAmount()) < maxcap;
    }

}
