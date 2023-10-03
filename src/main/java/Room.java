import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private ArrayList<Item> itemList = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Room getWest() {
        return west;
    }

    public Room getEast() {
        return east;
    }

    public Room getSouth() {
        return south;
    }

    public Room getNorth() {
        return north;
    }

    public String getDescription() {

        return "In the room you see: " + itemList.toString();
    }


    @Override
    public String toString() {
        return "\n" + name + " - " + description;
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public Item findItem(String kortNavn) {
        for (Item item : itemList) {
            if (item.getKortNavn().equals(kortNavn)) {
                return item;
            }
        }
        return null;
    }

    public Item removeItem(String kortNavn) {
        Item item = findItem(kortNavn);
        itemList.remove(item);
        return item;
    }

    public Item placeItem(String kortNavn) {
        Item item = findItem(kortNavn);
        itemList.add(item);
        return item;
    }

}

