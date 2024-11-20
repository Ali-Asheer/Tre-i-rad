import java.util.Scanner;

public class TwoPlayers {

    public TwoPlayers() {

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter Player 1 Name : ");
        String p1 = sc.next();
        System.out.print("Enter Player 2 Name : ");
        String p2 = sc.next();
        System.out.println();
        System.out.println("( Welcome " + p1 + ", " + p2 + " )");
        System.out.println("( " + p1 + " will Start the game with (X) symbol and " + p2 + " with symbol (O) )");
        System.out.println();
        DrawTable drawArray = new DrawTable();
        ifTableIsFull test = new ifTableIsFull();
        drawArray.mainArray();
        test.isTableFull();
        twoPlayersGame(p1);
    }








    public void twoPlayersGame(String p) {
        DrawTable drawArray = new DrawTable();
        int x;
        int y;
        switch (new askNumber().askNumber1(p, 9)) {
            case 1:
                x = 1;
                y = 2;
                new PlayerX().printSympol(drawArray.mainArray(), drawArray.xArray(), x, y);
                break;
            case 2:
                x = 1;
                y = 14;
                new PlayerX().printSympol(drawArray.mainArray(), drawArray.xArray(), x, y);
                break;
            case 3:
                x = 1;
                y = 26;
                new PlayerX().printSympol(drawArray.mainArray(), drawArray.xArray(), x, y);
                break;
            case 4:
                x = 8;
                y = 2;
                new PlayerX().printSympol(drawArray.mainArray(), drawArray.xArray(), x, y);
                break;
            case 5:
                x = 8;
                y = 14;
                new PlayerX().printSympol(drawArray.mainArray(), drawArray.xArray(), x, y);
                break;
            case 6:
                x = 8;
                y = 26;
                new PlayerX().printSympol(drawArray.mainArray(), drawArray.xArray(), x, y);
                break;
            case 7:
                x = 15;
                y = 2;
                new PlayerX().printSympol(drawArray.mainArray(), drawArray.xArray(), x, y);
                break;
            case 8:
                x = 15;
                y = 14;
                new PlayerX().printSympol(drawArray.mainArray(), drawArray.xArray(), x, y);
                break;
            case 9:
                x = 15;
                y = 26;
                new PlayerX().printSympol(drawArray.mainArray(), drawArray.xArray(), x, y);
                break;
        }

    }
}