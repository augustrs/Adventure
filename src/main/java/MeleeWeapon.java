public class MeleeWeapon extends Weapon{

    public MeleeWeapon(String kortNavn, String langNavn, int damage) {
        super(kortNavn, langNavn, damage);

    }
@Override
    public AttackEnum attack() {
        return AttackEnum.ATTACK;
    }
}
