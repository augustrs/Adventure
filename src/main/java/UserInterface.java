import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Adventure adventure;
    Music music = new Music();
    private Item item;


    public UserInterface() {
        adventure = new Adventure();
        adventure.createMap();
        music.play();

    }

    public void start() {
        welcome();
        userinput();
        do {
            userinput();

        } while (true);
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

        System.out.println("▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔\n" + adventure.getCurrentRoom() + adventure.getCurrentRoom().getDescription());
        System.out.println("");
    }


    public void userinput() {
        String input = scanner.nextLine().trim().toLowerCase();
        String[] commands = input.split("\\s+");
        String command = commands[0];

        if (commands.length == 1) {

            switch (command) {
                case "help", "h" -> {
                    System.out.println("Commands:" +
                            "\nGO           go north, go south, go east, go west - you can also use N, S, E and W" +
                            "\nEXIT         to exit the program" +
                            "\nMUTE         to turn off  game music" +
                            "\nRESUME       to start music" +
                            "\nLOOK         to take another look around the room" +
                            "\nTAKE         to pickup an object from a room" +
                            "\nDROP         to drop an item inside a room" +
                            "\nINVENTORY    to look in your inventory");
                }
                case "look" -> {
                    System.out.println(adventure.getCurrentRoom() + adventure.getCurrentRoom().getDescription());
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
                            case FIRED -> {
                                System.out.println("You've fired your weapon");
                            }
                            case ATTACK -> {
                                System.out.println("Attacking!");
                            }
                            case NO_AMMO -> {
                                System.out.println("You dont have any ammo!");
                            }
                            case NOT_A_WEAPON -> {
                                System.out.println("You dont have a weapon equipped");
                            }
                        }

                        }
                        default -> System.out.println("Invalid input, type 'help' for list of commands");
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
                                    System.out.println("no " + commands[1] + " was found in your inventory");
                                }

                            }


                        }
                        default -> System.out.println("Invalid input, type 'help' for list of commands");
                    }

            }
        }
