public class Adventure {

private Map map = new Map();
private Player player;

    public Adventure() {
        map.createMap();
        player = new Player();
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
}
