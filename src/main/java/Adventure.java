public class Adventure {

    private Map map = new Map();
    private Player player;


    public Adventure() {

        map.createMap();
        player = new Player(map.getStarterRoom());

    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public void createMap() {
        map.createMap();
    }


    public void goNorth() {
        player.goNorth();
    }

    public void goSouth() {
        player.goSouth();
    }

    public void goWest() {
        player.goWest();
    }

    public void goEast() {
        player.goEast();
    }

    public Item takeItem(String kortNavn) {
        return player.takeItem(kortNavn);
    }

    public Item dropItem(String kortNavn) {
        return player.dropItem(kortNavn);
    }

    public Player getPlayer() {
        return player;
    }


    public Returnmessage eatItem(String kortNavn) {
        return player.eatItem(kortNavn);
    }


    public Returnmessage equipItem(String kortNavn) {
        return player.equipItem(kortNavn);
    }

    public AttackEnum attack() {
        if (player.getCurrentRoom().getEnemyList().isEmpty()) {
            return AttackEnum.NO_ENEMY;
        } else {
            Enemy enemy = player.getCurrentRoom().getEnemyList().get(0);


            if (player.getCurrentWeapon() instanceof RangedWeapon) {
                int currentAmmo = player.getCurrentWeapon().getAmmo();
                if (currentAmmo < 1) {
                    return AttackEnum.NO_AMMO;
                } else {
                    ((RangedWeapon) player.getCurrentWeapon()).setAmmo(currentAmmo - 1);
                    enemy.setHp(enemy.getHp() - player.getCurrentWeapon().getDamage());
                    enemy.isEnemyDead();
                    if (enemy.getHp() > 0) {
                        System.out.println("The enemy attacks with their weapon '" + enemy.getWeapon() + "'");
                        System.out.println("The enemy dealt '" + enemy.getWeapon().getDamage() + "' damage");
                        player.setHealth(player.getHealth() - enemy.getWeapon().getDamage());
                        System.out.println("You have '" + player.getHealth() + "' HP remaining");
                    }
                    return AttackEnum.FIRED;
                }
            }
            if (player.getCurrentWeapon() instanceof MeleeWeapon) {
                enemy.setHp(enemy.getHp() - player.getCurrentWeapon().getDamage());
                enemy.isEnemyDead();
                if (enemy.getHp() > 0) {
                    System.out.println("The enemy attacks with their weapon '" + enemy.getWeapon() + "'");
                    System.out.println("The enemy dealt '" + enemy.getWeapon().getDamage() + "' damage");
                    player.setHealth(player.getHealth() - enemy.getWeapon().getDamage());
                    player.isPlayerDead();
                    System.out.println("You have '" + player.getHealth() + "' HP remaining");
                }
                return AttackEnum.ATTACK;
            } else {
                return AttackEnum.NOT_A_WEAPON;
            }
        }
    }


    public void printItemList() {
        getCurrentRoom().printItemlist();
    }

    public void printEnemyList() {
        getCurrentRoom().printEnemyList();
    }

    public boolean playerisDead() {
        return player.playerisDead;
    }

    public void resetGame() {
        map.createMap();
        player.setCurrentRoom(map.getStarterRoom());
        player.resetPlayerState();
        System.out.println("The game has been reset, welcome back!");
        System.out.println("Find your way to the pharaoh's tomb and receive infinite wealth.");
        System.out.println("Type 'help' for a list of commands.");
    }

    public boolean checkFinalEnemyDefeat() {
        if (map.getFinalEnemy().getHp() < 0) {
            return true;
        } else {
            return false;
        }


    }

}




