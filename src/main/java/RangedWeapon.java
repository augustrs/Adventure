public class RangedWeapon extends Weapon {
    public int damage;
    public int ammo;

    public RangedWeapon(String kortNavn, String langNavn, int damage, int ammo) {
        super(kortNavn, langNavn, damage);
        this.ammo = ammo;
    }

    public int remainingAmmo(){
        return ammo;
    }


    @Override
    public AttackEnum attack() {
        if(ammo>0){
            setAmmo(ammo-1);
            return AttackEnum.FIRED;
        }else{
            return AttackEnum.NO_AMMO;
        }
    }

    public int getAmmo() {
        return ammo;
    }
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
}

