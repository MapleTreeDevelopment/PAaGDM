package gdl.playerdata.runescape;

import gdl.playerdata.PlayerInformation;
import org.apache.mina.core.buffer.IoBuffer;

/**
 * Do not use this class in final production.
 * Functions are only for testing and do not function properly!
 */
public class Player {

    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    private final PlayerInformation playerInformation;

    public PlayerInformation getPlayerInformation() {
        return playerInformation;
    }

    public Player(PlayerInformation playerInformation, Location location) {
        this.playerInformation = playerInformation;
        this.location = location;
    }

    public void serializeData(IoBuffer buffer) {
        buffer.putInt(location.getX());     //X
        buffer.putInt(location.getY());     //Y
        buffer.put((byte) location.getZ()); //Z
    }

    public void deserializeData(IoBuffer buffer) {
        this.setLocation(new Location(
                buffer.getInt(),        //X
                buffer.getInt(),        //Y
                buffer.getUnsigned())); //Z
    }

}
