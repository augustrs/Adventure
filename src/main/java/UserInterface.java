import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Adventure adventure;
    Music music = new Music();


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

        System.out.println("▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔\n" + adventure.getCurrentRoom());
        System.out.println("");
    }



    public void userinput() {
        String input = scanner.nextLine().trim().toLowerCase();

        switch (input) {
            case "go north", "north", "n" -> {
                adventure.goNorth();
            }


            case "go south", "south", "s" -> {
                adventure.goSouth();
            }

            case "go east", "east", "e" -> {
                adventure.goEast();
            }
            case "go west", "west", "w" -> {
                adventure.goWest();
            }
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
            default -> System.out.println("Intet fundet");
        }

    }
}
