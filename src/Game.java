import java.util.InputMismatchException;
import java.util.Scanner;




//  Start Program

public class Game {

    public void Game(String[] args) {                             m
        PlayersMenuText();
        int gameSelect = askNumber1("", 2);
        if (gameSelect == 1) {TwoPlayers();}
        else if (gameSelect == 2) {onePlayers();
        }
    }
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