package gr.aueb.cf.testbed.projectsA.projects;

import java.util.Arrays;
import java.util.Scanner;

public class Project08 {

    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {



        boolean gameOver = false;
        boolean p1Plays = true;
        int playerTurnsCount = 1;
        int[][] tableau = new int[3][3];

        for (int[] row : tableau) {
            Arrays.fill(row, (char)32);
        }

        String p1 = "";
        String p2 = "";
        int xPos = -1;
        int yPos = -1;


        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Player 1: Enter your name: ");
        p1 = in.nextLine();
        System.out.println("Player 2: Enter your name: ");
        p2 = in.nextLine();
        System.out.println(p1+" VS "+p2+". Begin!");
        System.out.println(" ");
        //playerInit(p1,p2);
        tableauShow(tableau,p1Plays,-1,-1);
        System.out.println(" ");

        do {
            p1Plays = (playerTurnsCount % 2 != 0);

            if (p1Plays) {
                System.out.println(p1+" 's Turn!");

                do {
                    System.out.println(p1+" Enter row number: ");
                    xPos = in.nextInt();
                    xPos = checkTurn(xPos);
                    System.out.println(p1+" Enter column number: ");
                    yPos = in.nextInt();in.nextLine();
                    yPos = checkTurn(yPos);


                } while (!isPosEmpty(tableau, xPos, yPos));

                tableauShow(tableau,p1Plays,xPos,yPos);
                //checkTTT
                playerTurnsCount++;
                p1Plays = false;

            } else {

                System.out.println(p2+" 's Turn!");

                do {

                System.out.println(p2+" Enter row number: ");
                xPos = in.nextInt();
                xPos = checkTurn(xPos);
                System.out.println(p2+" Enter column number: ");
                yPos = in.nextInt();in.nextLine();
                yPos = checkTurn(yPos);

                } while (!isPosEmpty(tableau, xPos, yPos));

                tableauShow(tableau,p1Plays,xPos,yPos);
                playerTurnsCount++;
                p1Plays = true;
            }

        } while (!(gameOver(tableau, playerTurnsCount,p1Plays, p1, p2)));


    }


    public static void tableauShow(int[][] arr, boolean plays ,int xpos, int ypos) {

        xpos = xpos -1;
        ypos = ypos -1;



        if (xpos < 0) {
            for (int i = 0; i < arr.length; i++) {

                System.out.println(" ");
                System.out.print("|");

                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(" "+ " "+" |");
                }
            }
            System.out.println("");
        } else if (plays == true){
            arr[xpos][ypos] = 88; //Player A 264
            for (int i = 0; i < arr.length; i++) {

                System.out.println(" ");
                System.out.print("|");

                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(" "+(char)arr[i][j]+" |");
                }
            }
            System.out.println("");
        } else {

            arr[xpos][ypos] = 79; //Player B 237
            for (int i = 0; i < arr.length; i++) {

                System.out.println(" ");
                System.out.print("|");

                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(" "+(char)arr[i][j]+" |");
                }
            }
            System.out.println("");
        }
        System.out.println(" ");
    }

    public static int checkTurn (int input) {



        while ((input <= 0) || (input > 3)) {

            System.out.println("Invalid Position! Position must be 1-3.");
            System.out.println();
            input = in.nextInt();

        }

        return input;
    }

    public static boolean isPosEmpty(int[][] arr, int xPos, int yPos) {


        if (arr[xPos-1][yPos-1] != 32) {
            System.out.println("Position taken! Try again!");
            return false;
        } else {

            return true;
        }


    }

    public static boolean gameOver (int[][] arr ,int playerTurnsCount, boolean p1Plays, String p1, String p2) {

        int winValue;
        int hSum = 0;
        int vSum = 0;
        boolean d1 = false, d2 = false;
        String currentPlayer;

        if (playerTurnsCount == 10) {
            System.out.println("Nobody wins! Game Over! ");
            return true;
        }


        if (!p1Plays) { ///?FIX THIS !!!! argei to loop kata 1
            currentPlayer  = p1;
            winValue = 264;


        } else {
            winValue = 237;
            currentPlayer  = p2;
        }

        if ((arr[0][0] + arr[1][1] + arr[2][2]) == winValue) {
            System.out.println(currentPlayer + " WINS! C O N G R A T S !");
            return true;
        }

        if ((arr[0][2] + arr[1][1] + arr[2][0]) == winValue) {
            System.out.println(currentPlayer + " WINS! C O N G R A T S !");
            return true;
        }

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                hSum += arr[i][j];
                if (hSum == winValue) {
                    System.out.println(currentPlayer + " WINS! C O N G R A T S !");
                    return true;
                }
            }
            vSum += arr[i][0];

            if (vSum == winValue) {
                System.out.println(currentPlayer + " WINS! C O N G R A T S !");
                return true;
            }
        }

        return false;
    }

}

