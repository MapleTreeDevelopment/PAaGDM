package gdl.playerdata.entity;

import java.util.ArrayList;

/**
 * Diese Klasse repräsentiert ein Inventar für Spieler.
 *
 * Hinweis: Diese Klasse dient nur zu Testzwecken und sollte nicht in der finalen Produktion verwendet werden.
 * Die Funktionen sind möglicherweise fehlerhaft oder nicht vollständig implementiert.
 */
public class Inventory {

    // Liste, die die Items im Inventar speichert
    private ArrayList<Item> inventory = new ArrayList<>();

    // Maximale Kapazität des Inventars
    private final int maxcap = 28;

    /**
     * Standardkonstruktor für das Inventar.
     */
    public Inventory() {
        // Kein spezieller Code im Konstruktor erforderlich
    }

    /**
     * Fügt ein Item dem Inventar hinzu, falls genügend Platz vorhanden ist.
     *
     * @param item Das hinzuzufügende Item.
     * @return True, wenn das Item erfolgreich hinzugefügt wurde, andernfalls False.
     */
    public boolean addItem(Item item) {
        if (hasRoomFor(item)) {
            inventory.add(item);
            return true;
        }
        return false;
    }

    /**
     * Überprüft, ob ein bestimmtes Item im Inventar enthalten ist.
     *
     * @param item Das zu suchende Item.
     * @return True, wenn das Item im Inventar vorhanden ist, andernfalls False.
     */
    public boolean containsItem(Item item) {
        return inventory.contains(item);
    }

    /**
     * Entfernt ein Item aus dem Inventar, falls es vorhanden ist.
     *
     * @param item Das zu entfernende Item.
     * @return True, wenn das Item erfolgreich entfernt wurde, andernfalls False.
     */
    public boolean removeItem(Item item) {
        if (containsItem(item)) {
            inventory.remove(item);
            return true;
        }
        return false;
    }

    /**
     * Überprüft, ob genügend Platz im Inventar für ein bestimmtes Item vorhanden ist.
     *
     * @param item Das Item, dessen Platzbedarf überprüft werden soll.
     * @return True, wenn genügend Platz vorhanden ist, andernfalls False.
     */
    public boolean hasRoomFor(Item item) {
        return inventory.size() + (item.isStackable() ? 1 : item.getAmount()) <= maxcap;
    }
}
