public class Player {
    private Room currentRoom;
    public void goNorth() {
        if (currentRoom.getNorth() == null) {
            System.out.println("You cant go this way");
        } else {
            currentRoom = currentRoom.getNorth();
            System.out.println(getCurrentRoom());
        }
    }
    public void goSouth() {
        if (currentRoom.getSouth() == null) {
            System.out.println("You cant go this way");
        } else {
            currentRoom = currentRoom.getSouth();
            System.out.println(getCurrentRoom());
        }
    }
    public void goEast() {
        if (currentRoom.getEast() == null) {
            System.out.println("You cant go this way");
        } else {
            currentRoom = currentRoom.getEast();
            System.out.println(getCurrentRoom());
        }
    }


    public void goWest() {
        if (currentRoom.getWest() == null) {
            System.out.println("You cant go this way");
        } else {
            currentRoom = currentRoom.getWest();
            System.out.println(getCurrentRoom());
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
