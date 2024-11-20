import java.util.Scanner;
import java.util.InputMismatchException;

public class askNumber {

    public int askNumber1(String playerName,int ask) {
        boolean error = false;
        int x = 0;
        if (playerName != "") playerName = playerName + ". ";
        do {
            try {
                do {
                    Scanner sc = new Scanner(System.in);
                    System.out.print(playerName + "Enter a number between (1-" + ask + ") : ");// enter here.
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




}

