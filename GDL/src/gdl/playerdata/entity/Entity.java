package gdl.playerdata.entity;

public abstract class Entity {

    public Entity(Location location) {
        this.location = location;
    }

    // Die aktuelle Position des Spielers
    private Location location;

    /**
     * @return Die aktuelle Position des Spielers.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Setzt die Position des Spielers.
     *
     * @param location Die neue Position des Spielers.
     */
    public void setLocation(Location location) {
        this.location = location;
    }
}
