package gr.aueb.cf.testbed.projectsA.projects;

import java.util.Scanner;

import static java.lang.Character.getNumericValue;

public class Project10 {

    //test


    //

    static boolean[][] seats;
    static int[][] seat;
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        seats = new boolean[30][12]; //false by default;
        char col;
        int row;
        int choice = 0;

        System.out.println("TSBP | Theatre Seat Booker Program");
        showMenu();

        do {
            try {
                    choice = in.nextInt();
                switch (choice) {
                    case 1:
                        seatCheck(choice);

                        col = (char) seat[0][0];
                        row = seat[0][1];

                        book(col, row);

                        showMenu();
                        break;

                    case 2:
                        seatCheck(choice);

                        col = (char) seat[0][0];
                        row = seat[0][1];

                        cancel(col, row);

                        showMenu();
                        break;

                    case 3:
                        showPlan(seats);
                        showMenu();
                        break;

                    case 4:
                        System.out.println("Goodbye!");
                        choice = -1;
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                        showMenu();
                        break;

                }
            } catch (Exception e) {
                System.out.println("Please enter a number, not character!");
                showMenu();
                in.nextLine();
            }

        } while (choice != -1);
    }



    public static void showPlan(boolean[][] seats) {
        System.out.print("     [C][D][E][F][G][H][I][J][K][L][M][N]");
        for (int i = 0; i < seats.length; i++) {

            System.out.println();
            System.out.printf("[%02d] ", i+1);

            for (int j = 0; j < seats[i].length; j++) {

                if (seats[i][j]) {
                    System.out.print("[X]");
                } else {
                    System.out.print("[ ]");
                }
            }


        }
        System.out.println();
    }

    public static void showMenu() {
        System.out.println();
        System.out.println("What do you want to do? ");
        System.out.println("(1) Book.");
        System.out.println("(2) Cancel.");
        System.out.println("(3) Show Seats");
        System.out.println("(4) Exit");

    }

    public static void book(char column, int row) {

        seats[row][column] = true;
        System.out.printf("Seat Reserved at %c%d!", column+67, row+1);

    }

    public static void cancel(char column, int row) {

        if (!seats[column][row]) {
            System.out.println();
        } else {
            int choice = in.nextInt();

            if (choice == 1) {
                seats[row][column] = false;
                System.out.printf("Reservation cancelled at %c%d!", column + 48, row);
            } else System.out.println("Seat NOT cancelled.");
        }


    }

    public static int[][] seatCheck (int choice) {

        int seatCol;
        char colInput;
        int rowInput;
        int columnNo;
        seat = new int[1][2];


        do {
            System.out.println("Enter Column Letter (C-N): ");

            colInput = in.next().charAt(0);

            while (((int) colInput < 66) || ((int) colInput > 78)) {
                System.out.println("Not a Valid Column! Choose from C - N");
                colInput = in.next().charAt(0);
            }

            columnNo = (int) colInput - 67;

            System.out.println("Enter Row Number: 1-30");

            rowInput = in.nextInt()-1;

            while ((rowInput < 0) || (rowInput > 31)) {
                System.out.println("Not a Valid Row! Choose from 1 - 30");
                rowInput = in.nextInt();
            }

            if ((seats[columnNo][rowInput]) && (choice == 1)){
                System.out.println("!SEAT ALREADY BOOKED! Try with a new seat!");
            } else if ((seats[columnNo][rowInput]) && (choice == 2)) {
                System.out.println("!SEAT ALREADY BOOKED! Proceed with cancellation?");
                System.out.println("1.YES");
                System.out.println("2.NO");
            }  else if ((!seats[columnNo][rowInput]) && (choice == 2)) {
                System.out.println("Seat not booked, no reason to cancel!");
                break;
            }

        } while (seats[columnNo][rowInput] && (choice == 1));



        seat[0][0] = columnNo;
        seat[0][1] = rowInput;

        return seat;
    }


}



