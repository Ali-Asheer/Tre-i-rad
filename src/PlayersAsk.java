import java.util.Scanner;

public class PlayersAsk {
    public PlayersAsk() {

        System.out.println("#####################################");
        System.out.println("############ TRE I RAD  #############");
        System.out.println("#####################################");
        System.out.println();
        System.out.println("(1) - Two Players");
        System.out.println("(2) - You VS Computer");
        System.out.println("----------------------");

        new askNumber().askNumber1(2);

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter Player 1 Name : ");
        String p1 = sc.next();
        System.out.print("Enter Player 2 Name : ");
        String p2 = sc.next();
        System.out.println();
        System.out.println("( Welcome " + p1 + " and " + p2 + " )");
        System.out.println("( " + p1 + " will Start the game with X symbol and " + p2 + " with symbol O )");
        System.out.println();

    }
}
