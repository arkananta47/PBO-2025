/**
 * Class Room - a room in an adventure game.
 * A "Room" represents one location in the scenery of the game.
 * It is connected to other rooms via exits.
 */
class Room {
    public String description;
    public Room northExit, southExit, eastExit, westExit;

    public Room(String description) {
        this.description = description;
    }

    public void setExits(Room north, Room east, Room south, Room west) {
        if (north != null) northExit = north;
        if (east != null) eastExit = east;
        if (south != null) southExit = south;
        if (west != null) westExit = west;
    }

    public String getDescription() {
        return description;
    }
}
