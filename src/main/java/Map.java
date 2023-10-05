public class Map {
    private Room starterRoom;

    public void createMap() {
        Room room1 = new Room("Entrance of the pyramid", "You find yourself at the entrance of a pyramid ...");
        Room room2 = new Room("Hallway", "You find yourself at a long hallway ...");
        Room room3 = new Room("Traproom", "You find yourself in a room full of armed traps ...");
        Room room4 = new Room("Food room", "You are in a room full of vessels ...");
        Room room5 = new Room("Pharaohs room", "Ahead of you is the tomb of ...");
        Room room6 = new Room("War room", "Room full of weapons ...");
        Room room7 = new Room("Water room", "Ahead of you is a pool of water ...");
        Room room8 = new Room("Loot room", "Gold and prices ...");
        Room room9 = new Room("Grave room", "You have arrived to a room full of deadly mummies");

        // room 1
        room1.setNorth(null);
        room1.setEast(room2);
        room1.setWest(null);
        room1.setSouth(room4);
        room1.addItem(new Item("lamp", "A shiny brass lamp"));
        room1.addItem(new Item("watch", "A shiny golden watch"));
        room1.addItem(new Food("apple", "A red apple", 10));
        room1.addItem(new RangedWeapon("bow", "An ancient bow",20, 2));


        // room 2
        room2.setNorth(null);
        room2.setEast(room3);
        room2.setWest(room1);
        room2.setSouth(null);
        // room 3
        room3.setNorth(null);
        room3.setEast(null);
        room3.setWest(room2);
        room3.setSouth(room6);
        // room 4
        room4.setNorth(room1);
        room4.setEast(null);
        room4.setWest(null);
        room4.setSouth(room7);
        // room 5
        room5.setNorth(null);
        room5.setEast(null);
        room5.setWest(null);
        room5.setSouth(room8);
        // room 6
        room6.setNorth(room3);
        room6.setEast(null);
        room6.setWest(null);
        room6.setSouth(room9);
        // room 7
        room7.setNorth(room4);
        room7.setEast(room8);
        room7.setWest(null);
        room7.setSouth(null);
        // room 8
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);
        room8.setSouth(null);
        // room 9
        room9.setNorth(room6);
        room9.setEast(null);
        room9.setWest(room8);
        room9.setSouth(null);
        this.starterRoom = room1;
    }

    public Room getStarterRoom() {
        return starterRoom;
    }


}
