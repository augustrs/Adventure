import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private int health;
    private Weapon currentWeapon;

    public Player(Room currentRoom) {
        this.health = 50;
        this.inventory = new ArrayList<>();
        this.currentRoom = currentRoom;
    }

    public void goNorth() {
        if (currentRoom.getNorth() == null) {
            System.out.println("You cant go this way");
        } else {
            currentRoom = currentRoom.getNorth();
            System.out.println(getCurrentRoom() + getCurrentRoom().getDescription());
        }
    }

    public void goSouth() {
        if (currentRoom.getSouth() == null) {
            System.out.println("You cant go this way");
        } else {
            currentRoom = currentRoom.getSouth();
            System.out.println(getCurrentRoom() + getCurrentRoom().getDescription());
        }
    }

    public void goEast() {
        if (currentRoom.getEast() == null) {
            System.out.println("You cant go this way");
        } else {
            currentRoom = currentRoom.getEast();
            System.out.println(getCurrentRoom() + getCurrentRoom().getDescription());
        }
    }


    public void goWest() {
        if (currentRoom.getWest() == null) {
            System.out.println("You cant go this way");
        } else {
            currentRoom = currentRoom.getWest();
            System.out.println(getCurrentRoom() + getCurrentRoom().getDescription());
        }
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
    public AttackEnum attack(){
        if(currentWeapon instanceof RangedWeapon){
            if(currentWeapon.getAmmo() < 1){
                return  AttackEnum.NO_AMMO;
            } else {
                return AttackEnum.FIRED;
            }
        }
        return AttackEnum.NOT_A_WEAPON;
    }
}
