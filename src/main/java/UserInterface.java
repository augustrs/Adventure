import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Adventure adventure;

    public UserInterface() {
        adventure = new Adventure();
        adventure.createMap();
    }

    public void start() {
        welcome();
        userinput();
        do {userinput();

        }while (true);
    }

    public void welcome() {
        System.out.println("Welcome to: THE BEST ADVENTURE GAME");
        System.out.println("Can you find your way to the xxx");
        System.out.println("Type 'help' for full list of commands");
        System.out.println(adventure.getCurrent());
        System.out.println("");
    }

    public void userinput() {
        String input = scanner.nextLine().toLowerCase();

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
                System.out.println("Commands:\n\nTo move you can use these commands\ngo north, north, n \ngo south, south, s\ngo west, west, w\ngo east, east, e");
            }
            case "look" -> {
                System.out.println(adventure.getCurrent());
            }
            default -> System.out.println("Intet fundet");
        }

    }
}
