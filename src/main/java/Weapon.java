public abstract class Weapon extends Item {

    public int damage;
    private int ammo;

    public Weapon(String kortNavn, String langNavn, int damage) {
        super(kortNavn, langNavn);
        this.damage = damage;
    }
    public abstract AttackEnum attack();

    public int getAmmo() {
        return ammo;
    }

    public int getDamage() {
        return damage;
    }
}




