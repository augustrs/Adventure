public class Adventure {

    private Map map = new Map();
    private Player player;

    public Adventure() {
        map.createMap();
        player = new Player(50);
        player.setCurrentRoom(map.getStarterRoom());
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public void createMap() {
        map.createMap();
    }


    public void goNorth() {
        player.goNorth();
    }

    public void goSouth() {
        player.goSouth();
    }

    public void goWest() {
        player.goWest();
    }

    public void goEast() {
        player.goEast();
    }

    public Item takeItem(String kortNavn) {
        return player.takeItem(kortNavn);
    }

    public Item dropItem(String kortNavn) {
        return player.dropItem(kortNavn);
    }

    public Player getPlayer() {
        return player;
    }


    public Returnmessage eatItem(String kortNavn) {
        return player.eatItem(kortNavn);
    }



}



