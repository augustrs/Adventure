public class Map {
    private Room starterRoom;
    private Enemy finalEnemy;

    public void createMap() {
        Room room1 = new Room("Entrance of the pyramid", "You find yourself at the entrance of a pyramid");
        Room room2 = new Room("Hallway", "You find yourself at a long hallway");
        Room room3 = new Room("Traproom", "You find yourself in a room full of armed traps");
        Room room4 = new Room("Food room", "You are in a room full of vessels");
        Room room5 = new Room("Pharaohs room", "Ahead of you is the tomb of");
        Room room6 = new Room("War room", "Room full of weapons");
        Room room7 = new Room("Water room", "Ahead of you is a pool of water");
        Room room8 = new Room("Loot room", "Gold and prices");
        Room room9 = new Room("Grave room", "You have arrived to a room full of deadly mummies");

        // room 1
        room1.setNorth(null);
        room1.setEast(room2);
        room1.setWest(null);
        room1.setSouth(room4);
        room1.addItem(new Item("lamp", "A shiny brass lamp"));
        room1.addItem(new Item("watch", "A shiny golden watch"));
        room1.addItem(new Food("apple", "A red apple", 10));
        room1.addItem(new RangedWeapon("bow", "An ancient bow",5, 2));
        room1.addEnemy(new Enemy("mummy","An ancient dusty mummy",10,new MeleeWeapon("book", "A very boring, but heavy book",5), room1,1));
        room1.addItem(new MeleeWeapon("club", "A heavy club",7));


        // room 2
        room2.setNorth(null);
        room2.setEast(room3);
        room2.setWest(room1);
        room2.setSouth(null);
        room2.addItem(new Item ("torch", "A torch"));
        room2.addItem(new Item("cup", "A cup made of clay"));
        room2.addItem(new Food("bread", "Aged bread", 5));
        room2.addItem(new MeleeWeapon("spear", "A long sharp spear", 10));
        room2.addEnemy(new Enemy("Sand Golem", "A big sand golem", 20, new MeleeWeapon("Saber", "A sharp saber", 7), room2,2));
        // room 3
        room3.setNorth(null);
        room3.setEast(null);
        room3.setWest(room2);
        room3.setSouth(room6);
        room3.addItem(new Item("statue", "A Statue of a Pharaoh"));
        room3.addItem(new Food("healthpotion", "A greater healthy looking elixir", 15));
        room3.addItem(new RangedWeapon("slingshot", "An old slingshot", 4, 10));
        room3.addEnemy(new Enemy("anubis sentinel", "A large anubis sentinel", 30, new MeleeWeapon("Spear", "A giant spear", 9), room3,3));
        // room 4
        room4.setNorth(room1);
        room4.setEast(null);
        room4.setWest(null);
        room4.setSouth(room7);
        room4.addItem(new Item ("torch", "A torch"));
        room4.addItem(new Item("cup", "A cup made of clay"));
        room4.addItem(new Food("bread", "Aged bread", 5));
        room4.addItem(new Food("healthpotion", "A healthy looking elixir", 10));
        room4.addItem(new Food("apple", "A rotten apple", -4));
        room4.addItem(new Food("healthpotion", "A greater healthy looking elixir", 15));
        room4.addEnemy(new Enemy("Bone Archer", "A bone archer", 10, new RangedWeapon("Bow", "A longbow", 5, 10), room4,4));
        room4.addEnemy(new Enemy("Bone Archer", "A bone archer", 10, new RangedWeapon("Bow", "A longbow", 5, 10), room4,4));
        // room 5
        room5.setNorth(null);
        room5.setEast(null);
        room5.setWest(null);
        room5.setSouth(room8);
        room5.addItem(new Item ("torch", "A torch"));
        room5.addItem(new Item ("torch", "A torch"));
        room5.addItem(new Item ("tablet", "Pharaoh's Tablet"));
        room5.addItem(new Food("healthpotion", "A lesser healthy looking elixir", 8));
        room5.addItem(new Food("???", "???", -6));
        room5.addEnemy(new Enemy("King Pharaoh", "King of the Pyramid", 50, new MeleeWeapon("Staff", "Pharaoh's Staff of Doom", 25), room5,5));
        setFinalEnemy(room5.getEnemyList().get(0));

        // room 6
        room6.setNorth(room3);
        room6.setEast(null);
        room6.setWest(null);
        room6.setSouth(room9);
        room6.addItem(new Item("Artifact", "A mysterious ancient artifact"));
        room6.addItem(new Food("Snack", "a little snack", 5));
        room6.addEnemy (new Enemy ("Sand monster", "A frightening monster made out of sand", 20, new MeleeWeapon("Sword", "A sword made out of sand", 7), room6,6));

        // room 7
        room7.setNorth(room4);
        room7.setEast(room8);
        room7.setWest(null);
        room7.setSouth(null);
        room7.addItem(new Item("tablet", "an ancient tablet inscribed with hieroglyphs"));
        room7.addEnemy(new Enemy("Elemental", "a water elemental", 20, new MeleeWeapon("Lance", "A Lance made out of water", 9), room7,7));
        room7.addItem(new Food("Potion", "a minor healthpotion", 10));
        // room 8
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);
        room8.setSouth(null);
        room8.addItem(new Item("Statue", "a golden statue"));
        room8.addItem(new Item("purse", "a purse full of gold and coins"));
        room8.addItem(new Item("chest", "a treasure chest full of value"));
        room8.addEnemy(new Enemy("Snake", "a large snake", 20, new MeleeWeapon("Club", "a venomous club", 9), room7,7));
        // room 9
        room9.setNorth(room6);
        room9.setEast(null);
        room9.setWest(room8);
        room9.setSouth(null);
        room9.addItem(new Item("plate", "An ancient sandstone plate"));
        room9.addItem(new Item("Tombstone", "An ancient tombstone of the 2nd pharaoh king"));
        room9.addItem(new Item("Tombstone", "An ancient tombstone of the 1st pharaoh king"));
        room9.addEnemy(new Enemy("Sandstone Gargoyle", "A giant sandstone gargoyle", 22, new MeleeWeapon("longsword", "a giant but heavy longsword", 14), room9,9));
        room9.addEnemy(new Enemy("Sandstone Gargoyle", "A large sandstone gargoyle", 14, new RangedWeapon("crossbow", "A light crossbow", 8, 5), room9,9));
        room9.addItem(new Food("healthpotion", "A greater healthy looking elixir", 15));
        room9.addItem(new Food("mysterypotion", "???", -8));
        this.starterRoom = room1;
    }

    public Room getStarterRoom() {
        return starterRoom;
    }

    public Enemy getFinalEnemy() {
        return finalEnemy;
    }

    public void setFinalEnemy(Enemy enemy) {
        this.finalEnemy = enemy;
    }

}
