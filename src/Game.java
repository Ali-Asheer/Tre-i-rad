import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;



public class Game {
    private int user1Score = 0;
    private int user2Score = 0;
    int[] partSelect = new int[9];





    //  Start of game

    public Game() {
    
        PlayersMenuText();                                                            // To first page menu
        int gameSelect = askNumber1("", 2);                            // To select between player against player or player against computer
        TwoPlayersMenu(gameSelect);                                                   // To input menu to input players names

    }



    // Main game start

    public void gameStart(String p1, String p2) {
        System.out.println("( " + p1 + "'s Score : " + user1Score + "  )  VS  ( " + p2 + "'s Score : " + user2Score + " )");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        makeEmptyArray();               // To make array with 9 cells to put 1 for player 1 and 2 for player 2 and 0 if it empties.
        DrawTable mt = new DrawTable();
        char[][] mainArr = mt.mainArray();
        printArray(mainArr);
        boolean running = false;

        while (!running) {
            while (!isBoardFull()) {


                twoPlayersGame(askNumber2(p1, USER1), mainArr, mt.xArray());
                if (isWon(USER1, p1, p1, p2)) {
                    getYesNo(p1, p2);
                    running = true;

                }

                if (isBoardFull()) {
                    System.out.println("********************************");
                    System.out.println("**( The game ended in a draw )**");
                    System.out.println("********************************");
                    System.out.println();
                    getYesNo(p1, p2);
                }

                if (Objects.equals(p2, "Computer")) {
                    twoPlayersGame(computerNum(), mainArr, mt.oArray());
                } else {
                    twoPlayersGame(askNumber2(p2, USER2), mainArr, mt.oArray());
                }

                if (isWon(USER2, p2, p1, p2)) {
                    getYesNo(p1, p2);
                    running = true;
                    break;
                }

                if (isBoardFull()) {
                    System.out.println("********************************");
                    System.out.println("**( The game ended in a draw )**");
                    System.out.println("********************************");
                    System.out.println();
                    getYesNo(p1, p2);
                }

            }
            System.out.println("*********** GAME OVER **********");
            break;
        }
    }

    // Location of symbol array on a main array

    public void twoPlayersGame(int s, char[][] mt, char[][] ms) {
        int x;
        int y;
        switch (s) {
            case 1:
                x = 1;
                y = 2;
                printSymbol(mt, ms, x, y);
                break;
            case 2:
                x = 1;
                y = 14;
                printSymbol(mt, ms, x, y);
                break;
            case 3:
                x = 1;
                y = 26;
                printSymbol(mt, ms, x, y);
                break;
            case 4:
                x = 8;
                y = 2;
                printSymbol(mt, ms, x, y);
                break;
            case 5:
                x = 8;
                y = 14;
                printSymbol(mt, ms, x, y);
                break;
            case 6:
                x = 8;
                y = 26;
                printSymbol(mt, ms, x, y);
                break;
            case 7:
                x = 15;
                y = 2;
                printSymbol(mt, ms, x, y);
                break;
            case 8:
                x = 15;
                y = 14;
                printSymbol(mt, ms, x, y);
                break;
            case 9:
                x = 15;
                y = 26;
                printSymbol(mt, ms, x, y);
                break;
        }
    }

    // to put a symbol array at a main array

    public void printSymbol(char[][] mainArray1, char[][] xArray1, int x, int y) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                mainArray1[i + x][j + y] = xArray1[i][j];
            }
            System.out.println();
        }
        printArray(mainArray1);
    }

    // to print the main board

    public static void printArray(char[][] mainArray2) {
        for (char[] row : mainArray2) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();
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
    getYesNo(p1, p2);           // to select to continue or exit
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

// select to continue or exit

    public void getYesNo(String p1, String p2) {
        Scanner scanner = new Scanner(System.in);
        boolean yesNo = true;

        do {
            System.out.print("Du you want to continue (Y/N) : ");
            String input = scanner.nextLine();
            if (input.toLowerCase().startsWith("j") || input.toLowerCase().startsWith("y")) {
               gameStart(p1, p2);yesNo = false;                  // if select Yes it will continue.
            } else if (input.toLowerCase().startsWith("n")) {
                System.out.println("------- Thank you and goodbye -------");
                yesNo = false;

            }

        } while (yesNo);

    }
    public void makeEmptyArray() {
        for (int i = 0; i < 9; i++) {
            partSelect[i] = 0;
        }
    }


}