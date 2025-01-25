package gdl.playerdata.entity;

import gdl.playerdata.PlayerInformation;
import org.apache.mina.core.buffer.IoBuffer;

/**
 * Diese Klasse repräsentiert einen Spieler im Spiel.
 * 
 * Hinweis: Diese Klasse dient nur zu Testzwecken und sollte nicht in der finalen Produktion verwendet werden.
 */
public class Player extends Entity {


    // Spielerinformationen wie Name, ID usw.
    private final PlayerInformation playerInformation;

    /**
     * Konstruktor zur Erstellung eines Spielers mit den angegebenen Informationen und einer Position.
     *
     * @param playerInformation Die allgemeinen Informationen des Spielers (z. B. Name, ID).
     */
    public Player(PlayerInformation playerInformation) {
        super(new Location(3222, 3222, 0));
        this.playerInformation = playerInformation;
    }

    /**
     * @return Die allgemeinen Informationen des Spielers.
     */
    public PlayerInformation getPlayerInformation() {
        return playerInformation;
    }

    /**
     * Serialisiert die Daten des Spielers (Position) in einen `IoBuffer`.
     *
     * @param buffer Der `IoBuffer`, in den die Daten geschrieben werden.
     */
    public void serializeData(IoBuffer buffer) {
        buffer.putInt(getLocation().getX());     // X-Koordinate
        buffer.putInt(getLocation().getY());     // Y-Koordinate
        buffer.put((byte) getLocation().getZ()); // Z-Koordinate
    }

    /**
     * Deserialisiert die Daten des Spielers (Position) aus einem `IoBuffer`.
     *
     * @param buffer Der `IoBuffer`, aus dem die Daten gelesen werden.
     */
    public void deserializeData(IoBuffer buffer) {
        this.setLocation(new Location(
                buffer.getInt(),        // X-Koordinate
                buffer.getInt(),        // Y-Koordinate
                buffer.getUnsigned()    // Z-Koordinate
        ));
    }
}