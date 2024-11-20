import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;



public class Game {

    int[] partSelect = new int[9];
    private static final int EMPTY = 0;
    private final int USER1 = 1;
    private final int USER2 = 2;
    private final int COMPUTER = 2;
    private int user1Score = 0;
    private int user2Score = 0;




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
            while (!isArrayFull()) {
                twoPlayersGame(askNumber2(p1, USER1), mainArr, mt.xArray());
                if (isWon(USER1, p1, p1, p2)) {
                    getYesNo(p1, p2);
                    running = true; }

                if (isArrayFull()) {
                    System.out.println("********************************");
                    System.out.println("**( The game ended in a draw )**");
                    System.out.println("********************************");
                    System.out.println();
                    getYesNo(p1, p2); }

                if (Objects.equals(p2, "Computer")) {
                    twoPlayersGame(computerNum(), mainArr, mt.oArray());
                } else {
                    twoPlayersGame(askNumber2(p2, USER2), mainArr, mt.oArray()); }

                if (isWon(USER2, p2, p1, p2)) {
                    getYesNo(p1, p2);
                    running = true;
                    break;}

                if (isArrayFull()) {
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

    //  checking array with 0 contain
    public void makeEmptyArray() {
        for (int i = 0; i < 9; i++) {
            partSelect[i] = 0;
        }
    }

//  check if all cells are full
    public boolean isArrayFull() {
        for (int i = 0; i < 9; i++) {
            if (partSelect[i] == EMPTY) {
                return false;
            }
        }
        return true;
    }

    // Select a number 1-9 and check the array cell if it empties.
    public int askNumber2(String p, int USER) {
        int checkPlace = askNumber1(p, 9);
        while (!(checkPart(partSelect, checkPlace, USER))) {
            checkPlace = askNumber1(p, 9);
        }
        return checkPlace;
    }

    // check the array cell if it empty to put users symbol

    public boolean checkPart(int[] partSelect, int i, int user) {
        if (partSelect[i - 1] == EMPTY) {
            partSelect[i - 1] = user;
            return true;
        } else {
            return false;
        }
    }
    // Generate a random number as a computer choice
    public int computerNum() {
        Random random = new Random();
        int num;
        num = random.nextInt(8) + 1;
        while (!(checkPart(partSelect, num, COMPUTER))) {
            num = random.nextInt(8) + 1;
        }
        return num;
    }

    // check the cells if it did the conditions to win and add the scores and choose the winner
    public boolean isWon(int player, String p, String p1, String p2) {

        for (int i = 0; i < 9; i++) {
            if ((partSelect[0] == player && partSelect[1] == player && partSelect[2] == player)
                    || (partSelect[3] == player && partSelect[4] == player && partSelect[5] == player)
                    || (partSelect[6] == player && partSelect[7] == player && partSelect[8] == player)
                    || (partSelect[0] == player && partSelect[3] == player && partSelect[6] == player)
                    || (partSelect[1] == player && partSelect[4] == player && partSelect[7] == player)
                    || (partSelect[2] == player && partSelect[5] == player && partSelect[8] == player)
                    || (partSelect[0] == player && partSelect[4] == player && partSelect[8] == player)
                    || (partSelect[6] == player && partSelect[4] == player && partSelect[2] == player)) {
                if (player == 1) {
                    user1Score++;
                }
                if (player == 2) {
                    user2Score++;
                }
                System.out.println("**** " + p + " win this round, congratulations. ****");
                System.out.println("---------------------------------------------------------");
                return true;
            }
        }
        System.out.println("( " + p1 + "ّs Score : " + user1Score + "  )  VS  ( " + p2 + "ّs Score : " + user2Score + " )");
        return false;
    }


}