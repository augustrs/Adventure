import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    boolean pathExist = true;
    public void start() {
        welcome();
        userinput();
    }
    public void welcome() {
        System.out.println("Welcome to: THE BEST ADVENTURE GAME");
        System.out.println("Can you find your way to the xxx");
        System.out.println("Type 'help' for full list of commands");
    }
    public void userinput() {
    String input = scanner.nextLine().toLowerCase();

    switch (input) {
        case "go north", "north", "n" -> {
            if (pathExist == true){
                System.out.println("Going north!");
            }else {
                System.out.println("You can't go that way!");
            }

        }
        case "go south", "south", "s" -> {
            if (pathExist == true){
                System.out.println("Going south!");
            }else {
                System.out.println("You can't go that way!");
            }
        }
        case "go east", "east", "e" -> {
            if (pathExist == true) {
                System.out.println("Going east!");
            } else {
                System.out.println("I cant go that way");
            }
        }
        case "go west", "west", "w" -> {
            if (pathExist == true) {
                System.out.println("Going west!");
            } else {
                System.out.println("I cant go that way");
            }
        }
        case "help", "h" -> {
            System.out.println("Commands:\n\nTo move you can use these commands\ngo north, north, n \ngo south, south, s\ngo west, west, w\ngo east, east, e");
        }
    }

    }
}
