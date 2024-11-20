import java.util.InputMismatchException;
import java.util.Scanner;



public class Game {

    //  Start of game

    public Game() {
    
        PlayersMenuText();                                                            // To first page menu
        int gameSelect = askNumber1("", 2);                            // To select between player against player or player against computer
        TwoPlayersMenu(gameSelect);                                                   // To input menu to input players names

    }





// menu to input players names

public void TwoPlayersMenu(int gameSelect) {
    Scanner sc = new Scanner(System.in);
    System.out.println();
    System.out.print("Enter Player 1 Name : ");
    String p1 = sc.next();

    String p2;
    if (gameSelect == 1) {
        System.out.print("Enter Player 2 Name : ");
        p2 = sc.next();
    } else p2 = "Computer";
    System.out.println();
    System.out.println("( This game is between " + p1 + " VS " + p2 + " )");
    System.out.println("( " + p1 + " will Start the game with (X) symbol and " + p2 + " with symbol (O) )");
    System.out.println();
    getYesNo(p1, p2);
}

// First page menu

public void PlayersMenuText() {
    System.out.println("#####################################");
    System.out.println("############ TRE I RAD  #############");
    System.out.println("#####################################");
    System.out.println();
    System.out.println("(1) - Two Players");
    System.out.println("(2) - You VS Computer");
    System.out.println("----------------------");
}



















// To select a number and check it if it`s not in the range and not a string.

public int askNumber1(String playerName, int ask) {
    boolean error = false;
    int x = 0;
    if (playerName != "") playerName = playerName + ". ";
    do {
        try {
            do {
                Scanner sc = new Scanner(System.in);
                System.out.print(playerName + "Please enter a number between (1-" + ask + ") : ");
                x = sc.nextInt();
                error = false;
            }
            while (x < 1 || x > ask);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input..Please input integer only..");
            error = true;
        }
    }
    while (error);
    return (x);
}

    public void getYesNo(String p1, String p2) {
        Scanner scanner = new Scanner(System.in);
        boolean yesNo = true;

        do {
            System.out.print("Du you want to continue (Y/N) : ");
            String input = scanner.nextLine();
            if (input.toLowerCase().startsWith("j") || input.toLowerCase().startsWith("y")) {
                System.out.println("stttaaaarrrrttttttttttt");yesNo = false;
               // twoPlayersStart(p1, p2);
            } else if (input.toLowerCase().startsWith("n")) {
                System.out.println("------- Thank you and goodbye -------");
                yesNo = false;

            }

        } while (yesNo);

    }









}