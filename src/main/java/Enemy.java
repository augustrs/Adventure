public class Enemy {
    private String name;
    private String description;
    private int hp;
    private Weapon weapon;
    private Room room;
    private int roomNumber;

    public Enemy(String name, String description, int hp, Weapon weapon, Room room, int roomNumber){
        this.name = name;
        this.description = description;
        this.hp = hp;
        this.weapon = weapon;
        this.room = room;
        this.roomNumber = roomNumber;

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHp() {
        return hp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Room currentRoom() {
        return room;
    }
    public void setHp(int newHp){
        this.hp=newHp;
    }

    @Override
    public String toString() {
        return description + " ("+hp+"hp)"+ "\nIn their hands they are holding: '" + weapon+"'";

    }
    public void isEnemyDead() {
        if (getRoomNumber() == 5) {
            if (hp <= 0) {
                System.out.println(name + ", " + description + " has died by a lethal strike.");
                System.out.println("Congratulations, you have completed the game!");
                System.exit(0);
            }else if (hp > 0){
                System.out.println(name + ", " + description + " has '" + hp + "' HP remaining");
            }
        } else {
            if (hp > 0) {
                System.out.println(description + " has '" + hp + "' HP remaining");
            } else {
                System.out.println(description + " has died and dropped their weapon: '" + weapon + "' in the room");

                currentRoom().getItemList().add(weapon);
                weapon = null;
                currentRoom().getEnemyList().remove(this);
            }
        }
    }


}
