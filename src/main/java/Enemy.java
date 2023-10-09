public class Enemy {
    private String name;
    private String description;
    private int hp;
    private Weapon weapon;
    private Room room;

    public Enemy(String name, String description, int hp, Weapon weapon){
        this.name = name;
        this.description = description;
        this.hp = hp;
        this.weapon = weapon;

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

    public Room getRoom() {
        return room;
    }
    public void hit(int newHp){
        this.hp=newHp;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", hp=" + hp +
                ", weapon=" + weapon +
                ", room=" + room +
                '}';
    }
}
