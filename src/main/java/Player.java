import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private int health;
    private Weapon currentWeapon;
    public boolean playerisDead = false;
    public Player(Room currentRoom) {
        this.health = 70;
        this.inventory = new ArrayList<>();
        this.currentRoom = currentRoom;
    }

    public void goNorth() {
        if (currentRoom.getNorth() == null) {
            System.out.println("You cant go this way");
        } else {
            currentRoom = currentRoom.getNorth();
            System.out.println(currentRoom);
            System.out.println("On the floor you see: ");
            currentRoom.printItemlist();
            System.out.println("\nIn the room you also see: ");
            currentRoom.printEnemyList();
            System.out.println("");
        }
    }

    public void goSouth() {
        if (currentRoom.getSouth() == null) {
            System.out.println("You cant go this way");
        } else {
            currentRoom = currentRoom.getSouth();
            System.out.println(currentRoom);
            System.out.println("On the floor you see: ");
            currentRoom.printItemlist();
            System.out.println("\nIn the room you also see: ");
            currentRoom.printEnemyList();
            System.out.println("");        }
    }

    public void goEast() {
        if (currentRoom.getEast() == null) {
            System.out.println("You cant go this way");
        } else {
            currentRoom = currentRoom.getEast();
            System.out.println(currentRoom);
            System.out.println("On the floor you see: ");
            currentRoom.printItemlist();
            System.out.println("\nIn the room you also see: ");
            currentRoom.printEnemyList();
            System.out.println("");        }
    }


    public void goWest() {
        if (currentRoom.getWest() == null) {
            System.out.println("You cant go this way");
        } else {
            currentRoom = currentRoom.getWest();
            System.out.println(currentRoom);
            System.out.println("On the floor you see: ");
            currentRoom.printItemlist();
            System.out.println("\nIn the room you also see: ");
            currentRoom.printEnemyList();
            System.out.println("");        }
    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public Item takeItem(String kortNavn) {
        Item pickedItem = getCurrentRoom().removeItem(kortNavn);
        addItem(pickedItem);
        return pickedItem;
    }

    public Item dropItem(String kortNavn) {
        Item pickedItem = findItemInInventory(kortNavn);
        if (pickedItem != null) {
            removeItem(pickedItem);
            getCurrentRoom().addItem(pickedItem);
        }
        return pickedItem;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    private Item findItemInInventory(String kortNavn) {
        for (Item item : inventory) {
            if (item.getKortNavn().equalsIgnoreCase(kortNavn)) {
                return item;
            }
        }
        return null;
    }

    public Returnmessage eatItem(String kortNavn) {
        Item item = findItemInInventory(kortNavn);
        if (item == null) {
            return Returnmessage.NOT_FOUND;
        } else if (item instanceof Food food) {
            removeItem(item);
            health+=food.getHealingPoint();
            return Returnmessage.OK;
        } else {
            return Returnmessage.NOT_OK;
        }
    }

    public int getHealth() {
        return health;
    }
    public Returnmessage equipItem(String kortNavn){
        Item equippedWeapon = findItemInInventory(kortNavn);
        if (equippedWeapon == null){
            return Returnmessage.NOT_FOUND;
        }else if(equippedWeapon instanceof Weapon){
            currentWeapon = (Weapon)equippedWeapon;
            getCurrentRoom().removeItem(kortNavn);
            inventory.remove(equippedWeapon);
            return Returnmessage.OK;
        }else {
            return Returnmessage.NOT_OK;
        }
    }

        public void isPlayerDead() {

            if (health < 1) {
                playerisDead = true;

            }

    }

    public void resetPlayerState() {
        health = 70;
        inventory.clear();
        currentWeapon = null;
        playerisDead = false;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
