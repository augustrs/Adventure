import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Adventure adventure;
    Music music = new Music();
    private Item item;
    boolean hasWelcomed = false;


    public UserInterface() {
        adventure = new Adventure();
        adventure.createMap();
        music.play();

    }

    // Add a boolean flag to track whether you are in a game session
    boolean inGameSession = false;

    public void start() {
        while (true) {
            if (!inGameSession) {
                welcome();
                inGameSession = true;
            }
            if (adventure.playerisDead()) {
                gameOver();
            } else {
                userinput();
            }
            adventure.checkFinalEnemyDefeat();
            if (adventure.finalEnemyDefeated) {

                victory();
            }
        }
    }

    public void gameOver() {
        System.out.println("\uD835\uDC18\uD835\uDC0E\uD835\uDC14 \uD835\uDC07\uD835\uDC00\uD835\uDC15\uD835\uDC04 \uD835\uDC03\uD835\uDC08\uD835\uDC04\uD835\uDC03!");
        System.out.println(skullASCII);
        System.out.println("Game over, do you want to play again? (yes/no)");
        String playAgain = scanner.nextLine().trim().toLowerCase();
        if (playAgain.equals("yes")) {
            adventure.resetGame();
            hasWelcomed = false;
        } else {
            inGameSession = false;
        }
    }


    public void victory() {
        System.out.println("Congratulations! You have defeated the final boss.");
        System.out.println("Do you want to play again? (yes/no)");
        String playAgain = scanner.nextLine().trim().toLowerCase();
        if (playAgain.equals("yes")) {
            adventure.resetGame();
            hasWelcomed = false;
        } else {
            inGameSession = false;
        }
    }



    public void welcome() {

        System.out.println("Welcome to:");
        System.out.println("            ▄▄                                                                          ▄▄         ▄▄  \n" +
                "███▀▀██▀▀█████                                                                          ██       ▀███  \n" +
                "█▀   ██   ▀███                                                                                     ██  \n" +
                "     ██     ███████▄   ▄▄█▀██    ▀████████▄▀██▀   ▀██▀███▄███ ▄█▀██▄ ▀████████▄█████▄ ▀███    ▄█▀▀███  \n" +
                "     ██     ██    ██  ▄█▀   ██     ██   ▀██  ██   ▄█   ██▀ ▀▀██   ██   ██    ██    ██   ██  ▄██    ██  \n" +
                "     ██     ██    ██  ██▀▀▀▀▀▀     ██    ██   ██ ▄█    ██     ▄█████   ██    ██    ██   ██  ███    ██  \n" +
                "     ██     ██    ██  ██▄    ▄     ██   ▄██    ███     ██    ██   ██   ██    ██    ██   ██  ▀██    ██  \n" +
                "   ▄████▄  ████  ████▄ ▀█████▀     ██████▀     ▄█    ▄████▄  ▀████▀██▄████  ████  ████▄████▄ ▀████▀███▄\n" +
                "                                   ██        ▄█                                                        \n" +
                "                                 ▄████▄    ██▀                                                         \n");
        System.out.println("Find your way to the pharaohs tomb, and recieve infinite wealth");
        System.out.println("Type 'help' for full list of commands");

        System.out.println("▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔\n");
        System.out.println("On the floor you see: ");
        adventure.printItemList();
        System.out.println("\nIn the room you also see: ");
        adventure.printEnemyList();
        System.out.println("");


    }


    public void userinput() {
        String input = scanner.nextLine().trim().toLowerCase();
        String[] commands = input.split("\\s+");
        String command = commands[0];





        if (commands.length == 1) {

            switch (command) {
                case "help", "h" -> {
                    System.out.println("Commands:");
                    System.out.println("GO <direction>  - Move in the specified direction (e.g., 'go north', 'go west'). You can also use N, S, E, and W.");
                    System.out.println("EXIT            - Exit the program.");
                    System.out.println("MUTE            - Turn off game music.");
                    System.out.println("RESUME          - Start music.");
                    System.out.println("LOOK            - Take another look around the room.");
                    System.out.println("TAKE <item>     - Pick up an object from a room (e.g., 'take club').");
                    System.out.println("DROP <item>     - Drop an item inside a room (e.g., 'drop club').");
                    System.out.println("EAT <item>      - Consume an item in your inventory for health (e.g., 'eat apple').");
                    System.out.println("INVENTORY       - View items in your inventory.");
                    System.out.println("EQUIP <item>    - Equip a weapon from your inventory (e.g., 'equip club').");
                    System.out.println("ATTACK          - Attack the enemy with your equipped weapon.");
                }
                case "look" -> {
                    System.out.println("On the floor you see: ");
                    adventure.printItemList();
                    System.out.println("\nIn the room you also see: ");
                    adventure.printEnemyList();
                    System.out.println("");
                }
                case "exit" -> {
                    System.exit(0);
                }
                case "mute" -> {
                    music.stopMusic();
                }
                case "resume" -> {
                    music.playMusic();
                }
                case "inventory" -> {
                    System.out.println(adventure.getPlayer().getInventory());
                }
                case "attack" -> {
                    AttackEnum result = adventure.attack();
                    switch (result) {
                        case ATTACK -> {
                            if (adventure.playerisDead() == false) {
                                System.out.println("\nAttack sequence successful");
                            }
                        }
                        case FIRED -> {

                            System.out.println("\nFiring sequence successful");
                        }
                        case NO_AMMO -> {
                            System.out.println("\nNO AMMO! cant attack!");
                        }
                        case NOT_A_WEAPON -> {
                            System.out.println("\nYou dont have a weapon equipped to attack with");
                        }
                        case NO_ENEMY -> {
                            System.out.println("\nNo enemy to attack");
                        }
                    }
                }
                default -> System.out.println("\nInvalid input, type 'help' for list of commands");
            }
        }
        if (commands.length == 2)
            switch (commands[0]) {

                case "go" -> {
                    switch (commands[1]) {
                        case "north", "n" -> {
                            adventure.goNorth();
                        }
                        case "south", "s" -> {
                            adventure.goSouth();
                        }
                        case "east", "e" -> {
                            adventure.goEast();
                        }
                        case "west", "w" -> {
                            adventure.goWest();
                        }
                        default -> System.out.println("Invalid input");
                    }
                }

                case "take" -> {

                    Item pickItem = adventure.takeItem(commands[1]);
                    if (pickItem != null) {
                        System.out.println("Picked up '" + pickItem + "'");
                    } else System.out.println("There is no " + commands[1] + " in this room");
                }
                case "drop" -> {
                    Item pickItem = adventure.dropItem(commands[1]);
                    if (pickItem != null) {
                        System.out.println("Dropped '" + pickItem + "'");
                    } else System.out.println("There is no " + commands[1] + " in your inventory");
                }
                case "eat" -> {
                    Returnmessage result = adventure.eatItem(commands[1]);
                    switch (result) {
                        case OK -> {

                            System.out.println("Eating " + commands[1] + "!");
                            System.out.println("You now have " + adventure.getPlayer().getHealth() + " hp");
                        }
                        case NOT_OK -> {
                            System.out.println("You can't eat " + commands[1]);

                        }
                        case NOT_FOUND -> {
                            System.out.println("No " + commands[1] + " was found in your inventory");
                        }
                    }
                }
                case "equip" -> {
                    Returnmessage result = adventure.equipItem(commands[1]);
                    switch (result) {
                        case OK -> {
                            System.out.println("Equipping " + commands[1] + "!");

                        }
                        case NOT_OK -> {
                            System.out.println("You can't equip " + commands[1]);
                        }
                        case NOT_FOUND -> {
                            System.out.println("No " + commands[1] + " was found in your inventory");
                        }
                    }
                }
                default -> System.out.println("Invalid input, type 'help' for list of commands");
            }
    }

    private String skullASCII = ("                                _,.-------.,_\n" +
            "                            ,;~'             '~;,\n" +
            "                          ,;                     ;,\n" +
            "                         ;                         ;\n" +
            "                        ,'                         ',\n" +
            "                       ,;                           ;,\n" +
            "                       ; ;      .           .      ; ;\n" +
            "                       | ;   ______       ______   ; |\n" +
            "                       |  `/~\"     ~\" . \"~     \"~\\'  |\n" +
            "                       |  ~  ,-~~~^~, | ,~^~~~-,  ~  |\n" +
            "                        |   |        }:{        |   |\n" +
            "                        |   l       / | \\       !   |\n" +
            "                        .~  (__,.--\" .^. \"--.,__)  ~.\n" +
            "                        |     ---;' / | \\ `;---     |\n" +
            "                         \\__.       \\/^\\/       .__/\n" +
            "                          V| \\                 / |V\n" +
            "       __                  | |T~\\___!___!___/~T| |                  _____\n" +
            "    .-~  ~\"-.              | |`IIII_I_I_I_IIII'| |               .-~     \"-.\n" +
            "   /         \\             |  \\,III I I I III,/  |              /           Y\n" +
            "  Y          ;              \\   `~~~~~~~~~~'    /               i           |\n" +
            "  `.   _     `._              \\   .       .   /               __)         .'\n" +
            "    )=~         `-.._           \\.    ^    ./           _..-'~         ~\"<_\n" +
            " .-~                 ~`-.._       ^~~~^~~~^       _..-'~                   ~.\n" +
            "/                          ~`-.._           _..-'~                           Y\n" +
            "{        .~\"-._                  ~`-.._ .-'~                  _..-~;         ;\n" +
            " `._   _,'     ~`-.._                  ~`-.._           _..-'~     `._    _.-\n" +
            "    ~~\"              ~`-.._                  ~`-.._ .-'~              ~~\"~\n" +
            "  .----.            _..-'  ~`-.._                  ~`-.._          .-~~~~-.\n" +
            " /      `.    _..-'~             ~`-.._                  ~`-.._   (        \".\n" +
            "Y        `=--~                  _..-'  ~`-.._                  ~`-'         |\n" +
            "|                         _..-'~             ~`-.._                         ;\n" +
            "`._                 _..-'~                         ~`-.._            -._ _.'\n" +
            "   \"-.=\"      _..-'~                                     ~`-.._        ~`.\n" +
            "    /        `.                                                ;          Y\n" +
            "   Y           Y                                              Y           |\n" +
            "   |           ;                                              `.          /\n" +
            "   `.       _.'                                                 \"-.____.-'\n" +
            "     ~-----\"");



}
