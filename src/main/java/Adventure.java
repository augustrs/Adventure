public class Adventure {

    private Map map = new Map();
    private Player player;
    public boolean finalEnemyDefeated;
    private Enemy finalEnemy;
    public Adventure() {
        finalEnemy = null;
        finalEnemyDefeated=false;
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
        checkFinalEnemyDefeat();
        return player.attack();
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
    public void checkFinalEnemyDefeat() {
        if (finalEnemy != null && finalEnemy.getHp()<=0) {
            finalEnemyDefeated=true;
            System.out.println(" ▄▄   ▄▄ ▄▄▄ ▄▄▄▄▄▄▄ ▄▄▄▄▄▄▄ ▄▄▄▄▄▄▄ ▄▄▄▄▄▄   ▄▄   ▄▄ \n" +
                    "█  █ █  █   █       █       █       █   ▄  █ █  █ █  █\n" +
                    "█  █▄█  █   █       █▄     ▄█   ▄   █  █ █ █ █  █▄█  █\n" +
                    "█       █   █     ▄▄█ █   █ █  █ █  █   █▄▄█▄█       █\n" +
                    "█       █   █    █    █   █ █  █▄█  █    ▄▄  █▄     ▄█\n" +
                    " █     ██   █    █▄▄  █   █ █       █   █  █ █ █   █  \n" +
                    "  █▄▄▄█ █▄▄▄█▄▄▄▄▄▄▄█ █▄▄▄█ █▄▄▄▄▄▄▄█▄▄▄█  █▄█ █▄▄▄█  \n");

        }
    }

}




