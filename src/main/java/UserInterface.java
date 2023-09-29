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
                            "\nTo move you can use these commands" +
                            "\ngo north, north, n " +
                            "\ngo south, south, s" +
                            "\ngo west, west, w" +
                            "\ngo east, east, e" +
                            "\n'exit' to exit the program" +
                            "\n'mute' to turn off  game music" +
                            "\n'resume' to start music");
                }
                case "look" -> {
                    System.out.println(adventure.getCurrentRoom());
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
                    }
                }

                case "take" -> {
                    Item pickItem = adventure.takeItem(commands[1]);

                }
                default -> System.out.println("Invalid input, type 'help' for list of commands");
            }

    }
}
